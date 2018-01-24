package bit.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.model.dao.ElecDAO;
import bit.model.dao.ElecDAOImpl;
import bit.model.dto.Electronics;

public class ElecServiceImpl implements ElecService {
	
	private ElecDAO dao = new ElecDAOImpl();

	@Override
	public List<Electronics> selectAll() throws SQLException {
		List<Electronics> list = dao.selectAll();
		System.out.println("list : " + list);
		if(list == null || list.size()==0)
			throw new SQLException("검색된 자료가 없습니다.");
		
		return list;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		
		return 0;
	}

	@Override
	public Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException {
		
		
		return null;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		
		return 0;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		
		return 0;
	} 
	

}
