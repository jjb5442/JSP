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
		
		//Connection ����
		con = DriverManager.getConnection(url,user,password);
		System.out.println("Success Connection!");
		
		PreparedStatement ps = null;//SQL��ɹ� ������ ����ϴ� ��ü
		ResultSet rs = null;//SQL���� �� ���޹��� �����Ͱ� ����ִ� ��ü
		
		//SQL��ɾ� ���� �غ�
		ps = con.prepareStatement("select tname from tab");
		//executeQuery() : SQL ��ɾ ������ �� ����� ResultSet���� ��ȯ
		rs = ps.executeQuery();
		
		//rs.next() : ������ �����Ͱ� �����ִ��� Ȯ���ϴ� Method
		while(rs.next()) {
			System.out.println("Table Name : " + rs.getString("tname"));
		}
		//close() : ��ü �Ҵ� ����
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
