package exerciseDiary.controller.action;

import java.io.IOException;   

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
public class CheckUser implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {

			if (id == null || id.trim().length() == 0 || pw == null || pw.trim().length() == 0) {
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			boolean result = EDService.checkUser(id, pw);

			if (result) {
				request.getSession().setAttribute("id", id);
				response.sendRedirect("exerciseDiary?command=getAllVideoList&userId=id");
			}
		} catch (Exception e) {
			log.info("로그인 중 에러 발생");
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		}
	}
}
