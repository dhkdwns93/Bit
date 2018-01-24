 package mini.user.service;

import java.sql.SQLException;

import mini.user.dto.UserDTO;

public interface UserService {
	/**
	 * �α��� üũ
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException;
   /**
    * ȸ�� ���� ���
    * insert into users values(user_id=?, pwd=?, name=?, gender=?)
    */
   int insertUser(UserDTO userDTO) throws SQLException;
   
   /**
    * ȸ�� ����������
    * update users set pwd=?, name=?,gender=? where user_id=?
    */
   int updateUser(UserDTO userDTO) throws SQLException;
   /**
    *ȸ�� ����
    *delete from users where user_id=?
    */
   int deleteUser(String userId,String pwd)  throws SQLException;
}
