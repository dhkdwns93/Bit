package bit.model.dao;

import bit.model.dto.UserDTO;

public interface UserDAO {
  /**
   * 
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	UserDTO loginCheck(UserDTO userDTO)throws Exception;
	
	/**
	 * ������ ȸ������ (Insert)
	 * insert into userDTO(user_id, pwd, name, gender) values(?,?,?,?)
	 */
	int insertMember(UserDTO userDTO)throws Exception;
	
	/**
	 * ������ �������� ����
	 * update members set(pwd =? , name=?, gender=?) where userId = ?
	 * */
	int updateMember(UserDTO userDTO)throws Exception;
	
	/**
	 * UserId�� �ش��ϴ� ȸ������ �˻�
	 * */
	UserDTO selectUserId(String user_id) throws Exception;
}
