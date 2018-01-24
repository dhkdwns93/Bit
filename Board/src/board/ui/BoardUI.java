package board.ui;

import board.BoardUIMapping;

/*
 * ���÷��� -> ������ ���, ���α׷��� ������ �� ����� �����ϴ��Ŀ� ���� �ٸ��� ���������.
 * 			������ ������ �ش� ��ü�� �������� ���������.
 * 
 */

//����� ȭ�� ó��
public class BoardUI extends BaseUI{
	String[] key = {"exit","search","searchOne","add","update","delete"};
	BoardUIMapping mapping = null;
	
	public void excute() throws Exception {
		mapping = new BoardUIMapping();
		// key�� add��� addUI�� �ν��Ͻ� �ּҰ�
		
		while(true) {
			int type = menu();
			
			if(type >= key.length) {
				System.out.println("�߸� �����ϼ̽��ϴ�.");
				continue;
			}
			IBoardUI ui = mapping.getBoardUI(key[type]);
			
			if(ui != null) {
				ui.excute();
			}

		}
	}
	
	private int menu() {
		System.out.println("---------------------------");
		System.out.println(" [ó�� ������ �Խ��� ���� ���α׷�]");
		System.out.println("---------------------------");
		System.out.println("1. ��ü �Խñ� ��ȸ");
		System.out.println("2. ��ȣ�� �Խñ� ��ȸ");
		System.out.println("3. �� �� ���");
		System.out.println("4. �Խñ� ����");
		System.out.println("5. �Խñ� ����");
		System.out.println("0. ���α׷� ����");
		
		int type = scanInt("ó���� �׸��� �Է�");  //scanInt�� BaseUI�� ����
		return type;		
	}
}
