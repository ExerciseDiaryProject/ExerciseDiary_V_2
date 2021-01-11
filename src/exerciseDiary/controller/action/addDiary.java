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
public class addDiary implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		// 입력 값u
		String diaryNo = request.getParameter("diaryNo");
		String diaryTitle = request.getParameter("diaryTitle");
		String diaryContent = request.getParameter("diaryContent");
		String writeDate = request.getParameter("writeDate");
		String todayWeight = request.getParameter("todayWeight");
		String userId = request.getParameter("userId");
		String purpose = request.getParameter("purpose");
		String programNo = request.getParameter("programNo");

		Diary diary = new Diary(diaryNo, diaryTitle, diaryContent, writeDate, todayWeight, new Users(userId), new Purpose(purpose), new Video(programNo));
		try{
			boolean result = EDService.addDiary(diary);
			if(result){
				request.getSession().setAttribute("diary", diary);
				request.setAttribute("successMsg", "작성 완료");
				log.info("다이어리 작성 완료");
				
				url ="writeDiary.jsp";

			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("다이어리 작성 실패");
			}
		} catch(Exception s){
			log.info("다이어리 작성 중 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
		} 
		request.getRequestDispatcher(url).forward(request, response);
	} 
}
