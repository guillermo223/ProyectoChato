package com.proyecto.quental.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MensajeService}.
 *
 * @author Brian Wing Shun Chan
 * @see MensajeService
 * @generated
 */
public class MensajeServiceWrapper implements MensajeService,
    ServiceWrapper<MensajeService> {
    private MensajeService _mensajeService;

    public MensajeServiceWrapper(MensajeService mensajeService) {
        _mensajeService = mensajeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mensajeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mensajeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mensajeService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MensajeService getWrappedMensajeService() {
        return _mensajeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMensajeService(MensajeService mensajeService) {
        _mensajeService = mensajeService;
    }

    @Override
    public MensajeService getWrappedService() {
        return _mensajeService;
    }

    @Override
    public void setWrappedService(MensajeService mensajeService) {
        _mensajeService = mensajeService;
    }
}
