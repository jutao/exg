package edu.jt.exg.logic.v_comment;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class V_commentBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public V_commentBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String userkey="";
		public String getUserkey(){return userkey;}
		public void setUserkey(String userkey){this.userkey = userkey;}
		
		private String targetkey="";
		public String getTargetkey(){return targetkey;}
		public void setTargetkey(String targetkey){this.targetkey = targetkey;}
		
		private String detail="";
		public String getDetail(){return detail;}
		public void setDetail(String detail){this.detail = detail;}
		
		private String pic1="";
		public String getPic1(){return pic1;}
		public void setPic1(String pic1){this.pic1 = pic1;}
		
		private String pic2="";
		public String getPic2(){return pic2;}
		public void setPic2(String pic2){this.pic2 = pic2;}
		
		private String pic3="";
		public String getPic3(){return pic3;}
		public void setPic3(String pic3){this.pic3 = pic3;}
		
		private String category="";
		public String getCategory(){return category;}
		public void setCategory(String category){this.category = category;}
		
		private Integer display=null;
		public Integer getDisplay(){return display;}
		public void setDisplay(Integer display){this.display = display;}
		
		private Integer displayFrom=null;
		public Integer getDisplayFrom(){return displayFrom;}
		public void setDisplayFrom(Integer displayFrom){this.displayFrom = displayFrom;}
		
		private Integer displayTo=null;
		public Integer getDisplayTo(){return displayTo;}
		public void setDisplayTo(Integer displayTo){this.displayTo = displayTo;}
		
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
		
		private String user_key="";
		public String getUser_key(){return user_key;}
		public void setUser_key(String user_key){this.user_key = user_key;}
		
		private String neckname="";
		public String getNeckname(){return neckname;}
		public void setNeckname(String neckname){this.neckname = neckname;}
		
		private String icon="";
		public String getIcon(){return icon;}
		public void setIcon(String icon){this.icon = icon;}
		
		private String user_id="";
		public String getUser_id(){return user_id;}
		public void setUser_id(String user_id){this.user_id = user_id;}
		
		private String target_id="";
		public String getTarget_id(){return target_id;}
		public void setTarget_id(String target_id){this.target_id = target_id;}
		
		private String target_name="";
		public String getTarget_name(){return target_name;}
		public void setTarget_name(String target_name){this.target_name = target_name;}
		

}