package vo;

public class LoginVo {
	
	private int id;
	private String un;
	private String pw;
	private String user_type;
	private String name;
	private String authent;
	
	public String getAuthent() {
		return authent;
	}
	public void setAuthent(String authent) {
		this.authent = authent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
