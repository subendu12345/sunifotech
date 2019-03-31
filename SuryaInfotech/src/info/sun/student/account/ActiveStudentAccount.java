package info.sun.student.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sun.student.dao.ActiveAccount;

/**
 * Servlet implementation class ActiveStudentAccount
 */
@WebServlet("/active")
public class ActiveStudentAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveStudentAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("This the student Activate Page");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("u"));
		try 
		{
			ActiveAccount account = new ActiveAccount(id);
			if(account.activeAccount())
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
