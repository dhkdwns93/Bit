package board;

import board.service.BoardService;

public class BoardServiceFactory {
	private static BoardService service = null;
	
	// 사용중인 사용자가 있다면 다른 사용자들은 사용 불가능하게 하기 위해서 동기화\
	// + 싱글톤
	public static synchronized BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
			return service;
		}
		return service;
	}
}