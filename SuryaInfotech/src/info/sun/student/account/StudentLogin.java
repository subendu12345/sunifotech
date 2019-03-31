package info.sun.student.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.sun.student.dao.StudentLogInSuccess;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/studentlogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("u_ID" ));
		String password = request.getParameter("pass");
		
		try
		{
			StudentLogInSuccess inSuccess = new StudentLogInSuccess(id, password);
			if(inSuccess.success())
			{
				if(inSuccess.getIs_acteve()== 1) 
				{
					String name = inSuccess.getName(id);
					HttpSession session = request.getSession();
					session.setAttribute("studentname", name);
					response.sendRedirect("home.jsp");
				}
				if(inSuccess.getIs_acteve()== 0)
				{
					System.out.println("Your Account is not active , Please Contact Admin");
					PrintWriter out = response.getWriter();
					out.println("<html><head>");
					out.println("</head>");
					out.println("<body>");
					 out.println("<script type=\"text/javascript\">");
					   out.println("alert('Your Account is not active mode, Please Contact Admin');");
					   out.println("location='home.jsp';");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				}
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			id=0;
			password=null;
		}
	}
	

}
