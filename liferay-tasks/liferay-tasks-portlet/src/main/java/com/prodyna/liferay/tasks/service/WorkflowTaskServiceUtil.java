package com.prodyna.liferay.tasks.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for WorkflowTask. This utility wraps
 * {@link com.prodyna.liferay.tasks.service.impl.WorkflowTaskServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowTaskService
 * @see com.prodyna.liferay.tasks.service.base.WorkflowTaskServiceBaseImpl
 * @see com.prodyna.liferay.tasks.service.impl.WorkflowTaskServiceImpl
 * @generated
 */
public class WorkflowTaskServiceUtil {
    private static WorkflowTaskService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.prodyna.liferay.tasks.service.impl.WorkflowTaskServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> myWorkflowTasks(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService().myWorkflowTasks(companyId);
    }

    public static java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> groupWorkflowTasks(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService().groupWorkflowTasks(companyId);
    }

    public static com.prodyna.liferay.tasks.service.model.PDWorkflowTask assignMeWorkflowTask(
        long companyId, long workflowTaskId)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService().assignMeWorkflowTask(companyId, workflowTaskId);
    }

    public static com.prodyna.liferay.tasks.service.model.PDWorkflowTask completeWorkflowTask(
        long workflowTaskId, java.lang.String transition,
        java.lang.String comment)
        throws com.liferay.portal.kernel.workflow.WorkflowException {
        return getService()
                   .completeWorkflowTask(workflowTaskId, transition, comment);
    }

    public static void clearService() {
        _service = null;
    }

    public static WorkflowTaskService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    WorkflowTaskService.class.getName());

            if (invokableService instanceof WorkflowTaskService) {
                _service = (WorkflowTaskService) invokableService;
            } else {
                _service = new WorkflowTaskServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(WorkflowTaskServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(WorkflowTaskService service) {
    }
}
