package framework.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;

import framework.struts1.form.CustomerForm;

public class CustomerAction extends DispatchAction {

	public ActionForward testStruts1(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm form = (CustomerForm) actionForm;
		String name = form.getName();
		String password = form.getPassword();
		System.err.println(name);
		System.err.println(password);
		return null;
	}
}
