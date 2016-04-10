package edu.jt.exg.logic.user;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import utility.CommonMethod;
import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.action.UserAction;
import edu.jt.exg.logic.v_address.V_addressBatisDao;

public class PageStatus implements Serializable {

	private static final long serialVersionUID = 19761210;
	private Calendar cale = Calendar.getInstance();

	public PageStatus() {
		super();
	}

	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * 
	 * @param UserAction
	 *            action句柄
	 * @param params
	 *            设置参数
	 */
	public void setRecordsRangeAndOrderByRules(UserAction userAction,
			String params) {
		// 获取记录范围*************************************************
		String[] array = params.split("&");
		String tmp = "";
		int pos = 0;
		for (int i = 0; i < array.length; i++) {
			tmp = array[i];
			if (array[i].indexOf("start=") != -1) {
				pos = tmp.indexOf("start=");
				userAction.start = tmp.substring(pos + 6, tmp.length());
			} else if (array[i].indexOf("range=") != -1) {
				pos = tmp.indexOf("range=");
				userAction.range = tmp.substring(pos + 6, tmp.length());
			} else if (array[i].indexOf("action=") != -1) {
				pos = tmp.indexOf("action=");
				userAction.action = tmp.substring(pos + 7, tmp.length());
			}
		}
		if (userAction.start == null)
			userAction.start = "0";
		else if (userAction.start.length() == 0)
			userAction.start = "0";
		if (userAction.range == null)
			userAction.range = ConstSetup.REFERENCE_RANGE;
		else if (userAction.range.length() == 0)
			userAction.range = ConstSetup.REFERENCE_RANGE;
		setOrderByMap(userAction);
	}

	/**
	 * 设置查询页面返回记录的范围和排序规则
	 * 
	 * @param UserAction
	 *            action句柄
	 */
	public void setRecordsRangeAndOrderByRules(UserAction userAction) {
		// 获取记录范围*************************************************
		userAction.action = userAction.request.getParameter("action");
		if (userAction.start == null)
			userAction.start = "0";
		else if (userAction.start.length() == 0)
			userAction.start = "0";
		if (userAction.range == null)
			userAction.range = ConstSetup.REFERENCE_RANGE;
		else if (userAction.range.length() == 0)
			userAction.range = ConstSetup.REFERENCE_RANGE;
		setOrderByMap(userAction);
	}

	/**
	 * 设置排序
	 * 
	 * @param UserAction
	 *            action句柄
	 */
	private void setOrderByMap(UserAction userAction) {
		userAction.orderByMap = Utilities.csi.getLinkedHashMap_String_String();
		// orderByMap.put(UserSqlStorehouse.UPDATEDATE_DESC,null);
	}

	/**
	 * 控件初始化
	 * 
	 * @param UserAction
	 *            action句柄
	 */
	public void setControlsValues(UserAction userAction) {
		InitPageControl.initGenderMap(userAction);
		InitPageControl.initAddress_provinceMap(userAction);
		InitPageControl.initAddress_cityMap(userAction);
		InitPageControl.initAddress_areaMap(userAction);
		InitPageControl.initBanknameMap(userAction);
		InitPageControl.initCategoryMap(userAction);
		InitPageControl.initInvalidMap(userAction);
		InitPageControl.initTimestamp(userAction);
		InitPageControl.initUsertypeMap(userAction);

	}

