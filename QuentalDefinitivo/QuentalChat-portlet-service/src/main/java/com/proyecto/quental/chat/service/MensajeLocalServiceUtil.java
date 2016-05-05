package com.proyecto.quental.chat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Mensaje. This utility wraps
 * {@link com.proyecto.quental.chat.service.impl.MensajeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MensajeLocalService
 * @see com.proyecto.quental.chat.service.base.MensajeLocalServiceBaseImpl
 * @see com.proyecto.quental.chat.service.impl.MensajeLocalServiceImpl
 * @generated
 */
public class MensajeLocalServiceUtil {
    private static MensajeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.proyecto.quental.chat.service.impl.MensajeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the mensaje to the database. Also notifies the appropriate model listeners.
    *
    * @param mensaje the mensaje
    * @return the mensaje that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje addMensaje(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMensaje(mensaje);
    }

    /**
    * Creates a new mensaje with the primary key. Does not add the mensaje to the database.
    *
    * @param mensajeId the primary key for the new mensaje
    * @return the new mensaje
    */
    public static com.proyecto.quental.chat.model.Mensaje createMensaje(
        long mensajeId) {
        return getService().createMensaje(mensajeId);
    }

    /**
    * Deletes the mensaje with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje that was removed
    * @throws PortalException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje deleteMensaje(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMensaje(mensajeId);
    }

    /**
    * Deletes the mensaje from the database. Also notifies the appropriate model listeners.
    *
    * @param mensaje the mensaje
    * @return the mensaje that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje deleteMensaje(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMensaje(mensaje);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.proyecto.quental.chat.model.Mensaje fetchMensaje(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMensaje(mensajeId);
    }

    /**
    * Returns the mensaje with the primary key.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje
    * @throws PortalException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje getMensaje(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMensaje(mensajeId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> getMensajes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMensajes(start, end);
    }

    /**
    * Returns the number of mensajes.
    *
    * @return the number of mensajes
    * @throws SystemException if a system exception occurred
    */
    public static int getMensajesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMensajesCount();
    }

    /**
    * Updates the mensaje in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mensaje the mensaje
    * @return the mensaje that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje updateMensaje(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMensaje(mensaje);
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

    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> getMensajesByConversacion(
        long idConv) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMensajesByConversacion(idConv);
    }

    public static void clearService() {
        _service = null;
    }

    public static MensajeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MensajeLocalService.class.getName());

            if (invokableLocalService instanceof MensajeLocalService) {
                _service = (MensajeLocalService) invokableLocalService;
            } else {
                _service = new MensajeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(MensajeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MensajeLocalService service) {
    }
}
