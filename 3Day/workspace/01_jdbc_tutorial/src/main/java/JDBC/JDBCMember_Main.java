package JDBC;

import java.sql.SQLException;
import java.util.Scanner;

import Member.DAO;

public class JDBCMember_Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void Modify(DAO dao) throws SQLException {
		String id = new String();
		String value = new String();
		System.out.println("검색할 아이디 입력 : ");
		id = sc.next();
		if(dao.SearchID(id,false) == false)
			return;
		while(true) {
			dao.SearchID(id,true);
			System.out.println("수정할 컬럼을 선택하시오");
			System.out.println(" 1.비밀번호");
			System.out.println(" 2.마일리지");
			System.out.println(" 3.주소");
			System.out.println(" 4.종료");
			System.out.print("선택 : ");
			int Select = sc.nextInt();
			switch(Select) {
			case 1:
				System.out.print("수정할 비밀번호 입력 : ");
				value = sc.next();
				dao.ModifyID(id, dao.getCOL_PASSWORD(), value);
				break;
			case 2:
				System.out.print("수정할 마일리지 입력 : ");
				value = sc.next();
				dao.ModifyID(id, dao.getCOL_MILEAGE(), value);
				break;
			case 3:
				System.out.print("수정할 주소 입력 : ");
				value = sc.next();
				dao.ModifyID(id, dao.getCOL_ADDRESS(), value);
				break;
			case 4:
				return;
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DAO dao = new DAO();
		int Select;
		String id = new String();
		while(true) {
			System.out.println("====회원 관리 시스템====");
			System.out.println("   1.회원 등록");
			System.out.println("   2.회원 목록");
			System.out.println("   3.회원 검색");//ID를 기준으로 검색,삭제,수정
			System.out.println("   4.회원 삭제");//수정 : 비밀번호,마일리지,주소
			System.out.println("   5.회원 수정");
			System.out.println("   6.종료");
			System.out.print("선택 : ");
			Select = sc.nextInt();
			switch (Select) {
			case 1:
				dao.Insert();
				break;
			case 2:
				dao.Print();
				break;
			case 3:
				System.out.println("검색할 아이디 입력 : ");
				id = sc.next();
				dao.SearchID(id,true);
				break;
			case 4:
				System.out.println("삭제할 아이디 입력 : ");
				id = sc.next();
				dao.DeleteID(id);
				break;
			case 5:
				Modify(dao);
				break;
			case 6:
				return;
			}
		}
	}

}
