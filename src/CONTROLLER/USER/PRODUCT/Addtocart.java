package CONTROLLER.USER.PRODUCT;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Cgiohang;
import MODEL.Giohang;
import MODEL.User;

/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/Addtocart")
public class Addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session=request.getSession();
	  try{
				User u=(User)session.getAttribute("user");
		      	if(u!=null)
		      	{
			   		 Giohang gh=new Giohang();
			   		 int id_sp =Integer.parseInt( request.getParameter("addcart"));
			   		 int  soluong =Integer.parseInt(request.getParameter("soluong"));
			   		 gh.setId_user(u.getId_user());
			   		 gh.setId_sp(id_sp);
			   		 gh.setSoluong(soluong);
			   		 
			   			Cgiohang.themgiohang(gh);
			   			
			   		 }
			  }
	   		 catch(Exception e)
	   		 {
	   			
	   		 }
	  response.sendRedirect(request.getContextPath()+"/Loadcart");
	  
	}
}
