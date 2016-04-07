package edu.jt.exg.logic.task;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class TaskUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/task/taskSpringInstance.xml");
	}
}