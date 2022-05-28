package Servlet_Quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrintGuGuDan")
public class PrintGuGuDan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrintGuGuDan() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int Start = Integer.parseInt(request.getParameter("Start"));
		int End = Integer.parseInt(request.getParameter("End"));
		
		PrintWriter out = response.getWriter();
		out.print("<html><head></head><body>");
		

		out.print("<table bgcolor='#ACFA58' border=1 width=800 align=center>");
		out.print("<tr>");
		for(int i = Start ; i <= End ; i++)
			out.print("<th>" + i + "´Ü</th>");
		for(int i = 1 ; i <= 9 ; i++){
			out.print("<tr>");
			for(int dan = Start ; dan <= End ; dan++){
				out.print("<td>" + dan + " X " + i + " = " + (dan * i) + "</td>");
			}
			out.print("</tr>");
		}
		out.print("</tr>");
		out.print("</table>");
		out.print("</body></html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}



