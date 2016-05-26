package edu.jt.exg.dto;
import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order_master")
public class Order_master implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Order_master(){super();}
	
	
		private String id="";
		@XmlElement(name = "id")
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String orderid="";
		@XmlElement(name = "orderid")
		public String getOrderid(){return orderid;}
		public void setOrderid(String orderid){this.orderid = orderid;}
		
		private String repair_userkey="";
		@XmlElement(name = "repair_userkey")
		public String getRepair_userkey(){return repair_userkey;}
		public void setRepair_userkey(String repair_userkey){this.repair_userkey = repair_userkey;}
		
		private String outcome="";
		@XmlElement(name = "outcome")
		public String getOutcome(){return outcome;}
		public void setOutcome(String outcome){this.outcome = outcome;}
		
		private String outcome_image1="";
		@XmlElement(name = "outcome_image1")
		public String getOutcome_image1(){return outcome_image1;}
		public void setOutcome_image1(String outcome_image1){this.outcome_image1 = outcome_image1;}
		
		private String outcome_image2="";
		@XmlElement(name = "outcome_image2")
		public String getOutcome_image2(){return outcome_image2;}
		public void setOutcome_image2(String outcome_image2){this.outcome_image2 = outcome_image2;}
		
		private String outcome_image3="";
		@XmlElement(name = "outcome_image3")
		public String getOutcome_image3(){return outcome_image3;}
		public void setOutcome_image3(String outcome_image3){this.outcome_image3 = outcome_image3;}
		
		private String status="";
		@XmlElement(name = "status")
		public String getStatus(){return status;}
		public void setStatus(String status){this.status = status;}
		
		private String statusName="";
		@XmlElement(name = "statusName")
		public String getStatusName(){return statusName;}
		public void setStatusName(String statusName){this.statusName = statusName;}
		
		private String invalid="";
		@XmlElement(name = "invalid")
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		
		private Date update_time=null;
		@XmlElement(name = "update_time")
		public Date getUpdate_time(){return update_time;}
		public void setUpdate_time(Date update_time){this.update_time = update_time;}

		private String taskKey=null;
		@XmlElement(name = "taskKey")
		public String getTaskKey(){return taskKey;}
		public void setTaskKey(String taskKey){this.taskKey = taskKey;}
		
		
}