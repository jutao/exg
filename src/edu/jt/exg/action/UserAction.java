package edu.jt.exg.action;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.struts2.ServletActionContext;

import utility.CommonMethod;
import utility.Page;
import utility.PropertyUtil;
import utility.Utilities;
import edu.jt.exg.logic.user.InitPageControl;
import edu.jt.exg.logic.user.PageStatus;
import edu.jt.exg.logic.user.UserBean;
import edu.jt.exg.logic.user.UserBatisDao;
import edu.jt.exg.logic.user.UserUtility;



public class UserAction extends UserAttributeAction {

	private static final long serialVersionUID = 19761210;

	/**
	 * 页面跳转
	 * @return 返回跳转页面指针
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		request=ServletActionContext.getRequest();
		singleServletModel=Utilities.csi.getSingleServletModel(request);
		ps=UserUtility.getIocHandel().getBean("PageStatus",PageStatus.class);
		showPage=Utilities.csi.getShowPage();		
		//根据action参数跳转
		String forward="";
		if(action.equals("initquery") || action.equals("${action}")) forward=doInitQuery();
		else if(action.equals("query")) forward=doQuery();
		else if(action.equals("initsinglequery")) forward=doInitSingleQuery();
		else if(action.equals("singlequery")) forward=doSingleQuery();
		else if(action.equals("initmultiquery")) forward=doInitMulitQuery();
		else if(action.equals("multiquery")) forward=doMulitQuery();
    	else if(action.equals("initcreate")) forward=doInitCreate();
    	else if(action.equals("initupdate")) forward=doInitUpdate();
    	else if(action.equals("create") || action.equals("update")) forward=doCreateOrUpdate();
    	else if(action.equals("detail")) forward=doDetail();
    	else if(action.equals("delete")) forward=doDelete();
    	else if(action.equals("deleteSelected")) forward=doDeleteSelected();
		return forward;
	}
	
	/**
	 * @return 返回初始化查询页面
	 */
	private String doInitQuery(){return doCommonInitQuery("initquery");}
	
	/**
	 * @return 返回查询页面
	 */
	private String doQuery(){return doCommonQuery("query");}
	
	/**
	 * @return 返回初始化单选弹出页面
	 */
	private String doInitSingleQuery(){return doCommonInitQuery("initsinglequery");}
	
	/**
	 * @return 返回单选弹出页面
	 */
	private String doSingleQuery(){return doCommonQuery("singlequery");}
	
	/**
	 * @return 返回初始化多选弹出页面
	 */
	private String doInitMulitQuery(){return doCommonInitQuery("initmultiquery");}
	
	/**
	 * @return 返回多选弹出页面
	 */
	private String doMulitQuery(){return doCommonQuery("multiquery");}
	
	/**
	 * 初始化查询通用方法
	 * @return
	 */
	private String doCommonInitQuery(String parm){
		String params=singleServletModel.getRequest().getParameter("params");
		//从翻页得到隐藏域传递参数,否则从from得到参数
		if(params!=null) ps.setRecordsRangeAndOrderByRules(this,params);
		else ps.setRecordsRangeAndOrderByRules(this);
		this.setAdressJson(CommonMethod.getadressJson());
		
		batisDao=UserUtility.getIocHandel().getBean("UserBatisDao",UserBatisDao.class);
		
		
		orderByMap.put(UserBatisDao.ID_ASC, null);//sqlserver必须排序否则分页会有问题
		
		
		
		
		userList=batisDao.findByAll(orderByMap,start,range);
		
    	userList=ps.wrapperRecorders(this,"show");
    	
    	
    	long num=batisDao.findByAllCount();
    	
        String page=Page.getPage(singleServletModel.getRequest(),
        		new StringBuffer("action=").append(parm).append("&go2page=edu/jt/exg/action/UserAction.action").toString(),
        		Integer.parseInt(start),Integer.parseInt(range),num);
        showPage.setPage(page);
        String page1=Page.getPage1(singleServletModel.getRequest(),
        		new StringBuffer("action=").append(parm).append("&go2page=edu/jt/exg/action/UserAction.action").toString(),
        		Integer.parseInt(start),Integer.parseInt(range),num);
        showPage.setPage1(page1);
        setStart(start);
        setUserList(userList);
        setShowPage(showPage);
		ps.setControlsValues(this);//控件初始化
		//如果有多个s:optiontransferselect必须在这里都要初始化
		
		return parm;
	}
	
