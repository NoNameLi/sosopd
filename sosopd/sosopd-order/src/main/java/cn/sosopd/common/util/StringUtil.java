package cn.sosopd.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
 
import com.alibaba.fastjson.JSON;

/**
 * 字符串工具类
 * 
 * @author Tiny
 *
 */
public class StringUtil {

    /**
     * 判断是否为json
     * 
     * @param str
     * @return
     */
    public static boolean isJson(String str) {
        if (StringUtils.isEmpty(str))
            return false;
        try {
            JSON.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否为Long
     * 
     * @param str
     * @return
     */
    public static boolean isLong(String str) {
        if (StringUtils.isEmpty(str))
            return false;
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否为Integer
     * 
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (StringUtils.isEmpty(str))
            return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否为Float
     * 
     * @param str
     * @return
     */
    public static boolean isFloat(String str) {
        if (StringUtils.isEmpty(str))
            return false;
        try {
            Float.parseFloat(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否为Integer
     * 
     * @param str
     * @return
     */
    public static BigDecimal isBigDecimal(String str) {
        if (StringUtils.isEmpty(str))
            return null;
        try {
            return new BigDecimal(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 格式化字符串，如果字符串为空,则返回""
     * 
     * @param str
     * @return
     */
    public static String formatStr(Object str) {
        if (null == str || "".equals(str)) {
            return "";
        } else {
            return str.toString();
        }
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * 
     * @param params
     *            需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, Object> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = (String) params.get(key);

            // 拼接时，不包括最后一个&字符
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }

    public static String getStringFromMap(Map<String, Object> map, String key, String defaultValue) {
        if (key == "" || key == null) {
            return defaultValue;
        }
        String result = (String) map.get(key);
        if (result == null) {
            return defaultValue;
        } else {
            return result;
        }
    }

    public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
        }
        return tInputStringStream;
    }

    public static int getIntFromMap(Map<String, Object> map, String key) {
        if (key == "" || key == null) {
            return 0;
        }
        if (map.get(key) == null) {
            return 0;
        }
        return Integer.parseInt((String) map.get(key));
    }
    
    /**
     * 转换成小写
     * 
     * @param str
     * @return
     */
    public static String exChangeToLower(String str) {
        StringBuffer sb = new StringBuffer();
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 转换成大写
     * 
     * @param str
     * @return
     */
    public static String exChangeToUpper(String str) {
        StringBuffer sb = new StringBuffer();
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取字符串中第一数 例 1，12，1257
     * 
     * @param str
     * @return
     */
    public static int getFirstNumFromString(String str) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1));
        }
        return 0;
    }

    /**
     * 获取从开始到第一个数字汉字之间的子串
     * 
     * @param str
     * @return
     */
    public static String getBeginToFirstNum(String str) {
        Pattern pt = Pattern.compile("(一|二|三|四|五|六|七|八|九|十)");
        Matcher matcher = pt.matcher(str);
        if (matcher.find(1)) {
            return str.substring(0, matcher.start());
        }
        return str;
    }

    /**
     * 使用 StringBuilder 拼接字符串
     * 
     * @param strs
     * @return
     */
    public static String appendStr(String... strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (StringUtils.isNoneEmpty(strs[i]))
                sb.append(strs[i]);
        }
        return sb.toString();
    }
}
