package Servlet_Chapter_06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String[] language = request.getParameterValues("language");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head></head><body>");
		out.print("아이디 : " + id + "<br/>");
		out.print("관심언어 : " + Arrays.toString(language) + "<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("직종 : " + job+ "<br/>");
		out.print("</body><html>");
		out.close();
	}

}







