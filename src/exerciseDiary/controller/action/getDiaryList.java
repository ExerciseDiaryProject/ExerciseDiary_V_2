package exerciseDiary.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class getDiaryList implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
//		String userId = request.getParameter("userId");
		String userId = (String) request.getSession().getAttribute("id");
		System.out.println(userId);

		try {
			
			request.setAttribute("diaryList", EDService.getDiaryList(userId));
			request.getSession().setAttribute("successMsg", "list 출력 성공");

			 url = "dList.jsp";
		} catch (Exception s) {
			log.info("다이어리 list 출력 중 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
