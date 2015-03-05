package com.prodyna.liferay.tasks.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for WorkflowTask. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowTaskServiceUtil
 * @see com.prodyna.liferay.tasks.service.base.WorkflowTaskServiceBaseImpl
 * @see com.prodyna.liferay.tasks.service.impl.WorkflowTaskServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface WorkflowTaskService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link WorkflowTaskServiceUtil} to access the workflow task remote service. Add custom service methods to {@link com.prodyna.liferay.tasks.service.impl.WorkflowTaskServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> myWorkflowTasks(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException;

    public java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> groupWorkflowTasks(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException;

    public com.prodyna.liferay.tasks.service.model.PDWorkflowTask assignMeWorkflowTask(
        long companyId, long workflowTaskId)
        throws com.liferay.portal.kernel.exception.PortalException;

    public com.prodyna.liferay.tasks.service.model.PDWorkflowTask completeWorkflowTask(
        long workflowTaskId, java.lang.String transition,
        java.lang.String comment)
        throws com.liferay.portal.kernel.workflow.WorkflowException;
}
