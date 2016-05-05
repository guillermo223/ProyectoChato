package com.proyecto.quental.chat.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.proyecto.quental.chat.model.Asignacion;
import com.proyecto.quental.chat.model.Conversacion;
import com.proyecto.quental.chat.service.AsignacionLocalServiceUtil;
import com.proyecto.quental.chat.service.ConversacionLocalServiceUtil;
import com.proyecto.quental.chat.service.base.ConversacionLocalServiceBaseImpl;

/**
 * The implementation of the conversacion local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.proyecto.quental.chat.service.ConversacionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.base.ConversacionLocalServiceBaseImpl
 * @see com.proyecto.quental.chat.service.ConversacionLocalServiceUtil
 */
public class ConversacionLocalServiceImpl
    extends ConversacionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.proyecto.quental.chat.service.ConversacionLocalServiceUtil} to access the conversacion local service.
     */
	public List<Conversacion> getConversacionesNoAsignadas() throws SystemException{
		return conversacionPersistence.findByPendientes(false);
	}
	
	public List<Conversacion> getConversacionesAbiertas() throws SystemException{
		return conversacionPersistence.findByCerradas(false);
	}
	public List<Conversacion> getConversacionesAsignadasPorTecnico(long idTecnico) throws SystemException, PortalException{
		// creamos la lista de las conversaciones abiertas
		List<Conversacion> listaAbiertas = this.getConversacionesAbiertas();
		// inicializamos lo que vamos a devolver
		List<Conversacion> ConversacionesPorTecnico = new ArrayList<Conversacion>();
		// recorremos la lista de las Abiertas
		for(Conversacion conversacion:listaAbiertas){
			// encontramos por cada conversacion abierta las asignaciones que tiene
			List<Asignacion> byConversacion = AsignacionLocalServiceUtil.getByConversacion(conversacion.getConversacionId());
			for(Asignacion asignacion:byConversacion){
				if(asignacion.getUserId() == idTecnico)
				{   
					Conversacion conversacionAsignada = ConversacionLocalServiceUtil.getConversacion(asignacion.getConversacionId());
					
					ConversacionesPorTecnico.add(conversacionAsignada);
					break;
				}
			}
			
			
		}
		return ConversacionesPorTecnico;
	}
	
}
