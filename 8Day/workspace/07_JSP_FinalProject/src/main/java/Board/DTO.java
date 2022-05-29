package Board;

import java.sql.Date;

public class DTO {
	private int no;
	private String title;
	private String content;
	private String id;
	private Date regist;
	private int valiable;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public DTO(int no, String title, String content, String id, Date regist, int valiable) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regist = regist;
		this.valiable = valiable;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegist() {
		return regist;
	}

	public void setRegist(Date regist) {
		this.regist = regist;
	}

	public int getVailable() {
		return valiable;
	}

	public void setVailable(int vailable) {
		this.valiable = vailable;
	}
	
	
}
