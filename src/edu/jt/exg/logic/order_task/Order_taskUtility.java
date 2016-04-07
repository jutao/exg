package edu.jt.exg.logic.order_task;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class Order_taskUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/order_task/order_taskSpringInstance.xml");
	}
}