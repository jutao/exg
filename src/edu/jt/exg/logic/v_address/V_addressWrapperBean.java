package edu.jt.exg.logic.v_address;

public class V_addressWrapperBean {
	public V_addressWrapperBean(){super();}
	
	/**
	 * province_code表主键
	 */
	private String province_code="";
	public String  getProvince_code(){return province_code;}
	public void setProvince_code(String province_code){this.province_code = province_code;}

			private String province_name="";
		public String  getProvince_name(){return province_name;}
		public void setProvince_name(String province_name){this.province_name = province_name;}
		
		private String city_code="";
		public String  getCity_code(){return city_code;}
		public void setCity_code(String city_code){this.city_code = city_code;}
		
		private String city_name="";
		public String  getCity_name(){return city_name;}
		public void setCity_name(String city_name){this.city_name = city_name;}
		
		private String area_code="";
		public String  getArea_code(){return area_code;}
		public void setArea_code(String area_code){this.area_code = area_code;}
		
		private String area_name="";
		public String  getArea_name(){return area_name;}
		public void setArea_name(String area_name){this.area_name = area_name;}
		

}