package exerciseDiary.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GetDiaryDetail implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			String diaryNo = request.getParameter("diaryNo");
			request.setAttribute("diaryDetail", EDService.getDiaryDetail(diaryNo));
			request.setAttribute("successMsg","다이어리 상세보기 성공");
			url = "dDetail.jsp";
		} catch(Exception s){
			log.info("다이어리 상세보기 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
