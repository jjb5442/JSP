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
			System.out.println("====ȸ�� ���� �ý���====");
			System.out.println("   1.ȸ�� ���");
			System.out.println("   2.ȸ�� ���");
			System.out.println("   3.ȸ�� �˻�");//ID�� �������� �˻�,����,����
			System.out.println("   4.ȸ�� ����");//���� : ��й�ȣ,���ϸ���,�ּ�
			System.out.println("   5.ȸ�� ����");
			System.out.println("   6.����");
			System.out.print("���� : ");
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