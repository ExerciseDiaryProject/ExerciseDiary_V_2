package exerciseDiary.controller.action;

import java.io.IOException;
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
public class addDiary implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 값
		String diaryTitle = request.getParameter("diaryTitle");
		String diaryContent = request.getParameter("diaryContent");
		String todayWeight = request.getParameter("todayWeight");
		Date date = new Date();
		Users userId = null;
		Purpose purpose = null;
		Video programNo = null;

		try {
			userId = EDService.getUser(request.getParameter("userId"));
			purpose = EDService.findPurpose(request.getParameter("purpose"));
			programNo = EDService.findProgram(request.getParameter("programNo"));
			
			if(diaryTitle == null || diaryTitle.trim().length() == 0 ||
				diaryContent == null || diaryContent.trim().length() == 0 ||
				todayWeight == null || todayWeight.trim().length() == 0 ||
		 		userId == null ||  purpose == null || programNo == null) {
					throw new Exception("입력값이 충분하지 않습니다.");
			}

			boolean result = EDService
					.addDiary(Diary.builder().diaryTitle(diaryTitle).diaryContent(diaryContent).writeDate(date)
							.todayWeight(todayWeight).userId(userId).purpose(purpose).programNo(programNo).build());

			if (result) {
				request.setAttribute("successMsg", "작성 완료");
				response.sendRedirect("exerciseDiary?command=getDiaryList");
				log.info("다이어리 작성 완료");

			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("다이어리 작성 실패");
			}
		} catch (Exception s) {
			log.info("다이어리 작성 중 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		}
		
	}
}
