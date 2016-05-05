package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.proyecto.quental.chat.model.Mensaje;

/**
 * The persistence interface for the mensaje service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MensajePersistenceImpl
 * @see MensajeUtil
 * @generated
 */
public interface MensajePersistence extends BasePersistence<Mensaje> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MensajeUtil} to access the mensaje persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the mensajes where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @return the matching mensajes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> findByConversacion(
        long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> findByConversacion(
        long conversacionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> findByConversacion(
        long conversacionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje findByConversacion_First(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException;

    /**
    * Returns the first mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mensaje, or <code>null</code> if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje fetchByConversacion_First(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje findByConversacion_Last(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException;

    /**
    * Returns the last mensaje in the ordered set where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mensaje, or <code>null</code> if a matching mensaje could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje fetchByConversacion_Last(
        long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.proyecto.quental.chat.model.Mensaje[] findByConversacion_PrevAndNext(
        long mensajeId, long conversacionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException;

    /**
    * Removes all the mensajes where conversacionId = &#63; from the database.
    *
    * @param conversacionId the conversacion ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByConversacion(long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of mensajes where conversacionId = &#63;.
    *
    * @param conversacionId the conversacion ID
    * @return the number of matching mensajes
    * @throws SystemException if a system exception occurred
    */
    public int countByConversacion(long conversacionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the mensaje in the entity cache if it is enabled.
    *
    * @param mensaje the mensaje
    */
    public void cacheResult(com.proyecto.quental.chat.model.Mensaje mensaje);

    /**
    * Caches the mensajes in the entity cache if it is enabled.
    *
    * @param mensajes the mensajes
    */
    public void cacheResult(
        java.util.List<com.proyecto.quental.chat.model.Mensaje> mensajes);

    /**
    * Creates a new mensaje with the primary key. Does not add the mensaje to the database.
    *
    * @param mensajeId the primary key for the new mensaje
    * @return the new mensaje
    */
    public com.proyecto.quental.chat.model.Mensaje create(long mensajeId);

    /**
    * Removes the mensaje with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje that was removed
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje remove(long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException;

    public com.proyecto.quental.chat.model.Mensaje updateImpl(
        com.proyecto.quental.chat.model.Mensaje mensaje)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the mensaje with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchMensajeException} if it could not be found.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje
    * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje findByPrimaryKey(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.proyecto.quental.chat.NoSuchMensajeException;

    /**
    * Returns the mensaje with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mensajeId the primary key of the mensaje
    * @return the mensaje, or <code>null</code> if a mensaje with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.proyecto.quental.chat.model.Mensaje fetchByPrimaryKey(
        long mensajeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the mensajes.
    *
    * @return the mensajes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.proyecto.quental.chat.model.Mensaje> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the mensajes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of mensajes.
    *
    * @return the number of mensajes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
