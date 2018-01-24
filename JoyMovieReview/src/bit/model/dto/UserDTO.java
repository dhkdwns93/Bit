package bit.model.dto;

public class UserDTO {

	private String user_id; 		
	private String pwd; 			
	private String name; 			
	private String gender; 		
	
	public UserDTO() {}
	
	public UserDTO(String user_id, String pwd) {
		super();
		this.user_id = user_id;
		this.pwd = pwd;
	}
	
	public UserDTO(String user_id, String pwd, String name) {
		super();
		this.user_id = user_id;
		this.pwd = pwd;
		this.name = name;
	}
	
	

	public UserDTO(String user_id, String pwd, String name, String gender) {
		super();
		this.user_id = user_id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
