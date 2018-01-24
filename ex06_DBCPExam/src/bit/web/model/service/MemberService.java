package bit.web.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.web.model.vo.MemberVo;

public interface MemberService {
	/**
	 * 1. ��� ȸ������ �˻�
	 * 
	 *  
	 * */
	List<MemberVo> memberSelectAll() throws SQLException;
	
	/**
	 * 2. ȸ������
	 *  :�����ϱ� ���� id �ߺ�üũ�Ѵ�.
	 * @return : 0�̸� ����, 1�̻��̸� ����
	 **/
	int memberInsert(MemberVo memberVo) throws SQLException;
	
	/**
	 * ���̵� �ش��ϴ� ȸ�� ����
	 * 
	 * @return : 0�̸� ����, 1�̻��̸� ����
	 **/
	int memberDelete(String id) throws SQLException;
}
