package com.springboot.filterinterceptoraspect.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class InterceptorHandler implements HandlerInterceptor {
    /**
     * 控制器方法处理之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("preHandle");
    System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
    System.out.println(((HandlerMethod) handler).getMethod().getName());
    request.setAttribute("startTime", new Date().getTime());
    return true;
    // return false:表示拦截，return true:表示不拦截
  }

    /**
     * 控制器方法处理之后 控制器方法调用不抛异常调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    System.out.println("postHandle");
    Long startTime = (Long) request.getAttribute("startTime");
    System.out.println("interceptor 耗时：" + (new Date().getTime() - startTime));
  }

    /**
     * 控制器方法抛不抛异常都会被调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    System.out.println("afterCompletion");
    Long startTime = (Long) request.getAttribute("startTime");
    System.out.println("interceptor 耗时：" + (new Date().getTime() - startTime));
  }
}
