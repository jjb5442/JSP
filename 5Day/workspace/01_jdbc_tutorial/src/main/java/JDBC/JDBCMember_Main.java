package JDBC;

import java.sql.SQLException;
import java.util.Scanner;

import Member.DAO;

public class JDBCMember_Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void Modify(DAO dao) throws SQLException {
		String id = new String();
		String value = new String();
		System.out.println("�˻��� ���̵� �Է� : ");
		id = sc.next();
		if(dao.SearchID(id,false) == false)
			return;
		while(true) {
			dao.SearchID(id,true);
			System.out.println("������ �÷��� �����Ͻÿ�");
			System.out.println(" 1.��й�ȣ");
			System.out.println(" 2.���ϸ���");
			System.out.println(" 3.�ּ�");
			System.out.println(" 4.����");
			System.out.print("���� : ");
			int Select = sc.nextInt();
			switch(Select) {
			case 1:
				System.out.print("������ ��й�ȣ �Է� : ");
				value = sc.next();
				dao.ModifyID(id, dao.getCOL_PASSWORD(), value);
				break;
			case 2:
				System.out.print("������ ���ϸ��� �Է� : ");
				value = sc.next();
				dao.ModifyID(id, dao.getCOL_MILEAGE(), value);
				break;
			case 3:
				System.out.print("������ �ּ� �Է� : ");
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
				System.out.println("�˻��� ���̵� �Է� : ");
				id = sc.next();
				dao.SearchID(id,true);
				break;
			case 4:
				System.out.println("������ ���̵� �Է� : ");
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