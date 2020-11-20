package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Brote {
    private  String idBrote; /** Solo tiene estos dos atributos, id y una lista de casos*/
    List<Caso> casosList;

    public String getIdBrote(){
        return idBrote;
    }
    public Brote (){}
    public Brote(String idBrote) { /** Constructor*/
        this.idBrote = idBrote;
        this.casosList = new LinkedList<Caso>();
    }
    public void addCaso(Caso caso){ /**Añadimos casos al brote */
        this.casosList.add(caso);
    }

    public List<Caso> getCasosList() { /** Devolver Uns lista de casos */
        return casosList;
    }


}
