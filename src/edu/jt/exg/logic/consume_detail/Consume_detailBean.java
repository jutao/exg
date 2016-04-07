package edu.jt.exg.logic.consume_detail;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Consume_detailBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Consume_detailBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String detailid="";
		public String getDetailid(){return detailid;}
		public void setDetailid(String detailid){this.detailid = detailid;}
		
		private String taskkey="";
		public String getTaskkey(){return taskkey;}
		public void setTaskkey(String taskkey){this.taskkey = taskkey;}
		
		private Double quantity=null;
		public Double getQuantity(){return quantity;}
		public void setQuantity(Double quantity){this.quantity = quantity;}
		
		private Double quantityFrom=null;
		public Double getQuantityFrom(){return quantityFrom;}
		public void setQuantityFrom(Double quantityFrom){this.quantityFrom = quantityFrom;}
		
		private Double quantityTo=null;
		public Double getQuantityTo(){return quantityTo;}
		public void setQuantityTo(Double quantityTo){this.quantityTo = quantityTo;}
		
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
		

}