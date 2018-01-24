package board;

import board.ui.BoardUI;

public class BoardMain {
	public static void main(String[] args) {
		BoardUI ui = new BoardUI();
		try {
			ui.excute();
		} catch(Exception e) {     //각각의 UI들의 throw Exception은 여기서 잡아준다
			e.printStackTrace();
		}
	}
}