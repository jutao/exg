package edu.jt.exg.logic.advertisements;
import org.springframework.context.ApplicationContext;
import utility.SingleClassPathXmlApplicationContext;
public class AdvertisementsUtility {
	public static ApplicationContext getIocHandel(){
		return SingleClassPathXmlApplicationContext.getSingleClassPathXmlApplicationContext(
			"edu/jt/exg/logic/advertisements/advertisementsSpringInstance.xml");
	}
}