package com.prodyna.liferay.tasks.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkflowTaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowTaskLocalService
 * @generated
 */
public class WorkflowTaskLocalServiceWrapper implements WorkflowTaskLocalService,
    ServiceWrapper<WorkflowTaskLocalService> {
    private WorkflowTaskLocalService _workflowTaskLocalService;

    public WorkflowTaskLocalServiceWrapper(
        WorkflowTaskLocalService workflowTaskLocalService) {
        _workflowTaskLocalService = workflowTaskLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _workflowTaskLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _workflowTaskLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _workflowTaskLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public WorkflowTaskLocalService getWrappedWorkflowTaskLocalService() {
        return _workflowTaskLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedWorkflowTaskLocalService(
        WorkflowTaskLocalService workflowTaskLocalService) {
        _workflowTaskLocalService = workflowTaskLocalService;
    }

    @Override
    public WorkflowTaskLocalService getWrappedService() {
        return _workflowTaskLocalService;
    }

    @Override
    public void setWrappedService(
        WorkflowTaskLocalService workflowTaskLocalService) {
        _workflowTaskLocalService = workflowTaskLocalService;
    }
}
