package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

import net.arnx.jsonic.JSON;
import core.ListKeyBean;
import edu.jt.exg.dto.AreaDto;
import edu.jt.exg.dto.CityDto;
import edu.jt.exg.dto.ProvinceDto;
import edu.jt.exg.logic.category_master.Category_masterBatisDao;
import edu.jt.exg.logic.category_master.Category_masterBean;
import edu.jt.exg.logic.category_master.Category_masterUtility;
import edu.jt.exg.logic.v_address.V_addressBatisDao;
import edu.jt.exg.logic.v_address.V_addressBean;
import edu.jt.exg.logic.v_address.V_addressUtility;

/**
 * 共通方法类
 * @author Tao Ju
 *	2015/05/31 11:44:00
 */
public class CommonMethod {
	/**
	 * 获取原始Json数据并转化
	 */
	public static String getadressJson(){
		V_addressBean v_addressBean = new V_addressBean();
		V_addressBatisDao v_addressBatisDao = V_addressUtility.getIocHandel().getBean("V_addressBatisDao", V_addressBatisDao.class);
		List<V_addressBean> list = v_addressBatisDao.finder(v_addressBean);
		List<ProvinceDto> province_list=new ArrayList<ProvinceDto>();
		List<CityDto> city_list=new ArrayList<CityDto>();
		List<AreaDto> area_list=new ArrayList<AreaDto>();
		String provinceCode="";
		String CityCode="";
		ProvinceDto province=new ProvinceDto();
		CityDto city=new CityDto();
		AreaDto area=new AreaDto();
		for (int i = 0; i < list.size(); i++) {
			V_addressBean v_address=list.get(i);
			if(!provinceCode.equals(v_address.getProvince_code())){
				if(area_list.size()>0){//直辖市
					city.setArea_list(area_list);
				}
				provinceCode=v_address.getProvince_code();
				CityCode=v_address.getCity_code();
				province=new ProvinceDto();
				addprovince(province, province_list, v_address);
				city_list=new ArrayList<CityDto>();
				province.setCity_list(city_list);
				city=new CityDto();
				addCity(city, city_list, v_address);
				area_list=new ArrayList<AreaDto>();
				addArea(area, area_list, v_address);
			}else{
				if(!CityCode.equals(v_address.getCity_code())){
					city.setArea_list(area_list);
					area_list=new ArrayList<AreaDto>();
					CityCode=v_address.getCity_code();
					addArea(area, area_list, v_address);
					city=new CityDto();
					addCity(city, city_list, v_address);
				}else{
					addArea(area, area_list, v_address);
				}
			}
			if(i==list.size()-1){
				city.setArea_list(area_list);
			}
		}
		return JSON.encode(province_list);
	}
	private static void addArea(AreaDto area,List<AreaDto> area_list,V_addressBean v_address){
		area=new AreaDto();
		area.setArea_code(v_address.getArea_code());
		area.setArea_name(v_address.getArea_name());
		area_list.add(area);
	}
	private static void addCity(CityDto city,List<CityDto> city_list,V_addressBean v_address){
		city.setCity_code(v_address.getCity_code());
		city.setCity_name(v_address.getCity_name());
		city_list.add(city);
	}
	private static void addprovince(ProvinceDto province,List<ProvinceDto> province_list,V_addressBean v_address){
		province.setProvince_code(v_address.getProvince_code());
		province.setProvince_name(v_address.getProvince_name());
		province_list.add(province);
	}
	
	
	
	
	/**
	 * 将品种code组合成中文
	 */
	public static String varietieCodeToWord(String varieties){
		if (varieties.trim().length() > 0) {
			List<String> varietiesList = Utilities.csi
					.getArrayList_String();
		// 以,为分隔符
		StringTokenizer varietiesSt = Utilities.csi.getStringTokenizer(
				varieties, ",");
		LinkedHashMap<String, String> varietiesMap=Utilities.csi.getLinkedHashMap_String_String();
		CommonMethod.getCheckMap(varietiesMap, "1026");
			while (varietiesSt.hasMoreTokens())
				varietiesList.add(varietiesMap
						.get(varietiesSt.nextToken().trim()));
		varieties = new String();
			
		for (String varietie : varietiesList) {
			varieties += "," + varietie;
		}
		varieties = varieties.substring(1, varieties.length());
	}
		return varieties;
	}
//TODO 20151015 by lirh
	/**
	 * 取得下拉框数据
	 * @param selectMap
	 * @param code 区分 category_master-code
	 */
	public static void getSelectMap(LinkedHashMap<String, String> selectMap, String code){
		Category_masterBean category_masterBean = new Category_masterBean();

		category_masterBean.setParent_code(code); 
		Category_masterBatisDao category_masterBatisDao = Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao", Category_masterBatisDao.class);
		List<Category_masterBean> list = category_masterBatisDao.finder(category_masterBean);
		selectMap.put("","");

		for (int i = 0; i < list.size(); i++) {
			Category_masterBean category = list.get(i);
			selectMap.put(category.getCode(),category.getName());
		}
	}
	/**
	 * 取得CheckBox数据
	 * @param selectMap
	 * @param code 区分 category_master-code
	 */
	public static void getCheckMap(LinkedHashMap<String, String> selectMap, String code){
		Category_masterBean category_masterBean = new Category_masterBean();
		
		category_masterBean.setParent_code(code); 
		Category_masterBatisDao category_masterBatisDao = Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao", Category_masterBatisDao.class);
		List<Category_masterBean> list = category_masterBatisDao.finder(category_masterBean);

		for (int i = 0; i < list.size(); i++) {
			Category_masterBean category = list.get(i);
			selectMap.put(category.getCode(),category.getName());
		}
	}
	
