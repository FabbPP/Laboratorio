package Lab24;
public class CaballeroMoro extends Soldado implements SoldadoEspecial{
    private static int cantidad;
    private int cantidadFlechas;
    private int tamañoFlechas;

    public CaballeroMoro (Ejercito suEjercito){
        super("Caballero_Moro", suEjercito);
        vidaActual = 13;
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad ++;
    }
    public void realizarHabilidadEspecial(){
        lanzarFlechas();
        envestir();
    }
    public void subirNivelEvolucion(){
        cantidadFlechas += 5;
        tamañoFlechas --;
        nivelAtaque ++;
    }
    public void lanzarFlechas(){
        cantidadFlechas --;
    }
    public void envestir(){
    }
}
