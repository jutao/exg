package utility;

import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyUtil {
    //WEB-INF/classes/
    private static final String CONFIG_PATH = "../../config.properties";
    private static final String CONFIG_KEY = "config_properties";
    private static Properties props;
    private static ResourceBundle myResources;

    static {
        myResources = PropertyResourceBundle.getBundle("config");
    }

	public PropertyUtil() {
	}

	
    public static String getProperty(String key) {
        return getProperties().getString(key);
    }
	
    public static String getProperty(String key, String defaultValue) {
        String ret = getProperties().getString(key);
        if (ret == null || ret.length() == 0) {
            return defaultValue;
        }
        return ret;
    }

    public static Object getPropertyObject(String key) {
        return getProperties().getObject(key);
    }
    
    private static ResourceBundle getProperties() {
        return myResources;
    }

}
