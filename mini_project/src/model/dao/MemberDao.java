package model.dao;

import model.dto.Members;

public interface MemberDao {
	/**
	 * ������ ȸ������ (Insert)
	 * insert into members(user_id, pwd, pwd_check, name, gender) values(?,?,?,?,?)
	 * */
	int insertMember(Members member)throws Exception;
	
	/**
	 * ������ �������� ����
	 * update members set(pwd =? , pwdCheck=?, name=?, gender=?) where userId = ?
	 * */
	int updateMember(Members member)throws Exception;
	
	/**
	 *�α���
	 * */
	Members loginMember(Members member)throws Exception;
	
	/**
	 * UserId�� �ش��ϴ� ȸ������ �˻�
	 * */
	Members selectUserId(String userId) throws Exception;
	
}
