package cn.sosopd.common.util;

import cn.sosopd.user.entity.SosopdUser;

public class UserTokenLocal {

    private static ThreadLocal<SosopdUser> local = new ThreadLocal<>();

    public static void setUser(SosopdUser user) {
        local.set(user);
    }

    public static SosopdUser getCurrentUser() {
        return local.get();
    }
}
