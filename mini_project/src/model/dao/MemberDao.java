package model.dao;

import model.dto.Members;

public interface MemberDao {
	/**
	 * 유저의 회원가입 (Insert)
	 * insert into members(user_id, pwd, pwd_check, name, gender) values(?,?,?,?,?)
	 * */
	int insertMember(Members member)throws Exception;
	
	/**
	 * 유저의 개인정보 수정
	 * update members set(pwd =? , pwdCheck=?, name=?, gender=?) where userId = ?
	 * */
	int updateMember(Members member)throws Exception;
	
	/**
	 *로그인
	 * */
	Members loginMember(Members member)throws Exception;
	
	/**
	 * UserId에 해당하는 회원정보 검색
	 * */
	Members selectUserId(String userId) throws Exception;
	
}
