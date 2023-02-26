package bean;

import java.util.ArrayList;
import java.util.List;

public class CinePelicula {
    String Titulo = "", Horarios = "";

    public CinePelicula() {
    }
    
    public CinePelicula( String DiaSemana, String Horarios ) {
        this.Titulo = DiaSemana;
        this.Horarios = Horarios;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getHorarios() {
        return Horarios;
    }

    public void setHorarios(String Horarios) {
        this.Horarios = Horarios;
    }
    
    public List<CinePelicula> getCinePeliculaList ( String [][] mRegistros ){
        if( mRegistros == null) return null;
        
        List<CinePelicula> lstCinePelicula = new ArrayList<>();
        for ( String [] aCinePelicula : mRegistros)
            lstCinePelicula.add( new CinePelicula( aCinePelicula [0], aCinePelicula[1] ) );
        
        return lstCinePelicula;
    }
}    