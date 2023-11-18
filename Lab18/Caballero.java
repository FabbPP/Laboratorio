package Lab18;
public class Caballero extends Soldado{
    private static int cantidad = 0;
    private String armaActual = "Lanza";
    private boolean montando = true;
    
    public Caballero(Ejercito suEjercito){
        super("Caballero",suEjercito);
        setNombre((getTipoDeSoldado()+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
}