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
public class deleteDiary implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = EDService.deleteDiary(request.getParameter("diaryNo"));
			if(result){
				request.getSession().setAttribute("diary", result);
				request.getSession().setAttribute("successMsg", "삭제 완료");
				log.info("해당 다이어리 삭제 완료");
				//				url = "index.html";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("다이어리 삭제 오류");
			}
		}catch(Exception s){
			log.info("다이어리 삭제 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
