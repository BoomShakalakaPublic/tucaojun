/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.HttpSessionRequiredException;



/**
 *
 * @author gao
 */
public class authFilter implements Filter{
    
    private ArrayList<String> urlList;
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
        String urls = fc.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());

                 }
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
	HttpServletResponse response = (HttpServletResponse) sr1;
        String url = request.getServletPath();
        boolean allowed=false;
        if(urlList.contains(url)){
            allowed=true;
        }
        if(!allowed){
            HttpSession session = request.getSession(false);
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            try{
                if(null==session || null==session.getAttribute("user")){

                    httpResponse.sendRedirect(request.getContextPath()+"/login");

                }
                else{
                    fc.doFilter(sr, sr1);
                }
            }catch( HttpSessionRequiredException e){
                httpResponse.sendRedirect(request.getContextPath()+"/login");
            }
        }
        return;
        
    }
        

    @Override
    public void destroy() {
        
    }



        
}
    

