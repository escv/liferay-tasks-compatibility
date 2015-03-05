package com.prodyna.liferay.tasks.service.model;

import com.liferay.portal.kernel.json.JSON;

import java.util.List;

public class PDWorkflowTask {

	private long workflowTaskId;
	
	private String title = "";
	
	private long createTimestamp;
	
	private String workflowName = "";
	
	private String description = "";
	
	private long articleId;
	
	private String previewUrl;
	
	private List<String> transitions;
	
	private boolean completed;
	
	private String initiator;
	
	private String entryType;

	
	public long getWorkflowTaskId() {
		return workflowTaskId;
	}

	public void setWorkflowTaskId(long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	
	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}
	
	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	@JSON(include=true)
	public List<String> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<String> transitions) {
		this.transitions = transitions;
	}

	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (workflowTaskId ^ (workflowTaskId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDWorkflowTask other = (PDWorkflowTask) obj;
		if (workflowTaskId != other.workflowTaskId)
			return false;
		return true;
	}
	
	
}
