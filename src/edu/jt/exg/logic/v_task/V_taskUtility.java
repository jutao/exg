package edu.jt.exg.logic.v_task;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class V_taskUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/v_task/v_taskSpringInstance.xml");
	}
}