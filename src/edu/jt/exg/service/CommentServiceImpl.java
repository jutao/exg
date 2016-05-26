package edu.jt.exg.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import edu.jt.exg.dto.Advertisements;
import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.Comment;
import edu.jt.exg.logic.advertisements.AdvertisementsBatisDao;
import edu.jt.exg.logic.advertisements.AdvertisementsBean;
import edu.jt.exg.logic.advertisements.AdvertisementsUtility;
import edu.jt.exg.logic.comment.CommentBatisDao;
import edu.jt.exg.logic.comment.CommentBean;
import edu.jt.exg.logic.comment.CommentUtility;
import edu.jt.exg.logic.order_master.Order_masterBatisDao;
import edu.jt.exg.logic.order_master.Order_masterUtility;
import edu.jt.exg.logic.user.UserBatisDao;
import edu.jt.exg.logic.user.UserBean;
import edu.jt.exg.logic.user.UserUtility;
import utility.ConstSetup;
import utility.Utilities;


public class CommentServiceImpl implements CommentService {
    private static final long serialVersionUID = 1L;

	/**
	 * 记录起始读取位置
	 */
	public String start=null;
	public String getStart(){return start;}
	public void setStart(String start){this.start=start;}
	
	/**
	 * 记录范围
	 */
	public String range=ConstSetup.REFERENCE_RANGE;
	
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}

	/**
	 * 排序规则
	 */
	public LinkedHashMap<String,String> orderByMap=null;
	@Override
	public Callback createComment(Comment comment) {
		int result=0;
		if(comment.getCategory().equals("1")){
			UserBatisDao userDao=UserUtility.getIocHandel().getBean("UserBatisDao",
					UserBatisDao.class);
			UserBean userBean=new UserBean();
			userBean.setUserid(comment.getTargetkey());
			List<UserBean> listUser=userDao.finder(userBean);
			if(listUser.size()>0){
				comment.setTargetkey(listUser.get(0).getId());
				CommentBean commentBean=new CommentBean();
				BeanUtils.copyProperties(comment, commentBean);
				commentBean.setInvalid("0");
				commentBean.setRegister_time(Utilities.csi.getCurrentTimestamp());
				commentBean.setUpdate_time(Utilities.csi.getCurrentTimestamp());
				CommentBatisDao dao=CommentUtility.getIocHandel().getBean("CommentBatisDao",
						CommentBatisDao.class);
				result =dao.insert(commentBean);
			}
		}
		Callback callback=new Callback();
		if(result==1){
			callback.setResult(true);
		}else{
			callback.setResult(false);
		}
		return callback;
	}
	

    
}
