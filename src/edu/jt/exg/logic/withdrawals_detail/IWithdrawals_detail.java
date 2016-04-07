package edu.jt.exg.logic.withdrawals_detail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IWithdrawals_detail {
	public List<Withdrawals_detailBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public Withdrawals_detailBean findByKey(String key);//根据主键查询记录
	public List<Withdrawals_detailBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(Withdrawals_detailBean withdrawals_detailBean);//根据主键更新记录
	public int insert(Withdrawals_detailBean withdrawals_detailBean);//插入记录
}