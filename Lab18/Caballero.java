package Lab18;
public class Caballero extends Soldado{
    private static int cantidad = 0;
    private String armaActual = "Lanza";
    private boolean montando = true;
    
    public Caballero(){
        super("Caballero");
        setNombre(("Caballero"+cantidad+"x"+getEjercito().getNombre()));
        cantidad++;
    }
    public void agregarCaballero(){
        
    }
}
