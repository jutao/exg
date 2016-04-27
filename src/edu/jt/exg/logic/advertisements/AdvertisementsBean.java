package edu.jt.exg.logic.advertisements;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AdvertisementsBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public AdvertisementsBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
//		private String targetkey="";
//		public String getTargetkey(){return targetkey;}
//		public void setTargetkey(String targetkey){this.targetkey = targetkey;}
		
		private String top_pic1="";
		public String getTop_pic1(){return top_pic1;}
		public void setTop_pic1(String top_pic1){this.top_pic1 = top_pic1;}
		
		private String url="";
		public String getUrl(){return url;}
		public void setUrl(String url){this.url = url;}
		
//		private String category="";
//		public String getCategory(){return category;}
//		public void setCategory(String category){this.category = category;}
		
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
		

}