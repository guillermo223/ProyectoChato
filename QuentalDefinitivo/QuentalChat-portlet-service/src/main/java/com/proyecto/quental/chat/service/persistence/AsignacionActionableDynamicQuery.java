package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.proyecto.quental.chat.model.Asignacion;
import com.proyecto.quental.chat.service.AsignacionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AsignacionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AsignacionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AsignacionLocalServiceUtil.getService());
        setClass(Asignacion.class);

        setClassLoader(com.proyecto.quental.chat.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("asignacionId");
    }
}
