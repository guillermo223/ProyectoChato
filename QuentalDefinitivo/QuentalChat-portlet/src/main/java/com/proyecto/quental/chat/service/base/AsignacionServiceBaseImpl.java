package com.proyecto.quental.chat.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.proyecto.quental.chat.model.Asignacion;
import com.proyecto.quental.chat.service.AsignacionService;
import com.proyecto.quental.chat.service.persistence.AsignacionPersistence;
import com.proyecto.quental.chat.service.persistence.ConversacionPersistence;
import com.proyecto.quental.chat.service.persistence.MensajePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the asignacion remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.proyecto.quental.chat.service.impl.AsignacionServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.proyecto.quental.chat.service.impl.AsignacionServiceImpl
 * @see com.proyecto.quental.chat.service.AsignacionServiceUtil
 * @generated
 */
public abstract class AsignacionServiceBaseImpl extends BaseServiceImpl
    implements AsignacionService, IdentifiableBean {
    @BeanReference(type = com.proyecto.quental.chat.service.AsignacionLocalService.class)
    protected com.proyecto.quental.chat.service.AsignacionLocalService asignacionLocalService;
    @BeanReference(type = com.proyecto.quental.chat.service.AsignacionService.class)
    protected com.proyecto.quental.chat.service.AsignacionService asignacionService;
    @BeanReference(type = AsignacionPersistence.class)
    protected AsignacionPersistence asignacionPersistence;
    @BeanReference(type = com.proyecto.quental.chat.service.ConversacionLocalService.class)
    protected com.proyecto.quental.chat.service.ConversacionLocalService conversacionLocalService;
    @BeanReference(type = com.proyecto.quental.chat.service.ConversacionService.class)
    protected com.proyecto.quental.chat.service.ConversacionService conversacionService;
    @BeanReference(type = ConversacionPersistence.class)
    protected ConversacionPersistence conversacionPersistence;
    @BeanReference(type = com.proyecto.quental.chat.service.MensajeLocalService.class)
    protected com.proyecto.quental.chat.service.MensajeLocalService mensajeLocalService;
    @BeanReference(type = com.proyecto.quental.chat.service.MensajeService.class)
    protected com.proyecto.quental.chat.service.MensajeService mensajeService;
    @BeanReference(type = MensajePersistence.class)
    protected MensajePersistence mensajePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private AsignacionServiceClpInvoker _clpInvoker = new AsignacionServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.proyecto.quental.chat.service.AsignacionServiceUtil} to access the asignacion remote service.
     */

    /**
     * Returns the asignacion local service.
     *
     * @return the asignacion local service
     */
    public com.proyecto.quental.chat.service.AsignacionLocalService getAsignacionLocalService() {
        return asignacionLocalService;
    }

    /**
     * Sets the asignacion local service.
     *
     * @param asignacionLocalService the asignacion local service
     */
    public void setAsignacionLocalService(
        com.proyecto.quental.chat.service.AsignacionLocalService asignacionLocalService) {
        this.asignacionLocalService = asignacionLocalService;
    }

    /**
     * Returns the asignacion remote service.
     *
     * @return the asignacion remote service
     */
    public com.proyecto.quental.chat.service.AsignacionService getAsignacionService() {
        return asignacionService;
    }

    /**
     * Sets the asignacion remote service.
     *
     * @param asignacionService the asignacion remote service
     */
    public void setAsignacionService(
        com.proyecto.quental.chat.service.AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    /**
     * Returns the asignacion persistence.
     *
     * @return the asignacion persistence
     */
    public AsignacionPersistence getAsignacionPersistence() {
        return asignacionPersistence;
    }

    /**
     * Sets the asignacion persistence.
     *
     * @param asignacionPersistence the asignacion persistence
     */
    public void setAsignacionPersistence(
        AsignacionPersistence asignacionPersistence) {
        this.asignacionPersistence = asignacionPersistence;
    }

    /**
     * Returns the conversacion local service.
     *
     * @return the conversacion local service
     */
    public com.proyecto.quental.chat.service.ConversacionLocalService getConversacionLocalService() {
        return conversacionLocalService;
    }

    /**
     * Sets the conversacion local service.
     *
     * @param conversacionLocalService the conversacion local service
     */
    public void setConversacionLocalService(
        com.proyecto.quental.chat.service.ConversacionLocalService conversacionLocalService) {
        this.conversacionLocalService = conversacionLocalService;
    }

    /**
     * Returns the conversacion remote service.
     *
     * @return the conversacion remote service
     */
    public com.proyecto.quental.chat.service.ConversacionService getConversacionService() {
        return conversacionService;
    }

    /**
     * Sets the conversacion remote service.
     *
     * @param conversacionService the conversacion remote service
     */
    public void setConversacionService(
        com.proyecto.quental.chat.service.ConversacionService conversacionService) {
        this.conversacionService = conversacionService;
    }

    /**
     * Returns the conversacion persistence.
     *
     * @return the conversacion persistence
     */
    public ConversacionPersistence getConversacionPersistence() {
        return conversacionPersistence;
    }

    /**
     * Sets the conversacion persistence.
     *
     * @param conversacionPersistence the conversacion persistence
     */
    public void setConversacionPersistence(
        ConversacionPersistence conversacionPersistence) {
        this.conversacionPersistence = conversacionPersistence;
    }

    /**
     * Returns the mensaje local service.
     *
     * @return the mensaje local service
     */
    public com.proyecto.quental.chat.service.MensajeLocalService getMensajeLocalService() {
        return mensajeLocalService;
    }

    /**
     * Sets the mensaje local service.
     *
     * @param mensajeLocalService the mensaje local service
     */
    public void setMensajeLocalService(
        com.proyecto.quental.chat.service.MensajeLocalService mensajeLocalService) {
        this.mensajeLocalService = mensajeLocalService;
    }

    /**
     * Returns the mensaje remote service.
     *
     * @return the mensaje remote service
     */
    public com.proyecto.quental.chat.service.MensajeService getMensajeService() {
        return mensajeService;
    }

    /**
     * Sets the mensaje remote service.
     *
     * @param mensajeService the mensaje remote service
     */
    public void setMensajeService(
        com.proyecto.quental.chat.service.MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    /**
     * Returns the mensaje persistence.
     *
     * @return the mensaje persistence
     */
    public MensajePersistence getMensajePersistence() {
        return mensajePersistence;
    }

    /**
     * Sets the mensaje persistence.
     *
     * @param mensajePersistence the mensaje persistence
     */
    public void setMensajePersistence(MensajePersistence mensajePersistence) {
        this.mensajePersistence = mensajePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Asignacion.class;
    }

    protected String getModelClassName() {
        return Asignacion.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = asignacionPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
