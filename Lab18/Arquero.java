package Lab18;
public class Arquero extends Soldado{
    private static int cantidad = 0;
    private int numFlechas;
    
    public Arquero(Ejercito suEjercito){
        super("Arquero",suEjercito);
        setNombre((getTipoDeSoldado()+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
    public void disparar(){
        numFlechas--;
    }
}
