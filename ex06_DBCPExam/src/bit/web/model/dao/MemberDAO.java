package bit.web.model.dao;

import java.sql.SQLException;
import java.util.List;

import bit.web.model.vo.MemberVo;

public interface MemberDAO {
	/**
	 * 1. 모든 회원정보 검색
	 * (select id,pwd,name,age,phone,addr, join_date from member)
	 *  
	 **/
	List<MemberVo> memberSelectAll() throws SQLException;
	
	
	/**
	 * 2. 회원가입
	 * insert into member(id, pwd, name, age, phone, addr, join_date 
	 * values(?,?,?,?,?,?, sysdate)
	 * @return : 0이면 실패, 1이상이면 성공
	 **/
	int memberInsert(MemberVo memberVo) throws SQLException;
	
	
	/**
	 * 아이디 중복체크
	 * select id from member where id=?
	 * @return true이면 중복, false이면 사용가능
	 **/
	boolean memberByIdCheck(String id) throws SQLException;
	
	
	/**
	 * 아이디에 해당하는 회원 삭제
	 *delete from member where id=? 
	 * @return : 0이면 실패, 1이상이면 성공
	 **/
	int memberDelete(String id) throws SQLException;
}
