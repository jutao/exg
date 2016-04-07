package edu.jt.exg.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import utility.ConstSetup;
import utility.Utilities;
import edu.jt.exg.dto.Category;
import edu.jt.exg.logic.category_master.Category_masterBatisDao;
import edu.jt.exg.logic.category_master.Category_masterBean;
import edu.jt.exg.logic.category_master.Category_masterUtility;

public class CategoryServiceImpl implements CategoryService {

	/**
	 * 
	 */
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
	public List<Category> getData() {
		List<Category> result = new ArrayList<Category>();
		
		try 
    	{
			Category_masterBatisDao dao=Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao",Category_masterBatisDao.class);
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(Category_masterBatisDao.DISPLAY_ASC, null);
			
			Category_masterBean conditions = new Category_masterBean();
			conditions.setInvalid("0");
			List<Category_masterBean> res=dao.finder(orderByMap, conditions);
			if ( null != res) {
				Category dto = null;
				for(int i = 0; i < res.size(); i++){
					dto = new Category();
					BeanUtils.copyProperties(res.get(i), dto);
					result.add(dto);
    			}
			}    				
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return result;
	}
	
	@Override
	public List<Category> getData(String code) {
		List<Category> result = new ArrayList<Category>();
		
		try 
    	{
			Category_masterBatisDao dao=Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao",Category_masterBatisDao.class);
			this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
			this.orderByMap.put(Category_masterBatisDao.DISPLAY_ASC, null);
			
			Category_masterBean conditions = new Category_masterBean();
			conditions.setInvalid("0");
			if (!StringUtils.isEmpty(code)) {
				conditions.setParent_code(code);
			}
			List<Category_masterBean> res=dao.finder(orderByMap, conditions);
			if ( null != res) {
				Category dto = null;
				for(int i = 0; i < res.size(); i++){
					dto = new Category();
					BeanUtils.copyProperties(res.get(i), dto);
					result.add(dto);
    			}
			}    				
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return result;
	}

}
