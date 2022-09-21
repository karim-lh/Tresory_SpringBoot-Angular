package com.siga.domain;

public class InputSteps {
	private String id;
	private String decision;
	private String taskName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public InputSteps(String id, String decision, String taskName) {
		super();
		this.id = id;
		this.decision = decision;
		this.taskName = taskName;
	}
	public InputSteps() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
