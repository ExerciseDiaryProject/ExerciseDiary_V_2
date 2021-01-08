package exerciseDiary.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excerciseDiary.model.EDService;
import excerciseDiary.model.entity.Purpose;
import excerciseDiary.model.entity.Users;
import excerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class getUser implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			String id = request.getParameter("userId");
			request.getSession().setAttribute("id", EDService.getUser(id));
			request.getSession().setAttribute("successMsg", "list 출력 성공");

			url = "myPage.jsp";
		} catch(Exception s){

			log.info("회원정보 출력 중 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
