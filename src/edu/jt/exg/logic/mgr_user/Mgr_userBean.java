package edu.jt.exg.logic.mgr_user;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Mgr_userBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Mgr_userBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String usertype="";
		public String getUsertype(){return usertype;}
		public void setUsertype(String usertype){this.usertype = usertype;}
		
		private String userid="";
		public String getUserid(){return userid;}
		public void setUserid(String userid){this.userid = userid;}
		
		private String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private String login_password="";
		public String getLogin_password(){return login_password;}
		public void setLogin_password(String login_password){this.login_password = login_password;}
		
		private String yubei1="";
		public String getYubei1(){return yubei1;}
		public void setYubei1(String yubei1){this.yubei1 = yubei1;}
		
		private String yubei2="";
		public String getYubei2(){return yubei2;}
		public void setYubei2(String yubei2){this.yubei2 = yubei2;}
		
		private String yubei3="";
		public String getYubei3(){return yubei3;}
		public void setYubei3(String yubei3){this.yubei3 = yubei3;}
		
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