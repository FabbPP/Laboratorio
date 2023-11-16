package Lab18;
public class Espadachin extends Soldado{
    private static int cantidad = 0;
    private double longitudDeEspada;
    
    public Espadachin(){
        super("Espadachin");
        setNombre(("Espadachin"+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
    public void crearMurodeEspadas(){
        
    }
}
