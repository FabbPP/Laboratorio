package Lab18;
public class Espadachin extends Soldado{
    private static int cantidad = 0;
    private double longitudDeEspada;
    
    public Espadachin(Ejercito suEjercito){
        super("Espadachin",suEjercito);
        setNombre((getTipoDeSoldado()+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
    public void crearMurodeEspadas(){
        
    }
}
