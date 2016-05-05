package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.proyecto.quental.chat.model.Mensaje;

import java.util.List;

/**
 * The persistence utility for the mensaje service. This utility wraps {@link MensajePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MensajePersistence
 * @see MensajePersistenceImpl
 * @generated
 */
public class MensajeUtil {
    private static MensajePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Mensaje mensaje) {
        getPersistence().clearCache(mensaje);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Mensaje> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Mensaje> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Mensaje> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Mensaje update(Mensaje mensaje) throws SystemException {
        return getPersistence().update(mensaje);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Mensaje update(Mensaje mensaje, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(mensaje, serviceContext);
    }

    /**
    * Returns all the mensajes where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @return the matching mensajes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> findByConversacion(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConversacion(conversacionId);
    }

    /**
    * Returns a range of all the mensajes where conversacionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param conversacionId the conversacion ID
    * @param start the lower bound of the range of mensajes
    * @param end the upper bound of the range of mensajes (not inclusive)
    * @return the range of matching mensajes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> findByConversacion(
        long conversacionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConversacion(conversacionId, start, end);
    }

    /**
    * Returns an ordered range of all the mensajes where conversacionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param conversacionId the conversacion ID
    * @param start the lower bound of the range of mensajes
    * @param end the upper bound of the range of mensajes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching mensajes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> findByConversacion(
        long conversacionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConversacion(conversacionId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje findByConversacion_First(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException {
        return getPersistence()
                   .findByConversacion_First(conversacionId, orderByComparator);
    }

    /**
    * Returns the first mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mensaje, or <code>null</code> if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje fetchByConversacion_First(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConversacion_First(conversacionId, orderByComparator);
    }

    /**
    * Returns the last mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje findByConversacion_Last(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException {
        return getPersistence()
                   .findByConversacion_Last(conversacionId, orderByComparator);
    }

    /**
    * Returns the last mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mensaje, or <code>null</code> if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje fetchByConversacion_Last(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConversacion_Last(conversacionId, orderByComparator);
    }

    /**
    * Returns the mensajes before and after the current mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param mensajeId the primary key of the current mensaje
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje[] findByConversacion_PrevAndNext(
        long mensajeId, long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException {
        return getPersistence()
                   .findByConversacion_PrevAndNext(mensajeId, conversacionId,
            orderByComparator);
    }

    /**
    * Removes all the mensajes where conversacionId = &#63; from the database.
    *
    * @param conversacionId the conversacion ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByConversacion(long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByConversacion(conversacionId);
    }

    /**
    * Returns the number of mensajes where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @return the number of matching mensajes
    * @throws SystemException if a system exception occurred
    */
    public static int countByConversacion(long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByConversacion(conversacionId);
    }

    /**
    * Caches the mensaje in the entity cache if it is enabled.
    *
    * @param mensaje the mensaje
    */
    public static void cacheResult(
        com.proyecto.quental.chat.model.Mensaje mensaje) {
        getPersistence().cacheResult(mensaje);
    }

    /**
    * Caches the mensajes in the entity cache if it is enabled.
    *
    * @param mensajes the mensajes
    */
    public static void cacheResult(
        java.util.List<com.proyecto.quental.chat.model.Mensaje> mensajes) {
        getPersistence().cacheResult(mensajes);
    }

    /**
    * Creates a new mensaje with the primary key. Does not add the mensaje to the database.
    *
    * @param mensajeId the primary key for the new mensaje
    * @return the new mensaje
    */
    public static com.proyecto.quental.chat.model.Mensaje create(long mensajeId) {
        return getPersistence().create(mensajeId);
    }

    /**
    * Removes the mensaje with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje that was removed
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje remove(long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException {
        return getPersistence().remove(mensajeId);
    }

    public static com.proyecto.quental.chat.model.Mensaje updateImpl(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(mensaje);
    }

    /**
    * Returns the mensaje with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchMensajeException} if it could not be found.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje findByPrimaryKey(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException {
        return getPersistence().findByPrimaryKey(mensajeId);
    }

    /**
    * Returns the mensaje with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje, or <code>null</code> if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Mensaje fetchByPrimaryKey(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(mensajeId);
    }

    /**
    * Returns all the mensajes.
    *
    * @return the mensajes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the mensajes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.MensajeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mensajes
    * @param end the upper bound of the range of mensajes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of mensajes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Mensaje> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the mensajes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of mensajes.
    *
    * @return the number of mensajes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MensajePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MensajePersistence) PortletBeanLocatorUtil.locate(com.proyecto.quental.chat.service.ClpSerializer.getServletContextName(),
                    MensajePersistence.class.getName());

            ReferenceRegistry.registerReference(MensajeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MensajePersistence persistence) {
    }
}
