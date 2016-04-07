package edu.jt.exg.logic.consume_detail;

public class Consume_detailWrapperBean {
	public Consume_detailWrapperBean(){super();}
	
	/**
	 * id表主键
	 */
	private String id="";
	public String  getId(){return id;}
	public void setId(String id){this.id = id;}

			private String detailid="";
		public String  getDetailid(){return detailid;}
		public void setDetailid(String detailid){this.detailid = detailid;}
		
		private String taskkey="";
		public String  getTaskkey(){return taskkey;}
		public void setTaskkey(String taskkey){this.taskkey = taskkey;}
		
		private String quantity="";
		private String quantityFrom="";
		private String quantityTo="";
		public String  getQuantity(){return quantity;}
		public void setQuantity(String quantity){this.quantity = quantity;}
		public String  getQuantityFrom(){return quantityFrom;}
		public void setQuantityFrom(String quantityFrom){this.quantityFrom = quantityFrom;}
		public String  getQuantityTo(){return quantityTo;}
		public void setQuantityTo(String quantityTo){this.quantityTo = quantityTo;}
		
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