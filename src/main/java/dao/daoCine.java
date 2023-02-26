package dao;

import java.util.List;
import bean.Cine;
import bean.CinePelicula;
import bean.CineTarifa;

public class daoCine {
	db.DB db= new db.DB("cinestar");

	public String[][] getCines() {
		db.Sentencia("call sp_getCines()");
		return db.getRegistros();
				
	}
	
	public String[] getCine(Object idCine) {
		db.Sentencia(String.format("call sp_getCine(%s)", idCine ) );
        return db.getRegistro();

    }

    public String[][] getCineTarifas(Object idCine) {
    	db.Sentencia(String.format("call sp_getCineTarifas(%s)", idCine ) );
        return db.getRegistros();
    }

    public String[][] getCinePeliculas(Object idCine) {
    	db.Sentencia(String.format("call sp_getCinePeliculas(%s)", idCine ) );
        return db.getRegistros();
    }
    
    public List<Cine> getCineList() {
        db.Sentencia("call sp_getCines()");
        return  new Cine().getRegistros( db.getRegistros() );
    }
    
    public Cine getCineList(Object idCine) {
        db.Sentencia(String.format("call sp_getCine(%s)", idCine ) );
        return  new Cine( db.getRegistro() );

    }
    
    public List<CineTarifa> getCineTarifasList (Object idCine) {
         db.Sentencia(String.format("call sp_getCineTarifas(%s)", idCine ) );
        return new CineTarifa().getCineTarifaList( db.getRegistros() );
    }
    
    public List<CinePelicula> getCinePeliculasList (Object idCine) {
         db.Sentencia(String.format("call sp_getCinePeliculas(%s)", idCine ) );
        return new CinePelicula().getCinePeliculaList( db.getRegistros() );
    }


}
