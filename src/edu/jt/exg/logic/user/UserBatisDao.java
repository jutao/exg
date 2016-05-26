package edu.jt.exg.logic.user;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.binding.BindingException;
import utility.ConstSetup;
import utility.SplitPage;
import utility.Utilities;

public class UserBatisDao {
	/**
	 * 表或视图名
	 */
	public static String TABLE = "user";
	/**
	 * 主键升序
	 */
	public static String ID_ASC = "id asc";
	/**
	 * 主键降序
	 */
	public static String ID_DESC = "id desc";
	public static String LEVEL_ASC = "level asc";
	public static String LEVEL_DESC = "level desc";
	public static String USERID_ASC = "userid asc";
	public static String USERID_DESC = "userid desc";
	public static String NAME_ASC = "name asc";
	public static String NAME_DESC = "name desc";
	public static String NICKNAME_ASC = "nickname asc";
	public static String NICKNAME_DESC = "nickname desc";
	public static String ICON_ASC = "icon asc";
	public static String ICON_DESC = "icon desc";
	public static String ID_NUMBER_ASC = "id_number asc";
	public static String ID_NUMBER_DESC = "id_number desc";
	public static String EMAIL_ASC = "email asc";
	public static String EMAIL_DESC = "email desc";
	public static String GENDER_ASC = "gender asc";
	public static String GENDER_DESC = "gender desc";
	public static String ADDRESS_PROVINCE_ASC = "address_province asc";
	public static String ADDRESS_PROVINCE_DESC = "address_province desc";
	public static String ADDRESS_CITY_ASC = "address_city asc";
	public static String ADDRESS_CITY_DESC = "address_city desc";
	public static String ADDRESS_AREA_ASC = "address_area asc";
	public static String ADDRESS_AREA_DESC = "address_area desc";
	public static String ADDRESS_DETAILS_ASC = "address_details asc";
	public static String ADDRESS_DETAILS_DESC = "address_details desc";
	public static String HOMETOWN_ASC = "hometown asc";
	public static String HOMETOWN_DESC = "hometown desc";
	public static String OCCUPATION_ASC = "occupation asc";
	public static String OCCUPATION_DESC = "occupation desc";
	public static String INTEREST_ASC = "interest asc";
	public static String INTEREST_DESC = "interest desc";
	public static String BANKNAME_ASC = "bankname asc";
	public static String BANKNAME_DESC = "bankname desc";
	public static String BANK_BRANCH_ASC = "bank_branch asc";
	public static String BANK_BRANCH_DESC = "bank_branch desc";
	public static String CARD_NUMBER_ASC = "card_number asc";
	public static String CARD_NUMBER_DESC = "card_number desc";
	public static String BALANCE_ASC = "balance asc";
	public static String BALANCE_DESC = "balance desc";
	public static String POINT_ASC = "point asc";
	public static String POINT_DESC = "point desc";
	public static String RECOMMENDER_CODE_ASC = "recommender_code asc";
	public static String RECOMMENDER_CODE_DESC = "recommender_code desc";
	public static String LOGIN_PASSWORD_ASC = "login_password asc";
	public static String LOGIN_PASSWORD_DESC = "login_password desc";
	public static String GESTURE_PASSWORD_ASC = "gesture_password asc";
	public static String GESTURE_PASSWORD_DESC = "gesture_password desc";
	public static String TRADING_PASSWORD_ASC = "trading_password asc";
	public static String TRADING_PASSWORD_DESC = "trading_password desc";
	public static String CATEGORY_ASC = "category asc";
	public static String CATEGORY_DESC = "category desc";
	public static String USERTYPE_ASC = "usertype asc";
	public static String USERTYPE_DESC = "usertype desc";
	public static String QUALIFICAT_ASC = "qualificat asc";
	public static String QUALIFICAT_DESC = "qualificat desc";
	public static String YUBEI1_ASC = "yubei1 asc";
	public static String YUBEI1_DESC = "yubei1 desc";
	public static String YUBEI2_ASC = "yubei2 asc";
	public static String YUBEI2_DESC = "yubei2 desc";
	public static String YUBEI3_ASC = "yubei3 asc";
	public static String YUBEI3_DESC = "yubei3 desc";
	public static String INVALID_ASC = "invalid asc";
	public static String INVALID_DESC = "invalid desc";
	public static String REGISTER_TIME_ASC = "register_time asc";
	public static String REGISTER_TIME_DESC = "register_time desc";
	public static String UPDATE_TIME_ASC = "update_time asc";
	public static String UPDATE_TIME_DESC = "update_time desc";

