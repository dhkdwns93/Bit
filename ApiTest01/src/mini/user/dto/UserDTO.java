package mini.user.dto;

public class UserDTO {
	private String userId;
	private String pwd;
	private String name;
	private String gender;
	
	public UserDTO(String userId, String pwd) {
		
		this.userId = userId;
		this.pwd = pwd;
	}

	public UserDTO(String userId, String pwd, String name, String gender) {

		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;

	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
