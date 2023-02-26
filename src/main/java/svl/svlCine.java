package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import bean.Cine;


public class svlCine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public svlCine() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		dao.daoCine daoCine = new dao.daoCine();
		
		Object idCine= request.getParameter("idCine");
		if (idCine == null ){
			//String[][] mCines = daoCine.getCines();
			//session.setAttribute( "id", mCines == null ? null : "Cine" );
            //session.setAttribute("mCines", mCines);
            
            List <Cine> lstCine = daoCine.getCineList();
            session.setAttribute( "id", lstCine == null ? null : "cines" );
            session.setAttribute("lstCine", lstCine);
         
           
        }else{
        	//String [] aCine =daoCine.getCine(idCine);
        	//session.setAttribute( "id", aCine == null ? null : "lstCine" );
        	//session.setAttribute("aCine", aCine);
        	//session.setAttribute("mTarifas", daoCine.getCineTarifas(idCine) );
        	//session.setAttribute("mPeliculas", daoCine.getCinePeliculas(idCine) );
            
            Cine Cine = daoCine.getCineList(idCine);
            session.setAttribute( "id", Cine == null ? null : "cine" );
            session.setAttribute("Cine", Cine);
            session.setAttribute("lstCineTarifa", daoCine.getCineTarifasList( idCine ) );
            session.setAttribute("lstCinePelicula", daoCine.getCinePeliculasList( idCine ) );

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
