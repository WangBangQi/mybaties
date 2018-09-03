package com.zimo.mybaties.interceptor;

import com.zimo.mybaties.annoation.Access;
import com.zimo.mybaties.annoation.Token;
import com.zimo.mybaties.constants.TokenConstants;
import com.zimo.mybaties.dao.StudentMapper;
import com.zimo.mybaties.dto.student.StudentCacheDto;
import com.zimo.mybaties.model.Role;
import com.zimo.mybaties.model.Student;
import com.zimo.mybaties.service.StudentService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        //获取Token注解
        Token token = method.getAnnotation(Token.class);
        if (token == null)
            //表示不需要任何的登录和权限限制
            return true;


        //获取方法上的Access注解
        Access access = method.getAnnotation(Access.class);
        if (access==null)
            //为null，说明没有改access注解，不需要判断权限验证
            return true;
        Integer studentId = Integer.valueOf(request.getHeader(TokenConstants.REQUEST_ATTRIBUTE_STUDENT_KEY));
        Student student = studentMapper.searchById(studentId);
        List<Role> roles = student.getStudentRole().getRoles();
        if (access.permission()!=null){
            for (Role role : roles){
                if (role.getRoleName().equals(access.permission()))
                    return true;
            }
        }
        return false;
    }
}
