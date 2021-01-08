package exerciseDiary.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excerciseDiary.model.EDService;
import excerciseDiary.model.entity.Purpose;
import excerciseDiary.model.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class addUser implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		// 입력 값
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		Purpose userPurpose = null;

		try{
			userPurpose = EDService.findPurpose(request.getParameter("purpose"));
			Users user = new Users(id, pw, name, gender, age, height, weight, userPurpose);
			
			if(id != null && id.length() !=0 && name != null) {
				boolean result = EDService.addUser(user);
				if(result){
					request.getSession().setAttribute("successMsg", "가입 완료");
	
					log.info("user 가입 완료");
					url = "userLogin.html";
				} else{
					request.getSession().setAttribute("errorMsg", "회원가입 오류");
				}
			} else {
				request.getSession().setAttribute("errorMsg", "회원님의 정보가 제대로 입력되지 않았습니다.");
			} 
		} catch(Exception s){
			log.info("회원가입 중 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
		} 
		request.getRequestDispatcher(url).forward(request, response);
	}
}
