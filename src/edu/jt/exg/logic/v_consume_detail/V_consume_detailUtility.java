package edu.jt.exg.logic.v_consume_detail;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class V_consume_detailUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/v_consume_detail/v_consume_detailSpringInstance.xml");
	}
}