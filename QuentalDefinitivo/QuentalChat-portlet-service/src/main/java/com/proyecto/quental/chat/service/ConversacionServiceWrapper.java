package com.proyecto.quental.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConversacionService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConversacionService
 * @generated
 */
public class ConversacionServiceWrapper implements ConversacionService,
    ServiceWrapper<ConversacionService> {
    private ConversacionService _conversacionService;

    public ConversacionServiceWrapper(ConversacionService conversacionService) {
        _conversacionService = conversacionService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _conversacionService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _conversacionService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _conversacionService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ConversacionService getWrappedConversacionService() {
        return _conversacionService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedConversacionService(
        ConversacionService conversacionService) {
        _conversacionService = conversacionService;
    }

    @Override
    public ConversacionService getWrappedService() {
        return _conversacionService;
    }

    @Override
    public void setWrappedService(ConversacionService conversacionService) {
        _conversacionService = conversacionService;
    }
}
