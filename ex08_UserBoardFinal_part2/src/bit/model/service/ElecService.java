package bit.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.model.dao.ElecDAO;
import bit.model.dao.ElecDAOImpl;
import bit.model.dto.Electronics;

public class ElecService {
	private static ElecDAO  electronicsDao = new ElecDAOImpl();
	
	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	public static List<Electronics> selectAll() throws SQLException{
		  return electronicsDao.selectAll();
	  }
	  
	  /**
	   * ElectronicsDAOImpl의 레코드 삽입하는 메소d드 호출
	   * */
	  public static int insert(Electronics electronics) throws SQLException{
		  int result = electronicsDao.insert(electronics);
		  if(result==0)throw new SQLException("등록되지 않았습니다.");
		  return result;
	  }
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  public static Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException{
		 if(flag) {
		  int result = electronicsDao.updateByReadNum(modelNum);
		  if(result==0)new SQLException("게시물 조회수 증가하는데 오류가 발생했습니다.");
		 }
		 
		  Electronics elec = electronicsDao.selectByModelNum(modelNum);
		  if(elec==null) 
			  new SQLException(modelNum+"게시물은 존재하지 않습니다.");
		  return elec;
	  }
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	  public static int delete(String modelNum, String password) throws SQLException{
		  //비밀번호 검증
		 Electronics dbElec= electronicsDao.selectByModelNum(modelNum);
		  if(!dbElec.getPassword().equals(password)) {
			  throw new SQLException("비밀번호 오류입니다.");
		  }
		  int result = electronicsDao.delete(modelNum,password);
		  if(result==0)throw new SQLException("게시물이 삭제되지 않았습니다.");
		  return result;
	  }
	  
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	  public static int update(Electronics electronics) throws SQLException{
		//비밀번호 검증
		 Electronics dbElec= electronicsDao.selectByModelNum(electronics.getModelNum());
		  if(!dbElec.getPassword().equals(electronics.getPassword())) {
			  throw new SQLException("비밀번호 오류입니다.");
		  }
		  int result = electronicsDao.update(electronics);
		  if(result==0)throw new SQLException("게시물이 수정되지 않았습니다.");
		  return result;
		
	  }
	  
	  
}



