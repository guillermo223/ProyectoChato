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

import com.proyecto.quental.chat.NoSuchAsignacionException;
import com.proyecto.quental.chat.model.Asignacion;
import com.proyecto.quental.chat.model.impl.AsignacionImpl;
import com.proyecto.quental.chat.model.impl.AsignacionModelImpl;
import com.proyecto.quental.chat.service.persistence.AsignacionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the asignacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AsignacionPersistence
 * @see AsignacionUtil
 * @generated
 */
public class AsignacionPersistenceImpl extends BasePersistenceImpl<Asignacion>
    implements AsignacionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AsignacionUtil} to access the asignacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AsignacionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, AsignacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, AsignacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONVERSACION =
        new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, AsignacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConversacion",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION =
        new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, AsignacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConversacion",
            new String[] { Long.class.getName() },
            AsignacionModelImpl.CONVERSACIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONVERSACION = new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConversacion",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CONVERSACION_CONVERSACIONID_2 = "asignacion.conversacionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TECNICO = new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, AsignacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTecnico",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECNICO =
        new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, AsignacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTecnico",
            new String[] { Long.class.getName() },
            AsignacionModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TECNICO = new FinderPath(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTecnico",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_TECNICO_USERID_2 = "asignacion.userId = ?";
    private static final String _SQL_SELECT_ASIGNACION = "SELECT asignacion FROM Asignacion asignacion";
    private static final String _SQL_SELECT_ASIGNACION_WHERE = "SELECT asignacion FROM Asignacion asignacion WHERE ";
    private static final String _SQL_COUNT_ASIGNACION = "SELECT COUNT(asignacion) FROM Asignacion asignacion";
    private static final String _SQL_COUNT_ASIGNACION_WHERE = "SELECT COUNT(asignacion) FROM Asignacion asignacion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "asignacion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Asignacion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Asignacion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AsignacionPersistenceImpl.class);
    private static Asignacion _nullAsignacion = new AsignacionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Asignacion> toCacheModel() {
                return _nullAsignacionCacheModel;
            }
        };

    private static CacheModel<Asignacion> _nullAsignacionCacheModel = new CacheModel<Asignacion>() {
            @Override
            public Asignacion toEntityModel() {
                return _nullAsignacion;
            }
        };

    public AsignacionPersistenceImpl() {
        setModelClass(Asignacion.class);
    }

    /**
     * Returns all the asignacions where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @return the matching asignacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Asignacion> findByConversacion(long conversacionId)
        throws SystemException {
        return findByConversacion(conversacionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Asignacion> findByConversacion(long conversacionId, int start,
        int end) throws SystemException {
        return findByConversacion(conversacionId, start, end, null);
    }

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
    @Override
    public List<Asignacion> findByConversacion(long conversacionId, int start,
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

        List<Asignacion> list = (List<Asignacion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Asignacion asignacion : list) {
                if ((conversacionId != asignacion.getConversacionId())) {
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

            query.append(_SQL_SELECT_ASIGNACION_WHERE);

            query.append(_FINDER_COLUMN_CONVERSACION_CONVERSACIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AsignacionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(conversacionId);

                if (!pagination) {
                    list = (List<Asignacion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Asignacion>(list);
                } else {
                    list = (List<Asignacion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first asignacion in the ordered set where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching asignacion
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion findByConversacion_First(long conversacionId,
        OrderByComparator orderByComparator)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = fetchByConversacion_First(conversacionId,
                orderByComparator);

        if (asignacion != null) {
            return asignacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("conversacionId=");
        msg.append(conversacionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAsignacionException(msg.toString());
    }

    /**
     * Returns the first asignacion in the ordered set where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching asignacion, or <code>null</code> if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion fetchByConversacion_First(long conversacionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Asignacion> list = findByConversacion(conversacionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last asignacion in the ordered set where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching asignacion
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion findByConversacion_Last(long conversacionId,
        OrderByComparator orderByComparator)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = fetchByConversacion_Last(conversacionId,
                orderByComparator);

        if (asignacion != null) {
            return asignacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("conversacionId=");
        msg.append(conversacionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAsignacionException(msg.toString());
    }

    /**
     * Returns the last asignacion in the ordered set where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching asignacion, or <code>null</code> if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion fetchByConversacion_Last(long conversacionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByConversacion(conversacionId);

        if (count == 0) {
            return null;
        }

        List<Asignacion> list = findByConversacion(conversacionId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Asignacion[] findByConversacion_PrevAndNext(long asignacionId,
        long conversacionId, OrderByComparator orderByComparator)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = findByPrimaryKey(asignacionId);

        Session session = null;

        try {
            session = openSession();

            Asignacion[] array = new AsignacionImpl[3];

            array[0] = getByConversacion_PrevAndNext(session, asignacion,
                    conversacionId, orderByComparator, true);

            array[1] = asignacion;

            array[2] = getByConversacion_PrevAndNext(session, asignacion,
                    conversacionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Asignacion getByConversacion_PrevAndNext(Session session,
        Asignacion asignacion, long conversacionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ASIGNACION_WHERE);

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
            query.append(AsignacionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(conversacionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(asignacion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Asignacion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the asignacions where conversacionId = &#63; from the database.
     *
     * @param conversacionId the conversacion ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByConversacion(long conversacionId)
        throws SystemException {
        for (Asignacion asignacion : findByConversacion(conversacionId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(asignacion);
        }
    }

    /**
     * Returns the number of asignacions where conversacionId = &#63;.
     *
     * @param conversacionId the conversacion ID
     * @return the number of matching asignacions
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

            query.append(_SQL_COUNT_ASIGNACION_WHERE);

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
     * Returns all the asignacions where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching asignacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Asignacion> findByTecnico(long userId)
        throws SystemException {
        return findByTecnico(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Asignacion> findByTecnico(long userId, int start, int end)
        throws SystemException {
        return findByTecnico(userId, start, end, null);
    }

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
    @Override
    public List<Asignacion> findByTecnico(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECNICO;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TECNICO;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Asignacion> list = (List<Asignacion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Asignacion asignacion : list) {
                if ((userId != asignacion.getUserId())) {
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

            query.append(_SQL_SELECT_ASIGNACION_WHERE);

            query.append(_FINDER_COLUMN_TECNICO_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AsignacionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Asignacion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Asignacion>(list);
                } else {
                    list = (List<Asignacion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first asignacion in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching asignacion
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion findByTecnico_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = fetchByTecnico_First(userId, orderByComparator);

        if (asignacion != null) {
            return asignacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAsignacionException(msg.toString());
    }

    /**
     * Returns the first asignacion in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching asignacion, or <code>null</code> if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion fetchByTecnico_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Asignacion> list = findByTecnico(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last asignacion in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching asignacion
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion findByTecnico_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = fetchByTecnico_Last(userId, orderByComparator);

        if (asignacion != null) {
            return asignacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAsignacionException(msg.toString());
    }

    /**
     * Returns the last asignacion in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching asignacion, or <code>null</code> if a matching asignacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion fetchByTecnico_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTecnico(userId);

        if (count == 0) {
            return null;
        }

        List<Asignacion> list = findByTecnico(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Asignacion[] findByTecnico_PrevAndNext(long asignacionId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = findByPrimaryKey(asignacionId);

        Session session = null;

        try {
            session = openSession();

            Asignacion[] array = new AsignacionImpl[3];

            array[0] = getByTecnico_PrevAndNext(session, asignacion, userId,
                    orderByComparator, true);

            array[1] = asignacion;

            array[2] = getByTecnico_PrevAndNext(session, asignacion, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Asignacion getByTecnico_PrevAndNext(Session session,
        Asignacion asignacion, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ASIGNACION_WHERE);

        query.append(_FINDER_COLUMN_TECNICO_USERID_2);

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
            query.append(AsignacionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(asignacion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Asignacion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the asignacions where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTecnico(long userId) throws SystemException {
        for (Asignacion asignacion : findByTecnico(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(asignacion);
        }
    }

    /**
     * Returns the number of asignacions where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching asignacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTecnico(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TECNICO;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ASIGNACION_WHERE);

            query.append(_FINDER_COLUMN_TECNICO_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
     * Caches the asignacion in the entity cache if it is enabled.
     *
     * @param asignacion the asignacion
     */
    @Override
    public void cacheResult(Asignacion asignacion) {
        EntityCacheUtil.putResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionImpl.class, asignacion.getPrimaryKey(), asignacion);

        asignacion.resetOriginalValues();
    }

    /**
     * Caches the asignacions in the entity cache if it is enabled.
     *
     * @param asignacions the asignacions
     */
    @Override
    public void cacheResult(List<Asignacion> asignacions) {
        for (Asignacion asignacion : asignacions) {
            if (EntityCacheUtil.getResult(
                        AsignacionModelImpl.ENTITY_CACHE_ENABLED,
                        AsignacionImpl.class, asignacion.getPrimaryKey()) == null) {
                cacheResult(asignacion);
            } else {
                asignacion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all asignacions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AsignacionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AsignacionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the asignacion.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Asignacion asignacion) {
        EntityCacheUtil.removeResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionImpl.class, asignacion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Asignacion> asignacions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Asignacion asignacion : asignacions) {
            EntityCacheUtil.removeResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
                AsignacionImpl.class, asignacion.getPrimaryKey());
        }
    }

    /**
     * Creates a new asignacion with the primary key. Does not add the asignacion to the database.
     *
     * @param asignacionId the primary key for the new asignacion
     * @return the new asignacion
     */
    @Override
    public Asignacion create(long asignacionId) {
        Asignacion asignacion = new AsignacionImpl();

        asignacion.setNew(true);
        asignacion.setPrimaryKey(asignacionId);

        return asignacion;
    }

    /**
     * Removes the asignacion with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param asignacionId the primary key of the asignacion
     * @return the asignacion that was removed
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion remove(long asignacionId)
        throws NoSuchAsignacionException, SystemException {
        return remove((Serializable) asignacionId);
    }

    /**
     * Removes the asignacion with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the asignacion
     * @return the asignacion that was removed
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion remove(Serializable primaryKey)
        throws NoSuchAsignacionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Asignacion asignacion = (Asignacion) session.get(AsignacionImpl.class,
                    primaryKey);

            if (asignacion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAsignacionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(asignacion);
        } catch (NoSuchAsignacionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Asignacion removeImpl(Asignacion asignacion)
        throws SystemException {
        asignacion = toUnwrappedModel(asignacion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(asignacion)) {
                asignacion = (Asignacion) session.get(AsignacionImpl.class,
                        asignacion.getPrimaryKeyObj());
            }

            if (asignacion != null) {
                session.delete(asignacion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (asignacion != null) {
            clearCache(asignacion);
        }

        return asignacion;
    }

    @Override
    public Asignacion updateImpl(
        com.proyecto.quental.chat.model.Asignacion asignacion)
        throws SystemException {
        asignacion = toUnwrappedModel(asignacion);

        boolean isNew = asignacion.isNew();

        AsignacionModelImpl asignacionModelImpl = (AsignacionModelImpl) asignacion;

        Session session = null;

        try {
            session = openSession();

            if (asignacion.isNew()) {
                session.save(asignacion);

                asignacion.setNew(false);
            } else {
                session.merge(asignacion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AsignacionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((asignacionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        asignacionModelImpl.getOriginalConversacionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONVERSACION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION,
                    args);

                args = new Object[] { asignacionModelImpl.getConversacionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONVERSACION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERSACION,
                    args);
            }

            if ((asignacionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECNICO.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        asignacionModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TECNICO, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECNICO,
                    args);

                args = new Object[] { asignacionModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TECNICO, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECNICO,
                    args);
            }
        }

        EntityCacheUtil.putResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
            AsignacionImpl.class, asignacion.getPrimaryKey(), asignacion);

        return asignacion;
    }

    protected Asignacion toUnwrappedModel(Asignacion asignacion) {
        if (asignacion instanceof AsignacionImpl) {
            return asignacion;
        }

        AsignacionImpl asignacionImpl = new AsignacionImpl();

        asignacionImpl.setNew(asignacion.isNew());
        asignacionImpl.setPrimaryKey(asignacion.getPrimaryKey());

        asignacionImpl.setAsignacionId(asignacion.getAsignacionId());
        asignacionImpl.setUserId(asignacion.getUserId());
        asignacionImpl.setConversacionId(asignacion.getConversacionId());

        return asignacionImpl;
    }

    /**
     * Returns the asignacion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the asignacion
     * @return the asignacion
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAsignacionException, SystemException {
        Asignacion asignacion = fetchByPrimaryKey(primaryKey);

        if (asignacion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAsignacionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return asignacion;
    }

    /**
     * Returns the asignacion with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchAsignacionException} if it could not be found.
     *
     * @param asignacionId the primary key of the asignacion
     * @return the asignacion
     * @throws com.proyecto.quental.chat.NoSuchAsignacionException if a asignacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion findByPrimaryKey(long asignacionId)
        throws NoSuchAsignacionException, SystemException {
        return findByPrimaryKey((Serializable) asignacionId);
    }

    /**
     * Returns the asignacion with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the asignacion
     * @return the asignacion, or <code>null</code> if a asignacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Asignacion asignacion = (Asignacion) EntityCacheUtil.getResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
                AsignacionImpl.class, primaryKey);

        if (asignacion == _nullAsignacion) {
            return null;
        }

        if (asignacion == null) {
            Session session = null;

            try {
                session = openSession();

                asignacion = (Asignacion) session.get(AsignacionImpl.class,
                        primaryKey);

                if (asignacion != null) {
                    cacheResult(asignacion);
                } else {
                    EntityCacheUtil.putResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
                        AsignacionImpl.class, primaryKey, _nullAsignacion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AsignacionModelImpl.ENTITY_CACHE_ENABLED,
                    AsignacionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return asignacion;
    }

    /**
     * Returns the asignacion with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param asignacionId the primary key of the asignacion
     * @return the asignacion, or <code>null</code> if a asignacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Asignacion fetchByPrimaryKey(long asignacionId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) asignacionId);
    }

    /**
     * Returns all the asignacions.
     *
     * @return the asignacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Asignacion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Asignacion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Asignacion> findAll(int start, int end,
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

        List<Asignacion> list = (List<Asignacion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ASIGNACION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ASIGNACION;

                if (pagination) {
                    sql = sql.concat(AsignacionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Asignacion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Asignacion>(list);
                } else {
                    list = (List<Asignacion>) QueryUtil.list(q, getDialect(),
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
     * Removes all the asignacions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Asignacion asignacion : findAll()) {
            remove(asignacion);
        }
    }

    /**
     * Returns the number of asignacions.
     *
     * @return the number of asignacions
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

                Query q = session.createQuery(_SQL_COUNT_ASIGNACION);

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
     * Initializes the asignacion persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.proyecto.quental.chat.model.Asignacion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Asignacion>> listenersList = new ArrayList<ModelListener<Asignacion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Asignacion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AsignacionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
