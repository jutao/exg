package edu.jt.exg.logic.withdrawals_detail;

public class Withdrawals_detailWrapperBean {
	public Withdrawals_detailWrapperBean(){super();}
	
	/**
	 * id表主键
	 */
	private String id="";
	public String  getId(){return id;}
	public void setId(String id){this.id = id;}

			private String chargeid="";
		public String  getChargeid(){return chargeid;}
		public void setChargeid(String chargeid){this.chargeid = chargeid;}
		
		private String userkey="";
		public String  getUserkey(){return userkey;}
		public void setUserkey(String userkey){this.userkey = userkey;}
		
		private String amount="";
		private String amountFrom="";
		private String amountTo="";
		public String  getAmount(){return amount;}
		public void setAmount(String amount){this.amount = amount;}
		public String  getAmountFrom(){return amountFrom;}
		public void setAmountFrom(String amountFrom){this.amountFrom = amountFrom;}
		public String  getAmountTo(){return amountTo;}
		public void setAmountTo(String amountTo){this.amountTo = amountTo;}
		
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