package com.zimo.mybaties.constants;

public class TokenConstants {

    /**
     * 缓存中student的key
     */
    public static final String CACHE_STUDENT_KEY = "token-student-";

    public static final String CACHE_ADMIN_KEY = "token-admin-";

    public static final String REQUEST_ATTRIBUTE_STUDENT_KEY = "token-student";


    public static final Long ACCESS_TOKEN_EXP_TIME = 2*24*60*60*1000l;

    public static final Long REFRESH_TOKEN_EXP_TIME = 15*24*60*60*1000l;
}
