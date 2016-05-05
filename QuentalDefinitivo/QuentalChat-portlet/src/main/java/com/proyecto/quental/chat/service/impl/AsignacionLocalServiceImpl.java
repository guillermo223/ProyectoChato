package com.proyecto.quental.chat.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.proyecto.quental.chat.model.Asignacion;
import com.proyecto.quental.chat.model.Conversacion;
import com.proyecto.quental.chat.model.impl.AsignacionImpl;
import com.proyecto.quental.chat.service.AsignacionLocalServiceUtil;
import com.proyecto.quental.chat.service.ConversacionLocalServiceUtil;
import com.proyecto.quental.chat.service.base.AsignacionLocalServiceBaseImpl;

/**
 * The implementation of the asignacion local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.proyecto.quental.chat.service.AsignacionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.base.AsignacionLocalServiceBaseImpl
 * @see com.proyecto.quental.chat.service.AsignacionLocalServiceUtil
 */
public class AsignacionLocalServiceImpl extends AsignacionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.proyecto.quental.chat.service.AsignacionLocalServiceUtil} to access the asignacion local service.
     */
	public List<Asignacion> getByConversacion(long idConv) throws SystemException {
		return this.asignacionPersistence.findByConversacion(idConv);
	}
	public List<Asignacion> getByTecnico(long idTecnico) throws SystemException{
		return this.asignacionPersistence.findByTecnico(idTecnico);
	}
	/**
	 * Metodo que asigna una conversacion a un técnico, si ya estaba asignada, devuelve false
	 * en caso de poder asignar la conversacion por primera vez, lo hace y devuelve true
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public boolean asignarConversacion(long idConv, long idTecnico) throws SystemException, PortalException{
		
		//  por si ya está asignada la conversacion , devolvemos false
	    if(!this.getByConversacion(idConv).isEmpty())
	    	return false;
		// si no, creamos un nuevo registro de asignacion , lo persistimos y devolvemos true
		Asignacion asignacionImpl = new  AsignacionImpl();
	    asignacionImpl.setConversacionId(idConv);
	    asignacionImpl.setUserId(idTecnico);
	   
		AsignacionLocalServiceUtil.addAsignacion(asignacionImpl);
		// cambiamos el valor del campo asignado
		Conversacion conversacion = ConversacionLocalServiceUtil.getConversacion(idConv);
		conversacion.setAsignado(true);
		ConversacionLocalServiceUtil.updateConversacion(conversacion);
		return true;
	}
	/**
	 * Método que permite al técnico que esta manteniendo una conversacion invitar a participar un colega suyo 
	 *  @throws SystemException
	 */
	
    public void compartirConversacion(long idConv, long idTecnico) throws SystemException{
    	Asignacion asignacion = new  AsignacionImpl();
	    asignacion.setConversacionId(idConv);
	    asignacion.setUserId(idTecnico);
	    
		AsignacionLocalServiceUtil.addAsignacion(asignacion);
		
		
	}
    public Set<User> getListaColegasOnLine() throws SystemException, PortalException{
		  List<Conversacion> listaConversacionesAbiertas = ConversacionLocalServiceUtil.getConversacionesAbiertas();
		  List<Asignacion> listaAsignacionesConversacion;
		  Set<User> listaColegas = new HashSet<User>();
		  for(Conversacion conversacion:listaConversacionesAbiertas)
		  {  //  buscamos los tecnicos que atienden cada conversacion
			  listaAsignacionesConversacion = asignacionPersistence.findByConversacion(conversacion.getConversacionId());
			  for(Asignacion asignacion : listaAsignacionesConversacion)
			  {
				  User usuario = UserLocalServiceUtil.getUser(asignacion.getUserId());
				  listaColegas.add(usuario);
			  }
		  }
		  
		return listaColegas;
	} 
}
