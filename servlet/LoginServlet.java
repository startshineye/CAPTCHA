package com.yxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
   /**对输入验证码验证(通过session)
    * 1.获取用户输入的验证码.
    * 2.获取服务器端验证码
    * 3.进行判断,提示
    * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setCharacterEncoding(charset)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.获取用户输入的验证码.
		String clientCode = request.getParameter("code");
	    //2.获取服务器端验证码
		String servletCode = (String) request.getSession().getAttribute("code");
	    //3.进行判断,提示
		if(clientCode != null && servletCode.equalsIgnoreCase(clientCode)){
			out.print("验证通过登录成功");//输入正确，登录成功
		}else{
			//验证码输入错误，重新输入
			//转发到登录页面，重新登录
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
