package model.service;

import java.util.ArrayList;
import java.util.List;

import model.dao.ReviewDao;
import model.dao.ReviewDaoImpl;
import model.dto.Reviews;

public class ReviewServiceImpl implements ReviewService {
	ReviewDao dao = new ReviewDaoImpl();
	@Override
	public int insertReview(Reviews review) throws Exception {
		int result = dao.insertReview(review);
		if(result==0) {
			throw new Exception("등록되지 않았습니다.");
		}
		return result;
	}

	@Override
	public int updateReivew(Reviews review) throws Exception {
		int result = dao.updateReivew(review);
		if(result==0) {
			throw new Exception("수정되지 않았습니다.");
		}
		return result;
	}

	@Override
	public Reviews selectReviewUserId(String userId) throws Exception {
		Reviews review = null;
		review = dao.selectReviewUserId(userId);
		if(review.getReId()==null) {
			throw new Exception("검색되지 않습니다.");
		}
		return review;
	}

	@Override
	public boolean pwdCheck(String reId, String rePwd) throws Exception {
		boolean check = dao.pwdCheck(reId, rePwd);
		if(!check) {
			throw new Exception(reId +"와"+ rePwd+"동일하지않습니다.");
		}
		return check;
	}
	
	

	@Override
	public Reviews selectStar(String movieId) throws Exception {
		Reviews review = null;
		review = dao.selectStar(movieId);
		if(!review.getMovieId().equals(movieId)) {
			throw new Exception("영화코드가 동일하지않습니다..");
		}
		return review;
	}

	@Override
	public List<Reviews> selectAllReview() throws Exception {
		List<Reviews> list = new ArrayList<>();
		list = dao.selectAllReview();
		
		if(!list.iterator().hasNext()) {
			throw new Exception("리스트 자료가 존재하지않습니다.");
		}
		
		return list;
	}

	@Override
	public int updateSelectByreIdAndUserIdOrRePwd(String reId, String userId, String rePwd) throws Exception {
		int result = dao.updateSelectByreIdAndUserIdOrRePwd(reId, userId, rePwd);
		
		return result;
	}
	

}
