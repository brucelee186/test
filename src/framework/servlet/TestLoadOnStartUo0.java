package framework.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class TestLoadOnStartUo0 extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.err.println("Servlet加载成功... 初始加载的方法写在这里");
	}
}
