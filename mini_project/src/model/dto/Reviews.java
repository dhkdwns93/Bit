package model.dto;

public class Reviews {
	private String reId;
	private String movieId ;
	private String rePwd;
	private String userId;
	private String reTitle;
	private String reStar;
	private String reContent;
	
	public String getReId() {
		return reId;
	}

	public void setReId(String reId) {
		this.reId = reId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
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

	public String getReStar() {
		return reStar;
	}

	public void setReStar(String reStar) {
		this.reStar = reStar;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public Reviews() {	}
	
	//리뷰 게시판 작성
	
	
	public Reviews(String reId, String reTitle, String reStar, String reContent) {
		super();
		this.reId = reId;
		this.reTitle = reTitle;
		this.reStar = reStar;
		this.reContent = reContent;
	}
	public Reviews(String reId, String movieId, String rePwd, String userId, String reTitle, String reStar,
			String reContent) {
		super();
		this.reId = reId;
		this.movieId = movieId;
		this.rePwd = rePwd;
		this.userId = userId;
		this.reTitle = reTitle;
		this.reStar = reStar;
		this.reContent = reContent;
	}
	
	
	
}
