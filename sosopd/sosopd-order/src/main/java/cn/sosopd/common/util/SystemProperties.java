package cn.sosopd.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 系统属性配置项
 * 
 * @author ChenFeng
 * @date 2016年4月8日
 */
public abstract class SystemProperties {

    private static final Logger log = Logger.getLogger(SystemProperties.class);

    private static final Properties prop = new Properties();

    public static Map<String, Object> config = new HashMap<String, Object>();

    public static final String PROPERTIES_FILEPATH = "/system.properties";

    static {
        ResourceBundle rb = ResourceBundle.getBundle("system");
        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String val = rb.getString(key);
            config.put(key, val);
        }
        prop.putAll(config);
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }

    public static int getProperty(String key, int defaultValue) {
        String value = prop.getProperty(key);
        try {
            if (value != null) {
                return Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            log.warn("配置项值类型转化失败，key：" + key + "，value：" + value + "；返回默认值：" + defaultValue);
        } catch (NullPointerException e) {
            log.warn("配置项值类型转化失败，key：" + key + "，value：" + value + "；返回默认值：" + defaultValue);
        }
        return defaultValue;
    }

    public static long getProperty(String key, long defaultValue) {
        String value = prop.getProperty(key);
        try {
            if (value != null) {
                return Long.parseLong(value);
            }
        } catch (NumberFormatException e) {
            log.warn("配置项值类型转化失败，key：" + key + "，value：" + value + "；返回默认值：" + defaultValue);
        } catch (NullPointerException e) {
            log.warn("配置项值类型转化失败，key：" + key + "，value：" + value + "；返回默认值：" + defaultValue);
        }
        return defaultValue;
    }

    public static boolean getProperty(String key, boolean defaultValue) {
        String value = prop.getProperty(key);
        if (value != null) {
            return Boolean.parseBoolean(value);
        }
        return defaultValue;
    }
}