package mini.user.dao;

import java.sql.SQLException;

import mini.user.dto.UserDTO;

public interface UserDAO {
	/**
	 * �α��� ��� select user_id, pwd, name from users where user_id=? and pwd=?
	 */
	UserDTO loginCheck(UserDTO userDTO) throws SQLException;

	/**
	 * ȸ�� ���� ��� insert into users values(user_id=?, pwd=?, name=?, gender=?)
	 */
	int insertUser(UserDTO userDTO) throws SQLException;

	/**
	 * ȸ�� ���������� update users set pwd=?, name=?,gender=? where user_id=?
	 */
	int updateUser(UserDTO userDTO) throws SQLException;

	/**
	 * ȸ�� ���� delete from users where user_id=?
	 */
	int deleteUser(String userId,String pwd) throws SQLException;

}