	public UserBatisDao() {
		super();
	}

	/**
	 * 得到IUser接口实例
	 * 
	 * @return
	 */
	private IUser getIUser() {
		return (IUser) utility.BatisUtility.ctxProxool.getBean("userMapper");
	}

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	public List<UserBean> findByAll() {
		return getIUser().findByAll();
	}

	/**
	 * 查询所有记录分页
	 * 
	 * @param orderByMap
	 *            排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start
	 *            分页起始记录
	 * @param range
	 *            数据数量范围
	 * @return
	 */
	public List<UserBean> findByAll(LinkedHashMap<String, String> orderByMap,
			String start, String range) {
		StringBuffer sql = new StringBuffer("select * from ")
				.append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE);
		sql.replace(0, sql.length(),
				Utilities.getOrderByString(orderByMap, sql.toString()));
		try {
			sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(),
					Integer.parseInt(start), Integer.parseInt(range),
					ConstSetup.DATABASE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getIUser().finder(sql.toString());
	}

	/**
	 * 得到全部记录总数
	 * 
	 * @return long
	 */
	public long findByAllCount() {
		return getIUser().findByAllCount().longValue();
	}

	/**
	 * 根据主键查询记录
	 * 
	 * @param key
	 *            主键
	 * @return
	 */
	public UserBean findByKey(String key) {
		return getIUser().findByKey(key);
	}

	/**
	 * 根据条件查询全记录并排序分页
	 * 
	 * @param orderByMap
	 *            排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start
	 *            分页起始记录
	 * @param range
	 *            数据数量范围
	 * @param queryConditionsBean
	 *            查询条件
	 * @return
	 */
	public List<UserBean> finder(LinkedHashMap<String, String> orderByMap,
			String start, String range, UserBean queryConditionsBean) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.replace(0, sql.length(),
				getWhereString(queryConditionsBean, sql.toString()));
		sql.replace(0, sql.length(),
				Utilities.getOrderByString(orderByMap, sql.toString()));
		try {
			sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(),
					Integer.parseInt(start), Integer.parseInt(range),
					ConstSetup.DATABASE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getIUser().finder(sql.toString());
	}

