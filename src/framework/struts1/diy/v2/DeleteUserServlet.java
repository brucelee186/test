package framework.struts1.diy.v2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 9028960025593325158L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserManager userManager = new UserManager();
		String userName = req.getParameter("userName");
		userManager.delete(userName);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.err.println("doPost");
		this.doGet(req, resp);
	}
}
