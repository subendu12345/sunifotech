package info.sun.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sun.student.application.NewApplicationFrom;

/**
 * Servlet implementation class StudentApplicationFrom
 */
@WebServlet("/StudentApplicationFrom")
public class StudentApplicationFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentApplicationFrom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 String student_name = request.getParameter("studentname");
		 String student_add = request.getParameter("studentadd" );
		 String student_parent = request.getParameter("fatherName");
		 int course_id = Integer.parseInt(request.getParameter("course_id"));
		 String student_quly = request.getParameter("cualifi");
		 int student_marks = Integer.parseInt(request.getParameter("marks"));
		 String student_contact = request.getParameter("contact");
		 String student_password = request.getParameter("pass");
		 
		 try
		 {
			 NewApplicationFrom applicationFrom= new NewApplicationFrom(student_name, student_add, student_parent, course_id, student_quly, student_marks, student_contact, student_password);
			 if(applicationFrom.saveApplication()) {
				// PrintWriter out = response.getWriter();
				 int id = applicationFrom.getRoll();
					out.println("<html><head>");
					out.println("</head>");
					out.println("<body>");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Your Application is Successfully Submited\"Hello\"')");
					out.println("alert('And Your User ID is "+id+" ')");
					out.println("location='home.jsp';");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
				
			 }
			 else
			 {
				 out.println("Sorry You do not filup the from courectly!!!!");
			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
	}

}
