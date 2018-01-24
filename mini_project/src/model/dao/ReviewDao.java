package model.dao;

import java.util.List;

import model.dto.Reviews;

public interface ReviewDao {
	/**
	 * 
	 * insert into reviews (re_pwd, re_title, re_star, re_content) values(?,?,?,?,?)
	 * */
	int insertReview(Reviews review) throws Exception;
	/**
	 *  
	 *  update reviews set reTitle=?, reStar=?, reContent=? where reId =?
	 */
	int updateReivew(Reviews review) throws Exception;
	/**
	 * UserId�� ���� ����Խ��� ��ȸ
	 */
	Reviews selectReviewUserId(String userId) throws Exception;
	
	/**
	 * 
	 * true �� o , false �� x
	 * 
	 * */
	boolean pwdCheck( String reId, String rePwd) throws Exception;
	
	/**
	 * 
	 *  
	 *  select userId, reTitle from reviews where movieId = ? 
	 * */
	Reviews selectStar(String movieId) throws Exception;
	
	
	List<Reviews> selectAllReview() throws Exception;
	
	int updateSelectByreIdAndUserIdOrRePwd(String reId, String userId, String rePwd) throws Exception;
}
