package exerciseDiary.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserLogout implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession();
	    userSession.invalidate();
	    request.setAttribute("successMsg","로그아웃 성공");
	    log.info("logout");

	    response.sendRedirect("userLogin.html");
		
	}

}
