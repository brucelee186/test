package framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	/*
	 * servlet的生命周期
	 * 一 初始化
	 * 1 servlet容器初始化把.class文件读入到内存中
	 * 2 servlet容器创建servletConfig对象,servletConfig包含了servlet的初始化配置信息
	 * 3 servlet容器创建servlet对象
	 * 4 servlet对象调用init方法,初始化servlet
	 */
	private static final long serialVersionUID = -6599066181483422524L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		printWriter.println("<HTML>");
		printWriter.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		printWriter.println("  <BODY>");
		printWriter.println(" This is ");
		printWriter.println(this.getClass());
		printWriter.println("using doGet method");
		printWriter.println("  </BODY>");
		printWriter.println("</HTML>");
		Cookie[] cookieArray = req.getCookies();
		if(cookieArray != null && cookieArray.length > 0) {
			for (int i = 0; i < cookieArray.length; i++) {
				Cookie cookie = cookieArray[i];
				String name = cookie.getName();
				if (name.equals("username")) {
					printWriter.println("cookie.username: " + cookie.getValue());
				}
				if (name.equals("lastLoginDate")) {
					printWriter.println("cookie.lastLoginDate: " + cookie.getValue());
				}
			}
		}
		// 输出字符串,并清空缓存
		printWriter.flush();
		printWriter.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		if ("neo".equals(name) && "123".equals(password)) {
			out.print("欢迎你" + name);
			
			Cookie cookie = new Cookie("username", name);
			Cookie cookie2 = new Cookie("lastLoginDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			cookie.setMaxAge(60*60*60*12*30);
			cookie2.setMaxAge(60*60*60*12*30);
			resp.addCookie(cookie);
			resp.addCookie(cookie2);
			out.println("Cookie保存成功!");
			out.println("<br><br>") ;
			out.println("<a href=GetCookie02>读取Cookie</a>") ;
		} else {
			out.print(" 用户名或密码不对！ ");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
