package bit.model.service;

import java.sql.SQLException;
import java.util.List;

import bit.model.dao.ElecDAO;
import bit.model.dao.ElecDAOImpl;
import bit.model.dto.Electronics;

public class ElecService {
	private static ElecDAO  electronicsDao = new ElecDAOImpl();
	
	/**
	 * ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * */
	public static List<Electronics> selectAll() throws SQLException{
		  return electronicsDao.selectAll();
	  }
	  
	  /**
	   * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼�d�� ȣ��
	   * */
	  public static int insert(Electronics electronics) throws SQLException{
		  int result = electronicsDao.insert(electronics);
		  if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		  return result;
	  }
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	   * */
	  public static Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException{
		 if(flag) {
		  int result = electronicsDao.updateByReadNum(modelNum);
		  if(result==0)new SQLException("�Խù� ��ȸ�� �����ϴµ� ������ �߻��߽��ϴ�.");
		 }
		 
		  Electronics elec = electronicsDao.selectByModelNum(modelNum);
		  if(elec==null) 
			  new SQLException(modelNum+"�Խù��� �������� �ʽ��ϴ�.");
		  return elec;
	  }
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  public static int delete(String modelNum, String password) throws SQLException{
		  //��й�ȣ ����
		 Electronics dbElec= electronicsDao.selectByModelNum(modelNum);
		  if(!dbElec.getPassword().equals(password)) {
			  throw new SQLException("��й�ȣ �����Դϴ�.");
		  }
		  int result = electronicsDao.delete(modelNum,password);
		  if(result==0)throw new SQLException("�Խù��� �������� �ʾҽ��ϴ�.");
		  return result;
	  }
	  
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	   * */
	  public static int update(Electronics electronics) throws SQLException{
		//��й�ȣ ����
		 Electronics dbElec= electronicsDao.selectByModelNum(electronics.getModelNum());
		  if(!dbElec.getPassword().equals(electronics.getPassword())) {
			  throw new SQLException("��й�ȣ �����Դϴ�.");
		  }
		  int result = electronicsDao.update(electronics);
		  if(result==0)throw new SQLException("�Խù��� �������� �ʾҽ��ϴ�.");
		  return result;
		
	  }
	  
	  
}



