package mini.user.service;

import java.sql.SQLException;

import mini.user.dao.UserDAO;
import mini.user.dao.UserDAOimpl;
import mini.user.dto.UserDTO;

public class UserServiceimpl implements UserService {
	private UserDAO userDAO = new UserDAOimpl();

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		UserDTO dbUserDTO = userDAO.loginCheck(userDTO);
		if (dbUserDTO == null) {
			throw new SQLException("������ �ٽ� Ȯ�����ּ���.");
		}
		return dbUserDTO;
	}

	@Override
	public int insertUser(UserDTO userDTO) throws SQLException {
		int result = userDAO.insertUser(userDTO);
		if (userDTO == null) {
			throw new SQLException("����� ���� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public int updateUser(UserDTO userDTO) throws SQLException {
		int result = userDAO.updateUser(userDTO);

		if (userDTO == null) {
			throw new SQLException("������ ���� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public int deleteUser(String userId,String pwd) throws SQLException {
		int result = userDAO.deleteUser(userId,pwd);
		if (result == 0) {
			throw new SQLException("�н����尡 Ʋ�Ƚ��ϴ�.");
		}
		return result;
	}
}
