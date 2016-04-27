package edu.jt.exg.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.User;
import edu.jt.exg.dto.UserCheck;
import edu.jt.exg.logic.user.UserBatisDao;
import edu.jt.exg.logic.user.UserBean;
import edu.jt.exg.logic.user.UserUtility;

public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 1L;

	@Override
	public User getUserByID(String userid) {
		User result = new User();

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

		return usercheck;
	}

	@Override
	public Callback CreateUser(User user) {
		Callback callback = new Callback();

		UserBean userbean = new UserBean();
		UserBatisDao dao = UserUtility.getIocHandel().getBean("UserBatisDao",
				UserBatisDao.class);
		userbean.setUserid(user.getUserid());
		List<UserBean> res = dao.finder(userbean);
		if (res == null || res.size() == 0) {
			userbean.setCategory("1");
			userbean.setUsertype("40");
			userbean.setInvalid("0");
			userbean.setLevel(1);
			userbean.setLogin_password(user.getLogin_password());
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

		return callback;
	}

}
