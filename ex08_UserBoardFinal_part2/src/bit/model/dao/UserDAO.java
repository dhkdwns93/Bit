package bit.model.dao;

import java.sql.SQLException;

import bit.model.dto.UserDTO;

public interface UserDAO {
  /**
   * �α��� ���
   * select user_id , pwd, name from users where user_id=? and pwd=?
   * */
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}
