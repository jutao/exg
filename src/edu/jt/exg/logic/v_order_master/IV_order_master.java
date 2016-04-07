package edu.jt.exg.logic.v_order_master;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IV_order_master {
	public List<V_order_masterBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public V_order_masterBean findByKey(String key);//根据主键查询记录
	public List<V_order_masterBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(V_order_masterBean v_order_masterBean);//根据主键更新记录
	public int insert(V_order_masterBean v_order_masterBean);//插入记录
}