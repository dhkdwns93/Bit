package mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import mini.board.dto.ReviewDTO;
import mini.board.service.BoardService;
import mini.board.service.BoardServiceimpl;
import mini.service.ApiService;
import mini.service.ApiServieimpl;

public class ListViewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "viewByRank.jsp";
		ApiService apiService = new ApiServieimpl();
		BoardService bService=new BoardServiceimpl();
		try {
			System.out.println("ListViewAction : try-----");
			JSONArray jArr = apiService.listView();//boxoffice.
			List<ReviewDTO>list=bService.selectAll();
			HttpSession session = request.getSession();
			session.setAttribute("jArr", jArr);
			session.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "front?cmd=listView");
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
