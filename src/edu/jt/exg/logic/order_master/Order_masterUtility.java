package edu.jt.exg.logic.order_master;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class Order_masterUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/order_master/order_masterSpringInstance.xml");
	}
}