package edu.jt.exg.logic.v_order_master;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.binding.BindingException;
import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class V_order_masterBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE="v_order_master";
	/**
	 * 主键升序
	 */
	public static String ID_ASC="id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC="id desc";
			public static String ORDERID_ASC="orderid asc";
		public static String ORDERID_DESC="orderid desc";
		public static String REPAIR_USERKEY_ASC="repair_userkey asc";
		public static String REPAIR_USERKEY_DESC="repair_userkey desc";
		public static String OUTCOME_ASC="outcome asc";
		public static String OUTCOME_DESC="outcome desc";
		public static String OUTCOME_IMAGE1_ASC="outcome_image1 asc";
		public static String OUTCOME_IMAGE1_DESC="outcome_image1 desc";
		public static String OUTCOME_IMAGE2_ASC="outcome_image2 asc";
		public static String OUTCOME_IMAGE2_DESC="outcome_image2 desc";
		public static String OUTCOME_IMAGE3_ASC="outcome_image3 asc";
		public static String OUTCOME_IMAGE3_DESC="outcome_image3 desc";
		public static String STATUS_ASC="status asc";
		public static String STATUS_DESC="status desc";
		public static String INVALID_ASC="invalid asc";
		public static String INVALID_DESC="invalid desc";
		public static String REGISTER_TIME_ASC="register_time asc";
		public static String REGISTER_TIME_DESC="register_time desc";
		public static String UPDATE_TIME_ASC="update_time asc";
		public static String UPDATE_TIME_DESC="update_time desc";
		public static String REQ_NAME_ASC="req_name asc";
		public static String REQ_NAME_DESC="req_name desc";
		public static String REQ_ID_ASC="req_id asc";
		public static String REQ_ID_DESC="req_id desc";
		public static String REQ_ICON_ASC="req_icon asc";
		public static String REQ_ICON_DESC="req_icon desc";


	public V_order_masterBatisDao(){super();}
	
	/**
	 * 得到IV_order_master接口实例
	 * @return
	 */
	private IV_order_master getIV_order_master(){return (IV_order_master)utility.BatisUtility.ctxProxool.getBean("v_order_masterMapper");}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<V_order_masterBean> findByAll(){return getIV_order_master().findByAll();}

	/**
	 * 查询所有记录分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<V_order_masterBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getIV_order_master().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getIV_order_master().findByAllCount().longValue();}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public V_order_masterBean findByKey(String key){return getIV_order_master().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_order_masterBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,V_order_masterBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIV_order_master().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_order_masterBean> finder(LinkedHashMap<String, String> orderByMap,V_order_masterBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIV_order_master().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_order_masterBean> finder(V_order_masterBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getIV_order_master().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(V_order_masterBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getIV_order_master().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_order_masterBean> finderEqual(V_order_masterBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getIV_order_master().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_order_masterBean> finderEqual(LinkedHashMap<String, String> orderByMap,V_order_masterBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIV_order_master().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_order_masterBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,V_order_masterBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIV_order_master().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(V_order_masterBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getIV_order_master().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getIV_order_master().deleteByKey(key);
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
		try{getIV_order_master().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param v_order_masterBean
	 * @return
	 */
	public int updateByKey(V_order_masterBean v_order_masterBean){
		Integer result=new Integer(1);
		try{getIV_order_master().updateByKey(v_order_masterBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param v_order_masterBean
	 * @return
	 */
	public int insert(V_order_masterBean v_order_masterBean){
		Integer result=new Integer(1);
		try{v_order_masterBean.setId(Utilities.getRandomPK(true));
			getIV_order_master().insert(v_order_masterBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param V_order_masterBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(V_order_masterBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getOrderid().trim().length()>0)
			s.append("orderid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getOrderid().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getRepair_userkey().trim().length()>0)
			s.append("repair_userkey like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getRepair_userkey().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getOutcome().trim().length()>0)
			s.append("outcome like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getOutcome_image1().trim().length()>0)
			s.append("outcome_image1 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome_image1().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getOutcome_image2().trim().length()>0)
			s.append("outcome_image2 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome_image2().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getOutcome_image3().trim().length()>0)
			s.append("outcome_image3 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome_image3().trim())).append("%' escape '/' and ");
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
		if(queryConditionsBean.getReq_name().trim().length()>0)
			s.append("req_name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getReq_name().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getReq_id().trim().length()>0)
			s.append("req_id like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getReq_id().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getReq_icon().trim().length()>0)
			s.append("req_icon like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getReq_icon().trim())).append("%' escape '/' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}

	/**
	 * 返回sql语句的where子句
	 * @param V_order_masterBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(V_order_masterBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getOrderid().trim().length()>0)
			s.append("orderid = '").append(Utilities.percentMarkFilter(queryConditionsBean.getOrderid().trim())).append("' and ");
		if(queryConditionsBean.getRepair_userkey().trim().length()>0)
			s.append("repair_userkey = '").append(Utilities.percentMarkFilter(queryConditionsBean.getRepair_userkey().trim())).append("' and ");
		if(queryConditionsBean.getOutcome().trim().length()>0)
			s.append("outcome = '").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome().trim())).append("' and ");
		if(queryConditionsBean.getOutcome_image1().trim().length()>0)
			s.append("outcome_image1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome_image1().trim())).append("' and ");
		if(queryConditionsBean.getOutcome_image2().trim().length()>0)
			s.append("outcome_image2 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome_image2().trim())).append("' and ");
		if(queryConditionsBean.getOutcome_image3().trim().length()>0)
			s.append("outcome_image3 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getOutcome_image3().trim())).append("' and ");
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
		if(queryConditionsBean.getReq_name().trim().length()>0)
			s.append("req_name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getReq_name().trim())).append("' and ");
		if(queryConditionsBean.getReq_id().trim().length()>0)
			s.append("req_id = '").append(Utilities.percentMarkFilter(queryConditionsBean.getReq_id().trim())).append("' and ");
		if(queryConditionsBean.getReq_icon().trim().length()>0)
			s.append("req_icon = '").append(Utilities.percentMarkFilter(queryConditionsBean.getReq_icon().trim())).append("' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}
}