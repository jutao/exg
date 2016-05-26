package edu.jt.exg.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "v_task")
public class V_task implements Serializable {

	private static final long serialVersionUID = 19761210;

	public V_task() {
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

	private String userkey = "";

	@XmlElement(name = "userkey")
	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	private String pro_description = "";

	@XmlElement(name = "pro_description")
	public String getPro_description() {
		return pro_description;
	}

	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	private String pro_image1 = "";

	@XmlElement(name = "pro_image1")
	public String getPro_image1() {
		return pro_image1;
	}

	public void setPro_image1(String pro_image1) {
		this.pro_image1 = pro_image1;
	}

	private String solve_image1 = "";

	@XmlElement(name = "solve_image1")
	public String getSolve_image1() {
		return solve_image1;
	}

	public void setSolve_image1(String solve_image1) {
		this.solve_image1 = solve_image1;
	}

	private String seat = "";

	@XmlElement(name = "seat")
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
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

	private String name = "";

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String user_id = "";

	@XmlElement(name = "user_id")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private String icon = "";

	@XmlElement(name = "icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	private String category = "";

	@XmlElement(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private String categoryName = "";

	@XmlElement(name = "categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}