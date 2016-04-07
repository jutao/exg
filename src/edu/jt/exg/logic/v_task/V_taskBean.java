package edu.jt.exg.logic.v_task;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class V_taskBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public V_taskBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String taskid="";
		public String getTaskid(){return taskid;}
		public void setTaskid(String taskid){this.taskid = taskid;}
		
		private String userkey="";
		public String getUserkey(){return userkey;}
		public void setUserkey(String userkey){this.userkey = userkey;}
		
		private String serverkey="";
		public String getServerkey(){return serverkey;}
		public void setServerkey(String serverkey){this.serverkey = serverkey;}
		
		private Double tip=null;
		public Double getTip(){return tip;}
		public void setTip(Double tip){this.tip = tip;}
		
		private Double tipFrom=null;
		public Double getTipFrom(){return tipFrom;}
		public void setTipFrom(Double tipFrom){this.tipFrom = tipFrom;}
		
		private Double tipTo=null;
		public Double getTipTo(){return tipTo;}
		public void setTipTo(Double tipTo){this.tipTo = tipTo;}
		
		private Double epson=null;
		public Double getEpson(){return epson;}
		public void setEpson(Double epson){this.epson = epson;}
		
		private Double epsonFrom=null;
		public Double getEpsonFrom(){return epsonFrom;}
		public void setEpsonFrom(Double epsonFrom){this.epsonFrom = epsonFrom;}
		
		private Double epsonTo=null;
		public Double getEpsonTo(){return epsonTo;}
		public void setEpsonTo(Double epsonTo){this.epsonTo = epsonTo;}
		
		private String pro_description="";
		public String getPro_description(){return pro_description;}
		public void setPro_description(String pro_description){this.pro_description = pro_description;}
		
		private String pro_image1="";
		public String getPro_image1(){return pro_image1;}
		public void setPro_image1(String pro_image1){this.pro_image1 = pro_image1;}
		
		private String pro_image2="";
		public String getPro_image2(){return pro_image2;}
		public void setPro_image2(String pro_image2){this.pro_image2 = pro_image2;}
		
		private String pro_image3="";
		public String getPro_image3(){return pro_image3;}
		public void setPro_image3(String pro_image3){this.pro_image3 = pro_image3;}
		
		private String pro_image4="";
		public String getPro_image4(){return pro_image4;}
		public void setPro_image4(String pro_image4){this.pro_image4 = pro_image4;}
		
		private String pro_image5="";
		public String getPro_image5(){return pro_image5;}
		public void setPro_image5(String pro_image5){this.pro_image5 = pro_image5;}
		
		private String solve_image1="";
		public String getSolve_image1(){return solve_image1;}
		public void setSolve_image1(String solve_image1){this.solve_image1 = solve_image1;}
		
		private String solve_image2="";
		public String getSolve_image2(){return solve_image2;}
		public void setSolve_image2(String solve_image2){this.solve_image2 = solve_image2;}
		
		private String solve_image3="";
		public String getSolve_image3(){return solve_image3;}
		public void setSolve_image3(String solve_image3){this.solve_image3 = solve_image3;}
		
		private String seat="";
		public String getSeat(){return seat;}
		public void setSeat(String seat){this.seat = seat;}
		
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
		
		private String server_name="";
		public String getServer_name(){return server_name;}
		public void setServer_name(String server_name){this.server_name = server_name;}
		
		private Double server_price=null;
		public Double getServer_price(){return server_price;}
		public void setServer_price(Double server_price){this.server_price = server_price;}
		
		private Double server_priceFrom=null;
		public Double getServer_priceFrom(){return server_priceFrom;}
		public void setServer_priceFrom(Double server_priceFrom){this.server_priceFrom = server_priceFrom;}
		
		private Double server_priceTo=null;
		public Double getServer_priceTo(){return server_priceTo;}
		public void setServer_priceTo(Double server_priceTo){this.server_priceTo = server_priceTo;}
		
		private Double total_price=null;
		public Double getTotal_price(){return total_price;}
		public void setTotal_price(Double total_price){this.total_price = total_price;}
		
		private Double total_priceFrom=null;
		public Double getTotal_priceFrom(){return total_priceFrom;}
		public void setTotal_priceFrom(Double total_priceFrom){this.total_priceFrom = total_priceFrom;}
		
		private Double total_priceTo=null;
		public Double getTotal_priceTo(){return total_priceTo;}
		public void setTotal_priceTo(Double total_priceTo){this.total_priceTo = total_priceTo;}
		

}