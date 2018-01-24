package board.ui;

import java.util.Scanner;

import board.BoardServiceFactory;
import board.service.BoardService;

public abstract class BaseUI implements IBoardUI {
	private Scanner sc;
	protected BoardService service;
	
	@SuppressWarnings("static-access")
	public BaseUI() {
		service = new BoardServiceFactory().getInstance();
		sc = new Scanner(System.in);
	}	
	
	protected int scanInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	protected String scanStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}	
}