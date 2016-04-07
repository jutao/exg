package edu.jt.exg.logic.v_comment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IV_comment {
	public List<V_commentBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public V_commentBean findByKey(String key);//根据主键查询记录
	public List<V_commentBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(V_commentBean v_commentBean);//根据主键更新记录
	public int insert(V_commentBean v_commentBean);//插入记录
}