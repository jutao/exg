package edu.jt.exg.logic.charge_detail;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class Charge_detailUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/charge_detail/charge_detailSpringInstance.xml");
	}
}