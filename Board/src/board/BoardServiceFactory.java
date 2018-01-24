package board;

import board.service.BoardService;

public class BoardServiceFactory {
	private static BoardService service = null;
	
	// ������� ����ڰ� �ִٸ� �ٸ� ����ڵ��� ��� �Ұ����ϰ� �ϱ� ���ؼ� ����ȭ\
	// + �̱���
	public static synchronized BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
			return service;
		}
		return service;
	}
}