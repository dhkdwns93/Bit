package bit.model.dao;


import java.sql.SQLException;
import java.util.List;

import bit.model.dto.Electronics;

public interface ElecDAO {
	 /**
	  * ���ڵ� ��ü �˻�
	  * select * from Electronics
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * select * from Electronics where model_num=?
		  * */
	  Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException;
	 
	  /**
	   * �󼼺��⸦ �Ҷ� ��ȸ���� �����ϴ� �޼ҵ�
	   * */
	  int updateByReadNum(String modelNum) throws SQLException;
	  
	/**
	 * ���ڵ� ����
	 * @return : 1�̻� -���Լ��� , 0 - ���Խ���
	 * */
	  int insert(Electronics electronics) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1�̻� -�������� , 0 - ��������
	   * */
	   int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1�̻� -�������� , 0 - ��������
	    * */
	   int update(Electronics electronics) throws SQLException;
}



