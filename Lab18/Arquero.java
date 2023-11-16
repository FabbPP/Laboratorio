package Lab18;
public class Arquero extends Soldado{
    private static int cantidad = 0;
    private int numFlechas;
    
    public Arquero(){
        super("Arquero");
        setNombre(("Arquero"+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
    public void disparar(){
        numFlechas--;
    }
}
