package Lab22;
public class Espadachin extends Soldado{
    private static int cantidad = 0;
    private double longitudDeEspada;
    
    public Espadachin(Ejercito suEjercito){
        super("Espadachin",suEjercito);      
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad++;
    }
    public void crearMurodeEspadas(){
        nivelDefensa ++;
    }
}
