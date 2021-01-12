package exerciseDiary.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.model.EDService;
import exerciseDiary.model.entity.Purpose;
import exerciseDiary.model.entity.Users;
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

		try {
			userPurpose = EDService.findPurpose(request.getParameter("purpose"));

			if (id == null || id.trim().length() == 0 || pw == null || pw.trim().length() == 0 || name == null
					|| name.trim().length() == 0 || gender == null || gender.trim().length() == 0 || age == null
					|| age.trim().length() == 0 || height == null || height.trim().length() == 0 || weight == null
					|| weight.trim().length() == 0 || userPurpose == null) {
				throw new Exception("입력값이 충분하지 않습니다.");
			}

			Users user = new Users(id, pw, name, gender, age, height, weight, userPurpose);

			boolean result = EDService.addUser(user);
			
			if (result) {
				request.setAttribute("successMsg", "가입 완료");
				log.info("user 가입 완료");
				url = "userLogin.html";
			} 

		} catch (Exception s) {
			log.info("회원가입 중 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
