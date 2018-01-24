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
			throw new SQLException("정보를 다시 확인해주세요.");
		}
		return dbUserDTO;
	}

	@Override
	public int insertUser(UserDTO userDTO) throws SQLException {
		int result = userDAO.insertUser(userDTO);
		if(userDTO==null) {
			throw new SQLException("정보가 등록되지 않았습니다.");
		}
		return result;
	}

	@Override
	public int updateUser(UserDTO userDTO) throws SQLException {
		int result= userDAO.updateUser(userDTO);
		
		if(userDTO==null) {
			throw new SQLException("수정되지 않았습니다.");
		}
		return result;
	}

	@Override
	public UserDTO selectUser(String userId) throws SQLException {
		UserDTO userDTO = userDAO.selectUser(userId);
		
		if(!userId.equals(userDTO.getUserId())) {
			throw new SQLException("동일한 아이디가 아닙니다");
		}
		return userDTO;
	}

	@Override
	public int deleteUser(String user_id) throws SQLException {
		int result = userDAO.deleteUser(user_id);
		
		if(result==0) {
			throw new SQLException("삭제 실패!");
		}
		return result;
	}
	
	
	
	

}
