package Member;

import java.sql.Date;
public class DTO {
	private int 	no;
	private String 	id;
	private String 	password;
	private String 	name;
	private String 	birthday;
	private String 	address;
	private String 	email;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public DTO(int no, String id, String password, String name, 
			String birthday, String address, String email) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
