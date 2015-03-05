package com.prodyna.liferay.tasks.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkflowTaskServiceHttp
 * @see com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil
 * @generated
 */
public class WorkflowTaskServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(WorkflowTaskServiceSoap.class);

    public static com.prodyna.liferay.tasks.service.model.PDWorkflowTask[] myWorkflowTasks(
        long companyId) throws RemoteException {
        try {
            java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> returnValue =
                WorkflowTaskServiceUtil.myWorkflowTasks(companyId);

            return returnValue.toArray(new com.prodyna.liferay.tasks.service.model.PDWorkflowTask[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.prodyna.liferay.tasks.service.model.PDWorkflowTask[] groupWorkflowTasks(
        long companyId) throws RemoteException {
        try {
            java.util.List<com.prodyna.liferay.tasks.service.model.PDWorkflowTask> returnValue =
                WorkflowTaskServiceUtil.groupWorkflowTasks(companyId);

            return returnValue.toArray(new com.prodyna.liferay.tasks.service.model.PDWorkflowTask[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.prodyna.liferay.tasks.service.model.PDWorkflowTask assignMeWorkflowTask(
        long companyId, long workflowTaskId) throws RemoteException {
        try {
            com.prodyna.liferay.tasks.service.model.PDWorkflowTask returnValue = WorkflowTaskServiceUtil.assignMeWorkflowTask(companyId,
                    workflowTaskId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.prodyna.liferay.tasks.service.model.PDWorkflowTask completeWorkflowTask(
        long workflowTaskId, java.lang.String transition,
        java.lang.String comment) throws RemoteException {
        try {
            com.prodyna.liferay.tasks.service.model.PDWorkflowTask returnValue = WorkflowTaskServiceUtil.completeWorkflowTask(workflowTaskId,
                    transition, comment);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
