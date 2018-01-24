 package bit.model.service;

import java.sql.SQLException;

import bit.model.dto.UserDTO;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}
