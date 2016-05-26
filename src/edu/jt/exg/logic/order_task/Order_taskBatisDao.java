package edu.jt.exg.logic.order_task;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.binding.BindingException;
import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class Order_taskBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE="order_task";
	/**
	 * 主键升序
	 */
	public static String ID_ASC="id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC="id desc";
			public static String TASKKEY_ASC="taskkey asc";
		public static String TASKKEY_DESC="taskkey desc";
		public static String ORDERKEY_ASC="orderkey asc";
		public static String ORDERKEY_DESC="orderkey desc";
		public static String INVALID_ASC="invalid asc";
		public static String INVALID_DESC="invalid desc";
		public static String REGISTER_TIME_ASC="register_time asc";
		public static String REGISTER_TIME_DESC="register_time desc";
		public static String UPDATE_TIME_ASC="update_time asc";
		public static String UPDATE_TIME_DESC="update_time desc";


	public Order_taskBatisDao(){super();}
	
	/**
	 * 得到IOrder_task接口实例
	 * @return
	 */
	private IOrder_task getIOrder_task(){return (IOrder_task)utility.BatisUtility.ctxProxool.getBean("order_taskMapper");}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<Order_taskBean> findByAll(){return getIOrder_task().findByAll();}

	/**
	 * 查询所有记录分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<Order_taskBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getIOrder_task().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getIOrder_task().findByAllCount().longValue();}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public Order_taskBean findByKey(String key){return getIOrder_task().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Order_taskBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,Order_taskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIOrder_task().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Order_taskBean> finder(LinkedHashMap<String, String> orderByMap,Order_taskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIOrder_task().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Order_taskBean> finder(Order_taskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getIOrder_task().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(Order_taskBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getIOrder_task().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Order_taskBean> finderEqual(Order_taskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getIOrder_task().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Order_taskBean> finderEqual(LinkedHashMap<String, String> orderByMap,Order_taskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIOrder_task().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Order_taskBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,Order_taskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIOrder_task().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(Order_taskBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getIOrder_task().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getIOrder_task().deleteByKey(key);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键批量删除记录
	 * @param keys 主键集合
	 * @return
	 */
	public int deleteByKeys(List<String> keys){
		Integer result=new Integer(1);
		try{getIOrder_task().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param order_taskBean
	 * @return
	 */
	public int updateByKey(Order_taskBean order_taskBean){
		Integer result=new Integer(1);
		try{getIOrder_task().updateByKey(order_taskBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param order_taskBean
	 * @return
	 */
	public int insert(Order_taskBean order_taskBean){
		Integer result=new Integer(1);
		try{order_taskBean.setId(Utilities.getRandomPK(true));
			getIOrder_task().insert(order_taskBean);
		}catch(Exception e){
			result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param Order_taskBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(Order_taskBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getTaskkey().trim().length()>0)
			s.append("taskkey like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getTaskkey().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getOrderkey().trim().length()>0)
			s.append("orderkey like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getOrderkey().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getInvalid().trim().length()>0)
			s.append("invalid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getInvalid().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getRegister_timeFrom()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(register_time,'yyyy-MM-dd hh:mm:ss')>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(register_time)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),register_time,120)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("register_time>='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getRegister_timeFrom())).append("' and ");
		}
		if(queryConditionsBean.getRegister_timeTo()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(register_time,'yyyy-MM-dd hh:mm:ss')<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(register_time)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),register_time,120)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("register_time<='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getRegister_timeTo())).append("' and ");
		}
		if(queryConditionsBean.getUpdate_timeFrom()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(update_time,'yyyy-MM-dd hh:mm:ss')>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(update_time)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),update_time,120)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("update_time>='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getUpdate_timeFrom())).append("' and ");
		}
		if(queryConditionsBean.getUpdate_timeTo()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(update_time,'yyyy-MM-dd hh:mm:ss')<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(update_time)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),update_time,120)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("update_time<='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getUpdate_timeTo())).append("' and ");
		}

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}

	/**
	 * 返回sql语句的where子句
	 * @param Order_taskBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(Order_taskBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getTaskkey().trim().length()>0)
			s.append("taskkey = '").append(Utilities.percentMarkFilter(queryConditionsBean.getTaskkey().trim())).append("' and ");
		if(queryConditionsBean.getOrderkey().trim().length()>0)
			s.append("orderkey = '").append(Utilities.percentMarkFilter(queryConditionsBean.getOrderkey().trim())).append("' and ");
		if(queryConditionsBean.getInvalid().trim().length()>0)
			s.append("invalid = '").append(Utilities.percentMarkFilter(queryConditionsBean.getInvalid().trim())).append("' and ");
		if(queryConditionsBean.getRegister_timeFrom()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(register_time,'yyyy-MM-dd hh:mm:ss')>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(register_time)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),register_time,120)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("register_time>='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getRegister_timeFrom())).append("' and ");
		}
		if(queryConditionsBean.getRegister_timeTo()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(register_time,'yyyy-MM-dd hh:mm:ss')<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(register_time)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),register_time,120)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("register_time<='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getRegister_timeTo())).append("' and ");
		}
		if(queryConditionsBean.getUpdate_timeFrom()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(update_time,'yyyy-MM-dd hh:mm:ss')>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(update_time)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),update_time,120)>='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("update_time>='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getUpdate_timeFrom())).append("' and ");
		}
		if(queryConditionsBean.getUpdate_timeTo()!=null){
			if(ConstSetup.DATABASE.toUpperCase().equals("ORACLE")) s.append("to_char(update_time,'yyyy-MM-dd hh:mm:ss')<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("DB2")) s.append("char(update_time)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER")) s.append("CONVERT(varchar(20),update_time,120)<='");
			else if(ConstSetup.DATABASE.toUpperCase().equals("MYSQL") || ConstSetup.DATABASE.toUpperCase().equals("SYBASE")) s.append("update_time<='");
			s.append(Utilities.getDateString("yyyy-MM-dd hh:mm:ss", queryConditionsBean.getUpdate_timeTo())).append("' and ");
		}

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}
}