package edu.jt.exg.logic.category;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ICategory {
	public List<CategoryBean> findByAll();//全记录查询
	public Long findByAllCount();//全记录数量
	public CategoryBean findByKey(String key);//根据主键查询记录
	public List<CategoryBean> finder(@Param("sql")String sql);//全条件查询
	public Long finderCount(@Param("sql")String sql);//条件查询数量
	public int deleteByKey(String key);//根据主键删除记录
	public int deleteByKeys(List<String> keys);//根据主键批量删除记录
	public int updateByKey(CategoryBean categoryBean);//根据主键更新记录
	public int insert(CategoryBean categoryBean);//插入记录
}