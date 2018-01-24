package bit.model.service;

import java.sql.SQLException;

import bit.model.dao.UserDAO;
import bit.model.dao.UserDAOImpl;
import bit.model.dto.UserDTO;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		UserDTO dbUserDTO = userDAO.loginCheck(userDTO);
		if(dbUserDTO==null) {
			throw new SQLException("정보를 다시 확인해주세요.");
		}
		
		return dbUserDTO;
	}

}