	/**
	 * 查询通用方法
	 * @param parm 查询的action参数
	 * @return
	 */
	private String doCommonQuery(String parm){
		String params=singleServletModel.getRequest().getParameter("params");
		UserBean user=null;
		//从翻页得到隐藏域传递参数,否则从from得到参数
		if(params!=null){
			ps.setRecordsRangeAndOrderByRules(this,params);
			user=ps.getQueryConditionsFromParams(this, params);
		}else{
			ps.setRecordsRangeAndOrderByRules(this);
			user=ps.getQueryConditionsFromForm(this);
		}
		
		
		batisDao=UserUtility.getIocHandel().getBean("UserBatisDao",UserBatisDao.class);
		
		
		
		userList=batisDao.finder(orderByMap,start,range,user);
		
		userList=ps.wrapperRecorders(this,"show");
		
		
		long num=batisDao.finderCount(user);
		
		String page=Page.getPage(singleServletModel.getRequest(),
				new StringBuffer("action=").append(parm).append(ps.saveRequestParameters(user)).append("&go2page=edu/jt/exg/action/UserAction.action").toString(),
				Integer.parseInt(start),Integer.parseInt(range),num);
		showPage.setPage(page);
		String page1=Page.getPage1(singleServletModel.getRequest(),
				new StringBuffer("action=").append(parm).append(ps.saveRequestParameters(user)).append("&go2page=edu/jt/exg/action/UserAction.action").toString(),
				Integer.parseInt(start),Integer.parseInt(range),num);
		showPage.setPage1(page1);
		setStart(start);
		setUserList(userList);
        setShowPage(showPage);
		ps.setControlsValues(this);//控件初始化
		ps.readConditionsWrite2Controls(this,user);
		return parm;
	}
	
	/** 
	 * @return 返回初始化新建页面
	 */
	private String doInitCreate(){
		ps.setControlsValues(this);//控件初始化
		setDateTimePickerNowDateShow();//初始化显示日期控件的提示日期
		//如果有多个s:optiontransferselect必须在这里都要初始化
		this.setAdressJson(CommonMethod.getadressJson());
		return "initcreate";
	}
	
	/**
	 * @return 返回初始化修改页面
	 */
	private String doInitUpdate(){
		ps.setControlsValues(this);//控件初始化
		setDateTimePickerNowDateShow();//初始化显示日期控件的提示日期
		ps.readDatasWrite2Controls(this);
		return "initupdate";
	}
	
	/**
	 * 新建和修改通用方法
	 * @return 返回初始化查询页面
	 */
	private String doCreateOrUpdate(){
		this.usertype=this.usertype.substring(0, this.usertype.length()-1);
		String errorMsg=ps.readControlsWrite2Datas(this);
		setAction("initquery");//设置所有的动态传参
		if(errorMsg.indexOf("ERROR")==-1) return "toinitquery";
		else return "nullPoint";
	}
	
	/**
	 * @return 返回详细信息页面
	 */
	private String doDetail(){
		ps.setControlsValues(this);//控件初始化
		ps.readDatasWrite2Controls(this);
		return "detail";
	}
	
	/**
	 * 删除单条数据
	 * @return 返回初始化查询页面
	 */
	private String doDelete(){
		
		
		batisDao=UserUtility.getIocHandel().getBean("UserBatisDao",UserBatisDao.class);
		
		UserBean user=batisDao.findByKey(id);
		if(user.getIcon()!=null){
			String path=PropertyUtil.getProperty("path.image")+user.getIcon();
			CommonMethod.DeleteThis(path);
		}
		if(user.getQualificat()!=null){
			String path=PropertyUtil.getProperty("path.image")+user.getQualificat();
			CommonMethod.DeleteThis(path);
		}
		batisDao.deleteByKey(id);
		setAction("initquery");//设置所有的动态传参
		return "toinitquery";
	}
	
	/**
	 * 删除多条数据
	 * @return 返回初始化查询页面
	 */
    private String doDeleteSelected(){
    	
    	
    	batisDao=UserUtility.getIocHandel().getBean("UserBatisDao",UserBatisDao.class);
    	
		String ids=singleServletModel.getRequest().getParameter("ids");
		String[] array=ids.split(",");//mybatis
		
		
		
		List<String> idsList=Utilities.csi.getArrayList_String();//mybatis
		
		for(int i=0;i<array.length;i++) idsList.add(array[i]);//mybatis
		
		batisDao.deleteByKeys(idsList);
		
		setAction("initquery");//设置所有的动态传参
		return "toinitquery";
    }
}