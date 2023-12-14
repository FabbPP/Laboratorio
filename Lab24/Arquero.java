package Lab24;
public class Arquero extends Soldado{
    private static int cantidad = 0;
    private int numFlechas;
    
    public Arquero(Ejercito suEjercito){
        super("Arquero",suEjercito);
        nivelAtaque = 7;
        nivelDefensa = 3;
        cantidad++;
    }
    public void disparar(){
        if (numFlechas > 0)
            numFlechas--;
    }
}
