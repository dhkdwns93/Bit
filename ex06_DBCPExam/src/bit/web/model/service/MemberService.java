package bit.web.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.web.model.vo.MemberVo;

public interface MemberService {
	/**
	 * 1. 모든 회원정보 검색
	 * 
	 *  
	 * */
	List<MemberVo> memberSelectAll() throws SQLException;
	
	/**
	 * 2. 회원가입
	 *  :가입하기 전에 id 중복체크한다.
	 * @return : 0이면 실패, 1이상이면 성공
	 **/
	int memberInsert(MemberVo memberVo) throws SQLException;
	
	/**
	 * 아이디에 해당하는 회원 삭제
	 * 
	 * @return : 0이면 실패, 1이상이면 성공
	 **/
	int memberDelete(String id) throws SQLException;
}
