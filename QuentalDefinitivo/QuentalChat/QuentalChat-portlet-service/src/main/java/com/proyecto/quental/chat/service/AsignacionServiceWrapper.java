package com.proyecto.quental.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AsignacionService}.
 *
 * @author Brian Wing Shun Chan
 * @see AsignacionService
 * @generated
 */
public class AsignacionServiceWrapper implements AsignacionService,
    ServiceWrapper<AsignacionService> {
    private AsignacionService _asignacionService;

    public AsignacionServiceWrapper(AsignacionService asignacionService) {
        _asignacionService = asignacionService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _asignacionService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _asignacionService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _asignacionService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AsignacionService getWrappedAsignacionService() {
        return _asignacionService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAsignacionService(AsignacionService asignacionService) {
        _asignacionService = asignacionService;
    }

    @Override
    public AsignacionService getWrappedService() {
        return _asignacionService;
    }

    @Override
    public void setWrappedService(AsignacionService asignacionService) {
        _asignacionService = asignacionService;
    }
}
