package model.service;

import model.dto.Members;

public interface MemberService {
	
	int insertMember(Members member)throws Exception;
	
	
	int updateMember(Members member)throws Exception;
	
	
	Members loginMember(Members member)throws Exception;
	
	
	Members selectUserId(String userId) throws Exception;
	
}
