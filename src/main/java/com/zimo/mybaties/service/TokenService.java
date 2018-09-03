package com.zimo.mybaties.service;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Target;

public interface TokenService<T> {
    T getRequestToken(HttpServletRequest request,Class<T> t,String tokenKey);
}
