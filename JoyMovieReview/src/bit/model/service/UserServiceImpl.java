package bit.model.service;

import bit.model.dao.UserDAO;
import bit.model.dao.UserDAOImpl;
import bit.model.dto.UserDTO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws Exception {
		UserDTO dbuserDTO = userDAO.loginCheck(userDTO);
		if (dbuserDTO == null) {
			throw new Exception("정보를 다시 확인해주세요");
		}
		return dbuserDTO;
	}

	@Override
	public int insertMember(UserDTO userDTO) throws Exception {
		int result = userDAO.insertMember(userDTO);
		if (result == 0)
			throw new Exception("회원이 등록되지 않았음");
		return result;
	}

	@Override
	public int updateMember(UserDTO userDTO) throws Exception {
		UserDTO user = userDAO.selectUserId(userDTO.getUser_id());

		if (!userDTO.getUser_id().equals(userDTO.getUser_id())) {
			throw new Exception("인증되지않았습니다.");
		}
		int result = userDAO.updateMember(userDTO);
		if (result == 0)
			throw new Exception("회원정보가 수정되지 않았습니다.");
		return result;
	}

	@Override
	public UserDTO selectUserId(String user_id) throws Exception {
		UserDTO userDTO = null;
		userDTO = userDAO.selectUserId(user_id);
		
		if(!userDTO.getUser_id().equals(user_id)) {
			throw new Exception("일치하지않습니다.");
		}
		return userDTO;
	}

}
