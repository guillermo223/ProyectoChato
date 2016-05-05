package com.proyecto.quental.chat.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.proyecto.quental.chat.NoSuchMensajeException;
import com.proyecto.quental.chat.model.Mensaje;
import com.proyecto.quental.chat.model.impl.MensajeImpl;
import com.proyecto.quental.chat.model.impl.MensajeModelImpl;
import com.proyecto.quental.chat.service.persistence.MensajePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mensaje service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MensajePersistence
 * @see MensajeUtil
 * @generated
 */
public class MensajePersistenceImpl extends BasePersistenceImpl<Mensaje>
    implements MensajePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MensajeUtil} to access the mensaje persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MensajeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeModelImpl.FINDER_CACHE_ENABLED, MensajeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeModelImpl.FINDER_CACHE_ENABLED, MensajeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONVERSACION =
        new FinderPath(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeModelImpl.FINDER_CACHE_ENABLED, MensajeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConversacion",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION =
        new FinderPath(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeModelImpl.FINDER_CACHE_ENABLED, MensajeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConversacion",
            new String[] { Long.class.getName() },
            MensajeModelImpl.CONVERSACIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONVERSACION = new FinderPath(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConversacion",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CONVERSACION_CONVERSACIONID_2 = "mensaje.conversacionId = ?";
    private static final String _SQL_SELECT_MENSAJE = "SELECT mensaje FROM Mensaje mensaje";
    private static final String _SQL_SELECT_MENSAJE_WHERE = "SELECT mensaje FROM Mensaje mensaje WHERE ";
    private static final String _SQL_COUNT_MENSAJE = "SELECT COUNT(mensaje) FROM Mensaje mensaje";
    private static final String _SQL_COUNT_MENSAJE_WHERE = "SELECT COUNT(mensaje) FROM Mensaje mensaje WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "mensaje.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mensaje exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Mensaje exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MensajePersistenceImpl.class);
    private static Mensaje _nullMensaje = new MensajeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Mensaje> toCacheModel() {
                return _nullMensajeCacheModel;
            }
        };

    private static CacheModel<Mensaje> _nullMensajeCacheModel = new CacheModel<Mensaje>() {
            @Override
            public Mensaje toEntityModel() {
                return _nullMensaje;
            }
        };

    public MensajePersistenceImpl() {
        setModelClass(Mensaje.class);
    }

    /**
     * Returns all the mensajes where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @return the matching mensajes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Mensaje> findByConversacion(long conversacionId)
        throws SystemException {
        return findByConversacion(conversacionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Mensaje> findByConversacion(long conversacionId, int start,
        int end) throws SystemException {
        return findByConversacion(conversacionId, start, end, null);
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
    @Override
    public List<Mensaje> findByConversacion(long conversacionId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION;
            finderArgs = new Object[] { conversacionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONVERSACION;
            finderArgs = new Object[] {
                    conversacionId,
                    
                    start, end, orderByComparator
                };
        }

        List<Mensaje> list = (List<Mensaje>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Mensaje mensaje : list) {
                if ((conversacionId != mensaje.getConversacionId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_MENSAJE_WHERE);

            query.append(_FINDER_COLUMN_CONVERSACION_CONVERSACIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MensajeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(conversacionId);

                if (!pagination) {
                    list = (List<Mensaje>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Mensaje>(list);
                } else {
                    list = (List<Mensaje>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Mensaje findByConversacion_First(long conversacionId,
        OrderByComparator orderByComparator)
        throws NoSuchMensajeException, SystemException {
        Mensaje mensaje = fetchByConversacion_First(conversacionId,
                orderByComparator);

        if (mensaje != null) {
            return mensaje;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("conversacionId=");
        msg.append(conversacionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMensajeException(msg.toString());
    }

    /**
     * Returns the first mensaje in the ordered set where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching mensaje, or <code>null</code> if a matching mensaje could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje fetchByConversacion_First(long conversacionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Mensaje> list = findByConversacion(conversacionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Mensaje findByConversacion_Last(long conversacionId,
        OrderByComparator orderByComparator)
        throws NoSuchMensajeException, SystemException {
        Mensaje mensaje = fetchByConversacion_Last(conversacionId,
                orderByComparator);

        if (mensaje != null) {
            return mensaje;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("conversacionId=");
        msg.append(conversacionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMensajeException(msg.toString());
    }

    /**
     * Returns the last mensaje in the ordered set where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching mensaje, or <code>null</code> if a matching mensaje could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje fetchByConversacion_Last(long conversacionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByConversacion(conversacionId);

        if (count == 0) {
            return null;
        }

        List<Mensaje> list = findByConversacion(conversacionId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Mensaje[] findByConversacion_PrevAndNext(long mensajeId,
        long conversacionId, OrderByComparator orderByComparator)
        throws NoSuchMensajeException, SystemException {
        Mensaje mensaje = findByPrimaryKey(mensajeId);

        Session session = null;

        try {
            session = openSession();

            Mensaje[] array = new MensajeImpl[3];

            array[0] = getByConversacion_PrevAndNext(session, mensaje,
                    conversacionId, orderByComparator, true);

            array[1] = mensaje;

            array[2] = getByConversacion_PrevAndNext(session, mensaje,
                    conversacionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Mensaje getByConversacion_PrevAndNext(Session session,
        Mensaje mensaje, long conversacionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MENSAJE_WHERE);

        query.append(_FINDER_COLUMN_CONVERSACION_CONVERSACIONID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(MensajeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(conversacionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(mensaje);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Mensaje> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the mensajes where conversacionId = &#63; from the database.
     *
     * @param conversacionId the conversacion ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByConversacion(long conversacionId)
        throws SystemException {
        for (Mensaje mensaje : findByConversacion(conversacionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(mensaje);
        }
    }

    /**
     * Returns the number of mensajes where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @return the number of matching mensajes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByConversacion(long conversacionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONVERSACION;

        Object[] finderArgs = new Object[] { conversacionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MENSAJE_WHERE);

            query.append(_FINDER_COLUMN_CONVERSACION_CONVERSACIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(conversacionId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the mensaje in the entity cache if it is enabled.
     *
     * @param mensaje the mensaje
     */
    @Override
    public void cacheResult(Mensaje mensaje) {
        EntityCacheUtil.putResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeImpl.class, mensaje.getPrimaryKey(), mensaje);

        mensaje.resetOriginalValues();
    }

    /**
     * Caches the mensajes in the entity cache if it is enabled.
     *
     * @param mensajes the mensajes
     */
    @Override
    public void cacheResult(List<Mensaje> mensajes) {
        for (Mensaje mensaje : mensajes) {
            if (EntityCacheUtil.getResult(
                        MensajeModelImpl.ENTITY_CACHE_ENABLED,
                        MensajeImpl.class, mensaje.getPrimaryKey()) == null) {
                cacheResult(mensaje);
            } else {
                mensaje.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all mensajes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MensajeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MensajeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the mensaje.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Mensaje mensaje) {
        EntityCacheUtil.removeResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeImpl.class, mensaje.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Mensaje> mensajes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Mensaje mensaje : mensajes) {
            EntityCacheUtil.removeResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
                MensajeImpl.class, mensaje.getPrimaryKey());
        }
    }

    /**
     * Creates a new mensaje with the primary key. Does not add the mensaje to the database.
     *
     * @param mensajeId the primary key for the new mensaje
     * @return the new mensaje
     */
    @Override
    public Mensaje create(long mensajeId) {
        Mensaje mensaje = new MensajeImpl();

        mensaje.setNew(true);
        mensaje.setPrimaryKey(mensajeId);

        return mensaje;
    }

    /**
     * Removes the mensaje with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param mensajeId the primary key of the mensaje
     * @return the mensaje that was removed
     * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje remove(long mensajeId)
        throws NoSuchMensajeException, SystemException {
        return remove((Serializable) mensajeId);
    }

    /**
     * Removes the mensaje with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the mensaje
     * @return the mensaje that was removed
     * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje remove(Serializable primaryKey)
        throws NoSuchMensajeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Mensaje mensaje = (Mensaje) session.get(MensajeImpl.class,
                    primaryKey);

            if (mensaje == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMensajeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(mensaje);
        } catch (NoSuchMensajeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Mensaje removeImpl(Mensaje mensaje) throws SystemException {
        mensaje = toUnwrappedModel(mensaje);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(mensaje)) {
                mensaje = (Mensaje) session.get(MensajeImpl.class,
                        mensaje.getPrimaryKeyObj());
            }

            if (mensaje != null) {
                session.delete(mensaje);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (mensaje != null) {
            clearCache(mensaje);
        }

        return mensaje;
    }

    @Override
    public Mensaje updateImpl(com.proyecto.quental.chat.model.Mensaje mensaje)
        throws SystemException {
        mensaje = toUnwrappedModel(mensaje);

        boolean isNew = mensaje.isNew();

        MensajeModelImpl mensajeModelImpl = (MensajeModelImpl) mensaje;

        Session session = null;

        try {
            session = openSession();

            if (mensaje.isNew()) {
                session.save(mensaje);

                mensaje.setNew(false);
            } else {
                session.merge(mensaje);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MensajeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((mensajeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        mensajeModelImpl.getOriginalConversacionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONVERSACION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION,
                    args);

                args = new Object[] { mensajeModelImpl.getConversacionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONVERSACION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION,
                    args);
            }
        }

        EntityCacheUtil.putResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
            MensajeImpl.class, mensaje.getPrimaryKey(), mensaje);

        return mensaje;
    }

    protected Mensaje toUnwrappedModel(Mensaje mensaje) {
        if (mensaje instanceof MensajeImpl) {
            return mensaje;
        }

        MensajeImpl mensajeImpl = new MensajeImpl();

        mensajeImpl.setNew(mensaje.isNew());
        mensajeImpl.setPrimaryKey(mensaje.getPrimaryKey());

        mensajeImpl.setMensajeId(mensaje.getMensajeId());
        mensajeImpl.setAutor(mensaje.getAutor());
        mensajeImpl.setCreateDate(mensaje.getCreateDate());
        mensajeImpl.setContenido(mensaje.getContenido());
        mensajeImpl.setConversacionId(mensaje.getConversacionId());

        return mensajeImpl;
    }

    /**
     * Returns the mensaje with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the mensaje
     * @return the mensaje
     * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMensajeException, SystemException {
        Mensaje mensaje = fetchByPrimaryKey(primaryKey);

        if (mensaje == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMensajeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return mensaje;
    }

    /**
     * Returns the mensaje with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchMensajeException} if it could not be found.
     *
     * @param mensajeId the primary key of the mensaje
     * @return the mensaje
     * @throws com.proyecto.quental.chat.NoSuchMensajeException if a mensaje with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje findByPrimaryKey(long mensajeId)
        throws NoSuchMensajeException, SystemException {
        return findByPrimaryKey((Serializable) mensajeId);
    }

    /**
     * Returns the mensaje with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the mensaje
     * @return the mensaje, or <code>null</code> if a mensaje with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Mensaje mensaje = (Mensaje) EntityCacheUtil.getResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
                MensajeImpl.class, primaryKey);

        if (mensaje == _nullMensaje) {
            return null;
        }

        if (mensaje == null) {
            Session session = null;

            try {
                session = openSession();

                mensaje = (Mensaje) session.get(MensajeImpl.class, primaryKey);

                if (mensaje != null) {
                    cacheResult(mensaje);
                } else {
                    EntityCacheUtil.putResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
                        MensajeImpl.class, primaryKey, _nullMensaje);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MensajeModelImpl.ENTITY_CACHE_ENABLED,
                    MensajeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return mensaje;
    }

    /**
     * Returns the mensaje with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param mensajeId the primary key of the mensaje
     * @return the mensaje, or <code>null</code> if a mensaje with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Mensaje fetchByPrimaryKey(long mensajeId) throws SystemException {
        return fetchByPrimaryKey((Serializable) mensajeId);
    }

    /**
     * Returns all the mensajes.
     *
     * @return the mensajes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Mensaje> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Mensaje> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Mensaje> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Mensaje> list = (List<Mensaje>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MENSAJE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MENSAJE;

                if (pagination) {
                    sql = sql.concat(MensajeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Mensaje>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Mensaje>(list);
                } else {
                    list = (List<Mensaje>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the mensajes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Mensaje mensaje : findAll()) {
            remove(mensaje);
        }
    }

    /**
     * Returns the number of mensajes.
     *
     * @return the number of mensajes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_MENSAJE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the mensaje persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.proyecto.quental.chat.model.Mensaje")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Mensaje>> listenersList = new ArrayList<ModelListener<Mensaje>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Mensaje>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MensajeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
