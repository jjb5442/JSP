package Servlet_Chapter_04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CatChoice")
public class CatChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CatChoice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String[] Cat = request.getParameterValues("cat");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		
		out.print("<table align='center'>");
		out.print("<tr>");
		for(String path : Cat) {
			out.print("<td>");
			out.print("<img src='" + path + "'>");
			out.print("</td>");
		}
		out.print("</tr>");
		out.print("</table></body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}









