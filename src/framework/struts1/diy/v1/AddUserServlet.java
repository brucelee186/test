package framework.struts1.diy.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 9028960025593325158L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.err.println("doGet");
		String userName = req.getParameter("userName");
		UserManager userManager = new UserManager();
		userManager.add(userName);
		req.getRequestDispatcher("/jsp/diyStruts1/sucess.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.err.println("doPost");
		this.doGet(req, resp);
	}
}
