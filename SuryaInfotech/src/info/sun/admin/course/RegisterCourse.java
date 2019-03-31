package info.sun.admin.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sun.admin.courseregister.NewCourse;

/**
 * Servlet implementation class RegisterCourse
 */
@WebServlet("/courseregister")
public class RegisterCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int course_id =Integer.parseInt(request.getParameter("courseID"));
		String course_name =request.getParameter("cname");
		String course_duration = request.getParameter("duration");
		
		try 
		{
			NewCourse course = new NewCourse(course_id,course_name, course_duration);
			if(course.saveCourseDetails()) {
				response.sendRedirect("admin-home.jsp");
			}
			else
				out.println("Please Enter Right Data");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		
		
	}

}
