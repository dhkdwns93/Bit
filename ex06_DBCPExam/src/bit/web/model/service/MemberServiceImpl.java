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
			throw new SQLException("검색된 레코드는 없습니다.");// controller의 catch영역으로 점프..
		}
		return list;
	}

	@Override
	public int memberInsert(MemberVo memberVo) throws SQLException {
		// ID체크를 한다.

		boolean check = memberDao.memberByIdCheck(memberVo.getId());
		if ( check)
			throw new SQLException(memberVo.getId() + "가 중복입니다.");
		int insert = memberDao.memberInsert(memberVo);
		return insert;
	}

	@Override
	public int memberDelete(String id) throws SQLException {
		int remove = memberDao.memberDelete(id);
		if (remove == 0)
			throw new SQLException("삭제되지 않았습니다.");// servlet의 catch이동
		return remove;
	}

}