	/**
	 * 根据条件查询全记录并排序
	 * 
	 * @param orderByMap
	 *            排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param queryConditionsBean
	 *            查询条件
	 * @return
	 */
	public List<UserBean> finder(LinkedHashMap<String, String> orderByMap,
			UserBean queryConditionsBean) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.replace(0, sql.length(),
				getWhereString(queryConditionsBean, sql.toString()));
		sql.replace(0, sql.length(),
				Utilities.getOrderByString(orderByMap, sql.toString()));
		return getIUser().finder(sql.toString());
	}

	/**
	 * 根据条件查询全记录
	 * 
	 * @param queryConditionsBean
	 *            查询条件
	 * @return
	 */
	public List<UserBean> finder(UserBean queryConditionsBean) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.replace(0, sql.length(),
				getWhereString(queryConditionsBean, sql.toString()));
		return getIUser().finder(sql.toString());
	}

	/**
	 * 查询条件记录数量
	 * 
	 * @return long
	 */
	public long finderCount(UserBean queryConditionsBean) {
		String sql = "select count(1) from ";
		sql = getWhereString(queryConditionsBean, sql);
		return getIUser().finderCount(sql).longValue();
	}

	/**
	 * 得到无排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * 
	 * @param queryConditionsBean
	 *            查询条件
	 * @return
	 */
	public List<UserBean> finderEqual(UserBean queryConditionsBean) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.replace(0, sql.length(),
				getEqualWhereString(queryConditionsBean, sql.toString()));
		return getIUser().finder(sql.toString());
	}

	/**
	 * 得到排序的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * 
	 * @param queryConditionsBean
	 *            查询条件
	 * @return
	 */
	public List<UserBean> finderEqual(LinkedHashMap<String, String> orderByMap,
			UserBean queryConditionsBean) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.replace(0, sql.length(),
				getEqualWhereString(queryConditionsBean, sql.toString()));
		sql.replace(0, sql.length(),
				Utilities.getOrderByString(orderByMap, sql.toString()));
		return getIUser().finder(sql.toString());
	}

	/**
	 * 得到排序和分页范围的查询记录集合,忽略主键作为查询条件,非like组合用法
	 * 
	 * @param orderByMap
	 *            排序map:new HashMap<PERSON_ID_ASC,PERSON_ID_ASC>
	 * @param start
	 *            分页起始记录
	 * @param range
	 *            数据数量范围
	 * @param queryConditionsBean
	 *            查询条件
	 * @return
	 */
	public List<UserBean> finderEqual(LinkedHashMap<String, String> orderByMap,
			String start, String range, UserBean queryConditionsBean) {
		StringBuffer sql = new StringBuffer("select * from ");
		sql.replace(0, sql.length(),
				getEqualWhereString(queryConditionsBean, sql.toString()));
		sql.replace(0, sql.length(),
				Utilities.getOrderByString(orderByMap, sql.toString()));
		try {
			sql.replace(0, sql.length(), SplitPage.getSqlPage(sql.toString(),
					Integer.parseInt(start), Integer.parseInt(range),
					ConstSetup.DATABASE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getIUser().finder(sql.toString());
	}

	/**
	 * 查询条件记录数量
	 * 
	 * @return long
	 */
	public long finderEqualCount(UserBean queryConditionsBean) {
		String sql = "select count(1) from ";
		sql = getEqualWhereString(queryConditionsBean, sql);
		return getIUser().finderCount(sql).longValue();
	}

	/**
	 * 根据主键删除记录
	 * 
	 * @param key
	 *            主键
	 * @return
	 */
	public int deleteByKey(String key) {
		Integer result = new Integer(1);
		try {
			getIUser().deleteByKey(key);
		} catch (Exception e) {
			
			result = 0;
		}
		return result.intValue();
	}

	/**
	 * 根据主键批量删除记录
	 * 
	 * @param keys
	 *            主键集合
	 * @return
	 */
	public int deleteByKeys(List<String> keys) {
		Integer result = new Integer(1);
		try {
			getIUser().deleteByKeys(keys);
		} catch (BindingException e) {
		} catch (Exception e) {
			result = 0;
		}
		return result.intValue();
	}

	/**
	 * 根据主键更新记录
	 * 
	 * @param userBean
	 * @return
	 */
	public int updateByKey(UserBean userBean) {
		Integer result = new Integer(1);
		try {
			getIUser().updateByKey(userBean);
		} catch (Exception e) {
			result = 0;
		}
		return result.intValue();
	}

	/**
	 * 插入记录
	 * 
	 * @param userBean
	 * @return
	 */
	public int insert(UserBean userBean) {
		Integer result = new Integer(1);
		try {
			userBean.setId(Utilities.getRandomPK(true));
			getIUser().insert(userBean);
		} catch (Exception e) {
			result = 0;
		}
		return result.intValue();
	}

	/**
	 * 返回sql语句的where子句
	 * 
	 * @param UserBean
	 *            查询条件bean
	 * @param String
	 *            sql sql语句
	 * @return String sql语句
	 */
	private static String getWhereString(UserBean queryConditionsBean,
			String sql) {
		StringBuffer s = new StringBuffer(sql)
				.append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE)
				.append(" where 1=1 and ");
		if (queryConditionsBean.getUserid().trim().length() > 0)
			s.append("userid like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getUserid().trim())).append("%' escape '/' and ");
		if (queryConditionsBean.getLogin_password().trim().length() > 0)
			s.append("login_password like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getLogin_password().trim()))
					.append("%' escape '/' and ");
		if (queryConditionsBean.getName().trim().length() > 0)
			s.append("name like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getName().trim())).append("%' escape '/' and ");
		if (queryConditionsBean.getAddress_province().trim().length() > 1)
			s.append("address_province like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_province().trim()))
					.append("%' escape '/' and ");
		if (queryConditionsBean.getAddress_city().trim().length() > 0)
			s.append("address_city like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_city().trim()))
					.append("%' escape '/' and ");
		if (queryConditionsBean.getAddress_area().trim().length() > 0)
			s.append("address_area like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_area().trim()))
					.append("%' escape '/' and ");
		if (queryConditionsBean.getUsertype().trim().length() > 0)
			if (!queryConditionsBean.getUsertype().trim().equals("false"))
				s.append("usertype = '")
						.append(queryConditionsBean.getUsertype().trim())
						.append("' and ");
		if (queryConditionsBean.getInvalid().trim().length() > 0)
			s.append("invalid like '%")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getInvalid().trim())).append("%' escape '/' and ");

		sql = s.toString().substring(0, s.toString().length() - 5);
		return sql;
	}

	/**
	 * 返回sql语句的where子句
	 * 
	 * @param UserBean
	 *            查询条件bean
	 * @param String
	 *            sql sql语句
	 * @return String sql语句
	 */
	private static String getEqualWhereString(UserBean queryConditionsBean,
			String sql) {
		StringBuffer s = new StringBuffer(sql)
				.append(ConstSetup.DATABASE_OWNER).append(".").append(TABLE)
				.append(" where 1=1 and ");
		if (queryConditionsBean.getLevelFrom() != null)
			s.append("level>=")
					.append(queryConditionsBean.getLevelFrom().toString())
					.append(" and ");
		if (queryConditionsBean.getLevelTo() != null)
			s.append("level<=")
					.append(queryConditionsBean.getLevelTo().toString())
					.append(" and ");
		if (queryConditionsBean.getUserid().trim().length() > 0)
			s.append("userid = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getUserid().trim())).append("' and ");
		if (queryConditionsBean.getName().trim().length() > 0)
			s.append("name = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getName().trim())).append("' and ");
		if (queryConditionsBean.getNickname().trim().length() > 0)
			s.append("nickname = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getNickname().trim())).append("' and ");
		if (queryConditionsBean.getIcon().trim().length() > 0)
			s.append("icon = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getIcon().trim())).append("' and ");
		if (queryConditionsBean.getId_number().trim().length() > 0)
			s.append("id_number = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getId_number().trim())).append("' and ");
		if (queryConditionsBean.getEmail().trim().length() > 0)
			s.append("email = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getEmail().trim())).append("' and ");
		if (queryConditionsBean.getGender().trim().length() > 0)
			s.append("gender = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getGender().trim())).append("' and ");
		if (queryConditionsBean.getAddress_province().trim().length() > 0)
			s.append("address_province = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_province().trim())).append("' and ");
		if (queryConditionsBean.getAddress_city().trim().length() > 0)
			s.append("address_city = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_city().trim())).append("' and ");
		if (queryConditionsBean.getAddress_area().trim().length() > 0)
			s.append("address_area = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_area().trim())).append("' and ");
		if (queryConditionsBean.getAddress_details().trim().length() > 0)
			s.append("address_details = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getAddress_details().trim())).append("' and ");
		if (queryConditionsBean.getHometown().trim().length() > 0)
			s.append("hometown = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getHometown().trim())).append("' and ");
		if (queryConditionsBean.getOccupation().trim().length() > 0)
			s.append("occupation = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getOccupation().trim())).append("' and ");
		if (queryConditionsBean.getInterest().trim().length() > 0)
			s.append("interest = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getInterest().trim())).append("' and ");
		if (queryConditionsBean.getBankname().trim().length() > 0)
			s.append("bankname = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getBankname().trim())).append("' and ");
		if (queryConditionsBean.getBank_branch().trim().length() > 0)
			s.append("bank_branch = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getBank_branch().trim())).append("' and ");
		if (queryConditionsBean.getCard_number().trim().length() > 0)
			s.append("card_number = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getCard_number().trim())).append("' and ");
		if (queryConditionsBean.getBalanceFrom() != null)
			s.append("balance>=")
					.append(queryConditionsBean.getBalanceFrom().toString())
					.append(" and ");
		if (queryConditionsBean.getBalanceTo() != null)
			s.append("balance<=")
					.append(queryConditionsBean.getBalanceTo().toString())
					.append(" and ");
		if (queryConditionsBean.getPointFrom() != null)
			s.append("point>=")
					.append(queryConditionsBean.getPointFrom().toString())
					.append(" and ");
		if (queryConditionsBean.getPointTo() != null)
			s.append("point<=")
					.append(queryConditionsBean.getPointTo().toString())
					.append(" and ");
		if (queryConditionsBean.getRecommender_code().trim().length() > 0)
			s.append("recommender_code = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getRecommender_code().trim())).append("' and ");
		if (queryConditionsBean.getLogin_password().trim().length() > 0)
			s.append("login_password = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getLogin_password().trim())).append("' and ");
		if (queryConditionsBean.getGesture_password().trim().length() > 0)
			s.append("gesture_password = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getGesture_password().trim())).append("' and ");
		if (queryConditionsBean.getTrading_password().trim().length() > 0)
			s.append("trading_password = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getTrading_password().trim())).append("' and ");
		if (queryConditionsBean.getCategory().trim().length() > 0)
			s.append("category = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getCategory().trim())).append("' and ");
		if (queryConditionsBean.getUsertype().trim().length() > 0)
			if (!queryConditionsBean.getUsertype().trim().equals("false"))
				s.append("usertype = '")
						.append(queryConditionsBean.getUsertype().trim())
						.append("' and ");
		if (queryConditionsBean.getQualificat().trim().length() > 0)
			s.append("qualificat = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getQualificat().trim())).append("' and ");
		if (queryConditionsBean.getYubei1().trim().length() > 0)
			s.append("yubei1 = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getYubei1().trim())).append("' and ");
		if (queryConditionsBean.getYubei2().trim().length() > 0)
			s.append("yubei2 = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getYubei2().trim())).append("' and ");
		if (queryConditionsBean.getYubei3().trim().length() > 0)
			s.append("yubei3 = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getYubei3().trim())).append("' and ");
		if (queryConditionsBean.getInvalid().trim().length() > 0)
			s.append("invalid = '")
					.append(Utilities.percentMarkFilter(queryConditionsBean
							.getInvalid().trim())).append("' and ");
		if (queryConditionsBean.getRegister_timeFrom() != null) {
			if (ConstSetup.DATABASE.toUpperCase().equals("ORACLE"))
				s.append("to_char(register_time,'yyyy-MM-dd hh:mm:ss')>='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("DB2"))
				s.append("char(register_time)>='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER"))
				s.append("CONVERT(varchar(20),register_time,120)>='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("MYSQL")
					|| ConstSetup.DATABASE.toUpperCase().equals("SYBASE"))
				s.append("register_time>='");
			s.append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getRegister_timeFrom()))
					.append("' and ");
		}
		if (queryConditionsBean.getRegister_timeTo() != null) {
			if (ConstSetup.DATABASE.toUpperCase().equals("ORACLE"))
				s.append("to_char(register_time,'yyyy-MM-dd hh:mm:ss')<='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("DB2"))
				s.append("char(register_time)<='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER"))
				s.append("CONVERT(varchar(20),register_time,120)<='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("MYSQL")
					|| ConstSetup.DATABASE.toUpperCase().equals("SYBASE"))
				s.append("register_time<='");
			s.append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getRegister_timeTo())).append(
					"' and ");
		}
		if (queryConditionsBean.getUpdate_timeFrom() != null) {
			if (ConstSetup.DATABASE.toUpperCase().equals("ORACLE"))
				s.append("to_char(update_time,'yyyy-MM-dd hh:mm:ss')>='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("DB2"))
				s.append("char(update_time)>='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER"))
				s.append("CONVERT(varchar(20),update_time,120)>='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("MYSQL")
					|| ConstSetup.DATABASE.toUpperCase().equals("SYBASE"))
				s.append("update_time>='");
			s.append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getUpdate_timeFrom())).append(
					"' and ");
		}
		if (queryConditionsBean.getUpdate_timeTo() != null) {
			if (ConstSetup.DATABASE.toUpperCase().equals("ORACLE"))
				s.append("to_char(update_time,'yyyy-MM-dd hh:mm:ss')<='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("DB2"))
				s.append("char(update_time)<='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("SQLSERVER"))
				s.append("CONVERT(varchar(20),update_time,120)<='");
			else if (ConstSetup.DATABASE.toUpperCase().equals("MYSQL")
					|| ConstSetup.DATABASE.toUpperCase().equals("SYBASE"))
				s.append("update_time<='");
			s.append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getUpdate_timeTo())).append(
					"' and ");
		}

		sql = s.toString().substring(0, s.toString().length() - 5);
		return sql;
	}
}