package bit.model.dao;


import java.sql.SQLException;
import java.util.List;

import bit.model.dto.Electronics;

public interface ElecDAO {
	 /**
	  * 레코드 전체 검색
	  * select * from Electronics
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * select * from Electronics where model_num=?
		  * */
	  Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException;
	 
	  /**
	   * 상세보기를 할때 조회수를 증가하는 메소드
	   * */
	  int updateByReadNum(String modelNum) throws SQLException;
	  
	/**
	 * 레코드 삽입
	 * @return : 1이상 -삽입성공 , 0 - 삽입실패
	 * */
	  int insert(Electronics electronics) throws SQLException;
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * @return : 1이상 -삭제성공 , 0 - 삭제실패
	   * */
	   int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * @return : 1이상 -수정성공 , 0 - 수정실패
	    * */
	   int update(Electronics electronics) throws SQLException;
}