	/**
	 * 从翻页的参数中得到查询查询条件
	 * 
	 * @param UserAction
	 *            action句柄
	 * @param params
	 *            设置参数
	 */
	public UserBean getQueryConditionsFromParams(UserAction userAction,
			String params) {
		UserBean userBean = UserUtility.getIocHandel().getBean("UserBean",
				UserBean.class);
		String[] array = params.split("&");
		String tmp = "";
		int pos = 0;
		for (int i = 0; i < array.length; i++) {
			tmp = array[i];
			if (tmp.equals("start=") || tmp.equals("range=")
					|| tmp.equals("action="))
				continue;
			if (array[i].indexOf("levelFrom=") == 0) {
				pos = tmp.indexOf("levelFrom=");
				userBean.setLevelFrom(Integer.valueOf(tmp.substring(pos + 10,
						tmp.length())));
			} else if (array[i].indexOf("levelTo=") != -1) {
				pos = tmp.indexOf("levelTo=");
				userBean.setLevelTo(Integer.valueOf(tmp.substring(pos + 8,
						tmp.length())));
			}
			if (array[i].indexOf("userid=") == 0) {
				pos = tmp.indexOf("userid=");
				userBean.setUserid(tmp.substring(pos + 7, tmp.length()));
			}
			if (array[i].indexOf("name=") == 0) {
				pos = tmp.indexOf("name=");
				userBean.setName(tmp.substring(pos + 5, tmp.length()));
			}
			if (array[i].indexOf("nickname=") == 0) {
				pos = tmp.indexOf("nickname=");
				userBean.setNickname(tmp.substring(pos + 9, tmp.length()));
			}
			if (array[i].indexOf("icon=") == 0) {
				pos = tmp.indexOf("icon=");
				userBean.setIcon(tmp.substring(pos + 5, tmp.length()));
			}
			if (array[i].indexOf("id_number=") == 0) {
				pos = tmp.indexOf("id_number=");
				userBean.setId_number(tmp.substring(pos + 10, tmp.length()));
			}
			if (array[i].indexOf("email=") == 0) {
				pos = tmp.indexOf("email=");
				userBean.setEmail(tmp.substring(pos + 6, tmp.length()));
			}
			if (array[i].indexOf("gender=") == 0) {
				pos = tmp.indexOf("gender=");
				userBean.setGender(tmp.substring(pos + 7, tmp.length()));
			}
			if (array[i].indexOf("address_province=") == 0) {
				pos = tmp.indexOf("address_province=");
				userBean.setAddress_province(tmp.substring(pos + 17,
						tmp.length()));
			}
			if (array[i].indexOf("address_city=") == 0) {
				pos = tmp.indexOf("address_city=");
				userBean.setAddress_city(tmp.substring(pos + 13, tmp.length()));
			}
			if (array[i].indexOf("address_area=") == 0) {
				pos = tmp.indexOf("address_area=");
				userBean.setAddress_area(tmp.substring(pos + 13, tmp.length()));
			}
			if (array[i].indexOf("address_details=") == 0) {
				pos = tmp.indexOf("address_details=");
				userBean.setAddress_details(tmp.substring(pos + 16,
						tmp.length()));
			}
			if (array[i].indexOf("hometown=") == 0) {
				pos = tmp.indexOf("hometown=");
				userBean.setHometown(tmp.substring(pos + 9, tmp.length()));
			}
			if (array[i].indexOf("occupation=") == 0) {
				pos = tmp.indexOf("occupation=");
				userBean.setOccupation(tmp.substring(pos + 11, tmp.length()));
			}
			if (array[i].indexOf("interest=") == 0) {
				pos = tmp.indexOf("interest=");
				userBean.setInterest(tmp.substring(pos + 9, tmp.length()));
			}
			if (array[i].indexOf("bankname=") == 0) {
				pos = tmp.indexOf("bankname=");
				userBean.setBankname(tmp.substring(pos + 9, tmp.length()));
			}
			if (array[i].indexOf("bank_branch=") == 0) {
				pos = tmp.indexOf("bank_branch=");
				userBean.setBank_branch(tmp.substring(pos + 12, tmp.length()));
			}
			if (array[i].indexOf("card_number=") == 0) {
				pos = tmp.indexOf("card_number=");
				userBean.setCard_number(tmp.substring(pos + 12, tmp.length()));
			}
			if (array[i].indexOf("balanceFrom=") == 0) {
				pos = tmp.indexOf("balanceFrom=");
				userBean.setBalanceFrom(Double.valueOf(tmp.substring(pos + 12,
						tmp.length())));
			} else if (array[i].indexOf("balanceTo=") == 0) {
				pos = tmp.indexOf("balanceTo=");
				userBean.setBalanceTo(Double.valueOf(tmp.substring(pos + 10,
						tmp.length())));
			}
			if (array[i].indexOf("pointFrom=") == 0) {
				pos = tmp.indexOf("pointFrom=");
				userBean.setPointFrom(Integer.valueOf(tmp.substring(pos + 10,
						tmp.length())));
			} else if (array[i].indexOf("pointTo=") != -1) {
				pos = tmp.indexOf("pointTo=");
				userBean.setPointTo(Integer.valueOf(tmp.substring(pos + 8,
						tmp.length())));
			}
			if (array[i].indexOf("recommender_code=") == 0) {
				pos = tmp.indexOf("recommender_code=");
				userBean.setRecommender_code(tmp.substring(pos + 17,
						tmp.length()));
			}
			if (array[i].indexOf("login_password=") == 0) {
				pos = tmp.indexOf("login_password=");
				userBean.setLogin_password(tmp.substring(pos + 15, tmp.length()));
			}
			if (array[i].indexOf("gesture_password=") == 0) {
				pos = tmp.indexOf("gesture_password=");
				userBean.setGesture_password(tmp.substring(pos + 17,
						tmp.length()));
			}
			if (array[i].indexOf("trading_password=") == 0) {
				pos = tmp.indexOf("trading_password=");
				userBean.setTrading_password(tmp.substring(pos + 17,
						tmp.length()));
			}
			if (array[i].indexOf("category=") == 0) {
				pos = tmp.indexOf("category=");
				userBean.setCategory(tmp.substring(pos + 9, tmp.length()));
			}
			if (array[i].indexOf("usertype=") == 0) {
				pos = tmp.indexOf("usertype=");
				userBean.setUsertype(tmp.substring(pos + 9, tmp.length()));
			}
			if (array[i].indexOf("qualificat=") == 0) {
				pos = tmp.indexOf("qualificat=");
				userBean.setQualificat(tmp.substring(pos + 11, tmp.length()));
			}
			if (array[i].indexOf("yubei1=") == 0) {
				pos = tmp.indexOf("yubei1=");
				userBean.setYubei1(tmp.substring(pos + 7, tmp.length()));
			}
			if (array[i].indexOf("yubei2=") == 0) {
				pos = tmp.indexOf("yubei2=");
				userBean.setYubei2(tmp.substring(pos + 7, tmp.length()));
			}
			if (array[i].indexOf("yubei3=") == 0) {
				pos = tmp.indexOf("yubei3=");
				userBean.setYubei3(tmp.substring(pos + 7, tmp.length()));
			}
			if (array[i].indexOf("invalid=") == 0) {
				pos = tmp.indexOf("invalid=");
				userBean.setInvalid(tmp.substring(pos + 8, tmp.length()));
			}
			if (array[i].indexOf("register_timeFrom=") == 0) {
				pos = tmp.indexOf("register_timeFrom=");
				tmp = tmp.substring(pos + 18, tmp.length());
				userBean.setRegister_timeFrom(Utilities.transferStr2Timestamp(
						tmp, "yyyy-MM-dd hh:mm:ss"));
			} else if (array[i].indexOf("register_timeTo=") == 0) {
				pos = tmp.indexOf("register_timeTo=");
				tmp = tmp.substring(pos + 16, tmp.length());
				userBean.setRegister_timeTo(Utilities.transferStr2Timestamp(
						tmp, "yyyy-MM-dd hh:mm:ss"));
			}
			if (array[i].indexOf("update_timeFrom=") == 0) {
				pos = tmp.indexOf("update_timeFrom=");
				tmp = tmp.substring(pos + 16, tmp.length());
				userBean.setUpdate_timeFrom(Utilities.transferStr2Timestamp(
						tmp, "yyyy-MM-dd hh:mm:ss"));
			} else if (array[i].indexOf("update_timeTo=") == 0) {
				pos = tmp.indexOf("update_timeTo=");
				tmp = tmp.substring(pos + 14, tmp.length());
				userBean.setUpdate_timeTo(Utilities.transferStr2Timestamp(tmp,
						"yyyy-MM-dd hh:mm:ss"));
			}

		}
		return userBean;
	}

