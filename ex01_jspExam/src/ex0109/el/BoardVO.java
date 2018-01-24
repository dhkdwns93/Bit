package ex0109.el;

public class BoardVO {
	private int no;
	private String writer;
	private String subject;
	private String date;

	public BoardVO() {

	}

	public BoardVO(int no, String writer, String subject, String date) {
		super();
		this.no = no;
		this.writer = writer;
		this.subject = subject;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
