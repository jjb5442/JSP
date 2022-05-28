package Servlet_Chapter_03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetOrPost")
public class GetOrPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Method Call");
		
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<h1>doGet Method</h1>");
		out.print("<h3> ID : " + id + "</h3>");
		out.print("<h3> Password : " + password + "</h3>");
		out.print("</body></html>");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost Method Call");
		
		response.setContentType("text/html; charset=utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<h1>doPost Method</h1>");
		out.print("<h3> ID : " + id + "</h3>");
		out.print("<h3> Password : " + password + "</h3>");
		out.print("</body></html>");
		out.close();
	}

}



