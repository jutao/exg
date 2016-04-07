package edu.jt.exg.logic.v_address;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IV_address {
	public List<V_addressBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public V_addressBean findByKey(String key);//根据主键查询记录
	public List<V_addressBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(V_addressBean v_addressBean);//根据主键更新记录
	public int insert(V_addressBean v_addressBean);//插入记录
	public String finderProvince_name(String province_code);//根据省code查找省的名称
	public String finderCity_name(String city_code);//根据市code查找市的名称
	public String finderArea_name(String area_code);//根据区code查找区的名称
}