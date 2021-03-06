package JDBC;

import java.sql.SQLException;
import java.util.Scanner;

import Member.DAO;

public class JDBCMember_Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DAO dao = new DAO();
		Scanner sc = new Scanner(System.in);
		int Select;
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
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				return;
			}
		}
	}

}
