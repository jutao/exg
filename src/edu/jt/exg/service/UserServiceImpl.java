package edu.jt.exg.service;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import utility.CommonMethod;
import utility.Utilities;
import edu.jt.exg.action.UserAction;
import edu.jt.exg.dto.User;
import edu.jt.exg.dto.UserCheck;
import edu.jt.exg.logic.user.UserBatisDao;
import edu.jt.exg.logic.user.UserBean;
import edu.jt.exg.logic.user.UserUtility;
import edu.jt.exg.logic.v_address.V_addressBatisDao;

public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 1L;

	@Override
	public User getUserByID(User user) {
		User result = new User();
		String userid = user.getUserid();
		UserBean res = null;

		try {
			if (!StringUtils.isEmpty(userid)) {
				UserBatisDao dao = UserUtility.getIocHandel().getBean(
						"UserBatisDao", UserBatisDao.class);
				UserBean userbean = new UserBean();
				userbean.setUserid(userid);
				res = (UserBean) dao.finder(userbean).get(0);
				if (null != res) {
					BeanUtils.copyProperties(res, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result = UserInfo(result);
		return result;
	}

	@Override
	public UserCheck userCheck(User user) {
		UserBean userbean = new UserBean();
		UserBatisDao dao = UserUtility.getIocHandel().getBean("UserBatisDao",
				UserBatisDao.class);
		userbean.setUserid(user.getUserid());
		userbean.setLogin_password(user.getLogin_password());
		List<UserBean> res = dao.finder(userbean);
		UserCheck usercheck = new UserCheck();
		if (res == null || res.size() == 0) {
			usercheck.setResult(false);
		} else {
			usercheck.setResult(true);
		}
		usercheck.setUser(getUserByID(user));
		return usercheck;
	}

	@Override
	public UserCheck CreateUser(User user) {
		UserCheck callback = new UserCheck();

		UserBean userbean = new UserBean();
		UserBatisDao dao = UserUtility.getIocHandel().getBean("UserBatisDao",
				UserBatisDao.class);
		userbean.setUserid(user.getUserid());
		List<UserBean> res = dao.finder(userbean);
		if (res == null || res.size() == 0) {
			userbean.setCategory("2");
			userbean.setUsertype("40");
			userbean.setInvalid("0");
			userbean.setLevel(1);
			userbean.setLogin_password(user.getLogin_password());
			userbean.setRegister_time(Utilities.csi.getCurrentTimestamp());
			userbean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
			if (dao.insert(userbean) == 0) {
				callback.setCode(0);
				callback.setMessage("fail");
			} else {
				callback.setCode(1);
				callback.setMessage("success");
			}
		} else {
			callback.setCode(-1);
			callback.setMessage("repeat");
		}
		callback.setUser(getUserByID(user));
		return callback;
	}
		@Override
		public UserCheck UpdateUser(User user) {
			UserCheck callback = new UserCheck();

			UserBean userbean = new UserBean();
			UserBatisDao dao = UserUtility.getIocHandel().getBean("UserBatisDao",
					UserBatisDao.class);
			if (null != user) {
				BeanUtils.copyProperties(user, userbean);
				userbean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
			}
			int result=dao.updateByKey(userbean);
			if(result==0){
				callback.setResult(false);
			}else{
				callback.setResult(true);
			}
			return callback;
		}
	// 将code转换成中文传输给客户端
	private User UserInfo(User user) {
		UserAction userAction = new UserAction();

		if (user.getCategory() != null && !user.getCategory().equals("")) {
			userAction.categoryMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(userAction.categoryMap, "1002");// 用户区分：1002
			user.setCategoryName(Utilities.getWrapperSelect(user.getCategory(),
					userAction.categoryMap));
		}
		if (user.getGender() != null) {
			userAction.genderMap = Utilities.csi
					.getLinkedHashMap_String_String();
			CommonMethod.getSelectMap(userAction.genderMap, "1013");// 性别区分：1013
			user.setGenderName(Utilities.getWrapperSelect(user.getGender(),
					userAction.genderMap));
		}
		if (user.getUsertype() != null) {
			if (userAction.usertypeMap == null)
				userAction.usertypeMap = Utilities.csi
						.getLinkedHashMap_String_String();
			CommonMethod.getCheckMap(userAction.usertypeMap, "1003");// 已认证资格：1003
			String usertype = user.getUsertype();
			if (usertype.indexOf(",") != -1 && usertype.indexOf("V") != -1) {
				usertype = usertype.substring(2, usertype.length() - 1);
				user.setUsertype(usertype);
			}

			if (user.getUsertype().trim().length() > 0) {
				if (userAction.usertypeList == null) {
					userAction.usertypeList = Utilities.csi
							.getArrayList_String();
				}
				// 以,为分隔符
				StringTokenizer usertypeSt = Utilities.csi.getStringTokenizer(
						user.getUsertype(), ",");
				while (usertypeSt.hasMoreTokens())
					userAction.usertypeList.add(userAction.usertypeMap
							.get(usertypeSt.nextToken().trim()));
				userAction.setUsertypeList(userAction.usertypeList);
				usertype = new String();

				for (String susertype : userAction.usertypeList) {
					usertype += "," + susertype;
				}
				usertype = usertype.substring(1, usertype.length());
				user.setUsertypeName(usertype);
			}
		}
		if (user.getAddress_province() != null) {
			V_addressBatisDao dao = new V_addressBatisDao();
			user.setAddress_provinceName(dao.finderProvince_name(user
					.getAddress_province()));

		}
		if (user.getAddress_city() != null) {
			V_addressBatisDao dao = new V_addressBatisDao();
			user.setAddress_cityName(dao.finderCity_name(user.getAddress_city()));
		}
		if (user.getAddress_area() != null) {
			V_addressBatisDao dao = new V_addressBatisDao();
			user.setAddress_areaName(dao.finderArea_name(user.getAddress_area()));
		}
		return user;
	}


}
