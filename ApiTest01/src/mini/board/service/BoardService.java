package mini.board.service;

import java.util.List;

import mini.board.dto.ReviewDTO;

public interface BoardService {
	List<ReviewDTO> selectAll() throws Exception;

	int insertOne(ReviewDTO reviewDTO) throws Exception;

	int deleteOne(int reId, String rePwd) throws Exception;

	int updateOne(ReviewDTO reviewDTO) throws Exception;
}
