package bit.model.dao;

import bit.model.dto.UserDTO;

public interface UserDAO {
  /**
   * 
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	UserDTO loginCheck(UserDTO userDTO)throws Exception;
	
	/**
	 * 유저의 회원가입 (Insert)
	 * insert into userDTO(user_id, pwd, name, gender) values(?,?,?,?)
	 */
	int insertMember(UserDTO userDTO)throws Exception;
	
	/**
	 * 유저의 개인정보 수정
	 * update members set(pwd =? , name=?, gender=?) where userId = ?
	 * */
	int updateMember(UserDTO userDTO)throws Exception;
	
	/**
	 * UserId에 해당하는 회원정보 검색
	 * */
	UserDTO selectUserId(String user_id) throws Exception;
}
