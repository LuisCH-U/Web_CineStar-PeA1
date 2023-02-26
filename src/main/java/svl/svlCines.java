package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import bean.Cine;

public class svlCines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public svlCines() {
        super();
         
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
				dao.daoCine daoCine = new dao.daoCine();
	
    
    Object idCine = request.getParameter("idCine");
    
    if ( idCine == null ) {
    	String[][] aCines = daoCine.getCines();
    	session.setAttribute("id", aCines == null ? null : "cines");
    	session.setAttribute("aCines", aCines);
    	
    	
    	//List<Cine> lstCines = daoCine.getCinesList();
    	//session.setAttribute("id", lstCines == null ? null : "Cines");
    	//session.setAttribute("lstCines", lstCines);
    	
    } else {
    	
    	String[] aCine = daoCine.getCine( idCine );
    	session.setAttribute("id", aCine == null ? null : "cine");
    	session.setAttribute("Cine", aCine);
    	session.setAttribute("Tarifas", daoCine.getCineTarifas( idCine ));
    	session.setAttribute("Peliculas", daoCine.getCinePeliculas( idCine ));
    	
    	
    	//Cine Cine = daoCine.getCineList( idCine );
    	//session.setAttribute("id", Cine == null ? null : "Cine" );
    	//session.setAttribute("Cine", Cine);
    	//session.setAttribute("lstCineTarifas", daoCine.getCineTarifasList( idCine ) );
    	//session.setAttribute("lstCinePeliculas", daoCine.getCinePeliculasList( idCine ) );
    
    }
    
    response.sendRedirect("index.jsp");
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}
