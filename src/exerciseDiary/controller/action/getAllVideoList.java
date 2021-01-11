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
public class getAllVideoList implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		try {
			request.getSession().getAttribute("id");
			ArrayList<Video> vList = EDService.getAllVideoList();
			request.setAttribute("vList", vList);

			request.getSession().setAttribute("successMsg","영상 list 반환 성공");
			url = "vList.jsp";
		}catch(Exception s){
			log.info("영상 list 반환 에러 발생");
			System.out.println(s.getMessage());
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
