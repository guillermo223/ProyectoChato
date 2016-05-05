package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.proyecto.quental.chat.model.Mensaje;
import com.proyecto.quental.chat.service.MensajeLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class MensajeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MensajeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MensajeLocalServiceUtil.getService());
        setClass(Mensaje.class);

        setClassLoader(com.proyecto.quental.chat.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("mensajeId");
    }
}
