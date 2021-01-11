package exerciseDiary.controller.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import exerciseDiary.model.UserDAO;
import exerciseDiary.model.entity.Diary;
import exerciseDiary.model.entity.Purpose;
import exerciseDiary.model.entity.Users;
import exerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class addDiary implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		// 입력 값
//		String diaryNo = request.getParameter("diaryNo");
		String diaryTitle = request.getParameter("diaryTitle");
		String diaryContent = request.getParameter("diaryContent");
		String writeDate = request.getParameter("writeDate");
		String todayWeight = request.getParameter("todayWeight");
//		String programNo = request.getParameter("programNo");
		
		Users userId = null;
		Purpose purpose = null;
		Video programNo = null;

		try{
			userId = UserDAO.getUserID(request.getParameter("userId"));
			purpose = EDService.findPurpose(request.getParameter("purpose"));
			programNo = EDService.findProgram(request.getParameter("programNo"));
			
			Date date = DateFormat.getInstance().parse(writeDate);
		
//			Diary diary = new Diary(diaryTitle, diaryContent, date, todayWeight, new Users(userId), new Purpose(purpose), new Video(programNo));
//			Diary diary = new Diary();
			boolean result = EDService.addDiary(Diary.builder().diaryTitle(diaryTitle)
					.diaryContent(diaryContent).writeDate(date).todayWeight(todayWeight)
					.userId(userId).purpose(purpose).programNo(programNo).build());
			
			if(result){
//				request.getSession().setAttribute("diary", diary);
				request.setAttribute("successMsg", "작성 완료");
				log.info("다이어리 작성 완료");
				//  url = "activistDetail.jsp";

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
