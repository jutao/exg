package edu.jt.exg.logic.re_serve;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Re_serveBean implements Serializable {

	private static final long serialVersionUID = 19761210;
	
	public Re_serveBean(){super();}
	
	/**
	 * 页面显示数据行序列
	 */
	private Integer rownum=null;
	public Integer getRownum(){return rownum;}
	public void setRownum(Integer rownum){this.rownum = rownum;}
	
			private String id="";
		public String getId(){return id;}
		public void setId(String id){this.id = id;}
		
		private String serveid="";
		public String getServeid(){return serveid;}
		public void setServeid(String serveid){this.serveid = serveid;}
		
		private String name="";
		public String getName(){return name;}
		public void setName(String name){this.name = name;}
		
		private Double price=null;
		public Double getPrice(){return price;}
		public void setPrice(Double price){this.price = price;}
		
		private Double priceFrom=null;
		public Double getPriceFrom(){return priceFrom;}
		public void setPriceFrom(Double priceFrom){this.priceFrom = priceFrom;}
		
		private Double priceTo=null;
		public Double getPriceTo(){return priceTo;}
		public void setPriceTo(Double priceTo){this.priceTo = priceTo;}
		
		private String varieties="";
		public String getVarieties(){return varieties;}
		public void setVarieties(String varieties){this.varieties = varieties;}
		
		private String description="";
		public String getDescription(){return description;}
		public void setDescription(String description){this.description = description;}
		
		private String top_pic1="";
		public String getTop_pic1(){return top_pic1;}
		public void setTop_pic1(String top_pic1){this.top_pic1 = top_pic1;}
		
		private String pic1="";
		public String getPic1(){return pic1;}
		public void setPic1(String pic1){this.pic1 = pic1;}
		
		private String pic2="";
		public String getPic2(){return pic2;}
		public void setPic2(String pic2){this.pic2 = pic2;}
		
		private String pic3="";
		public String getPic3(){return pic3;}
		public void setPic3(String pic3){this.pic3 = pic3;}
		
		private String pic4="";
		public String getPic4(){return pic4;}
		public void setPic4(String pic4){this.pic4 = pic4;}
		
		private String pic5="";
		public String getPic5(){return pic5;}
		public void setPic5(String pic5){this.pic5 = pic5;}
		
		private String yubei1="";
		public String getYubei1(){return yubei1;}
		public void setYubei1(String yubei1){this.yubei1 = yubei1;}
		
		private String yubei2="";
		public String getYubei2(){return yubei2;}
		public void setYubei2(String yubei2){this.yubei2 = yubei2;}
		
		private String yubei3="";
		public String getYubei3(){return yubei3;}
		public void setYubei3(String yubei3){this.yubei3 = yubei3;}
		
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