package bean;

import java.util.ArrayList;
import java.util.List;

public class CineTarifa {
    String DiasSemana = "", Precio = "";

    public CineTarifa() {
    }
    
    public CineTarifa( String DiaSemana, String Precio ) {
        this.DiasSemana = DiaSemana;
        this.Precio = Precio;
    }

    public String getDiasSemana() {
        return DiasSemana;
    }

    public void setDiasSemana(String DiasSemana) {
        this.DiasSemana = DiasSemana;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
    
    public List<CineTarifa> getCineTarifaList ( String [][] mRegistros ){
        if( mRegistros == null) return null;
        
        List<CineTarifa> lstCineTarifa = new ArrayList<>();
        for ( String [] aCineTarifa : mRegistros)
            lstCineTarifa.add( new CineTarifa( aCineTarifa [0], aCineTarifa[1] ) );
        
        return lstCineTarifa;
    }
}    
