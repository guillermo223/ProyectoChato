package com.proyecto.quental.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AsignacionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AsignacionLocalService
 * @generated
 */
public class AsignacionLocalServiceWrapper implements AsignacionLocalService,
    ServiceWrapper<AsignacionLocalService> {
    private AsignacionLocalService _asignacionLocalService;

    public AsignacionLocalServiceWrapper(
        AsignacionLocalService asignacionLocalService) {
        _asignacionLocalService = asignacionLocalService;
    }

    /**
    * Adds the asignacion to the database. Also notifies the appropriate model listeners.
    *
    * @param asignacion the asignacion
    * @return the asignacion that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Asignacion addAsignacion(
        com.proyecto.quental.chat.model.Asignacion asignacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.addAsignacion(asignacion);
    }

    /**
    * Creates a new asignacion with the primary key. Does not add the asignacion to the database.
    *
    * @param asignacionId the primary key for the new asignacion
    * @return the new asignacion
    */
    @Override
    public com.proyecto.quental.chat.model.Asignacion createAsignacion(
        long asignacionId) {
        return _asignacionLocalService.createAsignacion(asignacionId);
    }

    /**
    * Deletes the asignacion with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param asignacionId the primary key of the asignacion
    * @return the asignacion that was removed
    * @throws PortalException if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Asignacion deleteAsignacion(
        long asignacionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.deleteAsignacion(asignacionId);
    }

    /**
    * Deletes the asignacion from the database. Also notifies the appropriate model listeners.
    *
    * @param asignacion the asignacion
    * @return the asignacion that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Asignacion deleteAsignacion(
        com.proyecto.quental.chat.model.Asignacion asignacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.deleteAsignacion(asignacion);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _asignacionLocalService.dynamicQuery();
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
        return _asignacionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _asignacionLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _asignacionLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _asignacionLocalService.dynamicQueryCount(dynamicQuery);
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
        return _asignacionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.proyecto.quental.chat.model.Asignacion fetchAsignacion(
        long asignacionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.fetchAsignacion(asignacionId);
    }

    /**
    * Returns the asignacion with the primary key.
    *
    * @param asignacionId the primary key of the asignacion
    * @return the asignacion
    * @throws PortalException if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Asignacion getAsignacion(
        long asignacionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getAsignacion(asignacionId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the asignacions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of asignacions
    * @param end the upper bound of the range of asignacions (not inclusive)
    * @return the range of asignacions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> getAsignacions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getAsignacions(start, end);
    }

    /**
    * Returns the number of asignacions.
    *
    * @return the number of asignacions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAsignacionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getAsignacionsCount();
    }

    /**
    * Updates the asignacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param asignacion the asignacion
    * @return the asignacion that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.proyecto.quental.chat.model.Asignacion updateAsignacion(
        com.proyecto.quental.chat.model.Asignacion asignacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.updateAsignacion(asignacion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _asignacionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _asignacionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _asignacionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> getByConversacion(
        long idConv) throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getByConversacion(idConv);
    }

    @Override
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> getByTecnico(
        long idTecnico)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getByTecnico(idTecnico);
    }

    /**
    * Metodo que asigna una conversacion a un técnico, si ya estaba asignada, devuelve false
    * en caso de poder asignar la conversacion por primera vez, lo hace y devuelve true
    *
    * @throws SystemException
    * @throws PortalException
    */
    @Override
    public boolean asignarConversacion(long idConv, long idTecnico)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.asignarConversacion(idConv, idTecnico);
    }

    /**
    * Método que permite al técnico que esta manteniendo una conversacion invitar a participar un colega suyo
    *
    * @throws SystemException
    */
    @Override
    public void compartirConversacion(long idConv, long idTecnico)
        throws com.liferay.portal.kernel.exception.SystemException {
        _asignacionLocalService.compartirConversacion(idConv, idTecnico);
    }

    @Override
    public java.util.Set<com.liferay.portal.model.User> getListaColegasOnLine()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _asignacionLocalService.getListaColegasOnLine();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AsignacionLocalService getWrappedAsignacionLocalService() {
        return _asignacionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAsignacionLocalService(
        AsignacionLocalService asignacionLocalService) {
        _asignacionLocalService = asignacionLocalService;
    }

    @Override
    public AsignacionLocalService getWrappedService() {
        return _asignacionLocalService;
    }

    @Override
    public void setWrappedService(AsignacionLocalService asignacionLocalService) {
        _asignacionLocalService = asignacionLocalService;
    }
}
