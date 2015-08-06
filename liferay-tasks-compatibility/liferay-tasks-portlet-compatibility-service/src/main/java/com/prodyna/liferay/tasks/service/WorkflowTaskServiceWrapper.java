package com.prodyna.liferay.tasks.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkflowTaskService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowTaskService
 * @generated
 */
public class WorkflowTaskServiceWrapper implements WorkflowTaskService,
    ServiceWrapper<WorkflowTaskService> {
    private WorkflowTaskService _workflowTaskService;

    public WorkflowTaskServiceWrapper(WorkflowTaskService workflowTaskService) {
        _workflowTaskService = workflowTaskService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _workflowTaskService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _workflowTaskService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _workflowTaskService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> myWorkflowTasks(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _workflowTaskService.myWorkflowTasks(companyId);
    }

    @Override
    public java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> groupWorkflowTasks(
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _workflowTaskService.groupWorkflowTasks(companyId);
    }

    @Override
    public com.prodyna.liferay.tasks.service.model.PDWorkflowTask assignMeWorkflowTask(
        long companyId, long workflowTaskId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _workflowTaskService.assignMeWorkflowTask(companyId,
            workflowTaskId);
    }

    @Override
    public com.prodyna.liferay.tasks.service.model.PDWorkflowTask completeWorkflowTask(
        long workflowTaskId, java.lang.String transition,
        java.lang.String comment)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _workflowTaskService.completeWorkflowTask(workflowTaskId,
            transition, comment);
    }

    @Override
    public java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> newTasksAfterTimestamp(
        long companyId, long timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _workflowTaskService.newTasksAfterTimestamp(companyId, timestamp);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public WorkflowTaskService getWrappedWorkflowTaskService() {
        return _workflowTaskService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedWorkflowTaskService(
        WorkflowTaskService workflowTaskService) {
        _workflowTaskService = workflowTaskService;
    }

    @Override
    public WorkflowTaskService getWrappedService() {
        return _workflowTaskService;
    }

    @Override
    public void setWrappedService(WorkflowTaskService workflowTaskService) {
        _workflowTaskService = workflowTaskService;
    }
}
