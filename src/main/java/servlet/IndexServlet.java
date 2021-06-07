package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.text.DecimalFormat;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import database.JDBCPuuntiheysDAO;
import database.JDBCPuuntiheysDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/index" })
public class IndexServlet extends HttpServlet
{
    JDBCPuuntiheysDAO levy;
    
    public IndexServlet() {
        this.levy = new JDBCPuuntiheysDAO();
    }
    
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        String density = "";
        final DecimalFormat desimal = new DecimalFormat("0.00");
        try {
            double paksuus = Double.parseDouble(req.getParameter("paksuus")) ;
            double pituus = Double.parseDouble(req.getParameter("pituus")) ;
            double leveys = Double.parseDouble(req.getParameter("leveys")) ;
            double paino = Double.parseDouble(req.getParameter("paino")) ;
            density = desimal.format((paino/1000.0) * 2.20462262185 / ((paksuus/1000.0) * 3.2808399 * ((pituus/1000.0) * 3.2808399) * ((leveys/1000.0) * 3.2808399)));
            double tilavuus = (paksuus * pituus * leveys);
            double tiheys = (paino/1000.0) / (tilavuus/1000000000.0);
            result = desimal.format(tiheys);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("result", result);
        req.setAttribute("density", density);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/index");
    }
    
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    }
}