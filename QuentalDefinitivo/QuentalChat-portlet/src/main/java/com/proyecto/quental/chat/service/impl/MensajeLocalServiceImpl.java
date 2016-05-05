package com.proyecto.quental.chat.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.proyecto.quental.chat.model.Mensaje;
import com.proyecto.quental.chat.service.base.MensajeLocalServiceBaseImpl;

/**
 * The implementation of the mensaje local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.proyecto.quental.chat.service.MensajeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.base.MensajeLocalServiceBaseImpl
 * @see com.proyecto.quental.chat.service.MensajeLocalServiceUtil
 */
public class MensajeLocalServiceImpl extends MensajeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.proyecto.quental.chat.service.MensajeLocalServiceUtil} to access the mensaje local service.
     */
	public List<Mensaje> getMensajesByConversacion(long idConv) throws SystemException {
		return this.mensajePersistence.findByConversacion(idConv);
	}
}
