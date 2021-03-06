package Member;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	private final String TABLE_NAME = "java_bean_member";
	private final String COL_NO = "no";
	private final String COL_NAME = "name";
	private final String COL_ID = "id";
	private final String COL_PASSWORD = "password";
	private final String COL_BIRTHDAY = "birthday";
	private final String COL_ADDRESS = "address";
	private final String COL_EMAIL = "email";
	
	private final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + 
										COL_NO + 		" number primary key, " + 
										COL_NAME + 		" varchar2(30) not null, " + 
										COL_ID + 		" varchar2(30) unique, " + 
										COL_PASSWORD + 	" varchar2(30) not null, " + 
										COL_BIRTHDAY + 	" date not null, " + 
										COL_ADDRESS + 	" varchar2(30) not null, " + 
										COL_EMAIL + 	" varchar2(30) not null)";
	private final String SEQUENCE_NAME = TABLE_NAME + "_seq";
	private final String CREATE_SEQUENCE = "create sequence " + SEQUENCE_NAME;
	private final String USE_SEQUENCE = SEQUENCE_NAME + ".nextval";
	
	private Connection con = null;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "c##jsp05";
	private final String PASSWORD = "jsp";
	
	public DAO() throws ClassNotFoundException,SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		CreateTable();
		CreateSequence();
	}
	
	private void CreateTable() throws SQLException {
		if(CheckTable() == true)
			return;
		PreparedStatement ps = null;
		ps = con.prepareStatement(CREATE_TABLE);
		int result = ps.executeUpdate();
		System.out.println("Create Table : " + TABLE_NAME);
		if(ps != null)ps.close();
	}
	
	private boolean CheckTable() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select tname from tab");
		rs = ps.executeQuery();
		boolean Check = false;
		while(rs.next()) {
			if(rs.getString("tname").equals(TABLE_NAME.toUpperCase())) {
				System.out.println("Find Table : " + TABLE_NAME);
				Check = true;
				break;
			}
		}
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return Check;
	}
	
	private void CreateSequence() throws SQLException{
		if(CheckSequence() == true)
			return;
		PreparedStatement ps = null;
		ps = con.prepareStatement(CREATE_SEQUENCE);
		int result = ps.executeUpdate();
		System.out.println("Create Sequence : " + SEQUENCE_NAME);
		if(ps != null)ps.close();
	}
	
	private boolean CheckSequence() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select sequence_name from user_sequences");
		rs = ps.executeQuery();
		boolean Check = false;
		while(rs.next()) {
			if(rs.getString("sequence_name").equals(SEQUENCE_NAME.toUpperCase())) {
				Check = true;
				System.out.println("Find Sequence : " + SEQUENCE_NAME);
				break;
			}
		}
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return Check;
	}
	public boolean SearchID(String ID) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select id from " + TABLE_NAME + " where id = ?");
		ps.setString(1, ID);
		rs = ps.executeQuery();
		boolean Check = false;
		if(rs.next())
			Check = true;
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return Check;
	}
	
	public void Insert(DTO member) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement("insert into " + TABLE_NAME + " values(" + 
									USE_SEQUENCE + ",?,?,?,?,?,?)");
		ps.setString(1,member.getName());
		ps.setString(2,member.getId());
		ps.setString(3,member.getPassword());
		ps.setString(4,member.getBirthday());
		ps.setString(5,member.getAddress());
		ps.setString(6,member.getEmail());
		int result = ps.executeUpdate();
		System.out.println("Create Member ID : " + member.getId());
		if(ps != null)ps.close();
	}
	
	public ArrayList<DTO> GetMemberList() throws SQLException{
		ArrayList<DTO> MemberList = new ArrayList();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select * from " + TABLE_NAME);
		rs = ps.executeQuery();
		while(rs.next()) {
			DTO member = new DTO(rs.getInt(COL_NO),
								 rs.getString(COL_ID),
								 rs.getString(COL_PASSWORD),
								 rs.getString(COL_NAME),
								 rs.getString(COL_BIRTHDAY),
								 rs.getString(COL_ADDRESS),
								 rs.getString(COL_EMAIL));
			MemberList.add(member);
		}
		return MemberList;
	}
}







