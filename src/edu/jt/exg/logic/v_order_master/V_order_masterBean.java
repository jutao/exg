package edu.jt.exg.logic.v_order_master;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class V_order_masterBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public V_order_masterBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String orderid="";
		public String getOrderid(){return orderid;}
		public void setOrderid(String orderid){this.orderid = orderid;}
		
		private String repair_userkey="";
		public String getRepair_userkey(){return repair_userkey;}
		public void setRepair_userkey(String repair_userkey){this.repair_userkey = repair_userkey;}
		
		private String outcome="";
		public String getOutcome(){return outcome;}
		public void setOutcome(String outcome){this.outcome = outcome;}
		
		private String outcome_image1="";
		public String getOutcome_image1(){return outcome_image1;}
		public void setOutcome_image1(String outcome_image1){this.outcome_image1 = outcome_image1;}
		
		private String outcome_image2="";
		public String getOutcome_image2(){return outcome_image2;}
		public void setOutcome_image2(String outcome_image2){this.outcome_image2 = outcome_image2;}
		
		private String outcome_image3="";
		public String getOutcome_image3(){return outcome_image3;}
		public void setOutcome_image3(String outcome_image3){this.outcome_image3 = outcome_image3;}
		
		private String status="";
		public String getStatus(){return status;}
		public void setStatus(String status){this.status = status;}
		
		private String invalid="";
		public String getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		
		private Timestamp register_time=null;
		public Timestamp getRegister_time(){return register_time;}
		public void setRegister_time(Timestamp register_time){this.register_time = register_time;}
		
		private Timestamp register_timeFrom=null;
		public Timestamp getRegister_timeFrom(){return register_timeFrom;}
		public void setRegister_timeFrom(Timestamp register_timeFrom){this.register_timeFrom = register_timeFrom;}
		
		private Timestamp register_timeTo=null;
		public Timestamp getRegister_timeTo(){return register_timeTo;}
		public void setRegister_timeTo(Timestamp register_timeTo){this.register_timeTo = register_timeTo;}
		
		private Timestamp update_time=null;
		public Timestamp getUpdate_time(){return update_time;}
		public void setUpdate_time(Timestamp update_time){this.update_time = update_time;}
		
		private Timestamp update_timeFrom=null;
		public Timestamp getUpdate_timeFrom(){return update_timeFrom;}
		public void setUpdate_timeFrom(Timestamp update_timeFrom){this.update_timeFrom = update_timeFrom;}
		
		private Timestamp update_timeTo=null;
		public Timestamp getUpdate_timeTo(){return update_timeTo;}
		public void setUpdate_timeTo(Timestamp update_timeTo){this.update_timeTo = update_timeTo;}
		
		private String req_name="";
		public String getReq_name(){return req_name;}
		public void setReq_name(String req_name){this.req_name = req_name;}
		
		private String req_id="";
		public String getReq_id(){return req_id;}
		public void setReq_id(String req_id){this.req_id = req_id;}
		
		private String req_icon="";
		public String getReq_icon(){return req_icon;}
		public void setReq_icon(String req_icon){this.req_icon = req_icon;}
		

}