package com.prodyna.liferay.tasks.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.prodyna.liferay.tasks.service.WorkflowTaskLocalService;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the workflow task local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.prodyna.liferay.tasks.service.impl.WorkflowTaskLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.prodyna.liferay.tasks.service.impl.WorkflowTaskLocalServiceImpl
 * @see com.prodyna.liferay.tasks.service.WorkflowTaskLocalServiceUtil
 * @generated
 */
public abstract class WorkflowTaskLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements WorkflowTaskLocalService,
        IdentifiableBean {
    @BeanReference(type = com.prodyna.liferay.tasks.service.WorkflowTaskLocalService.class)
    protected com.prodyna.liferay.tasks.service.WorkflowTaskLocalService workflowTaskLocalService;
    @BeanReference(type = com.prodyna.liferay.tasks.service.WorkflowTaskService.class)
    protected com.prodyna.liferay.tasks.service.WorkflowTaskService workflowTaskService;
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
    private WorkflowTaskLocalServiceClpInvoker _clpInvoker = new WorkflowTaskLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.prodyna.liferay.tasks.service.WorkflowTaskLocalServiceUtil} to access the workflow task local service.
     */

    /**
     * Returns the workflow task local service.
     *
     * @return the workflow task local service
     */
    public com.prodyna.liferay.tasks.service.WorkflowTaskLocalService getWorkflowTaskLocalService() {
        return workflowTaskLocalService;
    }

    /**
     * Sets the workflow task local service.
     *
     * @param workflowTaskLocalService the workflow task local service
     */
    public void setWorkflowTaskLocalService(
        com.prodyna.liferay.tasks.service.WorkflowTaskLocalService workflowTaskLocalService) {
        this.workflowTaskLocalService = workflowTaskLocalService;
    }

    /**
     * Returns the workflow task remote service.
     *
     * @return the workflow task remote service
     */
    public com.prodyna.liferay.tasks.service.WorkflowTaskService getWorkflowTaskService() {
        return workflowTaskService;
    }

    /**
     * Sets the workflow task remote service.
     *
     * @param workflowTaskService the workflow task remote service
     */
    public void setWorkflowTaskService(
        com.prodyna.liferay.tasks.service.WorkflowTaskService workflowTaskService) {
        this.workflowTaskService = workflowTaskService;
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

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = InfrastructureUtil.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
