package com.nhc.ajaxserver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res=(HttpServletResponse)response;

        HttpServletRequest req=(HttpServletRequest)request;

        String origin =req.getHeader("Origin");

        if(!org.springframework.util.StringUtils.isEmpty(origin)){
            res.addHeader("Access-Control-Allow-Origin",origin); //当请求携带cookie的时候，不能为*
        }

        res.addHeader("Access-Control-Allow-Methods","*");

        //支持所有自定义头
        String header=req.getHeader("Access-Control-Request-Headers");
        System.out.println("Access-Control-Request-Headers"+header);

        if(!org.springframework.util.StringUtils.isEmpty(header)&& header!=null ){
            res.addHeader("Access-Control-Allow-Headers",header);
        }
/*
        res.addHeader("Access-Control-Allow-Headers","x-header2,x-requested-with,x-header1");
*/

/*
        res.addHeader("Access-Control-Max-Age","3600"); //缓存非简单请求的预解命令
*/
        //enable cookie（请求带有cookie则必须要加上这个字段）;
        res.addHeader("Access-Control-Allow-Credentials","true");

        chain.doFilter(request,response);
    }
}
