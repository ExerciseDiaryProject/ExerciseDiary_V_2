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
public class updateUserPurpose implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		String id = request.getParameter("userId");
		String purpose = request.getParameter("purpose");

		try{
			boolean result = EDService.updateUserPurpose(id,purpose);
			if(result){
				request.getSession().setAttribute("id", EDService.getUser(id));
				request.getSession().setAttribute("successMsg", "수정 완료");
				log.info("운동목적 수정이 완료되었습니다.");

				url = "myPage.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("운동목적 수정  다시 시도해주세요.");
			}
		} catch(Exception s){
			log.info("운동목적 수정 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
