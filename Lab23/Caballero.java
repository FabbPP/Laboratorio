package Lab23;
public class Caballero extends Soldado{
    private static int cantidad = 0;
    private String armaActual = "Lanza";
    private boolean montando = true;
    
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
        if (montando == false){
            montando = true;
            super.atacar();
            cambiarArma();
            nivelAtaque = 3;
        }
    }
    public void desmontar(){
        if (montando == true){
            montando = false;
            super.defender();
            cambiarArma();
            nivelAtaque = 2;
        }
    }
}