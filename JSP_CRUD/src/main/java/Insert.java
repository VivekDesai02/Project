

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empDao.EmpMySql;
import pojo.EmpPojo;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		int salary = Integer.parseInt(request.getParameter("salary"));
//		pw.print(name + " " + city + " " + salary);
		
		EmpPojo ep = new EmpPojo();
		ep.setName(name);
		ep.setCity(city);
		ep.setSalary(salary);
		
//		request.setAttribute("data", ep);
		
		EmpMySql ems = new EmpMySql();
		int Status = ems.add(ep);
		
		if(Status == 1) {
//			request.getRequestDispatcher("empData.jsp").include(request, response);
			response.sendRedirect("empData.jsp");
		}else {
			pw.print("<h3>Data Not Inserted!!</h3>");
			request.getRequestDispatcher("Add.jsp").include(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
