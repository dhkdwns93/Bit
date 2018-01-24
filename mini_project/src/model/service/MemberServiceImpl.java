package model.service;

import model.dao.MemberDao;
import model.dao.MemberDaoImpl;
import model.dto.Members;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao = new MemberDaoImpl();
	@Override
	public int insertMember(Members member) throws Exception {
		int result = dao.insertMember(member);
		if(result==0) throw new Exception("등록되지 않았습니다.");
		return result;
	}

	

	@Override
	public int updateMember(Members member) throws Exception {
		Members members = dao.selectUserId(member.getUserId());
		
		if(!members.getUserId().equals(member.getUserId())) {
			throw new Exception("동일한 아이디가 아닙니다.");
		}
		int result = dao.updateMember(member);
		if(result==0) throw new Exception("수정되지않았습니다.");
		return result;
	}



	@Override
	public Members selectUserId(String userId) throws Exception {
		Members member = null;
		member = dao.selectUserId(userId);
		
		if(!member.getUserId().equals(userId)) {
			throw new Exception("해당 ID가 검색되지않았습니다..");
		}
		return member;
	}

	@Override
	public Members loginMember(Members member) throws Exception {
		Members dbMembers = dao.loginMember(member);
		if(dbMembers==null) {
			throw new Exception("회원가입을 해주세요");
		}
		return dbMembers;
	}

	
	

}
