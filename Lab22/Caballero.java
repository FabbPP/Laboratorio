package Lab22;
public class Caballero extends Soldado{
    private static int cantidad = 0;
    private String armaActual;
    private boolean montando;
    
    public Caballero(Ejercito suEjercito){
        super("Caballero",suEjercito);      
        nivelAtaque = 13;
        nivelDefensa = 7;
        cantidad++;
    }   
    public void cambiarArma(){
        if ("Lanza".equals(armaActual))
            armaActual = "Espada";
        else
            armaActual = "Lanza";
    }
    public void montar(){
        armaActual = "Lanza";
        montando = true;
        nivelAtaque = 3;
    }
    public void desmontar(){
        montando = false;
        actitud = "Defensa";
        armaActual = "Espada";
        nivelAtaque = 2;
    }
}