package cn.sosopd.common.helper;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserTokenManager {

    /** 将token存储到JVM内存(ConcurrentHashMap)中 */
    private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

    /**
     * @description 利用UUID创建Token(用户登录时，创建Token)
     * @created 2017年7月4日 下午4:46:46
     * @param username
     * @return
     */
    public String createToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, username);
        return token;
    }

    /**
     * @description Token验证(用户登录验证)
     * @created 2017年7月4日 下午4:46:50
     * @param token
     *            正确返回true
     * @return
     */
    public boolean checkToken(String token) {
        return StringUtils.isNotEmpty(token) && tokenMap.containsKey(token);
    }

    /**
     * @description Token删除(用户登出时，删除Token)
     * @created 2017年7月4日 下午4:46:54
     * @param token
     */
    public void deleteToken(String token) {
        tokenMap.remove(token);
    }

}
