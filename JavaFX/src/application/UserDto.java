package application;

public class UserDto {
	
	private int no;
	private String id;
	private String pw;
	
	public UserDto(int no, String id, String pw) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
