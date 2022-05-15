package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Main {

	public static void main(String[] args) 
			throws ClassNotFoundException,SQLException {
		//JDBC Driver loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Success Driver Load!");
		
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##jsp05";
		String password = "jsp";
		
		//Connection 연결
		con = DriverManager.getConnection(url,user,password);
		System.out.println("Success Connection!");
		
		PreparedStatement ps = null;//SQL명령문 보낼때 사용하는 객체
		ResultSet rs = null;//SQL실행 후 전달받을 데이터가 들어있는 객체
		
		//SQL명령어 전송 준비
		ps = con.prepareStatement("select tname from tab");
		//executeQuery() : SQL 명령어를 실행한 뒤 결과를 ResultSet으로 반환
		rs = ps.executeQuery();
		
		//rs.next() : 가져올 데이터가 남아있는지 확인하는 Method
		while(rs.next()) {
			System.out.println("Table Name : " + rs.getString("tname"));
		}
		//close() : 객체 할당 해제
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		
		System.out.println("\n\n");
		
		ps = con.prepareStatement("select * from testmember");
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("no") + " ");
			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getString("id") + " ");
			System.out.print(rs.getString("pw") + " ");
			System.out.print(rs.getInt("money") + " ");
			System.out.println(rs.getString("joindate"));
		}
		if(rs != null)rs.close();
		if(ps != null)ps.close();
	}

}
