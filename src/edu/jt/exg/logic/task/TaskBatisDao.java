package edu.jt.exg.logic.task;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.binding.BindingException;
import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class TaskBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE="task";
	/**
	 * 主键升序
	 */
	public static String ID_ASC="id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC="id desc";
			public static String TASKID_ASC="taskid asc";
		public static String TASKID_DESC="taskid desc";
		public static String USERKEY_ASC="userkey asc";
		public static String USERKEY_DESC="userkey desc";
		public static String SERVERKEY_ASC="serverkey asc";
		public static String SERVERKEY_DESC="serverkey desc";
		public static String TIP_ASC="tip asc";
		public static String TIP_DESC="tip desc";
		public static String EPSON_ASC="epson asc";
		public static String EPSON_DESC="epson desc";
		public static String PRO_DESCRIPTION_ASC="pro_description asc";
		public static String PRO_DESCRIPTION_DESC="pro_description desc";
		public static String PRO_IMAGE1_ASC="pro_image1 asc";
		public static String PRO_IMAGE1_DESC="pro_image1 desc";
		public static String PRO_IMAGE2_ASC="pro_image2 asc";
		public static String PRO_IMAGE2_DESC="pro_image2 desc";
		public static String PRO_IMAGE3_ASC="pro_image3 asc";
		public static String PRO_IMAGE3_DESC="pro_image3 desc";
		public static String PRO_IMAGE4_ASC="pro_image4 asc";
		public static String PRO_IMAGE4_DESC="pro_image4 desc";
		public static String PRO_IMAGE5_ASC="pro_image5 asc";
		public static String PRO_IMAGE5_DESC="pro_image5 desc";
		public static String SOLVE_IMAGE1_ASC="solve_image1 asc";
		public static String SOLVE_IMAGE1_DESC="solve_image1 desc";
		public static String SOLVE_IMAGE2_ASC="solve_image2 asc";
		public static String SOLVE_IMAGE2_DESC="solve_image2 desc";
		public static String SOLVE_IMAGE3_ASC="solve_image3 asc";
		public static String SOLVE_IMAGE3_DESC="solve_image3 desc";
		public static String SEAT_ASC="seat asc";
		public static String SEAT_DESC="seat desc";
		public static String STATUS_ASC="status asc";
		public static String STATUS_DESC="status desc";
		public static String INVALID_ASC="invalid asc";
		public static String INVALID_DESC="invalid desc";
		public static String REGISTER_TIME_ASC="register_time asc";
		public static String REGISTER_TIME_DESC="register_time desc";
		public static String UPDATE_TIME_ASC="update_time asc";
		public static String UPDATE_TIME_DESC="update_time desc";


	public TaskBatisDao(){super();}
	
	/**
	 * 得到ITask接口实例
	 * @return
	 */
	private ITask getITask(){return (ITask)utility.BatisUtility.ctxProxool.getBean("taskMapper");}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<TaskBean> findByAll(){return getITask().findByAll();}

	/**
	 * 查询所有记录分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<TaskBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getITask().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getITask().findByAllCount().longValue();}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public TaskBean findByKey(String key){return getITask().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<TaskBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,TaskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getITask().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<TaskBean> finder(LinkedHashMap<String, String> orderByMap,TaskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getITask().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<TaskBean> finder(TaskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getITask().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(TaskBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getITask().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<TaskBean> finderEqual(TaskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getITask().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<TaskBean> finderEqual(LinkedHashMap<String, String> orderByMap,TaskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getITask().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<TaskBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,TaskBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getITask().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(TaskBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getITask().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getITask().deleteByKey(key);
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
		try{getITask().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param taskBean
	 * @return
	 */
	public int updateByKey(TaskBean taskBean){
		Integer result=new Integer(1);
		try{getITask().updateByKey(taskBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param taskBean
	 * @return
	 */
	public int insert(TaskBean taskBean){
		Integer result=new Integer(1);
		try{taskBean.setId(Utilities.getRandomPK(true));
			getITask().insert(taskBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param TaskBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(TaskBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getTaskid().trim().length()>0)
			s.append("taskid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getTaskid().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getUserkey().trim().length()>0)
			s.append("userkey like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getUserkey().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getServerkey().trim().length()>0)
			s.append("serverkey like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getServerkey().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getTipFrom()!=null)
			s.append("tip>=").append(queryConditionsBean.getTipFrom().toString()).append(" and ");
		if(queryConditionsBean.getTipTo()!=null)
			s.append("tip<=").append(queryConditionsBean.getTipTo().toString()).append(" and ");
		if(queryConditionsBean.getEpsonFrom()!=null)
			s.append("epson>=").append(queryConditionsBean.getEpsonFrom().toString()).append(" and ");
		if(queryConditionsBean.getEpsonTo()!=null)
			s.append("epson<=").append(queryConditionsBean.getEpsonTo().toString()).append(" and ");
		if(queryConditionsBean.getPro_description().trim().length()>0)
			s.append("pro_description like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_description().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPro_image1().trim().length()>0)
			s.append("pro_image1 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image1().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPro_image2().trim().length()>0)
			s.append("pro_image2 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image2().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPro_image3().trim().length()>0)
			s.append("pro_image3 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image3().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPro_image4().trim().length()>0)
			s.append("pro_image4 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image4().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPro_image5().trim().length()>0)
			s.append("pro_image5 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image5().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getSolve_image1().trim().length()>0)
			s.append("solve_image1 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getSolve_image1().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getSolve_image2().trim().length()>0)
			s.append("solve_image2 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getSolve_image2().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getSolve_image3().trim().length()>0)
			s.append("solve_image3 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getSolve_image3().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getSeat().trim().length()>0)
			s.append("seat like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getSeat().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getStatus().trim().length()>0)
			s.append("status like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getStatus().trim())).append("%' escape '/' and ");
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
	 * @param TaskBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(TaskBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getTaskid().trim().length()>0)
			s.append("taskid = '").append(Utilities.percentMarkFilter(queryConditionsBean.getTaskid().trim())).append("' and ");
		if(queryConditionsBean.getUserkey().trim().length()>0)
			s.append("userkey = '").append(Utilities.percentMarkFilter(queryConditionsBean.getUserkey().trim())).append("' and ");
		if(queryConditionsBean.getServerkey().trim().length()>0)
			s.append("serverkey = '").append(Utilities.percentMarkFilter(queryConditionsBean.getServerkey().trim())).append("' and ");
		if(queryConditionsBean.getTipFrom()!=null)
			s.append("tip>=").append(queryConditionsBean.getTipFrom().toString()).append(" and ");
		if(queryConditionsBean.getTipTo()!=null)
			s.append("tip<=").append(queryConditionsBean.getTipTo().toString()).append(" and ");
		if(queryConditionsBean.getEpsonFrom()!=null)
			s.append("epson>=").append(queryConditionsBean.getEpsonFrom().toString()).append(" and ");
		if(queryConditionsBean.getEpsonTo()!=null)
			s.append("epson<=").append(queryConditionsBean.getEpsonTo().toString()).append(" and ");
		if(queryConditionsBean.getPro_description().trim().length()>0)
			s.append("pro_description = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_description().trim())).append("' and ");
		if(queryConditionsBean.getPro_image1().trim().length()>0)
			s.append("pro_image1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image1().trim())).append("' and ");
		if(queryConditionsBean.getPro_image2().trim().length()>0)
			s.append("pro_image2 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image2().trim())).append("' and ");
		if(queryConditionsBean.getPro_image3().trim().length()>0)
			s.append("pro_image3 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image3().trim())).append("' and ");
		if(queryConditionsBean.getPro_image4().trim().length()>0)
			s.append("pro_image4 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image4().trim())).append("' and ");
		if(queryConditionsBean.getPro_image5().trim().length()>0)
			s.append("pro_image5 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPro_image5().trim())).append("' and ");
		if(queryConditionsBean.getSolve_image1().trim().length()>0)
			s.append("solve_image1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getSolve_image1().trim())).append("' and ");
		if(queryConditionsBean.getSolve_image2().trim().length()>0)
			s.append("solve_image2 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getSolve_image2().trim())).append("' and ");
		if(queryConditionsBean.getSolve_image3().trim().length()>0)
			s.append("solve_image3 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getSolve_image3().trim())).append("' and ");
		if(queryConditionsBean.getSeat().trim().length()>0)
			s.append("seat = '").append(Utilities.percentMarkFilter(queryConditionsBean.getSeat().trim())).append("' and ");
		if(queryConditionsBean.getStatus().trim().length()>0)
			s.append("status = '").append(Utilities.percentMarkFilter(queryConditionsBean.getStatus().trim())).append("' and ");
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