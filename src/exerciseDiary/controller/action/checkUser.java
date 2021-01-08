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
public class checkUser implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			boolean result = EDService.checkUser(id, pw);

			if(result) {
				request.getSession().setAttribute("id", id);

				try {
					ArrayList<Video> vList = EDService.getAllVideoList();
					request.getSession().setAttribute("vList", vList);

					request.getSession().setAttribute("successMsg","모든 영상 list 반환 성공");
					url = "vList.jsp";
				}catch(Exception s){
					log.info("모든영상 list 반환 에러 발생");
					System.out.println(s.getMessage());
					request.getSession().setAttribute("errorMsg", s.getMessage());
					s.printStackTrace();
				}
			}
		} catch (Exception e) {
			log.info("로그인 중 에러 발생");
			System.out.println(e.getMessage());
			request.getSession().setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
