package edu.jt.exg.logic.v_order_task;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class V_order_taskUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/v_order_task/v_order_taskSpringInstance.xml");
	}
}