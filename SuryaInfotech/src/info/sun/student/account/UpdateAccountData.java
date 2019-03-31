package info.sun.student.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.sun.student.dao.UpdateStudentData;

/**
 * Servlet implementation class UpdateAccountData
 */
@WebServlet("/updateStudent")
public class UpdateAccountData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 int id = Integer.parseInt(request.getParameter("studentId")) ;
		 String student_name = request.getParameter("studentname");
		 String student_add = request.getParameter("address" );
		 String student_parent = request.getParameter("fatherName");
		 int course_id = Integer.parseInt(request.getParameter("course_id"));
		 String student_quly = request.getParameter("cualifi");
		 int student_marks = Integer.parseInt(request.getParameter("marks"));
		 String student_contact = request.getParameter("contact");
		 
		 
		 try 
		 {
			 UpdateStudentData data = new UpdateStudentData(id, student_name, student_add, student_parent, course_id, student_quly, student_marks, student_contact);
			 if(data.updateStudent()) {
				 response.sendRedirect("student-deatial.jsp");
			 }
			 else {
				 out.println("Some Thing Went to wrong");
			 }
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
		 finally {
			id=0;
			student_add=null;
			student_contact=null;
			student_marks=0;
			student_name=null;
			student_parent=null;
			student_quly=null;
		
		}
	}

}
