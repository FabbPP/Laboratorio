package Lab24;
public class Espadachin extends Soldado{
    private static int cantidad = 0;
    private boolean muroEscudos = false;
    private double longitudDeEspada;
    
    public Espadachin(Ejercito suEjercito){
        super("Espadachin",suEjercito);      
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad++;
    }
    public void crearMurodeEspadas(){
        if (muroEscudos == true)
            muroEscudos = false;
        else{
            nivelDefensa ++;
            muroEscudos = true;
        }
    }
}
