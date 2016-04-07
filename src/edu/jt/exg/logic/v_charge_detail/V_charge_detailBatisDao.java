package edu.jt.exg.logic.v_charge_detail;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.binding.BindingException;
import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class V_charge_detailBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE="v_charge_detail";
	/**
	 * 主键升序
	 */
	public static String ID_ASC="id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC="id desc";
			public static String CHARGEID_ASC="chargeid asc";
		public static String CHARGEID_DESC="chargeid desc";
		public static String USERKEY_ASC="userkey asc";
		public static String USERKEY_DESC="userkey desc";
		public static String AMOUNT_ASC="amount asc";
		public static String AMOUNT_DESC="amount desc";
		public static String CATEGORY_ASC="category asc";
		public static String CATEGORY_DESC="category desc";
		public static String STATUS_ASC="status asc";
		public static String STATUS_DESC="status desc";
		public static String INVALID_ASC="invalid asc";
		public static String INVALID_DESC="invalid desc";
		public static String REGISTER_TIME_ASC="register_time asc";
		public static String REGISTER_TIME_DESC="register_time desc";
		public static String UPDATE_TIME_ASC="update_time asc";
		public static String UPDATE_TIME_DESC="update_time desc";
		public static String NAME_ASC="name asc";
		public static String NAME_DESC="name desc";
		public static String USER_ID_ASC="user_id asc";
		public static String USER_ID_DESC="user_id desc";
		public static String ICON_ASC="icon asc";
		public static String ICON_DESC="icon desc";


	public V_charge_detailBatisDao(){super();}
	
	/**
	 * 得到IV_charge_detail接口实例
	 * @return
	 */
	private IV_charge_detail getIV_charge_detail(){return (IV_charge_detail)utility.BatisUtility.ctxProxool.getBean("v_charge_detailMapper");}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<V_charge_detailBean> findByAll(){return getIV_charge_detail().findByAll();}

	/**
	 * 查询所有记录分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<V_charge_detailBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getIV_charge_detail().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getIV_charge_detail().findByAllCount().longValue();}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public V_charge_detailBean findByKey(String key){return getIV_charge_detail().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_charge_detailBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,V_charge_detailBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIV_charge_detail().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_charge_detailBean> finder(LinkedHashMap<String, String> orderByMap,V_charge_detailBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIV_charge_detail().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_charge_detailBean> finder(V_charge_detailBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getIV_charge_detail().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(V_charge_detailBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getIV_charge_detail().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_charge_detailBean> finderEqual(V_charge_detailBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getIV_charge_detail().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_charge_detailBean> finderEqual(LinkedHashMap<String, String> orderByMap,V_charge_detailBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIV_charge_detail().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_charge_detailBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,V_charge_detailBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIV_charge_detail().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(V_charge_detailBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getIV_charge_detail().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getIV_charge_detail().deleteByKey(key);
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
		try{getIV_charge_detail().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param v_charge_detailBean
	 * @return
	 */
	public int updateByKey(V_charge_detailBean v_charge_detailBean){
		Integer result=new Integer(1);
		try{getIV_charge_detail().updateByKey(v_charge_detailBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param v_charge_detailBean
	 * @return
	 */
	public int insert(V_charge_detailBean v_charge_detailBean){
		Integer result=new Integer(1);
		try{v_charge_detailBean.setId(Utilities.getRandomPK(true));
			getIV_charge_detail().insert(v_charge_detailBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param V_charge_detailBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(V_charge_detailBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getChargeid().trim().length()>0)
			s.append("chargeid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getChargeid().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getUserkey().trim().length()>0)
			s.append("userkey like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getUserkey().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getAmountFrom()!=null)
			s.append("amount>=").append(queryConditionsBean.getAmountFrom().toString()).append(" and ");
		if(queryConditionsBean.getAmountTo()!=null)
			s.append("amount<=").append(queryConditionsBean.getAmountTo().toString()).append(" and ");
		if(queryConditionsBean.getCategory().trim().length()>0)
			s.append("category like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getCategory().trim())).append("%' escape '/' and ");
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
		if(queryConditionsBean.getName().trim().length()>0)
			s.append("name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getName().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getUser_id().trim().length()>0)
			s.append("user_id like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getUser_id().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getIcon().trim().length()>0)
			s.append("icon like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getIcon().trim())).append("%' escape '/' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}

	/**
	 * 返回sql语句的where子句
	 * @param V_charge_detailBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(V_charge_detailBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getChargeid().trim().length()>0)
			s.append("chargeid = '").append(Utilities.percentMarkFilter(queryConditionsBean.getChargeid().trim())).append("' and ");
		if(queryConditionsBean.getUserkey().trim().length()>0)
			s.append("userkey = '").append(Utilities.percentMarkFilter(queryConditionsBean.getUserkey().trim())).append("' and ");
		if(queryConditionsBean.getAmountFrom()!=null)
			s.append("amount>=").append(queryConditionsBean.getAmountFrom().toString()).append(" and ");
		if(queryConditionsBean.getAmountTo()!=null)
			s.append("amount<=").append(queryConditionsBean.getAmountTo().toString()).append(" and ");
		if(queryConditionsBean.getCategory().trim().length()>0)
			s.append("category = '").append(Utilities.percentMarkFilter(queryConditionsBean.getCategory().trim())).append("' and ");
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
		if(queryConditionsBean.getName().trim().length()>0)
			s.append("name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getName().trim())).append("' and ");
		if(queryConditionsBean.getUser_id().trim().length()>0)
			s.append("user_id = '").append(Utilities.percentMarkFilter(queryConditionsBean.getUser_id().trim())).append("' and ");
		if(queryConditionsBean.getIcon().trim().length()>0)
			s.append("icon = '").append(Utilities.percentMarkFilter(queryConditionsBean.getIcon().trim())).append("' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}
}