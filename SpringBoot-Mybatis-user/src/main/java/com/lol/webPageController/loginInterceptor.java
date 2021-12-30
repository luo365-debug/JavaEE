package com.lol.webPageController;

import com.sun.istack.internal.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆检查
 * 1.配置拦截器
 * 2.把配置放入容器 adminWebConfig
 * */
public class loginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行前
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆检查
        HttpSession httpSession=request.getSession();
        Object loginUser=httpSession.getAttribute("loginUser");

        if(loginUser!=null){
            //放行
            return true;
        }
        //未登录 拦截，重定向返回登录页
        response.sendRedirect("/");
        return false;
    }

    /**
     * 目标方法执行完成后
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    /**
     * 页面渲染后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
