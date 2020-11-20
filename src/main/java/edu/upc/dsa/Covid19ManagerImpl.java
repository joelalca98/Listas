package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {



    private static Covid19ManagerImpl manager;
    static final Logger logger = Logger.getLogger(Covid19ManagerImpl.class.getName());
    HashMap<String, ResourceBundle> data;
    HashMap<String, Brote> brotes;
    List<Caso> casos;
    Brote Mibrote;
    List<Caso> miListaCasos;
    List<Caso> resultado1;
    List<Caso> resultado2;
    List<Caso> resultado3;

    private Covid19ManagerImpl() /** Parte de Singletone */
    {
        this.data = new HashMap<String, ResourceBundle>();
    }

    public static  Covid19ManagerImpl getInstance() /**  La unica entrada a una única instancia*/
    {
        if(manager == null) manager = new Covid19ManagerImpl();

        return manager;
    }

    @Override
    public void addBrote(String idBrote) {
        this.brotes.put(idBrote,new Brote(idBrote));

    }

    @Override
    public Brote getBrote(String idBrote) {
        Brote brote = this.brotes.get(idBrote);
        logger.info("getbrote(" + idBrote + ")");
        return brote;
    }

    @Override
    public Brote addBrote(Brote brote) {
        this.brotes.put(null, brote);
        return brote;
    }

    @Override
    public Collection<Brote> brotesDisp() {
        return brotes.values();

    }

    @Override
    public Caso addCaso(Caso o) {
        this.casos.add(o);

        return o;
    }

    @Override
    public Caso addCaso(String nombre, String apellidos, String idCaso, Date fechaNacimiento, Date fechaInforme, String clasificación, String genero, String correo, String telefono, String direccion) {
      return this.addCaso(new Caso(nombre, apellidos, idCaso, fechaNacimiento, fechaInforme, clasificación, genero, correo, telefono, direccion));

    }

    @Override
    public List<Caso> ordersByClasificacion(String idBrote) {


        Mibrote = brotes.get(idBrote);
        miListaCasos = Mibrote.getCasosList();


        for (Caso f: miListaCasos) {
            if (f.getClasificación() == "confirmado") {


                resultado1.add(f); /**  Falta ordenarlo por fecha */





            }
            if (f.getClasificación() == "sospechoso") {

                resultado2.add(f);  /**  Falta ordenarlo por fecha */




            }
            if (f.getClasificación() == "noCaso") {

                resultado3.add(f);  /**  Falta ordenarlo por fecha */


            }



        }



        return resultado3;
    }

    @Override
    public int sizeBrotes() {



        int ret = this.brotes.size();
        logger.info("size caso" + ret);

        return ret;

    }

    public int sizeCasos() {


        int ret = this.casos.size();
        logger.info("size casos" + ret);

        return ret;

    }








    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");
    }




}
