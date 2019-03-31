package info.sun.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminAuthentication
 */
@WebServlet("/adminauth")
public class AdminAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminName = request.getParameter("adminName");
		String passWord = request.getParameter("adminPass");
		System.out.println("Hello Admin Authentication");
		String name = "subendu";
		String pass = "skmoon@mal3";
		if(adminName.equalsIgnoreCase(name) && passWord.equalsIgnoreCase(pass)) 
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("adminName", name);
			response.sendRedirect("admin-home.jsp");
			
		}
		else {
			response.sendRedirect("adminauth.jsp");
		}
	}

}