	/**
	 * 得到form的查询条件
	 * 
	 * @param UserAction
	 *            action句柄
	 */
	public UserBean getQueryConditionsFromForm(UserAction userAction) {
		UserBean userBean = UserUtility.getIocHandel().getBean("UserBean",
				UserBean.class);
		userBean = setUserBeanCommonAttributes(userBean, userAction);
		userBean.setLevelFrom(userAction.levelFrom);
		userBean.setLevelTo(userAction.levelTo);
		userBean.setBalanceFrom(userAction.balanceFrom);
		userBean.setBalanceTo(userAction.balanceTo);
		userBean.setPointFrom(userAction.pointFrom);
		userBean.setPointTo(userAction.pointTo);
		userAction.register_timeFrom = Utilities.setTimeStampFunction(
				userAction.register_timeDateFrom,
				userAction.register_timeHourFrom,
				userAction.register_timeMinuteFrom);
		userBean.setRegister_timeFrom(userAction.register_timeFrom);
		userAction.register_timeTo = Utilities.setTimeStampFunction(
				userAction.register_timeDateTo, userAction.register_timeHourTo,
				userAction.register_timeMinuteTo);
		userBean.setRegister_timeTo(userAction.register_timeTo);
		userAction.update_timeFrom = Utilities.setTimeStampFunction(
				userAction.update_timeDateFrom, userAction.update_timeHourFrom,
				userAction.update_timeMinuteFrom);
		userBean.setUpdate_timeFrom(userAction.update_timeFrom);
		userAction.update_timeTo = Utilities.setTimeStampFunction(
				userAction.update_timeDateTo, userAction.update_timeHourTo,
				userAction.update_timeMinuteTo);
		userBean.setUpdate_timeTo(userAction.update_timeTo);

		return userBean;
	}

	/**
	 * 读取控件值写入数据库
	 * 
	 * @param UserAction
	 *            action句柄
	 */
	public String readControlsWrite2Datas(UserAction userAction) {
		String errorMsg = "";
		UserBean userBean = UserUtility.getIocHandel().getBean("UserBean",
				UserBean.class);
		if (userAction.action.equals("create"))
			userBean.setId(Utilities.getRandomPK(true));
		else
			userBean.setId(userAction.id);
		userBean = setUserBeanCommonAttributes(userBean, userAction);
		userBean.setLevel(userAction.level);
		userBean.setBalance(userAction.balance);
		userBean.setPoint(userAction.point);
		userBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
		userBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());

		userAction.batisDao = UserUtility.getIocHandel().getBean(
				"UserBatisDao", UserBatisDao.class);
		if (userAction.action.equals("create"))
			errorMsg = Integer.toString(userAction.batisDao.insert(userBean));
		else
			errorMsg = Integer.toString(userAction.batisDao
					.updateByKey(userBean));

