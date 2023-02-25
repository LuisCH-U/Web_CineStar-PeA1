package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class svlCine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public svlCine() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		dao.daoCine daoCine = new dao.daoCine();
		
		Object idCine =request.getParameter("idCine");
		if( idCine == null) {
			String[][]mCines =daoCine.getVerCines();
			session.setAttribute("id", mCines == null ? null : "4");
			session.setAttribute("mCines", mCines);
		}
		response.sendRedirect("index.jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
