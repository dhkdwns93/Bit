package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//�տ� ���������ڰ� �پ�������� Interface�� public�̹Ƿ� default�� ���� ���� �����ʿ䰡 ����.
	void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}