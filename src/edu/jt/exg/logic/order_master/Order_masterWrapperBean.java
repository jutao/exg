package edu.jt.exg.logic.order_master;

public class Order_masterWrapperBean {
	public Order_masterWrapperBean(){super();}
	
	/**
	 * id表主键
	 */
	private String id="";
	public String  getId(){return id;}
	public void setId(String id){this.id = id;}

			private String orderid="";
		public String  getOrderid(){return orderid;}
		public void setOrderid(String orderid){this.orderid = orderid;}
		
		private String repair_userkey="";
		public String  getRepair_userkey(){return repair_userkey;}
		public void setRepair_userkey(String repair_userkey){this.repair_userkey = repair_userkey;}
		
		private String outcome="";
		public String  getOutcome(){return outcome;}
		public void setOutcome(String outcome){this.outcome = outcome;}
		
		private String outcome_image1="";
		public String  getOutcome_image1(){return outcome_image1;}
		public void setOutcome_image1(String outcome_image1){this.outcome_image1 = outcome_image1;}
		
		private String outcome_image2="";
		public String  getOutcome_image2(){return outcome_image2;}
		public void setOutcome_image2(String outcome_image2){this.outcome_image2 = outcome_image2;}
		
		private String outcome_image3="";
		public String  getOutcome_image3(){return outcome_image3;}
		public void setOutcome_image3(String outcome_image3){this.outcome_image3 = outcome_image3;}
		
		private String status="";
		public String  getStatus(){return status;}
		public void setStatus(String status){this.status = status;}
		
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
		

}