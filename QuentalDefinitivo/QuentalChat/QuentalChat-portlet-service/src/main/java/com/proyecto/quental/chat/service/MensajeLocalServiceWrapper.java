package com.proyecto.quental.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MensajeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MensajeLocalService
 * @generated
 */
public class MensajeLocalServiceWrapper implements MensajeLocalService,
    ServiceWrapper<MensajeLocalService> {
    private MensajeLocalService _mensajeLocalService;

    public MensajeLocalServiceWrapper(MensajeLocalService mensajeLocalService) {
        _mensajeLocalService = mensajeLocalService;
    }

    /**
    * Adds the mensaje to the database. Also notifies the appropriate model listeners.
    *
    * @param mensaje the mensaje
    * @return the mensaje that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Mensaje addMensaje(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.addMensaje(mensaje);
    }

    /**
    * Creates a new mensaje with the primary key. Does not add the mensaje to the database.
    *
    * @param mensajeId the primary key for the new mensaje
    * @return the new mensaje
    */
    @Override
    public com.proyecto.quental.chat.model.Mensaje createMensaje(long mensajeId) {
        return _mensajeLocalService.createMensaje(mensajeId);
    }

    /**
    * Deletes the mensaje with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje that was removed
    * @throws PortalException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Mensaje deleteMensaje(long mensajeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.deleteMensaje(mensajeId);
    }

    /**
    * Deletes the mensaje from the database. Also notifies the appropriate model listeners.
    *
    * @param mensaje the mensaje
    * @return the mensaje that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Mensaje deleteMensaje(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.deleteMensaje(mensaje);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _mensajeLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.proyecto.quental.chat.model.Mensaje fetchMensaje(long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.fetchMensaje(mensajeId);
    }

    /**
    * Returns the mensaje with the primary key.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje
    * @throws PortalException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Mensaje getMensaje(long mensajeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.getMensaje(mensajeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the mensajes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mensajes
    * @param end the upper bound of the range of mensajes (not inclusive)
    * @return the range of mensajes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> getMensajes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.getMensajes(start, end);
    }

    /**
    * Returns the number of mensajes.
    *
    * @return the number of mensajes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMensajesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.getMensajesCount();
    }

    /**
    * Updates the mensaje in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mensaje the mensaje
    * @return the mensaje that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Mensaje updateMensaje(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.updateMensaje(mensaje);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mensajeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mensajeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mensajeLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> getMensajesByConversacion(
        long idConv) throws com.liferay.portal.kernel.exception.SystemException {
        return _mensajeLocalService.getMensajesByConversacion(idConv);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MensajeLocalService getWrappedMensajeLocalService() {
        return _mensajeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMensajeLocalService(
        MensajeLocalService mensajeLocalService) {
        _mensajeLocalService = mensajeLocalService;
    }

    @Override
    public MensajeLocalService getWrappedService() {
        return _mensajeLocalService;
    }

    @Override
    public void setWrappedService(MensajeLocalService mensajeLocalService) {
        _mensajeLocalService = mensajeLocalService;
    }
}
