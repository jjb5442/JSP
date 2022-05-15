package Servlet_Chapter_05;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
    	System.out.println("LifeCycle ������ ȣ��");
    }
	public void init(ServletConfig config) throws ServletException {
    	System.out.println("init() ȣ��");
	}
	public void destroy() {
    	System.out.println("destroy() ȣ��");
	}

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("service() ȣ��"); }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doGet() ȣ��");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doPost() ȣ��");
	}
	
	@PostConstruct
	private void MyPostConstruct() {
		System.out.println("MyPostConstruct() ��ó�� �޼ҵ� ȣ��");
	}
	
	@PreDestroy
	private void MyPreDestroy() {		
		System.out.println("MyPreDestroy() ��ó�� �޼ҵ� ȣ��");
	}

}











