package bit.web.conrtoller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.web.model.service.MemberService;
import bit.web.model.service.MemberServiceImpl;
import bit.web.model.vo.MemberVo;


@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //service단에서 예외처리를 잡아준다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="memberSelect.jsp";
		
		//service 검색 호출 -> dao 호출
		MemberService service = new MemberServiceImpl();
		try {
			List<MemberVo> list = service.memberSelectAll();
			request.setAttribute("list", list);//view에서 ${list}를 반복문에 돌려준다.
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "memberForm.html");
			
			url="error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
