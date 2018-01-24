package bit.model.service;

import java.sql.SQLException;

import java.util.List;

import bit.model.dao.ReviewDAO;
import bit.model.dao.ReviewDAOImpl;

import bit.model.dto.ReviewDTO;

public class JoyMovieService {
	private static ReviewDAO re_dao = new ReviewDAOImpl();
	
	
	public static List<ReviewDTO> selectAll() throws SQLException{

		return re_dao.selectAll();
	  }
	  
	
	  public static int insert(ReviewDTO re_dto) throws SQLException{
		  int result = re_dao.insert(re_dto);
		  if(result==0)throw new SQLException("�벑濡앸릺吏� �븡�븯�뒿�땲�떎.");
		  return result;
	  }
	 
	  public static ReviewDTO selectByModelNum(String re_id, boolean flag) throws SQLException{
		 if(flag) {
		  int result = re_dao.updateByReadNum(re_id);
		  if(result==0)new SQLException("寃뚯떆臾� 議고쉶�닔 利앷��븯�뒗�뜲 �삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎.");
		 }
		 
		 ReviewDTO re_dto = re_dao.selectByReviewNum(re_id);
		  if(re_dto==null) 
			  new SQLException(re_id+"寃뚯떆臾쇱� 議댁옱�븯吏� �븡�뒿�땲�떎.");
		  return re_dto;
	  }
	  
	  
	  public static int delete(String re_id, String re_pwd) throws SQLException{
		 
		 ReviewDTO dbReview= re_dao.selectByReviewNum(re_id);
		  if(!dbReview.getRe_pwd().equals(re_pwd)) {
			  throw new SQLException("鍮꾨�踰덊샇 �삤瑜섏엯�땲�떎.");
		  }
		  int result = re_dao.delete(re_id, re_pwd);
		  if(result==0)throw new SQLException("寃뚯떆臾쇱씠 �궘�젣�릺吏� �븡�븯�뒿�땲�떎.");
		  return result;
	  }
	  
	  
	 
	  public static int update(ReviewDTO re_dto) throws SQLException{
		
		  ReviewDTO dbElec= re_dao.selectByReviewNum(re_dto.getRe_id());
		  if(!dbElec.getRe_pwd().equals(re_dto.getRe_pwd())) {
			  throw new SQLException("鍮꾨�踰덊샇 �삤瑜섏엯�땲�떎.");
		  }
		  int result = re_dao.update(dbElec);
		  if(result==0)throw new SQLException("寃뚯떆臾쇱씠 �닔�젙�릺吏� �븡�븯�뒿�땲�떎.");
		  return result;
		
	  }
	  
	  
}



