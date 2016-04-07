package edu.jt.exg.logic.v_order_master;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class V_order_masterUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/v_order_master/v_order_masterSpringInstance.xml");
	}
}