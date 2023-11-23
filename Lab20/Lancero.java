package Lab20;
public class Lancero extends Soldado {
    private static int cantidad = 0;
    private double longitudDeLanza;
    
    public Lancero(Ejercito suEjercito){
        super("Lancero",suEjercito);
        setNombre((getTipoDeSoldado()+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
    public void schiltrom(){
        nivelDefensa ++;
    }
    
}
