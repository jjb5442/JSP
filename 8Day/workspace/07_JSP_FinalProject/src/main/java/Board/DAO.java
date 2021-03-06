package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	public  final static int LIMIT_PAGE = 10;
	private final String TABLE_NAME = "itbank_board";
	private final String COL_NO = "no";
	private final String COL_TITLE = "title";
	private final String COL_CONTENT = "content";
	private final String COL_ID = "id";
	private final String COL_REGIST = "regist";
	private final String COL_VALIABLE = "valiable";
	
	private final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + 
										COL_NO + 			" number primary key, " + 
										COL_TITLE + 		" varchar2(40) not null, " + 
										COL_CONTENT + 		" varchar2(2048) not null, " + 
										COL_ID + 			" varchar2(30) not null, " + 
										COL_REGIST + 		" date not null, " + 
										COL_VALIABLE + 		" number default 1)";
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
	
	public int getNextNO() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs= null;
		ps = con.prepareStatement("select no from " + TABLE_NAME + " order by no desc");
		rs = ps.executeQuery();
		int no = 1;
		if(rs.next())
			no = rs.getInt("no") + 1;
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return no;
	}
	
	public void insert(DTO board) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement("insert into " + TABLE_NAME + " values(?,?,?,?,sysdate,1)");
		ps.setInt(1, getNextNO());
		ps.setString(2,board.getTitle());
		ps.setString(3,board.getContent());
		ps.setString(4,board.getId());
		int result = ps.executeUpdate();
		if(ps != null)ps.close();
	}
	
	public ArrayList<DTO> getBoardList(int pageNum) throws SQLException{
		int endPage = getNextNO() - 1 - (pageNum - 1) * LIMIT_PAGE;
		int startPage = endPage - (LIMIT_PAGE - 1);
		System.out.println("Start : " + startPage + " end : " + endPage);
		ArrayList<DTO> BoardList = new ArrayList<DTO>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement("select * from " + TABLE_NAME + 
				" where valiable = 1 and no >=" + startPage + " and no <= " + endPage + " order by no desc");
		rs = ps.executeQuery();
		while(rs.next()) {
			DTO board = new DTO(rs.getInt("no"),
								rs.getString("title"),
								rs.getString("content"),
								rs.getString("id"),
								rs.getDate("regist"),
								rs.getInt("valiable"));
			BoardList.add(board);
		}
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return BoardList;
	}
	
	public DTO getBoard(int no) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = con.prepareStatement("select * from " + TABLE_NAME + " where no = ?");
		ps.setInt(1, no);
		rs = ps.executeQuery();
		DTO board;
		if(rs.next()) {
			board = new DTO(rs.getInt("no"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("id"),
							rs.getDate("regist"),
							rs.getInt("valiable"));
		}else {
			board = null;
		}
		if(rs != null)rs.close();
		if(ps != null)ps.close();
		return board;
		
	}
	
	public void Update(DTO board) throws SQLException {
		PreparedStatement ps = null;
		ps = con.prepareStatement("update " + TABLE_NAME + " set title=?, content=? where no=?");
		ps.setString(1, board.getTitle());
		ps.setString(2, board.getContent());
		ps.setInt(3, board.getNo());
		int result = ps.executeUpdate();
		if(ps != null)ps.close();
	}
}















