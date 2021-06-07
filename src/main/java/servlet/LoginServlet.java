package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.JDBCPuuntiheysDAO;
import database.JDBCPuuntiheysDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	
	private final static String pin = "42";

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCPuuntiheysDAO dao = new JDBCPuuntiheysDAO();
		try {
			String givenPin = req.getParameter("salasana");
			if (givenPin.equals(pin)) {
				req.setAttribute("items", dao.getAll());
				System.out.println(dao.getAll());
				resp.sendRedirect("/database");
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			e.printStackTrace();
			
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}