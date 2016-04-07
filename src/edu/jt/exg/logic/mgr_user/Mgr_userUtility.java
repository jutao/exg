package edu.jt.exg.logic.mgr_user;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class Mgr_userUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/mgr_user/mgr_userSpringInstance.xml");
	}
}