	/**
	 * 
	 * @param list
	 * @param code 区分 category_master-code
	 */
	public static void getRadioList(List<ListKeyBean> radiolist, String code){
		Category_masterBean category_masterBean = 
				Category_masterUtility.getIocHandel().getBean("Category_masterBean", Category_masterBean.class);
		category_masterBean.setParent_code(code); 
		Category_masterBatisDao category_masterBatisDao = 
				Category_masterUtility.getIocHandel().getBean("Category_masterBatisDao", Category_masterBatisDao.class);
		List<Category_masterBean> list = category_masterBatisDao.finder(category_masterBean);

		for (int i = 0; i < list.size(); i++) {
			ListKeyBean listKB = new ListKeyBean(list.get(i).getCode(),list.get(i).getName());
			radiolist.add(listKB);
		}
	}
	
	/**
	 * 将radio的key从ListKeyBean中替换为对应的Value,用于在详情中以文本显示
	 * @param originalStr radio的key值
	 * @param list radio的键值对list(ListKeyBean)
	 * @return radio的value值
	 */
	public static String getWrapperRadio(String originalStr, List<ListKeyBean> list ){
		String radioValue = null;
		for (int i = 0; i < list.size(); i++) {
			ListKeyBean bean = list.get(i);
			if (bean.getKey().equals(originalStr)) {
				radioValue = bean.getValue();
				break;
			}
		}
		
		return radioValue;
	}
	
	public static boolean copyFile(String source, String target){
		boolean succ=false;
		File sourceFile=new File(source);

        int byteread = 0; // 读取的字节数 
		InputStream in=null;
		FileOutputStream fs=null;
		try {
			in=new FileInputStream(sourceFile);
			fs=new FileOutputStream(target);
			byte[] buffer = new byte[1024];  
			  
			while ((byteread = in.read(buffer)) != -1) {  
				fs.write(buffer, 0, byteread);  
			}
			succ=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			succ=false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			succ=false;
			e.printStackTrace();
		} finally{
			try {  
                if (fs != null)  
                	fs.close();  
                if (in != null)  
                    in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } 
		}
		
		return succ;
	}
	/**
	 * 刪除文件
	 * @param path
	 */
	public static  void DeleteThis(String path){
		File file=new File(path);
		if(file.exists()){
			file.delete();
		}
	}
}
