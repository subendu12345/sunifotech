package info.sun.student.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=87;
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Your Application is"+id+" Successfully Submited\"Hello\"')");
		out.println("location='home.jsp';");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
