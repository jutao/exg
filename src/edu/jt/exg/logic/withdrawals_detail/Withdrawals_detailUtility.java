package edu.jt.exg.logic.withdrawals_detail;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class Withdrawals_detailUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/withdrawals_detail/withdrawals_detailSpringInstance.xml");
	}
}