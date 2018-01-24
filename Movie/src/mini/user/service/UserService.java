 package mini.user.service;

import java.sql.SQLException;

import mini.user.dto.UserDTO;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException;
   /**
    * 회원 가입 기능
    * insert into users values(user_id=?, pwd=?, name=?, gender=?)
    */
   int insertUser(UserDTO userDTO) throws SQLException;
   
   /**
    * 회원 수정페이지
    * update users set pwd=?, name=?,gender=? where user_id=?
    */
   int updateUser(UserDTO userDTO) throws SQLException;
   /**
    *회원 삭제
    *delete from users where user_id=?
    */
   int deleteUser(String userId,String pwd)  throws SQLException;
}
