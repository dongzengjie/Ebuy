package com.example.demo.dzj.ebuy.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dzj.ebuy.entity.User;

public class ManagerInterceptor implements HandlerInterceptor {

	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user !=null) {
			return true;
		}else {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('" + request.getContextPath()
					+ "/tologin','_self')");
					
			out.println("</script>");
			out.println("</html>");
			return false;
		}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	


	

}