		return errorMsg;
	}

	/**
	 * 读取值写入控件
	 * 
	 * @param UserAction
	 *            action句柄
	 */
	public void readDatasWrite2Controls(UserAction userAction) {

		userAction.batisDao = UserUtility.getIocHandel().getBean(
				"UserBatisDao", UserBatisDao.class);
		UserBean userBean = userAction.batisDao.findByKey(userAction.id);

		write2ControlsCommon(userAction, userBean);
		if (userBean.getLevel() != null)
			if (userBean.getLevel().intValue() >= 0)
				userAction.setLevel(userBean.getLevel());
		if (userBean.getBalance() != null)
			if (userBean.getBalance().doubleValue() != 0)
				userAction.setBalance(userBean.getBalance());
		if (userBean.getPoint() != null)
			if (userBean.getPoint().intValue() >= 0)
				userAction.setPoint(userBean.getPoint());
		if (userAction.action.equals("initupdate")) {
			userAction.setAdressJson(CommonMethod.getadressJson());
			userAction.setAddress_city(userBean.getAddress_city());
			userAction.setAddress_area(userBean.getAddress_area());
			userAction.setAddress_province(userBean.getAddress_province());
		}
		// auto timestamp
		if (userAction.action.equals("detail"))
			userAction.setRegister_time(userBean.getRegister_time());// auto
																		// timestamp只作detail显示
		// auto timestamp
		if (userAction.action.equals("detail"))
			userAction.setUpdate_time(userBean.getUpdate_time());// auto
																	// timestamp只作detail显示

	}

	/**
	 * 保存查询条件写入跳转页面查询条件的控件
	 * 
	 * @param UserAction
	 *            action句柄
	 * @param UserBean
	 *            action句柄
	 */
	public void readConditionsWrite2Controls(UserAction userAction,
			UserBean userBean) {
		write2ControlsCommon(userAction, userBean);
		if (userBean.getLevelFrom() != null)
			if (userBean.getLevelFrom().intValue() >= 0)
				userAction.setLevelFrom(userBean.getLevelFrom());
		if (userBean.getLevelTo() != null)
			if (userBean.getLevelTo().intValue() >= 0)
				userAction.setLevelTo(userBean.getLevelTo());
		if (userBean.getBalanceFrom() != null)
			if (userBean.getBalanceFrom().doubleValue() != 0)
				userAction.setBalanceFrom(userBean.getBalanceFrom());
		if (userBean.getBalanceTo() != null)
			if (userBean.getBalanceTo().doubleValue() != 0)
				userAction.setBalanceTo(userBean.getBalanceTo());
		if (userBean.getPointFrom() != null)
			if (userBean.getPointFrom().intValue() >= 0)
				userAction.setPointFrom(userBean.getPointFrom());
		if (userBean.getPointTo() != null)
			if (userBean.getPointTo().intValue() >= 0)
				userAction.setPointTo(userBean.getPointTo());
		if (userBean.getRegister_timeFrom() != null) {
			userAction.setRegister_timeFrom(userBean.getRegister_timeFrom());
			userAction.setRegister_timeDateFrom(Utilities.csi
					.getSqlDate(userBean.getRegister_timeFrom()));
			cale.setTimeInMillis(userBean.getRegister_timeFrom().getTime());
			if (cale.get(Calendar.HOUR) < 10)
				userAction.setRegister_timeHourFrom("0"
						+ Integer.toString(cale.get(Calendar.HOUR)));
			else
				userAction.setRegister_timeHourFrom(Integer.toString(cale
						.get(Calendar.HOUR)));
			userAction
					.setRegister_timeHourSelectFrom(userAction.register_timeHourFrom);
			if (cale.get(Calendar.MINUTE) < 10)
				userAction.setRegister_timeMinuteFrom("0"
						+ Integer.toString(cale.get(Calendar.MINUTE)));
			else
				userAction.setRegister_timeMinuteFrom(Integer.toString(cale
						.get(Calendar.MINUTE)));
			userAction
					.setRegister_timeMinuteSelectFrom(userAction.register_timeMinuteFrom);
		}
		if (userBean.getRegister_timeTo() != null) {
			userAction.setRegister_timeTo(userBean.getRegister_timeTo());
			userAction.setRegister_timeDateTo(Utilities.csi.getSqlDate(userBean
					.getRegister_timeTo()));
			cale.setTimeInMillis(userBean.getRegister_timeFrom().getTime());
			if (cale.get(Calendar.HOUR) < 10)
				userAction.setRegister_timeHourTo("0"
						+ Integer.toString(cale.get(Calendar.HOUR)));
			else
				userAction.setRegister_timeHourTo(Integer.toString(cale
						.get(Calendar.HOUR)));
			userAction
					.setRegister_timeHourSelectTo(userAction.register_timeHourTo);
			if (cale.get(Calendar.MINUTE) < 10)
				userAction.setRegister_timeMinuteTo("0"
						+ Integer.toString(cale.get(Calendar.MINUTE)));
			else
				userAction.setRegister_timeMinuteTo(Integer.toString(cale
						.get(Calendar.MINUTE)));
			userAction
					.setRegister_timeMinuteSelectTo(userAction.register_timeMinuteTo);
		}
		if (userBean.getUpdate_timeFrom() != null) {
			userAction.setUpdate_timeFrom(userBean.getUpdate_timeFrom());
			userAction.setUpdate_timeDateFrom(Utilities.csi.getSqlDate(userBean
					.getUpdate_timeFrom()));
			cale.setTimeInMillis(userBean.getUpdate_timeFrom().getTime());
			if (cale.get(Calendar.HOUR) < 10)
				userAction.setUpdate_timeHourFrom("0"
						+ Integer.toString(cale.get(Calendar.HOUR)));
			else
				userAction.setUpdate_timeHourFrom(Integer.toString(cale
						.get(Calendar.HOUR)));
			userAction
					.setUpdate_timeHourSelectFrom(userAction.update_timeHourFrom);
			if (cale.get(Calendar.MINUTE) < 10)
				userAction.setUpdate_timeMinuteFrom("0"
						+ Integer.toString(cale.get(Calendar.MINUTE)));
			else
				userAction.setUpdate_timeMinuteFrom(Integer.toString(cale
						.get(Calendar.MINUTE)));
			userAction
					.setUpdate_timeMinuteSelectFrom(userAction.update_timeMinuteFrom);
		}
		if (userBean.getUpdate_timeTo() != null) {
			userAction.setUpdate_timeTo(userBean.getUpdate_timeTo());
			userAction.setUpdate_timeDateTo(Utilities.csi.getSqlDate(userBean
					.getUpdate_timeTo()));
			cale.setTimeInMillis(userBean.getUpdate_timeFrom().getTime());
			if (cale.get(Calendar.HOUR) < 10)
				userAction.setUpdate_timeHourTo("0"
						+ Integer.toString(cale.get(Calendar.HOUR)));
			else
				userAction.setUpdate_timeHourTo(Integer.toString(cale
						.get(Calendar.HOUR)));
			userAction.setUpdate_timeHourSelectTo(userAction.update_timeHourTo);
			if (cale.get(Calendar.MINUTE) < 10)
				userAction.setUpdate_timeMinuteTo("0"
						+ Integer.toString(cale.get(Calendar.MINUTE)));
			else
				userAction.setUpdate_timeMinuteTo(Integer.toString(cale
						.get(Calendar.MINUTE)));
			userAction
					.setUpdate_timeMinuteSelectTo(userAction.update_timeMinuteTo);
		}

	}

	/**
	 * 单条记录list页面显示或导出出列使用
	 * 
	 * @param UserAction
	 *            action句柄
	 * @param UserBean
	 *            action句柄
	 * @param type
	 *            控件类型
	 */
	public UserBean wrapperUserBean(UserAction userAction, UserBean userBean,
			String type) {
		// 上传照片显示***********************************************************************
		if (type.equals("show"))
			userBean.setIcon(Utilities.getWrapperUploadFileLinkString(
					userAction.request, userBean.getIcon(), "image"));
		else
			userBean.setIcon(userBean.getIcon());
		// s:select***************************************************************************
		InitPageControl.initGenderMap(userAction);
		userBean.setGender(Utilities.getWrapperSelect(userBean.getGender(),
				userAction.genderMap));
		// s:select***************************************************************************
		V_addressBatisDao dao = new V_addressBatisDao();
		userBean.setAddress_province(dao.finderProvince_name(userBean
				.getAddress_province()));
		// s:select***************************************************************************
		userBean.setAddress_city(dao.finderCity_name(userBean.getAddress_city()));
		// s:select***************************************************************************
		userBean.setAddress_area(dao.finderArea_name(userBean.getAddress_area()));
		// s:select***************************************************************************
		InitPageControl.initBanknameMap(userAction);
		userBean.setBankname(Utilities.getWrapperSelect(userBean.getBankname(),
				userAction.banknameMap));
		// s:select***************************************************************************
		InitPageControl.initCategoryMap(userAction);
		userBean.setCategory(Utilities.getWrapperSelect(userBean.getCategory(),
				userAction.categoryMap));
		// s:checkbox************************************************************************
		userBean.setUsertype(Utilities.getWrapperCheckbox(
				userBean.getUsertype(), "Y", "N"));
		// 上传照片显示***********************************************************************
		if (type.equals("show"))
			userBean.setQualificat(Utilities.getWrapperUploadFileLinkString(
					userAction.request, userBean.getQualificat(), "image"));
		else
			userBean.setQualificat(userBean.getQualificat());
		// s:select***************************************************************************
		InitPageControl.initInvalidMap(userAction);
		userBean.setInvalid(Utilities.getWrapperSelect(userBean.getInvalid(),
				userAction.invalidMap));

		// s:checkboxlist********************************************************************
		InitPageControl.initUsertypeMap(userAction);
		if (type.equals("show"))
			userBean.setUsertype(Utilities.getWrapperCheckboxlist(
					userBean.getUsertype(), ",", userAction.usertypeMap, "<br>"));
		else
			userBean.setUsertype(Utilities.getWrapperCheckboxlist(
					userBean.getUsertype(), ",", userAction.usertypeMap, "|"));
		return userBean;
	}

	/**
	 * 记录显示包装
	 * 
	 * @param UserAction
	 *            action句柄
	 * @param type
	 *            控件类型
	 */
	public List<UserBean> wrapperRecorders(UserAction userAction, String type) {
		UserBean user = null;
		List<UserBean> newUserList = UserUtility.getIocHandel().getBean(
				"List_UserBean", java.util.ArrayList.class);
		for (int i = 0; i < userAction.userList.size(); i++) {
			user = userAction.userList.get(i);
			user = wrapperUserBean(userAction, user, type);
			newUserList.add(user);
		}
		return newUserList;
	}

	/**
	 * 写入通用控件方法，firstDoubleSelectValue=一级菜单的值,必须推算出一级下拉的选项
	 * 
	 * @param UserAction
	 *            action句柄
	 * @param UserBean
	 *            action句柄
	 */
	private void write2ControlsCommon(UserAction userAction, UserBean userBean) {
		userAction.setId(userBean.getId());
		// textfield
		if (userBean.getUserid() != null)
			if (userBean.getUserid().trim().length() > 0)
				userAction.setUserid(userBean.getUserid());
		// textfield
		if (userBean.getName() != null)
			if (userBean.getName().trim().length() > 0)
				userAction.setName(userBean.getName());
		// textfield
		if (userBean.getNickname() != null)
			if (userBean.getNickname().trim().length() > 0)
				userAction.setNickname(userBean.getNickname());
		// img upload
		if (userBean.getIcon() != null) {
			if (userBean.getIcon().trim().length() > 0)
				userAction.setIcon(userBean.getIcon());
			else
				userAction.setIcon("");
		} else
			userAction.setIcon("");
		// textfield
		if (userBean.getId_number() != null)
			if (userBean.getId_number().trim().length() > 0)
				userAction.setId_number(userBean.getId_number());
		// textfield
		if (userBean.getEmail() != null)
			if (userBean.getEmail().trim().length() > 0)
				userAction.setEmail(userBean.getEmail());
		// select
		if (userBean.getGender() != null) {
			if (userBean.getGender().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setGender(userBean.getGender());
					userAction.setGenderSelect(userBean.getGender());
				} else
					userAction.setGender(Utilities.getWrapperSelect(
							userBean.getGender(), userAction.genderMap));
			}
		}
		// select

		if (userBean.getAddress_province() != null) {
			if (userBean.getAddress_province().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setAddress_province(userBean
							.getAddress_province());
					userAction.setAddress_provinceSelect(userBean
							.getAddress_province());
				} else {
					V_addressBatisDao dao = new V_addressBatisDao();
					userAction
							.setAddress_province(dao
									.finderProvince_name(userBean
											.getAddress_province()));
				}
			}

		}
		// select
		if (userBean.getAddress_city() != null) {
			if (userBean.getAddress_city().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setAddress_city(userBean.getAddress_city());
					userAction
							.setAddress_citySelect(userBean.getAddress_city());
				} else {
					V_addressBatisDao dao = new V_addressBatisDao();
					userAction.setAddress_city(dao.finderCity_name(userBean
							.getAddress_city()));
				}

			}
		}
		// select
		if (userBean.getAddress_area() != null) {
			if (userBean.getAddress_area().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setAddress_area(userBean.getAddress_area());
					userAction
							.setAddress_areaSelect(userBean.getAddress_area());
				} else {
					V_addressBatisDao dao = new V_addressBatisDao();
					userAction.setAddress_area(dao.finderArea_name(userBean
							.getAddress_area()));
				}
			}
		}
		// textfield
		if (userBean.getAddress_details() != null)
			if (userBean.getAddress_details().trim().length() > 0)
				userAction.setAddress_details(userBean.getAddress_details());
		// textfield
		if (userBean.getHometown() != null)
			if (userBean.getHometown().trim().length() > 0)
				userAction.setHometown(userBean.getHometown());
		// textfield
		if (userBean.getOccupation() != null)
			if (userBean.getOccupation().trim().length() > 0)
				userAction.setOccupation(userBean.getOccupation());
		// textfield
		if (userBean.getInterest() != null)
			if (userBean.getInterest().trim().length() > 0)
				userAction.setInterest(userBean.getInterest());
		// select
		if (userBean.getBankname() != null) {
			if (userBean.getBankname().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setBankname(userBean.getBankname());
					userAction.setBanknameSelect(userBean.getBankname());
				} else
					userAction.setBankname(Utilities.getWrapperSelect(
							userBean.getBankname(), userAction.banknameMap));
			}
		}
		// textfield
		if (userBean.getBank_branch() != null)
			if (userBean.getBank_branch().trim().length() > 0)
				userAction.setBank_branch(userBean.getBank_branch());
		// textfield
		if (userBean.getCard_number() != null)
			if (userBean.getCard_number().trim().length() > 0)
				userAction.setCard_number(userBean.getCard_number());
		// textfield
		if (userBean.getRecommender_code() != null)
			if (userBean.getRecommender_code().trim().length() > 0)
				userAction.setRecommender_code(userBean.getRecommender_code());
		// textfield
		if (userBean.getLogin_password() != null)
			if (userBean.getLogin_password().trim().length() > 0)
				userAction.setLogin_password(userBean.getLogin_password());
		// textfield
		if (userBean.getGesture_password() != null)
			if (userBean.getGesture_password().trim().length() > 0)
				userAction.setGesture_password(userBean.getGesture_password());
		// textfield
		if (userBean.getTrading_password() != null)
			if (userBean.getTrading_password().trim().length() > 0)
				userAction.setTrading_password(userBean.getTrading_password());
		// select
		if (userBean.getCategory() != null) {
			if (userBean.getCategory().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setCategory(userBean.getCategory());
					userAction.setCategorySelect(userBean.getCategory());
				} else
					userAction.setCategory(Utilities.getWrapperSelect(
							userBean.getCategory(), userAction.categoryMap));
			}
		}
		// checkbox
		if (userBean.getUsertype() != null) {

			String usertype = userBean.getUsertype();
			if (usertype.indexOf(",") != -1 && usertype.indexOf("V") != -1) {
				usertype = usertype.substring(2, usertype.length() - 1);
				userBean.setUsertype(usertype);
			}

			if (userBean.getUsertype().trim().length() > 0) {
				if (userAction.usertypeList == null) {
					userAction.usertypeList = Utilities.csi
							.getArrayList_String();
				}
				// 以,为分隔符
				StringTokenizer usertypeSt = Utilities.csi.getStringTokenizer(
						userBean.getUsertype(), ",");
				if (!userAction.action.equals("detail")) {
					while (usertypeSt.hasMoreTokens())
						userAction.usertypeList.add(usertypeSt.nextToken()
								.trim());
				} else {
					while (usertypeSt.hasMoreTokens())
						userAction.usertypeList.add(userAction.usertypeMap
								.get(usertypeSt.nextToken().trim()));
				}
				userAction.setUsertypeList(userAction.usertypeList);
				usertype = new String();

				for (String susertype : userAction.usertypeList) {
					usertype += "," + susertype;
				}
				usertype = usertype.substring(1, usertype.length());
				userAction.setUsertype(usertype);
			}
		}
		// img upload
		if (userBean.getQualificat() != null) {
			if (userBean.getQualificat().trim().length() > 0)
				userAction.setQualificat(userBean.getQualificat());
			else
				userAction.setQualificat("");
		} else
			userAction.setQualificat("");
		// textfield
		if (userBean.getYubei1() != null)
			if (userBean.getYubei1().trim().length() > 0)
				userAction.setYubei1(userBean.getYubei1());
		// textfield
		if (userBean.getYubei2() != null)
			if (userBean.getYubei2().trim().length() > 0)
				userAction.setYubei2(userBean.getYubei2());
		// textfield
		if (userBean.getYubei3() != null)
			if (userBean.getYubei3().trim().length() > 0)
				userAction.setYubei3(userBean.getYubei3());
		// select
		if (userBean.getInvalid() != null) {
			if (userBean.getInvalid().trim().length() > 0) {
				if (!userAction.action.equals("detail")) {
					userAction.setInvalid(userBean.getInvalid());
					userAction.setInvalidSelect(userBean.getInvalid());
				} else
					userAction.setInvalid(Utilities.getWrapperSelect(
							userBean.getInvalid(), userAction.invalidMap));
			}
		}

	}

	/**
	 * 非数值、日期、时间、password的字段设置
	 * 
	 * @param UserBean
	 *            action句柄
	 * @param UserAction
	 *            action句柄
	 */
	private UserBean setUserBeanCommonAttributes(UserBean userBean,
			UserAction userAction) {
		userBean.setUserid(userAction.userid);
		userBean.setName(userAction.name);
		userBean.setNickname(userAction.nickname);
		userBean.setIcon(userAction.icon);
		userBean.setId_number(userAction.id_number);
		userBean.setEmail(userAction.email);
		userBean.setGender(userAction.gender);
		userBean.setAddress_province(userAction.address_province);
		userBean.setAddress_city(userAction.address_city);
		userBean.setAddress_area(userAction.address_area);
		userBean.setAddress_details(userAction.address_details);
		userBean.setHometown(userAction.hometown);
		userBean.setOccupation(userAction.occupation);
		userBean.setInterest(userAction.interest);
		userBean.setBankname(userAction.bankname);
		userBean.setBank_branch(userAction.bank_branch);
		userBean.setCard_number(userAction.card_number);
		userBean.setRecommender_code(userAction.recommender_code);
		userBean.setLogin_password(userAction.login_password);
		userBean.setGesture_password(userAction.gesture_password);
		userBean.setTrading_password(userAction.trading_password);
		userBean.setCategory(userAction.category);
		userBean.setUsertype(userAction.usertype);
		userBean.setQualificat(userAction.qualificat);
		userBean.setYubei1(userAction.yubei1);
		userBean.setYubei2(userAction.yubei2);
		userBean.setYubei3(userAction.yubei3);
		userBean.setInvalid(userAction.invalid);

		return userBean;
	}

	/**
	 * 保留翻页条件参数,主键不包括
	 * 
	 * @param userQueryConditionsBean
	 * @return
	 */
	public String saveRequestParameters(UserBean queryConditionsBean) {
		StringBuffer paramStr = new StringBuffer("");
		if (queryConditionsBean.getLevelFrom() != null)
			paramStr.append("&levelFrom=").append(
					queryConditionsBean.getLevelFrom());
		if (queryConditionsBean.getLevelTo() != null)
			paramStr.append("&levelTo=").append(
					queryConditionsBean.getLevelTo());
		if (queryConditionsBean.getUserid().trim().length() > 0)
			paramStr.append("&userid=").append(
					queryConditionsBean.getUserid().trim());
		if (queryConditionsBean.getName().trim().length() > 0)
			paramStr.append("&name=").append(
					queryConditionsBean.getName().trim());
		if (queryConditionsBean.getNickname().trim().length() > 0)
			paramStr.append("&nickname=").append(
					queryConditionsBean.getNickname().trim());
		if (queryConditionsBean.getIcon().trim().length() > 0)
			paramStr.append("&icon=").append(
					queryConditionsBean.getIcon().trim());
		if (queryConditionsBean.getId_number().trim().length() > 0)
			paramStr.append("&id_number=").append(
					queryConditionsBean.getId_number().trim());
		if (queryConditionsBean.getEmail().trim().length() > 0)
			paramStr.append("&email=").append(
					queryConditionsBean.getEmail().trim());
		if (queryConditionsBean.getGender() != null)
			if (queryConditionsBean.getGender().trim().length() > 0)
				paramStr.append("&gender=").append(
						queryConditionsBean.getGender().trim());
		if (queryConditionsBean.getAddress_province() != null)
			if (queryConditionsBean.getAddress_province().trim().length() > 0)
				paramStr.append("&address_province=").append(
						queryConditionsBean.getAddress_province().trim());
		if (queryConditionsBean.getAddress_city() != null)
			if (queryConditionsBean.getAddress_city().trim().length() > 0)
				paramStr.append("&address_city=").append(
						queryConditionsBean.getAddress_city().trim());
		if (queryConditionsBean.getAddress_area() != null)
			if (queryConditionsBean.getAddress_area().trim().length() > 0)
				paramStr.append("&address_area=").append(
						queryConditionsBean.getAddress_area().trim());
		if (queryConditionsBean.getAddress_details().trim().length() > 0)
			paramStr.append("&address_details=").append(
					queryConditionsBean.getAddress_details().trim());
		if (queryConditionsBean.getHometown().trim().length() > 0)
			paramStr.append("&hometown=").append(
					queryConditionsBean.getHometown().trim());
		if (queryConditionsBean.getOccupation().trim().length() > 0)
			paramStr.append("&occupation=").append(
					queryConditionsBean.getOccupation().trim());
		if (queryConditionsBean.getInterest().trim().length() > 0)
			paramStr.append("&interest=").append(
					queryConditionsBean.getInterest().trim());
		if (queryConditionsBean.getBankname() != null)
			if (queryConditionsBean.getBankname().trim().length() > 0)
				paramStr.append("&bankname=").append(
						queryConditionsBean.getBankname().trim());
		if (queryConditionsBean.getBank_branch().trim().length() > 0)
			paramStr.append("&bank_branch=").append(
					queryConditionsBean.getBank_branch().trim());
		if (queryConditionsBean.getCard_number().trim().length() > 0)
			paramStr.append("&card_number=").append(
					queryConditionsBean.getCard_number().trim());
		if (queryConditionsBean.getBalanceFrom() != null)
			paramStr.append("&balanceFrom=").append(
					queryConditionsBean.getBalanceFrom());
		if (queryConditionsBean.getBalanceTo() != null)
			paramStr.append("&balanceTo=").append(
					queryConditionsBean.getBalanceTo());
		if (queryConditionsBean.getPointFrom() != null)
			paramStr.append("&pointFrom=").append(
					queryConditionsBean.getPointFrom());
		if (queryConditionsBean.getPointTo() != null)
			paramStr.append("&pointTo=").append(
					queryConditionsBean.getPointTo());
		if (queryConditionsBean.getRecommender_code().trim().length() > 0)
			paramStr.append("&recommender_code=").append(
					queryConditionsBean.getRecommender_code().trim());
		if (queryConditionsBean.getLogin_password().trim().length() > 0)
			paramStr.append("&login_password=").append(
					queryConditionsBean.getLogin_password().trim());
		if (queryConditionsBean.getGesture_password().trim().length() > 0)
			paramStr.append("&gesture_password=").append(
					queryConditionsBean.getGesture_password().trim());
		if (queryConditionsBean.getTrading_password().trim().length() > 0)
			paramStr.append("&trading_password=").append(
					queryConditionsBean.getTrading_password().trim());
		if (queryConditionsBean.getCategory() != null)
			if (queryConditionsBean.getCategory().trim().length() > 0)
				paramStr.append("&category=").append(
						queryConditionsBean.getCategory().trim());
		if (queryConditionsBean.getUsertype().trim().length() > 0)
			if (!queryConditionsBean.getUsertype().trim().equals("false"))
				paramStr.append("&usertype=").append(
						queryConditionsBean.getUsertype().trim());
		if (queryConditionsBean.getQualificat().trim().length() > 0)
			paramStr.append("&qualificat=").append(
					queryConditionsBean.getQualificat().trim());
		if (queryConditionsBean.getYubei1().trim().length() > 0)
			paramStr.append("&yubei1=").append(
					queryConditionsBean.getYubei1().trim());
		if (queryConditionsBean.getYubei2().trim().length() > 0)
			paramStr.append("&yubei2=").append(
					queryConditionsBean.getYubei2().trim());
		if (queryConditionsBean.getYubei3().trim().length() > 0)
			paramStr.append("&yubei3=").append(
					queryConditionsBean.getYubei3().trim());
		if (queryConditionsBean.getInvalid() != null)
			if (queryConditionsBean.getInvalid().trim().length() > 0)
				paramStr.append("&invalid=").append(
						queryConditionsBean.getInvalid().trim());
		if (queryConditionsBean.getRegister_timeFrom() != null)
			paramStr.append("&register_timeFrom=").append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getRegister_timeFrom()));
		if (queryConditionsBean.getRegister_timeTo() != null)
			paramStr.append("&register_timeTo=").append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getRegister_timeTo()));
		if (queryConditionsBean.getUpdate_timeFrom() != null)
			paramStr.append("&update_timeFrom=").append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getUpdate_timeFrom()));
		if (queryConditionsBean.getUpdate_timeTo() != null)
			paramStr.append("&update_timeTo=").append(
					Utilities.getDateString("yyyy-MM-dd hh:mm:ss",
							queryConditionsBean.getUpdate_timeTo()));

		return paramStr.toString();
	}
}