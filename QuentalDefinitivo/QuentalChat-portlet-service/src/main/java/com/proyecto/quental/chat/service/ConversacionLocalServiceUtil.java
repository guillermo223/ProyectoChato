package com.proyecto.quental.chat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Conversacion. This utility wraps
 * {@link com.proyecto.quental.chat.service.impl.ConversacionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConversacionLocalService
 * @see com.proyecto.quental.chat.service.base.ConversacionLocalServiceBaseImpl
 * @see com.proyecto.quental.chat.service.impl.ConversacionLocalServiceImpl
 * @generated
 */
public class ConversacionLocalServiceUtil {
    private static ConversacionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.proyecto.quental.chat.service.impl.ConversacionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the conversacion to the database. Also notifies the appropriate model listeners.
    *
    * @param conversacion the conversacion
    * @return the conversacion that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion addConversacion(
        com.proyecto.quental.chat.model.Conversacion conversacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addConversacion(conversacion);
    }

    /**
    * Creates a new conversacion with the primary key. Does not add the conversacion to the database.
    *
    * @param conversacionId the primary key for the new conversacion
    * @return the new conversacion
    */
    public static com.proyecto.quental.chat.model.Conversacion createConversacion(
        long conversacionId) {
        return getService().createConversacion(conversacionId);
    }

    /**
    * Deletes the conversacion with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param conversacionId the primary key of the conversacion
    * @return the conversacion that was removed
    * @throws PortalException if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion deleteConversacion(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteConversacion(conversacionId);
    }

    /**
    * Deletes the conversacion from the database. Also notifies the appropriate model listeners.
    *
    * @param conversacion the conversacion
    * @return the conversacion that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion deleteConversacion(
        com.proyecto.quental.chat.model.Conversacion conversacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteConversacion(conversacion);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.proyecto.quental.chat.model.Conversacion fetchConversacion(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchConversacion(conversacionId);
    }

    /**
    * Returns the conversacion with the primary key.
    *
    * @param conversacionId the primary key of the conversacion
    * @return the conversacion
    * @throws PortalException if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion getConversacion(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getConversacion(conversacionId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the conversacions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of conversacions
    * @param end the upper bound of the range of conversacions (not inclusive)
    * @return the range of conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> getConversacions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getConversacions(start, end);
    }

    /**
    * Returns the number of conversacions.
    *
    * @return the number of conversacions
    * @throws SystemException if a system exception occurred
    */
    public static int getConversacionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getConversacionsCount();
    }

    /**
    * Updates the conversacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param conversacion the conversacion
    * @return the conversacion that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion updateConversacion(
        com.proyecto.quental.chat.model.Conversacion conversacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateConversacion(conversacion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> getConversacionesNoAsignadas()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getConversacionesNoAsignadas();
    }

    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> getConversacionesAbiertas()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getConversacionesAbiertas();
    }

    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> getConversacionesAsignadasPorTecnico(
        long idTecnico)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getConversacionesAsignadasPorTecnico(idTecnico);
    }

    public static void clearService() {
        _service = null;
    }

    public static ConversacionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ConversacionLocalService.class.getName());

            if (invokableLocalService instanceof ConversacionLocalService) {
                _service = (ConversacionLocalService) invokableLocalService;
            } else {
                _service = new ConversacionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ConversacionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ConversacionLocalService service) {
    }
}
