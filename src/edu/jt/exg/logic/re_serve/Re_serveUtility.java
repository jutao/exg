package edu.jt.exg.logic.re_serve;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class Re_serveUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/re_serve/re_serveSpringInstance.xml");
	}
}