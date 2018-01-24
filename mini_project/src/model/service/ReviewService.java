package model.service;

import java.util.List;

import model.dto.Reviews;

public interface ReviewService {
	
	int insertReview(Reviews review) throws Exception;
	
	int updateReivew(Reviews review) throws Exception;
	
	Reviews selectReviewUserId(String userId) throws Exception;
	
	
	boolean pwdCheck( String reId, String rePwd) throws Exception;
	
	
	Reviews selectStar(String movieId) throws Exception;
	
	
	List<Reviews> selectAllReview() throws Exception;
	
	int updateSelectByreIdAndUserIdOrRePwd(String reId, String userId, String rePwd) throws Exception;
}
