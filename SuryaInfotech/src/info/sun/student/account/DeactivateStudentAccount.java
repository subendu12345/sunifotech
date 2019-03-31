package info.sun.student.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sun.student.dao.ActiveAccount;
import info.sun.student.dao.DeactivateSudent;

/**
 * Servlet implementation class DeactivateStudentAccount
 */
@WebServlet("/deactivate")
public class DeactivateStudentAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeactivateStudentAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("u"));
		try 
		{
			DeactivateSudent account = new DeactivateSudent(id);
			if(account.deactiveAccount())
				response.sendRedirect("student-deatial.jsp");
			else {
				out.println("Somthing wrong");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
