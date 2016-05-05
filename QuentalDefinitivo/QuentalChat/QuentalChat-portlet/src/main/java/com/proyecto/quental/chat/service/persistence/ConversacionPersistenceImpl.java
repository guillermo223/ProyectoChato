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

import com.proyecto.quental.chat.NoSuchConversacionException;
import com.proyecto.quental.chat.model.Conversacion;
import com.proyecto.quental.chat.model.impl.ConversacionImpl;
import com.proyecto.quental.chat.model.impl.ConversacionModelImpl;
import com.proyecto.quental.chat.service.persistence.ConversacionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the conversacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConversacionPersistence
 * @see ConversacionUtil
 * @generated
 */
public class ConversacionPersistenceImpl extends BasePersistenceImpl<Conversacion>
    implements ConversacionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ConversacionUtil} to access the conversacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ConversacionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, ConversacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, ConversacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PENDIENTES =
        new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, ConversacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPendientes",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PENDIENTES =
        new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, ConversacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPendientes",
            new String[] { Boolean.class.getName() },
            ConversacionModelImpl.ASIGNADO_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PENDIENTES = new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPendientes",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_PENDIENTES_ASIGNADO_2 = "conversacion.asignado = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERRADAS = new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, ConversacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCerradas",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERRADAS =
        new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, ConversacionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCerradas",
            new String[] { Boolean.class.getName() },
            ConversacionModelImpl.CERRADA_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERRADAS = new FinderPath(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCerradas",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_CERRADAS_CERRADA_2 = "conversacion.cerrada = ?";
    private static final String _SQL_SELECT_CONVERSACION = "SELECT conversacion FROM Conversacion conversacion";
    private static final String _SQL_SELECT_CONVERSACION_WHERE = "SELECT conversacion FROM Conversacion conversacion WHERE ";
    private static final String _SQL_COUNT_CONVERSACION = "SELECT COUNT(conversacion) FROM Conversacion conversacion";
    private static final String _SQL_COUNT_CONVERSACION_WHERE = "SELECT COUNT(conversacion) FROM Conversacion conversacion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "conversacion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Conversacion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Conversacion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ConversacionPersistenceImpl.class);
    private static Conversacion _nullConversacion = new ConversacionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Conversacion> toCacheModel() {
                return _nullConversacionCacheModel;
            }
        };

    private static CacheModel<Conversacion> _nullConversacionCacheModel = new CacheModel<Conversacion>() {
            @Override
            public Conversacion toEntityModel() {
                return _nullConversacion;
            }
        };

    public ConversacionPersistenceImpl() {
        setModelClass(Conversacion.class);
    }

    /**
     * Returns all the conversacions where asignado = &#63;.
     *
     * @param asignado the asignado
     * @return the matching conversacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Conversacion> findByPendientes(boolean asignado)
        throws SystemException {
        return findByPendientes(asignado, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Conversacion> findByPendientes(boolean asignado, int start,
        int end) throws SystemException {
        return findByPendientes(asignado, start, end, null);
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
    @Override
    public List<Conversacion> findByPendientes(boolean asignado, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PENDIENTES;
            finderArgs = new Object[] { asignado };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PENDIENTES;
            finderArgs = new Object[] { asignado, start, end, orderByComparator };
        }

        List<Conversacion> list = (List<Conversacion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Conversacion conversacion : list) {
                if ((asignado != conversacion.getAsignado())) {
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

            query.append(_SQL_SELECT_CONVERSACION_WHERE);

            query.append(_FINDER_COLUMN_PENDIENTES_ASIGNADO_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ConversacionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(asignado);

                if (!pagination) {
                    list = (List<Conversacion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Conversacion>(list);
                } else {
                    list = (List<Conversacion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first conversacion in the ordered set where asignado = &#63;.
     *
     * @param asignado the asignado
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching conversacion
     * @throws com.proyecto.quental.chat.NoSuchConversacionException if a matching conversacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion findByPendientes_First(boolean asignado,
        OrderByComparator orderByComparator)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = fetchByPendientes_First(asignado,
                orderByComparator);

        if (conversacion != null) {
            return conversacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("asignado=");
        msg.append(asignado);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConversacionException(msg.toString());
    }

    /**
     * Returns the first conversacion in the ordered set where asignado = &#63;.
     *
     * @param asignado the asignado
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching conversacion, or <code>null</code> if a matching conversacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion fetchByPendientes_First(boolean asignado,
        OrderByComparator orderByComparator) throws SystemException {
        List<Conversacion> list = findByPendientes(asignado, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Conversacion findByPendientes_Last(boolean asignado,
        OrderByComparator orderByComparator)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = fetchByPendientes_Last(asignado,
                orderByComparator);

        if (conversacion != null) {
            return conversacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("asignado=");
        msg.append(asignado);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConversacionException(msg.toString());
    }

    /**
     * Returns the last conversacion in the ordered set where asignado = &#63;.
     *
     * @param asignado the asignado
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching conversacion, or <code>null</code> if a matching conversacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion fetchByPendientes_Last(boolean asignado,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPendientes(asignado);

        if (count == 0) {
            return null;
        }

        List<Conversacion> list = findByPendientes(asignado, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Conversacion[] findByPendientes_PrevAndNext(long conversacionId,
        boolean asignado, OrderByComparator orderByComparator)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = findByPrimaryKey(conversacionId);

        Session session = null;

        try {
            session = openSession();

            Conversacion[] array = new ConversacionImpl[3];

            array[0] = getByPendientes_PrevAndNext(session, conversacion,
                    asignado, orderByComparator, true);

            array[1] = conversacion;

            array[2] = getByPendientes_PrevAndNext(session, conversacion,
                    asignado, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Conversacion getByPendientes_PrevAndNext(Session session,
        Conversacion conversacion, boolean asignado,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONVERSACION_WHERE);

        query.append(_FINDER_COLUMN_PENDIENTES_ASIGNADO_2);

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
            query.append(ConversacionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(asignado);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(conversacion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Conversacion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the conversacions where asignado = &#63; from the database.
     *
     * @param asignado the asignado
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPendientes(boolean asignado) throws SystemException {
        for (Conversacion conversacion : findByPendientes(asignado,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(conversacion);
        }
    }

    /**
     * Returns the number of conversacions where asignado = &#63;.
     *
     * @param asignado the asignado
     * @return the number of matching conversacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPendientes(boolean asignado) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PENDIENTES;

        Object[] finderArgs = new Object[] { asignado };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONVERSACION_WHERE);

            query.append(_FINDER_COLUMN_PENDIENTES_ASIGNADO_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(asignado);

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
     * Returns all the conversacions where cerrada = &#63;.
     *
     * @param cerrada the cerrada
     * @return the matching conversacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Conversacion> findByCerradas(boolean cerrada)
        throws SystemException {
        return findByCerradas(cerrada, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Conversacion> findByCerradas(boolean cerrada, int start, int end)
        throws SystemException {
        return findByCerradas(cerrada, start, end, null);
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
    @Override
    public List<Conversacion> findByCerradas(boolean cerrada, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERRADAS;
            finderArgs = new Object[] { cerrada };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERRADAS;
            finderArgs = new Object[] { cerrada, start, end, orderByComparator };
        }

        List<Conversacion> list = (List<Conversacion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Conversacion conversacion : list) {
                if ((cerrada != conversacion.getCerrada())) {
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

            query.append(_SQL_SELECT_CONVERSACION_WHERE);

            query.append(_FINDER_COLUMN_CERRADAS_CERRADA_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ConversacionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(cerrada);

                if (!pagination) {
                    list = (List<Conversacion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Conversacion>(list);
                } else {
                    list = (List<Conversacion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first conversacion in the ordered set where cerrada = &#63;.
     *
     * @param cerrada the cerrada
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching conversacion
     * @throws com.proyecto.quental.chat.NoSuchConversacionException if a matching conversacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion findByCerradas_First(boolean cerrada,
        OrderByComparator orderByComparator)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = fetchByCerradas_First(cerrada,
                orderByComparator);

        if (conversacion != null) {
            return conversacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("cerrada=");
        msg.append(cerrada);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConversacionException(msg.toString());
    }

    /**
     * Returns the first conversacion in the ordered set where cerrada = &#63;.
     *
     * @param cerrada the cerrada
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching conversacion, or <code>null</code> if a matching conversacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion fetchByCerradas_First(boolean cerrada,
        OrderByComparator orderByComparator) throws SystemException {
        List<Conversacion> list = findByCerradas(cerrada, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Conversacion findByCerradas_Last(boolean cerrada,
        OrderByComparator orderByComparator)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = fetchByCerradas_Last(cerrada,
                orderByComparator);

        if (conversacion != null) {
            return conversacion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("cerrada=");
        msg.append(cerrada);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchConversacionException(msg.toString());
    }

    /**
     * Returns the last conversacion in the ordered set where cerrada = &#63;.
     *
     * @param cerrada the cerrada
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching conversacion, or <code>null</code> if a matching conversacion could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion fetchByCerradas_Last(boolean cerrada,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCerradas(cerrada);

        if (count == 0) {
            return null;
        }

        List<Conversacion> list = findByCerradas(cerrada, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Conversacion[] findByCerradas_PrevAndNext(long conversacionId,
        boolean cerrada, OrderByComparator orderByComparator)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = findByPrimaryKey(conversacionId);

        Session session = null;

        try {
            session = openSession();

            Conversacion[] array = new ConversacionImpl[3];

            array[0] = getByCerradas_PrevAndNext(session, conversacion,
                    cerrada, orderByComparator, true);

            array[1] = conversacion;

            array[2] = getByCerradas_PrevAndNext(session, conversacion,
                    cerrada, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Conversacion getByCerradas_PrevAndNext(Session session,
        Conversacion conversacion, boolean cerrada,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONVERSACION_WHERE);

        query.append(_FINDER_COLUMN_CERRADAS_CERRADA_2);

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
            query.append(ConversacionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(cerrada);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(conversacion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Conversacion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the conversacions where cerrada = &#63; from the database.
     *
     * @param cerrada the cerrada
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCerradas(boolean cerrada) throws SystemException {
        for (Conversacion conversacion : findByCerradas(cerrada,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(conversacion);
        }
    }

    /**
     * Returns the number of conversacions where cerrada = &#63;.
     *
     * @param cerrada the cerrada
     * @return the number of matching conversacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCerradas(boolean cerrada) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERRADAS;

        Object[] finderArgs = new Object[] { cerrada };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONVERSACION_WHERE);

            query.append(_FINDER_COLUMN_CERRADAS_CERRADA_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(cerrada);

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
     * Caches the conversacion in the entity cache if it is enabled.
     *
     * @param conversacion the conversacion
     */
    @Override
    public void cacheResult(Conversacion conversacion) {
        EntityCacheUtil.putResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionImpl.class, conversacion.getPrimaryKey(), conversacion);

        conversacion.resetOriginalValues();
    }

    /**
     * Caches the conversacions in the entity cache if it is enabled.
     *
     * @param conversacions the conversacions
     */
    @Override
    public void cacheResult(List<Conversacion> conversacions) {
        for (Conversacion conversacion : conversacions) {
            if (EntityCacheUtil.getResult(
                        ConversacionModelImpl.ENTITY_CACHE_ENABLED,
                        ConversacionImpl.class, conversacion.getPrimaryKey()) == null) {
                cacheResult(conversacion);
            } else {
                conversacion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all conversacions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ConversacionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ConversacionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the conversacion.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Conversacion conversacion) {
        EntityCacheUtil.removeResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionImpl.class, conversacion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Conversacion> conversacions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Conversacion conversacion : conversacions) {
            EntityCacheUtil.removeResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
                ConversacionImpl.class, conversacion.getPrimaryKey());
        }
    }

    /**
     * Creates a new conversacion with the primary key. Does not add the conversacion to the database.
     *
     * @param conversacionId the primary key for the new conversacion
     * @return the new conversacion
     */
    @Override
    public Conversacion create(long conversacionId) {
        Conversacion conversacion = new ConversacionImpl();

        conversacion.setNew(true);
        conversacion.setPrimaryKey(conversacionId);

        return conversacion;
    }

    /**
     * Removes the conversacion with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param conversacionId the primary key of the conversacion
     * @return the conversacion that was removed
     * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion remove(long conversacionId)
        throws NoSuchConversacionException, SystemException {
        return remove((Serializable) conversacionId);
    }

    /**
     * Removes the conversacion with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the conversacion
     * @return the conversacion that was removed
     * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion remove(Serializable primaryKey)
        throws NoSuchConversacionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Conversacion conversacion = (Conversacion) session.get(ConversacionImpl.class,
                    primaryKey);

            if (conversacion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchConversacionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(conversacion);
        } catch (NoSuchConversacionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Conversacion removeImpl(Conversacion conversacion)
        throws SystemException {
        conversacion = toUnwrappedModel(conversacion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(conversacion)) {
                conversacion = (Conversacion) session.get(ConversacionImpl.class,
                        conversacion.getPrimaryKeyObj());
            }

            if (conversacion != null) {
                session.delete(conversacion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (conversacion != null) {
            clearCache(conversacion);
        }

        return conversacion;
    }

    @Override
    public Conversacion updateImpl(
        com.proyecto.quental.chat.model.Conversacion conversacion)
        throws SystemException {
        conversacion = toUnwrappedModel(conversacion);

        boolean isNew = conversacion.isNew();

        ConversacionModelImpl conversacionModelImpl = (ConversacionModelImpl) conversacion;

        Session session = null;

        try {
            session = openSession();

            if (conversacion.isNew()) {
                session.save(conversacion);

                conversacion.setNew(false);
            } else {
                session.merge(conversacion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ConversacionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((conversacionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PENDIENTES.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        conversacionModelImpl.getOriginalAsignado()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PENDIENTES,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PENDIENTES,
                    args);

                args = new Object[] { conversacionModelImpl.getAsignado() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PENDIENTES,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PENDIENTES,
                    args);
            }

            if ((conversacionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERRADAS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        conversacionModelImpl.getOriginalCerrada()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERRADAS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERRADAS,
                    args);

                args = new Object[] { conversacionModelImpl.getCerrada() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERRADAS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERRADAS,
                    args);
            }
        }

        EntityCacheUtil.putResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
            ConversacionImpl.class, conversacion.getPrimaryKey(), conversacion);

        return conversacion;
    }

    protected Conversacion toUnwrappedModel(Conversacion conversacion) {
        if (conversacion instanceof ConversacionImpl) {
            return conversacion;
        }

        ConversacionImpl conversacionImpl = new ConversacionImpl();

        conversacionImpl.setNew(conversacion.isNew());
        conversacionImpl.setPrimaryKey(conversacion.getPrimaryKey());

        conversacionImpl.setConversacionId(conversacion.getConversacionId());
        conversacionImpl.setNickName(conversacion.getNickName());
        conversacionImpl.setCreateDate(conversacion.getCreateDate());
        conversacionImpl.setFinDate(conversacion.getFinDate());
        conversacionImpl.setCategoria(conversacion.getCategoria());
        conversacionImpl.setDescripcion(conversacion.getDescripcion());
        conversacionImpl.setEtiquetas(conversacion.getEtiquetas());
        conversacionImpl.setAsignado(conversacion.isAsignado());
        conversacionImpl.setCerrada(conversacion.isCerrada());

        return conversacionImpl;
    }

    /**
     * Returns the conversacion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the conversacion
     * @return the conversacion
     * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchConversacionException, SystemException {
        Conversacion conversacion = fetchByPrimaryKey(primaryKey);

        if (conversacion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchConversacionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return conversacion;
    }

    /**
     * Returns the conversacion with the primary key or throws a {@link com.proyecto.quental.chat.NoSuchConversacionException} if it could not be found.
     *
     * @param conversacionId the primary key of the conversacion
     * @return the conversacion
     * @throws com.proyecto.quental.chat.NoSuchConversacionException if a conversacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion findByPrimaryKey(long conversacionId)
        throws NoSuchConversacionException, SystemException {
        return findByPrimaryKey((Serializable) conversacionId);
    }

    /**
     * Returns the conversacion with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the conversacion
     * @return the conversacion, or <code>null</code> if a conversacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Conversacion conversacion = (Conversacion) EntityCacheUtil.getResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
                ConversacionImpl.class, primaryKey);

        if (conversacion == _nullConversacion) {
            return null;
        }

        if (conversacion == null) {
            Session session = null;

            try {
                session = openSession();

                conversacion = (Conversacion) session.get(ConversacionImpl.class,
                        primaryKey);

                if (conversacion != null) {
                    cacheResult(conversacion);
                } else {
                    EntityCacheUtil.putResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
                        ConversacionImpl.class, primaryKey, _nullConversacion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ConversacionModelImpl.ENTITY_CACHE_ENABLED,
                    ConversacionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return conversacion;
    }

    /**
     * Returns the conversacion with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param conversacionId the primary key of the conversacion
     * @return the conversacion, or <code>null</code> if a conversacion with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Conversacion fetchByPrimaryKey(long conversacionId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) conversacionId);
    }

    /**
     * Returns all the conversacions.
     *
     * @return the conversacions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Conversacion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Conversacion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Conversacion> findAll(int start, int end,
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

        List<Conversacion> list = (List<Conversacion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONVERSACION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONVERSACION;

                if (pagination) {
                    sql = sql.concat(ConversacionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Conversacion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Conversacion>(list);
                } else {
                    list = (List<Conversacion>) QueryUtil.list(q, getDialect(),
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
     * Removes all the conversacions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Conversacion conversacion : findAll()) {
            remove(conversacion);
        }
    }

    /**
     * Returns the number of conversacions.
     *
     * @return the number of conversacions
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

                Query q = session.createQuery(_SQL_COUNT_CONVERSACION);

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
     * Initializes the conversacion persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.proyecto.quental.chat.model.Conversacion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Conversacion>> listenersList = new ArrayList<ModelListener<Conversacion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Conversacion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ConversacionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
