package edu.jt.exg.logic.mgr_user;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IMgr_user {
	public List<Mgr_userBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public Mgr_userBean findByKey(String key);//根据主键查询记录
	public List<Mgr_userBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(Mgr_userBean mgr_userBean);//根据主键更新记录
	public int insert(Mgr_userBean mgr_userBean);//插入记录
}