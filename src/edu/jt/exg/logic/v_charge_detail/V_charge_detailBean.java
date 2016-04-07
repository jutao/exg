package edu.jt.exg.logic.v_charge_detail;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class V_charge_detailBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public V_charge_detailBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String chargeid="";
		public String getChargeid(){return chargeid;}
		public void setChargeid(String chargeid){this.chargeid = chargeid;}
		
		private String userkey="";
		public String getUserkey(){return userkey;}
		public void setUserkey(String userkey){this.userkey = userkey;}
		
		private Double amount=null;
		public Double getAmount(){return amount;}
		public void setAmount(Double amount){this.amount = amount;}
		
		private Double amountFrom=null;
		public Double getAmountFrom(){return amountFrom;}
		public void setAmountFrom(Double amountFrom){this.amountFrom = amountFrom;}
		
		private Double amountTo=null;
		public Double getAmountTo(){return amountTo;}
		public void setAmountTo(Double amountTo){this.amountTo = amountTo;}
		
		private String category="";
		public String getCategory(){return category;}
		public void setCategory(String category){this.category = category;}
		
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
		
		private String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private String user_id="";
		public String getUser_id(){return user_id;}
		public void setUser_id(String user_id){this.user_id = user_id;}
		
		private String icon="";
		public String getIcon(){return icon;}
		public void setIcon(String icon){this.icon = icon;}
		

}