package mini.board.service;

import java.util.List;

import mini.board.dao.BoardDAO;
import mini.board.dao.BoardDAOimpl;
import mini.board.dto.ReviewDTO;

public class BoardServiceimpl implements BoardService {
	BoardDAO dao = new BoardDAOimpl();

	@Override
	public List<ReviewDTO> selectAll() throws Exception {
		List<ReviewDTO> list = dao.selectAll();
		return list;
	}
	
	@Override
	public List<ReviewDTO> selectByMid(String mId) throws Exception {
		List<ReviewDTO> list=dao.selectByMid(mId);
		
		return list;
	}

	@Override
	public int insertOne(ReviewDTO reviewDTO) throws Exception {
		int result = dao.insertOne(reviewDTO);
		if (reviewDTO == null || result == 0) {
			throw new Exception("제대로 등록되지 않았습니다.");
		}
		return result;
	}

	@Override
	public int deleteOne(int reId, String rePwd) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(ReviewDTO reviewDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
