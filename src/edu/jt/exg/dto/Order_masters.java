package edu.jt.exg.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order_masters")
public class Order_masters implements Serializable {

	private static final long serialVersionUID = 19761210;

	public Order_masters() {
		super();
	}
	private String id = "";
	@XmlElement(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String repair_userkey = "";
	
	@XmlElement(name = "repair_userkey")
	public String getRepair_userkey() {
		return repair_userkey;
	}

	public void setRepair_userkey(String repair_userkey) {
		this.repair_userkey = repair_userkey;
	}

	private String outcome = "";
	
	@XmlElement(name = "outcome")
	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	private String outcome_image1 = "";
	@XmlElement(name = "outcome_image1")
	public String getOutcome_image1() {
		return outcome_image1;
	}

	public void setOutcome_image1(String outcome_image1) {
		this.outcome_image1 = outcome_image1;
	}

	private String status = "";
	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	private String statusName = "";

	@XmlElement(name = "statusName")
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	private String invalid = "";
	@XmlElement(name = "invalid")
	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	private Date update_time = null;
	@XmlElement(name = "update_time")
	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	private String req_name = "";
	@XmlElement(name = "req_name")
	public String getReq_name() {
		return req_name;
	}

	public void setReq_name(String req_name) {
		this.req_name = req_name;
	}

	private String req_id = "";
	@XmlElement(name = "req_id")
	public String getReq_id() {
		return req_id;
	}

	public void setReq_id(String req_id) {
		this.req_id = req_id;
	}

	private String req_icon = "";
	@XmlElement(name = "req_icon")
	public String getReq_icon() {
		return req_icon;
	}

	public void setReq_icon(String req_icon) {
		this.req_icon = req_icon;
	}

	private String task_user_name = "";
	@XmlElement(name = "task_user_name")
	public String getTask_user_name() {
		return task_user_name;
	}

	public void setTask_user_name(String task_user_name) {
		this.task_user_name = task_user_name;
	}

	private String task_userid = "";
	@XmlElement(name = "task_userid")
	public String getTask_userid() {
		return task_userid;
	}

	public void setTask_userid(String task_userid) {
		this.task_userid = task_userid;
	}

	private String task_usericon = "";
	@XmlElement(name = "task_usericon")
	public String getTask_usericon() {
		return task_usericon;
	}

	public void setTask_usericon(String task_usericon) {
		this.task_usericon = task_usericon;
	}
	
	private Task task=null;
	@XmlElement(name = "task")
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}