package com.springboot.filterinterceptoraspect.common.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@WebFilter(filterName = "filterHandler",urlPatterns = {"/test"})
public class FilterHandler implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("filter init");
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("filter start");
    long startTime = new Date().getTime();
    HttpServletRequest  httpServletRequest = (HttpServletRequest) servletRequest;
    String token = httpServletRequest.getHeader("token");
    String name = httpServletRequest.getParameter("name");
    if(name!=null){
    filterChain.doFilter(servletRequest, servletResponse);
    long endTime = System.currentTimeMillis();
    System.out.println("filter time:" + (endTime - startTime));
    System.out.println("filter finish");
    }else{
//      servletResponse.setCharacterEncoding("UTF-8");
      servletResponse.setContentType("application/json;charset=utf-8");
      PrintWriter writer =  servletResponse.getWriter();
      Map<String,Object> map = new HashMap<>();
      map.put("code", 1);
      map.put("message", "验证不通过，过滤器进行拦截");
      // 方法1：
      /* ObjectMapper om = new ObjectMapper();
      writer.write(om.writeValueAsString(map));*/
      //方法2：
      writer.write(JSON.toJSONString(map));
      writer.flush();
      writer.close();
    }
  }

  @Override
  public void destroy() {
    System.out.println("filter destroy");
  }
}
