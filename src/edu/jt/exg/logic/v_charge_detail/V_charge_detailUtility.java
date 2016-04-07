package edu.jt.exg.logic.v_charge_detail;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class V_charge_detailUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/v_charge_detail/v_charge_detailSpringInstance.xml");
	}
}