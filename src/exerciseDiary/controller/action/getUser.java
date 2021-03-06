package exerciseDiary.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetUser implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			String id = (String)request.getSession().getAttribute("id");
			request.getSession().setAttribute("user", EDService.getUser(id));
			request.setAttribute("successMsg", "list 출력 성공");

			url = "myPage.jsp";
		} catch(Exception s){

			log.info("회원정보 출력 중 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
