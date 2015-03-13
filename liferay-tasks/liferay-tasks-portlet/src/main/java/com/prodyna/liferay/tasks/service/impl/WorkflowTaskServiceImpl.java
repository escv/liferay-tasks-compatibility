package com.prodyna.liferay.tasks.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.prodyna.liferay.tasks.service.base.WorkflowTaskServiceBaseImpl;
import com.prodyna.liferay.tasks.service.model.PDWorkflowTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the workflow task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.prodyna.liferay.tasks.service.WorkflowTaskService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.prodyna.liferay.tasks.service.base.WorkflowTaskServiceBaseImpl
 * @see com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil
 */
public class WorkflowTaskServiceImpl extends WorkflowTaskServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.prodyna.liferay.tasks.service.WorkflowTaskServiceUtil} to access the workflow task remote service.
     */
	
	/** The Constant LOG. */
    private static final Log LOG = LogFactoryUtil.getLog(WorkflowTaskServiceImpl.class);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm dd.MM.yyyy");
    
	public List<PDWorkflowTask> myWorkflowTasks(long companyId) throws PortalException, SystemException {
		long userId = PrincipalThreadLocal.getUserId();
		companyId = PortalUtil.getDefaultCompanyId();
		List<PDWorkflowTask> result = new ArrayList<PDWorkflowTask>();
		
		for (WorkflowTask task : WorkflowTaskManagerUtil.getWorkflowTasksByUser(PortalUtil.getDefaultCompanyId(), userId, false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			result.add(convertToPDWorkflowTask(companyId, userId, task));			
		}
		return result;
	}
	
	public List<PDWorkflowTask> groupWorkflowTasks(long companyId) throws PortalException, SystemException {
		long userId = PrincipalThreadLocal.getUserId();
		companyId = PortalUtil.getDefaultCompanyId();
		List<PDWorkflowTask> result = new ArrayList<PDWorkflowTask>();
		
		for (WorkflowTask task : WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(companyId, userId, false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			result.add(convertToPDWorkflowTask(companyId, userId, task));			
		}
		return result;
	}
	
	public PDWorkflowTask assignMeWorkflowTask(long companyId, long workflowTaskId) throws PortalException, SystemException {
		long userId = PrincipalThreadLocal.getUserId();
		companyId = PortalUtil.getDefaultCompanyId();
		WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(companyId, workflowTaskId);
		WorkflowInstance inst = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowTask.getWorkflowInstanceId());

		WorkflowTask wft = WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId, workflowTaskId, userId, "Assigned To Me", null, inst.getWorkflowContext());
		PDWorkflowTask result = convertToPDWorkflowTask(companyId, userId, wft);
		
		return result;
		
	}
	
	public PDWorkflowTask completeWorkflowTask(long workflowTaskId, String transition, String comment) throws PortalException, SystemException  {
		long userId = PrincipalThreadLocal.getUserId();
		long companyId = PortalUtil.getDefaultCompanyId();
		
		WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(companyId, workflowTaskId);
		WorkflowInstance inst = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowTask.getWorkflowInstanceId());
		
		WorkflowTask result = WorkflowTaskManagerUtil.completeWorkflowTask(companyId, userId, workflowTaskId, transition, comment, inst.getWorkflowContext());

		return convertToPDWorkflowTask(companyId, userId, result);
	}
	
	public List<PDWorkflowTask> newTasksAfterTimestamp(long companyId, long timestamp) throws PortalException, SystemException   {
		long userId = PrincipalThreadLocal.getUserId();
		companyId = PortalUtil.getDefaultCompanyId();
		Date lastPollDate = new Date(timestamp);
		
		List<PDWorkflowTask> result = new ArrayList<PDWorkflowTask>();
		List<WorkflowTask> toCheck = WorkflowTaskManagerUtil.getWorkflowTasksByUser(companyId, userId, false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		toCheck.addAll(WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(companyId, userId, false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null));
		
		for (WorkflowTask t : toCheck) {
			if (t.getCreateDate().after(lastPollDate)) {
				result.add(convertToPDWorkflowTask(companyId, userId, t));
			}
		}
		
		return result;
	}
			
	private PDWorkflowTask convertToPDWorkflowTask(long companyId, long userId, WorkflowTask wt) throws PortalException, SystemException {
		PDWorkflowTask task = new PDWorkflowTask();
		task.setWorkflowTaskId(wt.getWorkflowTaskId());
		task.setWorkflowName(wt.getWorkflowDefinitionName());
		
		List<String> transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, wt.getWorkflowTaskId());
		task.setTransitions(transitionNames);
		task.setCompleted(wt.getCompletionDate()!=null);
		task.setEntryType(String.valueOf(wt.getOptionalAttributes().get("entryType")));
		
		try {
			User user = UserLocalServiceUtil.getUser(GetterUtil.getLong(wt.getOptionalAttributes().get("userId")));
			task.setInitiator(user.getFullName());
		} catch (NestableException e1) {
			LOG.warn("Task without any create user found: "+wt.getWorkflowTaskId());
		}
		AssetRendererFactory rendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(String.valueOf(wt.getOptionalAttributes().get("entryClassName")));
		long entryId = GetterUtil.getLong(wt.getOptionalAttributes().get("entryClassPK"));
		AssetRenderer renderer = rendererFactory.getAssetRenderer(entryId);

		task.setArticleId(renderer.getClassPK());
		task.setCreateDate(DATE_FORMAT.format(wt.getCreateDate()));
		
		try {
			task.setTitle(StringUtil.upperCaseFirstLetter(wt.getName())+": " +renderer.getTitle(LocaleThreadLocal.getDefaultLocale()));
		} catch (Exception e1) {
			LOG.warn("Error while fetching the name for the asset entry", e1);
		}
		
		// the following code block is really ugly but i could not found any approach the fetch working preview urls
		if (JournalArticle.class.getName().equals(wt.getOptionalAttributes().get("entryClassName"))) {
			try {
				// generate a preview URL
				JournalArticle article = JournalArticleLocalServiceUtil.getArticle(entryId);
				String friendlyURL = GroupLocalServiceUtil.getGroup(renderer.getGroupId()).getFriendlyURL();

				String ppAuth = AuthTokenUtil.getToken(ServiceContextThreadLocal.getServiceContext().getRequest(), LayoutLocalServiceUtil.getDefaultPlid(renderer.getGroupId()), "15");
				String previewUrl = "/web"+friendlyURL+"?p_p_auth="+ppAuth+"&p_p_id=15&p_p_lifecycle=0&p_p_state=pop_up&p_p_mode=view&doAsGroupId="+renderer.getGroupId()+"&_15_groupId="+renderer.getGroupId()+"&_15_struts_action=%2Fjournal%2Fpreview_article_content&_15_articleId="+article.getArticleId();
				task.setPreviewUrl(previewUrl);
			} catch (NestableException e) {
				LOG.error("Error fetchin Article for Workflow Task", e);
			}
		}
		
		return task;
	}
} 
