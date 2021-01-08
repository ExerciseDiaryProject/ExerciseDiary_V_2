package excerciseDiary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciseDiary.controller.action.Action;

@WebServlet("/excerciseDiary")
public class EDController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");
		System.out.println(command);
		if(command == null) {
			response.sendRedirect("index.html");
			return;
		}
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		action.execute(request, response);
	}
}