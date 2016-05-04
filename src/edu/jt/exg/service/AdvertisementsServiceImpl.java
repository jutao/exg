package edu.jt.exg.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import edu.jt.exg.dto.Advertisements;
import edu.jt.exg.logic.advertisements.AdvertisementsBatisDao;
import edu.jt.exg.logic.advertisements.AdvertisementsBean;
import edu.jt.exg.logic.advertisements.AdvertisementsUtility;
import utility.ConstSetup;
import utility.Utilities;


public class AdvertisementsServiceImpl implements AdvertisementsService {
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
    public List<Advertisements> getAdvertisements() {
    	List<Advertisements> result= new ArrayList<Advertisements>();
    	
    	List<AdvertisementsBean> res=null;

    	try 
    	{
    		AdvertisementsBatisDao dao=AdvertisementsUtility.getIocHandel().getBean("AdvertisementsBatisDao",AdvertisementsBatisDao.class);
    		this.orderByMap=Utilities.csi.getLinkedHashMap_String_String();
//    		this.orderByMap.put(V_advertisements_otherBatisDao.CATEGORY_ASC, null);
    		
    		AdvertisementsBean condition = new AdvertisementsBean();
    		condition.setInvalid("0");
    		
   			res = dao.finder(this.orderByMap, condition);
    		
    		if ( null != res) {
    			for(int i = 0; i < res.size(); i++){
    				Advertisements dto = new Advertisements();
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
