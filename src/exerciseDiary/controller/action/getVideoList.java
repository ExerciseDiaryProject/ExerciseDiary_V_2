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
public class getVideoList implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			ArrayList<Video> vListPurpose = EDService.getVideoList(request.getParameter("purpose"));

			request.getSession().setAttribute("vListPurpose", vListPurpose);
			request.getSession().setAttribute("successMsg","목적별 영상 list 반환 성공");

			url = "vListPurpose.jsp";
		} catch(Exception s){
			log.info("목적별 영상 list 반환 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
