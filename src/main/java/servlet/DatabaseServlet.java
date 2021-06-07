package servlet;

import model.Puuntiheys;


import java.text.DecimalFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import database.JDBCPuuntiheysDAO;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import database.JDBCPuuntiheysDAO;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/database" })
public class DatabaseServlet extends HttpServlet{
	
	JDBCPuuntiheysDAO dao = new JDBCPuuntiheysDAO();
	String result = "";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("result", result);
		result = "";
		req.setAttribute("haut", dao.getAll());
		req.getRequestDispatcher("/database.jsp").forward(req, resp);
	}
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DecimalFormat desimal = new DecimalFormat("0.00");
		try {
			double paksuus = Double.valueOf(req.getParameter("paksuus")) ;
			double pituus = Double.valueOf(req.getParameter("pituus"));
			double leveys = Double.valueOf(req.getParameter("leveys")) ;
			double paino = Double.valueOf(req.getParameter("paino")) ;
			String grain = req.getParameter("grain");
			double tilavuus = (paksuus * pituus * leveys);
	        double tiheys = Math.round((paino/1000.0) / (tilavuus/1000000000.0));
	      
	        result = desimal.format(tiheys);
			
			
			Puuntiheys levy = new Puuntiheys(tiheys, paksuus, leveys, paino, pituus, grain);
			dao.addItem(levy);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("/database");
	}
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		Puuntiheys toDelete = dao.getItem(id);
		dao.removeItem(toDelete);
    }
}	

