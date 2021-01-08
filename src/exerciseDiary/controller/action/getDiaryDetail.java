package exerciseDiary.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excerciseDiary.model.EDService;
import excerciseDiary.model.entity.Diary;
import excerciseDiary.model.entity.Purpose;
import excerciseDiary.model.entity.Users;
import excerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class getDiaryDetail implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("diaryDetail", EDService.getDiaryDetail(request.getParameter("diaryNo")));
			request.getSession().setAttribute("successMsg","다이어리 상세보기 성공");
			//			url = "activistDetail.jsp";
		} catch(Exception s){
			log.info("다이어리 상세보기 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
