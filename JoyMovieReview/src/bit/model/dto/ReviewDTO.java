package bit.model.dto;

public class ReviewDTO {
	private String re_id;			//리뷰 게시판 번호 (자동증가) 
	private String m_id;			//API 정보 요청시 필요한 코드ID
	private String re_pwd;			//리뷰를 남길 시 수정, 삭제시 필요한 비밀번호
	private String user_id;			//UserDTO 
	private String re_title;
	private String re_star;
	private String re_content;
	
	
	public ReviewDTO(){}
	
	//삭제할때..
	public ReviewDTO(String user_id, String re_pwd) {
		this.user_id = user_id;
		this.re_pwd = re_pwd;
	}
	
	//모든 리뷰 출력 시
	public ReviewDTO(String re_id, String re_title, String user_id, String re_star, String re_content) {
		this.re_id = re_id;
		this.re_title = re_title;
		this.user_id = user_id;
		this.re_star = re_star;
		this.re_content = re_content;
	}
	
	public ReviewDTO(String re_id, String m_id, String re_pwd, String re_title, String user_id, String re_star, String re_content) {
		this.re_id = re_id;
		this.re_title = re_title;
		this.user_id = user_id;
		this.re_star = re_star;
		this.re_content = re_content;
	}
	
	//리뷰 작성 시
	public ReviewDTO(String m_id, String re_pwd, String user_id, String re_title,
			String re_star, String re_content) {
		this.m_id = m_id;
		this.re_pwd = re_pwd;
		this.user_id = user_id;
		this.re_title = re_title;
		this.re_star = re_star;
		this.re_content = re_content;
	}

	
	public String getRe_id() {
		return re_id;
	}
	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getRe_pwd() {
		return re_pwd;
	}
	public void setRe_pwd(String re_pwd) {
		this.re_pwd = re_pwd;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRe_title() {
		return re_title;
	}
	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}
	public String getRe_star() {
		return re_star;
	}
	public void setRe_star(String re_star) {
		this.re_star = re_star;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	
	
}
