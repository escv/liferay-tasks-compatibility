package com.prodyna.liferay.tasks.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.prodyna.liferay.tasks.service.ClpSerializer;
import com.prodyna.liferay.tasks.service.WorkflowTaskLocalServiceUtil;
import com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            WorkflowTaskLocalServiceUtil.clearService();

            WorkflowTaskServiceUtil.clearService();
        }
    }
}
