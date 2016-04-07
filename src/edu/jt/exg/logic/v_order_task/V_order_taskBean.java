package edu.jt.exg.logic.v_order_task;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class V_order_taskBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public V_order_taskBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String taskkey="";
		public String getTaskkey(){return taskkey;}
		public void setTaskkey(String taskkey){this.taskkey = taskkey;}
		
		private String orderkey="";
		public String getOrderkey(){return orderkey;}
		public void setOrderkey(String orderkey){this.orderkey = orderkey;}
		
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
		
		private String user_id="";
		public String getUser_id(){return user_id;}
		public void setUser_id(String user_id){this.user_id = user_id;}
		
		private String user_name="";
		public String getUser_name(){return user_name;}
		public void setUser_name(String user_name){this.user_name = user_name;}
		

}