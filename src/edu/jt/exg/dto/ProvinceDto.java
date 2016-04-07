package edu.jt.exg.dto;

import java.util.List;
/**
 * 省模型
 * @author Jutao
 *
 */
public class ProvinceDto {
	private String province_name;
	private String province_code;
	private List<CityDto> city_list;
	
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public List<CityDto> getCity_list() {
		return city_list;
	}
	public void setCity_list(List<CityDto> city_list) {
		this.city_list = city_list;
	}
	public String getProvince_code() {
		return province_code;
	}
	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}
	
}
