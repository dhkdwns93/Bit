 package bit.model.service;

import java.sql.SQLException;

import bit.model.dto.UserDTO;

public interface UserService {
	/**
	 * �α��� üũ
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}
