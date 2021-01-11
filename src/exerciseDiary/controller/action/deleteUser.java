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
public class deleteUser implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = EDService.deleteUser(request.getParameter("userId"));

			if(result){
				request.getSession().setAttribute("id", result);
				request.getSession().setAttribute("successMsg", "삭제 완료");
				log.info("회원탈퇴가 완료되었습니다.");

				url = "userLogin.html";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("회원 탈퇴 오류");
			}
		} catch(Exception s){
			log.info("회원 탈퇴 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}