package bit.web.model.dao;

import java.sql.SQLException;
import java.util.List;

import bit.web.model.vo.MemberVo;

public interface MemberDAO {
	/**
	 * 1. ��� ȸ������ �˻�
	 * (select id,pwd,name,age,phone,addr, join_date from member)
	 *  
	 **/
	List<MemberVo> memberSelectAll() throws SQLException;
	
	
	/**
	 * 2. ȸ������
	 * insert into member(id, pwd, name, age, phone, addr, join_date 
	 * values(?,?,?,?,?,?, sysdate)
	 * @return : 0�̸� ����, 1�̻��̸� ����
	 **/
	int memberInsert(MemberVo memberVo) throws SQLException;
	
	
	/**
	 * ���̵� �ߺ�üũ
	 * select id from member where id=?
	 * @return true�̸� �ߺ�, false�̸� ��밡��
	 **/
	boolean memberByIdCheck(String id) throws SQLException;
	
	
	/**
	 * ���̵� �ش��ϴ� ȸ�� ����
	 *delete from member where id=? 
	 * @return : 0�̸� ����, 1�̻��̸� ����
	 **/
	int memberDelete(String id) throws SQLException;
}
