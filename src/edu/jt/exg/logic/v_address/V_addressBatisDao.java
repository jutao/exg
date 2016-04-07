package edu.jt.exg.logic.v_address;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.binding.BindingException;

import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class V_addressBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE="v_address";
	/**
	 * 主键升序
	 */
	public static String PROVINCE_CODE_ASC="province_code asc";
	/**
	 * 主键降序
	 */
	public static String PROVINCE_CODE_DESC="province_code desc";
			public static String PROVINCE_NAME_ASC="province_name asc";
		public static String PROVINCE_NAME_DESC="province_name desc";
		public static String CITY_CODE_ASC="city_code asc";
		public static String CITY_CODE_DESC="city_code desc";
		public static String CITY_NAME_ASC="city_name asc";
		public static String CITY_NAME_DESC="city_name desc";
		public static String AREA_CODE_ASC="area_code asc";
		public static String AREA_CODE_DESC="area_code desc";
		public static String AREA_NAME_ASC="area_name asc";
		public static String AREA_NAME_DESC="area_name desc";


	public V_addressBatisDao(){super();}
	
	/**
	 * 得到IV_address接口实例
	 * @return
	 */
	private  IV_address getIV_address(){return (IV_address)utility.BatisUtility.ctxProxool.getBean("v_addressMapper");}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<V_addressBean> findByAll(){return getIV_address().findByAll();}

	/**
	 * 查询所有记录分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @return
	 */
	public List<V_addressBean> findByAll(LinkedHashMap<String, String> orderByMap,String start,String range){
		StringBuffer sql=new StringBuffer("select * from ").append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();} 
        return getIV_address().finder(sql.toString());
    }
	
	/**
	 * 得到全部记录总数
	 * @return long
	 */
	public long findByAllCount(){return getIV_address().findByAllCount().longValue();}
	/**
	 * 根据province查询省份名称
	 */
	public String finderProvince_name(String province_code){return getIV_address().finderProvince_name(province_code);}
	/**
	 * 根据province查询省份名称
	 */
	public String finderCity_name(String city_code){return getIV_address().finderCity_name(city_code);}
	/**
	 * 根据province查询省份名称
	 */
	public String finderArea_name(String area_code){return getIV_address().finderArea_name(area_code);}
	
	/**
	 * 根据主键查询记录
	 * @param key 主键
	 * @return
	 */
	public V_addressBean findByKey(String key){return getIV_address().findByKey(key);}
	
	/**
	 * 根据条件查询全记录并排序分页
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_addressBean> finder(LinkedHashMap<String, String> orderByMap,String start,String range,V_addressBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIV_address().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录并排序
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_addressBean> finder(LinkedHashMap<String, String> orderByMap,V_addressBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from "); 
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIV_address().finder(sql.toString());
	}
	
	/**
	 * 根据条件查询全记录
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_addressBean> finder(V_addressBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getWhereString(queryConditionsBean,sql.toString()));
        return getIV_address().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderCount(V_addressBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getWhereString(queryConditionsBean,sql);
        return getIV_address().finderCount(sql).longValue();
	}
	
	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_addressBean> finderEqual(V_addressBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
        return getIV_address().finder(sql.toString());
	}
	
	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_addressBean> finderEqual(LinkedHashMap<String, String> orderByMap,V_addressBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
        return getIV_address().finder(sql.toString());
	}
	
	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * @param orderByMap 排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start 分页起始记录
	 * @param range 数据数量范围
	 * @param queryConditionsBean 查询条件
	 * @return
	 */
	public List<V_addressBean> finderEqual(LinkedHashMap<String, String> orderByMap,String start,String range,V_addressBean queryConditionsBean){
		StringBuffer sql=new StringBuffer("select * from ");
		sql.replace(0, sql.length(), getEqualWhereString(queryConditionsBean,sql.toString()));
		sql.replace(0, sql.length(), Utilities.getOrderByString(orderByMap,sql.toString()));
		try{sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(), Integer.parseInt(start), Integer.parseInt(range), ConstSetup.DATABASE));
		}catch (Exception e){e.printStackTrace();}
        return getIV_address().finder(sql.toString());
	}
	
	/**
	 * 查询条件记录数量
	 * @return long
	 */
	public long finderEqualCount(V_addressBean queryConditionsBean){
		String sql="select count(1) from ";
		sql=getEqualWhereString(queryConditionsBean,sql);
        return getIV_address().finderCount(sql).longValue();
	}
	
	/**
	 * 根据主键删除记录
	 * @param key 主键
	 * @return
	 */
	public int deleteByKey(String key){
		Integer result=new Integer(1);
		try{getIV_address().deleteByKey(key);
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
		try{getIV_address().deleteByKeys(keys);
		}catch(BindingException e){
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 根据主键更新记录
	 * @param v_addressBean
	 * @return
	 */
	public int updateByKey(V_addressBean v_addressBean){
		Integer result=new Integer(1);
		try{getIV_address().updateByKey(v_addressBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 插入记录
	 * @param v_addressBean
	 * @return
	 */
	public int insert(V_addressBean v_addressBean){
		Integer result=new Integer(1);
		try{v_addressBean.setProvince_code(Utilities.getRandomPK(true));
			getIV_address().insert(v_addressBean);
		}catch(Exception e){result=0;}
		return result.intValue();
	}
	
	/**
	 * 返回sql语句的where子句
	 * @param V_addressBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(V_addressBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getProvince_name().trim().length()>0)
			s.append("province_name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getProvince_name().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getCity_code().trim().length()>0)
			s.append("city_code like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getCity_code().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getCity_name().trim().length()>0)
			s.append("city_name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getCity_name().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getArea_code().trim().length()>0)
			s.append("area_code like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getArea_code().trim())).append("%' escape '/' and ");
		if(queryConditionsBean.getArea_name().trim().length()>0)
			s.append("area_name like '%").append(Utilities.percentMarkFilter(queryConditionsBean.getArea_name().trim())).append("%' escape '/' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}

	/**
	 * 返回sql语句的where子句
	 * @param V_addressBean 查询条件bean
	 * @param String sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(V_addressBean queryConditionsBean,String sql){
		StringBuffer s=new StringBuffer(sql).append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE).append(" where 1=1 and ");
				if(queryConditionsBean.getProvince_name().trim().length()>0)
			s.append("province_name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getProvince_name().trim())).append("' and ");
		if(queryConditionsBean.getCity_code().trim().length()>0)
			s.append("city_code = '").append(Utilities.percentMarkFilter(queryConditionsBean.getCity_code().trim())).append("' and ");
		if(queryConditionsBean.getCity_name().trim().length()>0)
			s.append("city_name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getCity_name().trim())).append("' and ");
		if(queryConditionsBean.getArea_code().trim().length()>0)
			s.append("area_code = '").append(Utilities.percentMarkFilter(queryConditionsBean.getArea_code().trim())).append("' and ");
		if(queryConditionsBean.getArea_name().trim().length()>0)
			s.append("area_name = '").append(Utilities.percentMarkFilter(queryConditionsBean.getArea_name().trim())).append("' and ");

		sql=s.toString().substring(0,s.toString().length()-5);
		return sql;
	}
}