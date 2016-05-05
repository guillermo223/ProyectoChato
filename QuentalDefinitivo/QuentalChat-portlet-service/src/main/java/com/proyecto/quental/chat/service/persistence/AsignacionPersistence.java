package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.proyecto.quental.chat.model.Asignacion;

/**
 * The persistence interface for the asignacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AsignacionPersistenceImpl
 * @see AsignacionUtil
 * @generated
 */
public interface AsignacionPersistence extends BasePersistence<Asignacion> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AsignacionUtil} to access the asignacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the asignacions where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @return the matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findByConversacion(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the asignacions where conversacionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param conversacionId the conversacion ID
    * @param start the lower bound of the range of asignacions
    * @param end the upper bound of the range of asignacions (not inclusive)
    * @return the range of matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findByConversacion(
        long conversacionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the asignacions where conversacionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param conversacionId the conversacion ID
    * @param start the lower bound of the range of asignacions
    * @param end the upper bound of the range of asignacions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findByConversacion(
        long conversacionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first asignacion in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion findByConversacion_First(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Returns the first asignacion in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching asignacion, or <code>null</code> if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion fetchByConversacion_First(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last asignacion in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion findByConversacion_Last(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Returns the last asignacion in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching asignacion, or <code>null</code> if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion fetchByConversacion_Last(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the asignacions before and after the current asignacion in the ordered set where conversacionId = &#63;.
    *
    * @param asignacionId the primary key of the current asignacion
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion[] findByConversacion_PrevAndNext(
        long asignacionId, long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Removes all the asignacions where conversacionId = &#63; from the database.
    *
    * @param conversacionId the conversacion ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByConversacion(long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of asignacions where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @return the number of matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public int countByConversacion(long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the asignacions where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findByTecnico(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the asignacions where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of asignacions
    * @param end the upper bound of the range of asignacions (not inclusive)
    * @return the range of matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findByTecnico(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the asignacions where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of asignacions
    * @param end the upper bound of the range of asignacions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findByTecnico(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first asignacion in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion findByTecnico_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Returns the first asignacion in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching asignacion, or <code>null</code> if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion fetchByTecnico_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last asignacion in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion findByTecnico_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Returns the last asignacion in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching asignacion, or <code>null</code> if a matching asignacion could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion fetchByTecnico_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the asignacions before and after the current asignacion in the ordered set where userId = &#63;.
    *
    * @param asignacionId the primary key of the current asignacion
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion[] findByTecnico_PrevAndNext(
        long asignacionId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Removes all the asignacions where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByTecnico(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of asignacions where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching asignacions
    * @throws SystemException if a system exception occurred
    */
    public int countByTecnico(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the asignacion in the entity cache if it is enabled.
    *
    * @param asignacion the asignacion
    */
    public void cacheResult(
        com.proyecto.quental.chat.model.Asignacion asignacion);

    /**
    * Caches the asignacions in the entity cache if it is enabled.
    *
    * @param asignacions the asignacions
    */
    public void cacheResult(
        java.util.List<com.proyecto.quental.chat.model.Asignacion> asignacions);

    /**
    * Creates a new asignacion with the primary key. Does not add the asignacion to the database.
    *
    * @param asignacionId the primary key for the new asignacion
    * @return the new asignacion
    */
    public com.proyecto.quental.chat.model.Asignacion create(long asignacionId);

    /**
    * Removes the asignacion with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param asignacionId the primary key of the asignacion
    * @return the asignacion that was removed
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion remove(long asignacionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    public com.proyecto.quental.chat.model.Asignacion updateImpl(
        com.proyecto.quental.chat.model.Asignacion asignacion)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the asignacion with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchAsignacionException} if it could not be found.
    *
    * @param asignacionId the primary key of the asignacion
    * @return the asignacion
    * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion findByPrimaryKey(
        long asignacionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchAsignacionException;

    /**
    * Returns the asignacion with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param asignacionId the primary key of the asignacion
    * @return the asignacion, or <code>null</code> if a asignacion with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Asignacion fetchByPrimaryKey(
        long asignacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the asignacions.
    *
    * @return the asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the asignacions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.proyecto.quental.chat.model.impl.AsignacionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of asignacions
    * @param end the upper bound of the range of asignacions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of asignacions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Asignacion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the asignacions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of asignacions.
    *
    * @return the number of asignacions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
