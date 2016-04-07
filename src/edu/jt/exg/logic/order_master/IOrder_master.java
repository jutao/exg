package edu.jt.exg.logic.order_master;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IOrder_master {
	public List<Order_masterBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public Order_masterBean findByKey(String key);//根据主键查询记录
	public List<Order_masterBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(Order_masterBean order_masterBean);//根据主键更新记录
	public int insert(Order_masterBean order_masterBean);//插入记录
}