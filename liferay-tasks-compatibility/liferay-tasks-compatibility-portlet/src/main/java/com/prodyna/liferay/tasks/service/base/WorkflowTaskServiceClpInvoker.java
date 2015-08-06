package com.prodyna.liferay.tasks.service.base;

import com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkflowTaskServiceClpInvoker {
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;

    public WorkflowTaskServiceClpInvoker() {
        _methodName16 = "getBeanIdentifier";

        _methodParameterTypes16 = new String[] {  };

        _methodName17 = "setBeanIdentifier";

        _methodParameterTypes17 = new String[] { "java.lang.String" };

        _methodName20 = "myWorkflowTasks";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "groupWorkflowTasks";

        _methodParameterTypes21 = new String[] { "long" };

        _methodName22 = "assignMeWorkflowTask";

        _methodParameterTypes22 = new String[] { "long", "long" };

        _methodName23 = "completeWorkflowTask";

        _methodParameterTypes23 = new String[] {
                "long", "java.lang.String", "java.lang.String"
            };

        _methodName24 = "newTasksAfterTimestamp";

        _methodParameterTypes24 = new String[] { "long", "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return WorkflowTaskServiceUtil.getBeanIdentifier();
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            WorkflowTaskServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName20.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
            return WorkflowTaskServiceUtil.myWorkflowTasks(((Long) arguments[0]).longValue());
        }

        if (_methodName21.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
            return WorkflowTaskServiceUtil.groupWorkflowTasks(((Long) arguments[0]).longValue());
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            return WorkflowTaskServiceUtil.assignMeWorkflowTask(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            return WorkflowTaskServiceUtil.completeWorkflowTask(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return WorkflowTaskServiceUtil.newTasksAfterTimestamp(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
