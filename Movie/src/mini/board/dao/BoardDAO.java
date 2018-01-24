package mini.board.dao;

import java.sql.SQLException;
import java.util.List;

import mini.board.dto.ReviewDTO;

public interface BoardDAO {

	List<ReviewDTO> selectAll() throws SQLException;
	
	List<ReviewDTO> selectByMid(String mId) throws SQLException;
	
	int insertOne(ReviewDTO reviewDTO) throws SQLException;
	/*    
	 * re_id NUMBER(4) primary key,
    m_id varchar2(10),
    re_pwd varchar2(30),
    user_id varchar2(10) REFERENCES users(user_id),
    re_title varchar2(30),
    re_star number(2,1),
    re_content CLOB*/
	int deleteOne(int reId, String rePwd) throws SQLException;

	
	int updateOne(ReviewDTO reviewDTO) throws SQLException;
	

}
