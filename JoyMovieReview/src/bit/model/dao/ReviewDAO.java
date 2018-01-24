package bit.model.dao;

import java.sql.SQLException;

import java.util.List;

import bit.model.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * 모든 리뷰 전체 검색
	 */
	List<ReviewDTO> selectAll() throws SQLException;

	/**
	 * 리뷰 번호에 해당하는 레코드 검색
	 */
	ReviewDTO selectByReviewNum(String re_id) throws SQLException;

	/**
	 * 상세보기를 할대 조회수를 증가하는 메소드
	 */
	int updateByReadNum(String re_id) throws SQLException;

	/**
	 * 레코드 삽입
	 * 
	 * @return : 1이상 -삽입성공 , 0 - 삽입실패
	 */
	int insert(ReviewDTO re_vo) throws SQLException;

	/**
	 * 리뷰 번호에 해당하는 레코드 삭제
	 * 
	 * @return : 1이상 -삭제성공 , 0 - 삭제실패
	 */
	int delete(String re_id, String password) throws SQLException;

	/**
	 * 모델번호에 해당하는 레코드 수정
	 * 
	 * @return : 1이상 -수정성공 , 0 - 수정실패
	 */
	int update(ReviewDTO re_vo) throws SQLException;
}
