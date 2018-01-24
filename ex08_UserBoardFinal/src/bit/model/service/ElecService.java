package bit.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.model.dto.Electronics;

public interface ElecService {
	/**
	  * 레코드 전체 검색
	  * select * from Electronics
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	 int insert(Electronics electronics) throws SQLException;
	 
	 Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException;
	 
	 int delete(String modelNum, String password) throws SQLException;
	 
	 int update(Electronics electronics) throws SQLException;
	 
}
