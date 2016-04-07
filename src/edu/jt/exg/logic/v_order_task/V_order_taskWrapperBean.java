package edu.jt.exg.logic.v_order_task;

public class V_order_taskWrapperBean {
	public V_order_taskWrapperBean(){super();}
	
	/**
	 * id表主键
	 */
	private String id="";
	public String  getId(){return id;}
	public void setId(String id){this.id = id;}

			private String taskkey="";
		public String  getTaskkey(){return taskkey;}
		public void setTaskkey(String taskkey){this.taskkey = taskkey;}
		
		private String orderkey="";
		public String  getOrderkey(){return orderkey;}
		public void setOrderkey(String orderkey){this.orderkey = orderkey;}
		
		private String invalid="";
		public String  getInvalid(){return invalid;}
		public void setInvalid(String invalid){this.invalid = invalid;}
		
		private String register_time="";
		private String register_timeFrom="";
		private String register_timeTo="";
		public String  getRegister_time(){return register_time;}
		public void setRegister_time(String register_time){this.register_time = register_time;}
		public String  getRegister_timeFrom(){return register_timeFrom;}
		public void setRegister_timeFrom(String register_timeFrom){this.register_timeFrom = register_timeFrom;}
		public String  getRegister_timeTo(){return register_timeTo;}
		public void setRegister_timeTo(String register_timeTo){this.register_timeTo = register_timeTo;}
		
		private String update_time="";
		private String update_timeFrom="";
		private String update_timeTo="";
		public String  getUpdate_time(){return update_time;}
		public void setUpdate_time(String update_time){this.update_time = update_time;}
		public String  getUpdate_timeFrom(){return update_timeFrom;}
		public void setUpdate_timeFrom(String update_timeFrom){this.update_timeFrom = update_timeFrom;}
		public String  getUpdate_timeTo(){return update_timeTo;}
		public void setUpdate_timeTo(String update_timeTo){this.update_timeTo = update_timeTo;}
		
		private String req_name="";
		public String  getReq_name(){return req_name;}
		public void setReq_name(String req_name){this.req_name = req_name;}
		
		private String req_id="";
		public String  getReq_id(){return req_id;}
		public void setReq_id(String req_id){this.req_id = req_id;}
		
		private String user_id="";
		public String  getUser_id(){return user_id;}
		public void setUser_id(String user_id){this.user_id = user_id;}
		
		private String user_name="";
		public String  getUser_name(){return user_name;}
		public void setUser_name(String user_name){this.user_name = user_name;}
		

}