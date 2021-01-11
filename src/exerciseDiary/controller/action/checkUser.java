package exerciseDiary.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import exerciseDiary.model.entity.Purpose;
import exerciseDiary.model.entity.Users;
import exerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class checkUser implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			boolean result = EDService.checkUser(id, pw);

			if(result) {
				request.getSession().setAttribute("id", id);
				response.sendRedirect("exerciseDiary?command=getAllVideoList&userId=id");
//				request.getRequestDispatcher("exerciseDiary?command=getAllVideoList").forward(request, response);
			}
		} catch (Exception e) {
			log.info("로그인 중 에러 발생");
			System.out.println(e.getMessage());
			request.getSession().setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		}
	}
}
