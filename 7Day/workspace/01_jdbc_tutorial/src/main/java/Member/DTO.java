package Member;

import java.sql.Date;
import java.util.Scanner;

public class DTO {
	private int no;
	private String id;
	private String password;
	private int mileage;
	private String address;
	private Date register;
	
	public DTO() {
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 아이디 : ");
		id = sc.next();
		System.out.print("회원 비밀번호 : ");
		password = sc.next();
		System.out.print("회원 주소 : ");
		address = sc.next();
	}

	public DTO(int no, String id, String password, int mileage, String address, Date register) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.mileage = mileage;
		this.address = address;
		this.register = register;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}
	
	public void Print() {
		System.out.print(no + "\t");
		System.out.print(id + "\t");
		System.out.print(password + "\t");
		System.out.print(mileage + "\t");
		System.out.print(address + "\t");
		System.out.println(register);
	}
	
}
