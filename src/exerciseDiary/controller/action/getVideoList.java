package exerciseDiary.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import exerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GetVideoList implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			ArrayList<Video> vListPurpose = EDService.getVideoList(request.getParameter("value"));
			
			request.setAttribute("vListPurpose", vListPurpose);
			request.setAttribute("successMsg","목적별 영상 list 반환 성공");

			url = "vListPurpose.jsp";
		} catch(Exception s){
			log.info("목적별 영상 list 반환 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
