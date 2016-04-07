package edu.jt.exg.logic.comment;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class CommentUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/comment/commentSpringInstance.xml");
	}
}