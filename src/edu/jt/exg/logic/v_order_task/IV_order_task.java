package edu.jt.exg.logic.v_order_task;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IV_order_task {
	public List<V_order_taskBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public V_order_taskBean findByKey(String key);//根据主键查询记录
	public List<V_order_taskBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(V_order_taskBean v_order_taskBean);//根据主键更新记录
	public int insert(V_order_taskBean v_order_taskBean);//插入记录
}