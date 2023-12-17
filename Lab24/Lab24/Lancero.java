package Lab24;
public class Lancero extends Soldado {
    private static int cantidad = 0;
    private double longitudDeLanza;
    
    public Lancero(Ejercito suEjercito){
        super("Lancero",suEjercito);
        nivelAtaque = 5;
        nivelDefensa = 10;
        cantidad++;
    }
    public void schiltrom(){
        nivelDefensa ++;
    }
}
