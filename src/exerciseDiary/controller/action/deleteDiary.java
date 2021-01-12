package exerciseDiary.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import exerciseDiary.model.entity.Diary;
import exerciseDiary.model.entity.Purpose;
import exerciseDiary.model.entity.Users;
import exerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class deleteDiary implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = EDService.deleteDiary(request.getParameter("diaryNo"));
			if(result){
				request.setAttribute("successMsg", "삭제 완료");
				log.info("해당 다이어리 삭제 완료");
				response.sendRedirect("exerciseDiary?command=getDiaryList");
			}
		} catch(Exception s){
			log.info("다이어리 삭제 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}
