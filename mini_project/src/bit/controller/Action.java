package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//앞에 접근제한자가 붙어야하지만 Interface는 public이므로 default로 인해 따로 써줄필요가 없다.
	void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
