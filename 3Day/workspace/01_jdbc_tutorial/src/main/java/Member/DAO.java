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
	
	public String getCOL_NO() {
		return COL_NO;
	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public String getCOL_PASSWORD() {
		return COL_PASSWORD;
	}

	public String getCOL_MILEAGE() {
		return COL_MILEAGE;
	}

	public String getCOL_ADDRESS() {
		return COL_ADDRESS;
	}

	public String getCOL_REGISTER() {
		return COL_REGISTER;
	}

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
			System.out.println("???? ???????? ??????????.");
			return;
		}
		PreparedStatement ps = null;
		ps = con.prepareStatement(CREATE_TABLE);
		int result = ps.executeUpdate();
		System.out.println("result : " + result);
		System.out.println("?????? ????????.");
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
			System.out.println("???? ???????? ????????????.");
			return;
		}
		PreparedStatement ps = con.prepareStatement(CREATE_SEQUENCE);
		int result = ps.executeUpdate();
		System.out.println("?????? ????????.");
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
	
	private DTO GetResultDTO(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String id = rs.getString("id");
		String password = rs.getString("password");
		int mileage = rs.getInt("mileage");
		String address = rs.getString("address");
		Date register = rs.getDate("register");
		return new DTO(no, id, password, mileage, address, register);
	}
	
	public void Print() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = con.prepareStatement("select * from " + TABLE_NAME);
		rs = ps.executeQuery();
		boolean Check = false;
		while(rs.next()) {
			Check =  true;
			GetResultDTO(rs).Print();
		}
		if(Check == false)
			System.out.println("?????? ?????? ????????.");
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
	
	public boolean SearchID(String ID,boolean PrintStatus)  throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement("select * from " + TABLE_NAME + " where id=?");
		ps.setString(1, ID);
		rs = ps.executeQuery();
		if(rs.next()) {
			if(PrintStatus == true)
				GetResultDTO(rs).Print();

			if(rs != null)rs.close();
			if(ps != null)ps.close();
			return true;
		}
		else
		{
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			return false;
		}	
	}
	
	public void DeleteID(String ID) throws SQLException{
		if(SearchID(ID,true) == true) {
			PreparedStatement ps = null;
			ps = con.prepareStatement("delete " + TABLE_NAME + " where id=?");
			ps.setString(1, ID);
			int result = ps.executeUpdate();
			System.out.println("????????!");
			if(ps != null)ps.close();
		}else {
			System.out.println("???????? ???????? ????????.");
		}
	}
	
	public void ModifyID(String ID,String Col_Name,String value) throws SQLException {
		if(SearchID(ID,false) == true) {
			PreparedStatement ps = null;
			String SQL = "update " + TABLE_NAME + " set " + Col_Name + "=? where id=?";
			ps = con.prepareStatement(SQL);
			ps.setString(1, value);
			ps.setString(2, ID);
			int result = ps.executeUpdate();
			if(ps != null) ps.close();
		}
	}
}





