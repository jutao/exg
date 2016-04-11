package edu.jt.exg.logic.re_serve;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.binding.BindingException;
import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class Re_serveBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE="re_serve";
	/**
	 * 主键升序
	 */
	public static String ID_ASC="id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC="id desc";
			public static String SERVEID_ASC="serveid asc";
		public static String SERVEID_DESC="serveid desc";
		public static String NAME_ASC="name asc";
		public static String NAME_DESC="name desc";
		public static String PRICE_ASC="price asc";
		public static String PRICE_DESC="price desc";
		public static String VARIETIES_ASC="varieties asc";
		public static String VARIETIES_DESC="varieties desc";
		public static String DESCRIPTION_ASC="description asc";
		public static String DESCRIPTION_DESC="description desc";
		public static String TOP_PIC1_ASC="top_pic1 asc";
		public static String TOP_PIC1_DESC="top_pic1 desc";
		public static String PIC1_ASC="pic1 asc";
		public static String PIC1_DESC="pic1 desc";
		public static String PIC2_ASC="pic2 asc";
		public static String PIC2_DESC="pic2 desc";
		public static String PIC3_ASC="pic3 asc";
		public static String PIC3_DESC="pic3 desc";
		public static String PIC4_ASC="pic4 asc";
		public static String PIC4_DESC="pic4 desc";
		public static String PIC5_ASC="pic5 asc";
		public static String PIC5_DESC="pic5 desc";
		public static String YUBEI1_ASC="yubei1 asc";
		public static String YUBEI1_DESC="yubei1 desc";
		public static String YUBEI2_ASC="yubei2 asc";
		public static String YUBEI2_DESC="yubei2 desc";
		public static String YUBEI3_ASC="yubei3 asc";
		public static String YUBEI3_DESC="yubei3 desc";
		public static String DISPLAY_ASC="display asc";
		public static String DISPLAY_DESC="display desc";
		public static String INVALID_ASC="invalid asc";
		public static String INVALID_DESC="invalid desc";
		public static String REGISTER_TIME_ASC="register_time asc";
		public static String REGISTER_TIME_DESC="register_time desc";
		public static String UPDATE_TIME_ASC="update_time asc";
		public static String UPDATE_TIME_DESC="update_time desc";


	public Re_serveBatisDao(){super();}
	
	/**
	 * 得到IRe_serve接口实例
	 * @return
	 */
	private IRe_serve getIRe_serve(){return (IRe_serve)utility.BatisUtility.ctxProxool.getBean("re_serveMapper");}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<Re_serveBean> findByAll(){return getIRe_serve().findByAll();}

	/**
	 * 查询所有记录分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<Re_serveBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getIRe_serve().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getIRe_serve().findByAllCount().longValue();}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public Re_serveBean findByKey(String key){return getIRe_serve().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Re_serveBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,Re_serveBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIRe_serve().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Re_serveBean> finder(LinkedHashMap<String, String> orderByMap,Re_serveBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIRe_serve().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Re_serveBean> finder(Re_serveBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getIRe_serve().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(Re_serveBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getIRe_serve().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Re_serveBean> finderEqual(Re_serveBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getIRe_serve().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Re_serveBean> finderEqual(LinkedHashMap<String, String> orderByMap,Re_serveBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIRe_serve().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<Re_serveBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,Re_serveBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIRe_serve().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(Re_serveBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getIRe_serve().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getIRe_serve().deleteByKey(key);
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
		try{getIRe_serve().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param re_serveBean
	 * @return
	 */
	public int updateByKey(Re_serveBean re_serveBean){
		Integer result=new Integer(1);
		try{getIRe_serve().updateByKey(re_serveBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param re_serveBean
	 * @return
	 */
	public int insert(Re_serveBean re_serveBean){
		Integer result=new Integer(1);
		try{re_serveBean.setId(Utilities.getRandomPK(true));
			getIRe_serve().insert(re_serveBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param Re_serveBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(Re_serveBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getServeid().trim().length()>0)
			s.append("serveid like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getServeid().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getName().trim().length()>0)
			s.append("name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getName().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPriceFrom()!=null)
			s.append("price>=").append(queryConditionsBean.getPriceFrom().toString()).append(" and ");
		if(queryConditionsBean.getPriceTo()!=null)
			s.append("price<=").append(queryConditionsBean.getPriceTo().toString()).append(" and ");
		if(queryConditionsBean.getVarieties().trim().length()>0)
			if(!queryConditionsBean.getVarieties().trim().equals("false"))
				s.append("varieties = '").append(queryConditionsBean.getVarieties().trim()).append("' and ");
		if(queryConditionsBean.getDescription().trim().length()>0)
			s.append("description like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getDescription().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getTop_pic1().trim().length()>0)
			s.append("top_pic1 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getTop_pic1().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPic1().trim().length()>0)
			s.append("pic1 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPic1().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPic2().trim().length()>0)
			s.append("pic2 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPic2().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPic3().trim().length()>0)
			s.append("pic3 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPic3().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPic4().trim().length()>0)
			s.append("pic4 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPic4().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getPic5().trim().length()>0)
			s.append("pic5 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getPic5().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getYubei1().trim().length()>0)
			s.append("yubei1 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei1().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getYubei2().trim().length()>0)
			s.append("yubei2 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei2().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getYubei3().trim().length()>0)
			s.append("yubei3 like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei3().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getDisplayFrom()!=null)
			s.append("display>=").append(queryConditionsBean.getDisplayFrom().toString()).append(" and ");
		if(queryConditionsBean.getDisplayTo()!=null)
			s.append("display<=").append(queryConditionsBean.getDisplayTo().toString()).append(" and ");
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
	 * @param Re_serveBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(Re_serveBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getServeid().trim().length()>0)
			s.append("serveid = '").append(Utilities.percentMarkFilter(queryConditionsBean.getServeid().trim())).append("' and ");
		if(queryConditionsBean.getName().trim().length()>0)
			s.append("name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getName().trim())).append("' and ");
		if(queryConditionsBean.getPriceFrom()!=null)
			s.append("price>=").append(queryConditionsBean.getPriceFrom().toString()).append(" and ");
		if(queryConditionsBean.getPriceTo()!=null)
			s.append("price<=").append(queryConditionsBean.getPriceTo().toString()).append(" and ");
		if(queryConditionsBean.getVarieties().trim().length()>0)
			if(!queryConditionsBean.getVarieties().trim().equals("false"))
				s.append("varieties = '").append(queryConditionsBean.getVarieties().trim()).append("' and ");
		if(queryConditionsBean.getDescription().trim().length()>0)
			s.append("description = '").append(Utilities.percentMarkFilter(queryConditionsBean.getDescription().trim())).append("' and ");
		if(queryConditionsBean.getTop_pic1().trim().length()>0)
			s.append("top_pic1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getTop_pic1().trim())).append("' and ");
		if(queryConditionsBean.getPic1().trim().length()>0)
			s.append("pic1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPic1().trim())).append("' and ");
		if(queryConditionsBean.getPic2().trim().length()>0)
			s.append("pic2 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPic2().trim())).append("' and ");
		if(queryConditionsBean.getPic3().trim().length()>0)
			s.append("pic3 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPic3().trim())).append("' and ");
		if(queryConditionsBean.getPic4().trim().length()>0)
			s.append("pic4 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPic4().trim())).append("' and ");
		if(queryConditionsBean.getPic5().trim().length()>0)
			s.append("pic5 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getPic5().trim())).append("' and ");
		if(queryConditionsBean.getYubei1().trim().length()>0)
			s.append("yubei1 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei1().trim())).append("' and ");
		if(queryConditionsBean.getYubei2().trim().length()>0)
			s.append("yubei2 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei2().trim())).append("' and ");
		if(queryConditionsBean.getYubei3().trim().length()>0)
			s.append("yubei3 = '").append(Utilities.percentMarkFilter(queryConditionsBean.getYubei3().trim())).append("' and ");
		if(queryConditionsBean.getDisplayFrom()!=null)
			s.append("display>=").append(queryConditionsBean.getDisplayFrom().toString()).append(" and ");
		if(queryConditionsBean.getDisplayTo()!=null)
			s.append("display<=").append(queryConditionsBean.getDisplayTo().toString()).append(" and ");
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