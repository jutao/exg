package edu.jt.exg.logic.category;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class CategoryUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/category/categorySpringInstance.xml");
	}
}