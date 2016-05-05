package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.proyecto.quental.chat.model.Conversacion;
import com.proyecto.quental.chat.service.ConversacionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ConversacionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ConversacionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ConversacionLocalServiceUtil.getService());
        setClass(Conversacion.class);

        setClassLoader(com.proyecto.quental.chat.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("conversacionId");
    }
}
