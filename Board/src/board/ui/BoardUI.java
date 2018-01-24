package board.ui;

import board.BoardUIMapping;

/*
 * 리플렉션 -> 동적인 방식, 프로그램을 실행할 때 어떤것을 실행하느냐에 따라 다르게 만들어진다.
 * 			실행할 때마다 해당 객체가 동적으로 만들어진다.
 * 
 */

//사용자 화면 처리
public class BoardUI extends BaseUI{
	String[] key = {"exit","search","searchOne","add","update","delete"};
	BoardUIMapping mapping = null;
	
	public void excute() throws Exception {
		mapping = new BoardUIMapping();
		// key가 add라면 addUI의 인스턴스 주소값
		
		while(true) {
			int type = menu();
			
			if(type >= key.length) {
				System.out.println("잘못 선택하셨습니다.");
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
		System.out.println(" [처음 만나는 게시판 관리 프로그램]");
		System.out.println("---------------------------");
		System.out.println("1. 전체 게시글 조회");
		System.out.println("2. 번호로 게시글 조회");
		System.out.println("3. 새 글 등록");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("0. 프로그램 종료");
		
		int type = scanInt("처리할 항목을 입력");  //scanInt는 BaseUI에 있음
		return type;		
	}
}
