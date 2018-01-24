package mini.board.dto;

public class ReviewDTO {
	private int reId; // 리뷰 게시판 번호 (자동증가)
	private String mId; // movieCd
	private String rePwd; // 리뷰를 남길 시 수정, 삭제시 필요한 비밀번호
	private String userId; // UserDTO
	private String reTitle;
	private double reStar;
	private String reContent;
	
	public ReviewDTO(int reId, String mId, String rePwd, String userId, String reTitle, double reStar,
			String reContent) {
		super();
		this.reId = reId;
		this.mId = mId;
		this.rePwd = rePwd;
		this.userId = userId;
		this.reTitle = reTitle;
		this.reStar = reStar;
		this.reContent = reContent;
	}

	public ReviewDTO(String mId, String rePwd, String userId,String reTitle, double reStar, String reContent) {
		super();
		this.mId = mId;
		this.rePwd = rePwd;
		this.userId=userId;
		this.reTitle = reTitle;
		this.reStar = reStar;
		this.reContent = reContent;
	}

	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReTitle() {
		return reTitle;
	}

	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}

	public double getReStar() {
		return reStar;
	}

	public void setReStar(double reStar) {
		this.reStar = reStar;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

}
