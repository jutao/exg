package edu.jt.exg.dto;

import java.util.List;
/**
 * 城市模型
 * @author Jutao
 *
 */
public class CityDto {
	private String city_name;
	private String city_code;
	private List<AreaDto> area_list;
	
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public List<AreaDto> getArea_list() {
		return area_list;
	}
	public void setArea_list(List<AreaDto> area_list) {
		this.area_list = area_list;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	
}
