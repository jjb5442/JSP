package Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private final String TABLE_NAME = "jdbc_member";
	private final String COL_NO = "no";
	private final String COL_ID = "id";
	private final String COL_PASSWORD = "password";
	private final String COL_MILEAGE = "mileage";
	private final String COL_ADDRESS = "address";
	private final String COL_REGISTER = "register";
	
	private final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
										COL_NO + " number primary key, " + 
										COL_ID + " varchar2(20) unique, " +
										COL_PASSWORD + " varchar2(20) not null, " + 
										COL_MILEAGE + " number default 1000, " +
										COL_REGISTER + " date not null, " +
										COL_ADDRESS + " varchar2(20))";
	
	private final String SEQUENCE_NAME = TABLE_NAME + "_seq";
	private final String CREATE_SEQUENCE = "create sequence " + SEQUENCE_NAME;
	private final String USE_SEQUENCE = SEQUENCE_NAME + ".nextval";
	
	private Connection con = null;
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "c##jsp05";
	private final String password = "jsp";
	
	public DAO() throws ClassNotFoundException,SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Load");
		con = DriverManager.getConnection(url,user,password);
		System.out.println("Connection");
		CreateTable();
		CreateSequence();
	}
	
	private void CreateTable() throws SQLException {
		if(CheckTable() == true){
			System.out.println("이미 테이블이 존재합니다.");
			return;
		}
		PreparedStatement ps = null;
		ps = con.prepareStatement(CREATE_TABLE);
		int result = ps.executeUpdate();
		System.out.println("result : " + result);
		System.out.println("테이블 생성완료.");
		if(ps != null) ps.close();
	}
	
	private boolean CheckTable() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select tname from tab where tname = '" + TABLE_NAME.toUpperCase() + "'");
		rs = ps.executeQuery();
		boolean Check;
		if(rs.next() == true)
			Check = true;
		else
			Check = false;
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		return Check;
	}
	
	private void CreateSequence() throws SQLException  {
		if(CheckSequence() == true) {
			System.out.println("이미 존재하는 시퀀스입니다.");
			return;
		}
		PreparedStatement ps = con.prepareStatement(CREATE_SEQUENCE);
		int result = ps.executeUpdate();
		System.out.println("시퀀스 생성완료.");
		if(ps != null)ps.close();
	}
	private boolean CheckSequence() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select sequence_name from user_sequences"
				+ " where sequence_name = '" + SEQUENCE_NAME.toUpperCase() + "'");
		rs = ps.executeQuery();
		boolean Check = rs.next();
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return Check;
	}
	
	public void Print() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select * from " + TABLE_NAME);
		rs = ps.executeQuery();
		boolean Check = false;
		while(rs.next()) {
			Check =  true;
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String password = rs.getString("password");
			int mileage = rs.getInt("mileage");
			String address = rs.getString("address");
			Date register = rs.getDate("register");
			new DTO(no, id, password, mileage, address, register).Print();
		}
		if(Check == false)
			System.out.println("저장된 회원이 없습니다.");
		if(rs != null)rs.close();
		if(ps != null)ps.close();
	}
	
	public void Insert() throws SQLException {
		PreparedStatement ps = null;
		String Insert_SQL = "insert into " + TABLE_NAME + "(" +
						COL_NO + "," + COL_ID + "," + COL_PASSWORD + "," + 
						COL_ADDRESS + "," + COL_REGISTER + ") values("+
						USE_SEQUENCE + ",?,?,?,sysdate)";
		ps = con.prepareStatement(Insert_SQL);
		DTO dto = new DTO();
		ps.setString(1,dto.getId());
		ps.setString(2,dto.getPassword());
		ps.setString(3,dto.getAddress());
		int result = ps.executeUpdate();
		System.out.println("result : " + result);
		if(ps != null) ps.close();
	}
}





