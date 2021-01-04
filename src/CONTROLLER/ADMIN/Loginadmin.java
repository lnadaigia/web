package CONTROLLER.ADMIN;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import DAO.Cuser;
import MODEL.User;

/**
 * Servlet implementation class Loginadmin
 */
@WebServlet("/Loginadmin")
public class Loginadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session=request.getSession();
   		String url = "/admin/login.jsp";
	   try {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		User u=Cuser.getUserbyid(uname, pass);
		if(u!=null &&u.getPermission().equals("1"))
		{
			session.setAttribute("admin", u);
			url="/quanli";
		}
		else
			request.setAttribute("sai", "sai tài khoản hoặc mật khẩu");
	} catch (Exception e) {
		// TODO: handle exception
	}
	   resp.sendRedirect(request.getContextPath()+"/quanli");
}

}
