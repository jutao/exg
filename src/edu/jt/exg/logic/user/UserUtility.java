package edu.jt.exg.logic.user;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class UserUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/user/userSpringInstance.xml");
	}
}