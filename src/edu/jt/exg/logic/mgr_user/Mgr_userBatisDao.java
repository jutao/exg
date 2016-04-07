package edu.jt.exg.logic.mgr_user;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.binding.BindingException;

import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class Mgr_userBatisDao {
	/**
	 * 表或视图�?	 */
	public static String TABLE="mgr_user";
	/**
	 * 主键升序
	 */
	public static String ID_ASC="id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC="id desc";
			public static String USERTYPE_ASC="usertype asc";
		public static String USERTYPE_DESC="usertype desc";
		public static String USERID_ASC="userid asc";
		public static String USERID_DESC="userid desc";
		public static String NAME_ASC="name asc";
		public static String NAME_DESC="name desc";
		public static String LOGIN_PASSWORD_ASC="login_password asc";
		public static String LOGIN_PASSWORD_DESC="login_password desc";
		public static String YUBEI1_ASC="yubei1 asc";
		public static String YUBEI1_DESC="yubei1 desc";
		public static String YUBEI2_ASC="yubei2 asc";
		public static String YUBEI2_DESC="yubei2 desc";
		public static String YUBEI3_ASC="yubei3 asc";
		public static String YUBEI3_DESC="yubei3 desc";
		public static String INVALID_ASC="invalid asc";
		public static String INVALID_DESC="invalid desc";
		public static String REGISTER_TIME_ASC="register_time asc";
		public static String REGISTER_TIME_DESC="register_time desc";
		public static String UPDATE_TIME_ASC="update_time asc";
		public static String UPDATE_TIME_DESC="update_time desc";


	public Mgr_userBatisDao(){super();}
	
	/**
	 * 得到IMgr_user接口实例
	 * @return
	 */
	private IMgr_user getIMgr_user(){return (IMgr_user)utility.BatisUtility.ctxProxool.getBean("mgr_userMapper");}
	
	/**
	 * 查询所有记�?	 * @return
	 */
	public List<Mgr_userBean> findByAll(){return getIMgr_user().findByAll();}

	/**
	 * 查询所有记录分�?	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<Mgr_userBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getIMgr_user().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getIMgr_user().findByAllCount().longValue();}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public Mgr_userBean findByKey(String key){return getIMgr_user().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Mgr_userBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,Mgr_userBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIMgr_user().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Mgr_userBean> finder(LinkedHashMap<String, String> orderByMap,Mgr_userBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIMgr_user().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记�?	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Mgr_userBean> finder(Mgr_userBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getIMgr_user().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(Mgr_userBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getIMgr_user().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集�?忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Mgr_userBean> finderEqual(Mgr_userBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getIMgr_user().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集�?忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Mgr_userBean> finderEqual(LinkedHashMap<String, String> orderByMap,Mgr_userBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIMgr_user().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Mgr_userBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,Mgr_userBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIMgr_user().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(Mgr_userBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getIMgr_user().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getIMgr_user().deleteByKey(key);
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
		try{getIMgr_user().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param mgr_userBean
	 * @return
	 */
	public int updateByKey(Mgr_userBean mgr_userBean){
		Integer result=new Integer(1);
		try{getIMgr_user().updateByKey(mgr_userBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param mgr_userBean
	 * @return
	 */
	public int insert(Mgr_userBean mgr_userBean){
		Integer result=new Integer(1);
		try{mgr_userBean.setId(Utilities.getRandomPK(true));
			getIMgr_user().insert(mgr_userBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param Mgr_userBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(Mgr_userBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
		if(queryConditionsBean.getUsertype().trim().length()>0)
			s.append("usertype like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getUsertype().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getUserid().trim().length()>0)
			s.append("userid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getUserid().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getName().trim().length()>0)
			s.append("name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getName().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getInvalid().trim().length()>0)
			s.append("invalid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getInvalid().trim())).append("%' escape '/' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}

	/**
	 * 返回sql语句的where子句
	 * @param Mgr_userBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(Mgr_userBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getUsertype().trim().length()>0)
			s.append("usertype = '").append(Utilities.percentMarkFilter(queryConditionsBean.getUsertype().trim())).append("' and ");
		if(queryConditionsBean.getUserid().trim().length()>0)
			s.append("userid = '").append(Utilities.percentMarkFilter(queryConditionsBean.getUserid().trim())).append("' and ");
		if(queryConditionsBean.getName().trim().length()>0)
			s.append("name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getName().trim())).append("' and ");
		if(queryConditionsBean.getLogin_password().trim().length()>0)
			s.append("login_password = '").append(Utilities.percentMarkFilter(queryConditionsBean.getLogin_password().trim())).append("' and ");
		if(queryConditionsBean.getYubei1().trim().length()>0)
			s.append("yubei1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei1().trim())).append("' and ");
		if(queryConditionsBean.getYubei2().trim().length()>0)
			s.append("yubei2 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei2().trim())).append("' and ");
		if(queryConditionsBean.getYubei3().trim().length()>0)
			s.append("yubei3 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei3().trim())).append("' and ");
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