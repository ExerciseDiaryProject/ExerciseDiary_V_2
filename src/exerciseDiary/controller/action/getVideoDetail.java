package exerciseDiary.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class getVideoDetail implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			request.setAttribute("videoDetail", EDService.getVideoDetail(request.getParameter("playlist")));
			request.setAttribute("successMsg","비디오 상세보기 성공");
			url = "vDetail.jsp";
		} catch(Exception s){
			log.info("비디오 상세보기 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
