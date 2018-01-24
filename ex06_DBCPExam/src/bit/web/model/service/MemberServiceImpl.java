package bit.web.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.web.model.dao.MemberDAO;
import bit.web.model.dao.MemberDAOImpl;
import bit.web.model.vo.MemberVo;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDao = new MemberDAOImpl();

	@Override
	public List<MemberVo> memberSelectAll() throws SQLException {
		List<MemberVo> list = memberDao.memberSelectAll();
		if (list == null || list.size() == 0) {
			throw new SQLException("�˻��� ���ڵ�� �����ϴ�.");// controller�� catch�������� ����..
		}
		return list;
	}

	@Override
	public int memberInsert(MemberVo memberVo) throws SQLException {
		// IDüũ�� �Ѵ�.

		boolean check = memberDao.memberByIdCheck(memberVo.getId());
		if ( check)
			throw new SQLException(memberVo.getId() + "�� �ߺ��Դϴ�.");
		int insert = memberDao.memberInsert(memberVo);
		return insert;
	}

	@Override
	public int memberDelete(String id) throws SQLException {
		int remove = memberDao.memberDelete(id);
		if (remove == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");// servlet�� catch�̵�
		return remove;
	}

}
