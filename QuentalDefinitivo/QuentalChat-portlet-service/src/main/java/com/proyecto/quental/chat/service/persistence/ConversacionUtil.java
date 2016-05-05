package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.proyecto.quental.chat.model.Conversacion;

import java.util.List;

/**
 * The persistence utility for the conversacion service. This utility wraps {@link ConversacionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConversacionPersistence
 * @see ConversacionPersistenceImpl
 * @generated
 */
public class ConversacionUtil {
    private static ConversacionPersistence _persistence;

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
    public static void clearCache(Conversacion conversacion) {
        getPersistence().clearCache(conversacion);
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
    public static List<Conversacion> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Conversacion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Conversacion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Conversacion update(Conversacion conversacion)
        throws SystemException {
        return getPersistence().update(conversacion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Conversacion update(Conversacion conversacion,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(conversacion, serviceContext);
    }

    /**
    * Returns all the conversacions where asignado = &#63;.
    *
    * @param asignado the asignado
    * @return the matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findByPendientes(
        boolean asignado)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPendientes(asignado);
    }

    /**
    * Returns a range of all the conversacions where asignado = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param asignado the asignado
    * @param start the lower bound of the range of conversacions
    * @param end the upper bound of the range of conversacions (not inclusive)
    * @return the range of matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findByPendientes(
        boolean asignado, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPendientes(asignado, start, end);
    }

    /**
    * Returns an ordered range of all the conversacions where asignado = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param asignado the asignado
    * @param start the lower bound of the range of conversacions
    * @param end the upper bound of the range of conversacions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findByPendientes(
        boolean asignado, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPendientes(asignado, start, end, orderByComparator);
    }

    /**
    * Returns the first conversacion in the ordered set where asignado = &#63;.
    *
    * @param asignado the asignado
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion findByPendientes_First(
        boolean asignado,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence()
                   .findByPendientes_First(asignado, orderByComparator);
    }

    /**
    * Returns the first conversacion in the ordered set where asignado = &#63;.
    *
    * @param asignado the asignado
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching conversacion, or <code>null</code> if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion fetchByPendientes_First(
        boolean asignado,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPendientes_First(asignado, orderByComparator);
    }

    /**
    * Returns the last conversacion in the ordered set where asignado = &#63;.
    *
    * @param asignado the asignado
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion findByPendientes_Last(
        boolean asignado,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence()
                   .findByPendientes_Last(asignado, orderByComparator);
    }

    /**
    * Returns the last conversacion in the ordered set where asignado = &#63;.
    *
    * @param asignado the asignado
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching conversacion, or <code>null</code> if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion fetchByPendientes_Last(
        boolean asignado,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPendientes_Last(asignado, orderByComparator);
    }

    /**
    * Returns the conversacions before and after the current conversacion in the ordered set where asignado = &#63;.
    *
    * @param conversacionId the primary key of the current conversacion
    * @param asignado the asignado
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion[] findByPendientes_PrevAndNext(
        long conversacionId, boolean asignado,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence()
                   .findByPendientes_PrevAndNext(conversacionId, asignado,
            orderByComparator);
    }

    /**
    * Removes all the conversacions where asignado = &#63; from the database.
    *
    * @param asignado the asignado
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPendientes(boolean asignado)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPendientes(asignado);
    }

    /**
    * Returns the number of conversacions where asignado = &#63;.
    *
    * @param asignado the asignado
    * @return the number of matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static int countByPendientes(boolean asignado)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPendientes(asignado);
    }

    /**
    * Returns all the conversacions where cerrada = &#63;.
    *
    * @param cerrada the cerrada
    * @return the matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findByCerradas(
        boolean cerrada)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCerradas(cerrada);
    }

    /**
    * Returns a range of all the conversacions where cerrada = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param cerrada the cerrada
    * @param start the lower bound of the range of conversacions
    * @param end the upper bound of the range of conversacions (not inclusive)
    * @return the range of matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findByCerradas(
        boolean cerrada, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCerradas(cerrada, start, end);
    }

    /**
    * Returns an ordered range of all the conversacions where cerrada = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param cerrada the cerrada
    * @param start the lower bound of the range of conversacions
    * @param end the upper bound of the range of conversacions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findByCerradas(
        boolean cerrada, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCerradas(cerrada, start, end, orderByComparator);
    }

    /**
    * Returns the first conversacion in the ordered set where cerrada = &#63;.
    *
    * @param cerrada the cerrada
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion findByCerradas_First(
        boolean cerrada,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence().findByCerradas_First(cerrada, orderByComparator);
    }

    /**
    * Returns the first conversacion in the ordered set where cerrada = &#63;.
    *
    * @param cerrada the cerrada
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching conversacion, or <code>null</code> if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion fetchByCerradas_First(
        boolean cerrada,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCerradas_First(cerrada, orderByComparator);
    }

    /**
    * Returns the last conversacion in the ordered set where cerrada = &#63;.
    *
    * @param cerrada the cerrada
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion findByCerradas_Last(
        boolean cerrada,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence().findByCerradas_Last(cerrada, orderByComparator);
    }

    /**
    * Returns the last conversacion in the ordered set where cerrada = &#63;.
    *
    * @param cerrada the cerrada
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching conversacion, or <code>null</code> if a matching conversacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion fetchByCerradas_Last(
        boolean cerrada,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCerradas_Last(cerrada, orderByComparator);
    }

    /**
    * Returns the conversacions before and after the current conversacion in the ordered set where cerrada = &#63;.
    *
    * @param conversacionId the primary key of the current conversacion
    * @param cerrada the cerrada
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion[] findByCerradas_PrevAndNext(
        long conversacionId, boolean cerrada,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence()
                   .findByCerradas_PrevAndNext(conversacionId, cerrada,
            orderByComparator);
    }

    /**
    * Removes all the conversacions where cerrada = &#63; from the database.
    *
    * @param cerrada the cerrada
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCerradas(boolean cerrada)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCerradas(cerrada);
    }

    /**
    * Returns the number of conversacions where cerrada = &#63;.
    *
    * @param cerrada the cerrada
    * @return the number of matching conversacions
    * @throws SystemException if a system exception occurred
    */
    public static int countByCerradas(boolean cerrada)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCerradas(cerrada);
    }

    /**
    * Caches the conversacion in the entity cache if it is enabled.
    *
    * @param conversacion the conversacion
    */
    public static void cacheResult(
        com.proyecto.quental.chat.model.Conversacion conversacion) {
        getPersistence().cacheResult(conversacion);
    }

    /**
    * Caches the conversacions in the entity cache if it is enabled.
    *
    * @param conversacions the conversacions
    */
    public static void cacheResult(
        java.util.List<com.proyecto.quental.chat.model.Conversacion> conversacions) {
        getPersistence().cacheResult(conversacions);
    }

    /**
    * Creates a new conversacion with the primary key. Does not add the conversacion to the database.
    *
    * @param conversacionId the primary key for the new conversacion
    * @return the new conversacion
    */
    public static com.proyecto.quental.chat.model.Conversacion create(
        long conversacionId) {
        return getPersistence().create(conversacionId);
    }

    /**
    * Removes the conversacion with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param conversacionId the primary key of the conversacion
    * @return the conversacion that was removed
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion remove(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence().remove(conversacionId);
    }

    public static com.proyecto.quental.chat.model.Conversacion updateImpl(
        com.proyecto.quental.chat.model.Conversacion conversacion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(conversacion);
    }

    /**
    * Returns the conversacion with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchConversacionException} if it could not be found.
    *
    * @param conversacionId the primary key of the conversacion
    * @return the conversacion
    * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion findByPrimaryKey(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchConversacionException {
        return getPersistence().findByPrimaryKey(conversacionId);
    }

    /**
    * Returns the conversacion with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param conversacionId the primary key of the conversacion
    * @return the conversacion, or <code>null</code> if a conversacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.proyecto.quental.chat.model.Conversacion fetchByPrimaryKey(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(conversacionId);
    }

    /**
    * Returns all the conversacions.
    *
    * @return the conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the conversacions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.ConversacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of conversacions
    * @param end the upper bound of the range of conversacions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of conversacions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.proyecto.quental.chat.model.Conversacion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the conversacions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of conversacions.
    *
    * @return the number of conversacions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ConversacionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ConversacionPersistence) PortletBeanLocatorUtil.locate(com.proyecto.quental.chat.service.ClpSerializer.getServletContextName(),
                    ConversacionPersistence.class.getName());

            ReferenceRegistry.registerReference(ConversacionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ConversacionPersistence persistence) {
    }
}
