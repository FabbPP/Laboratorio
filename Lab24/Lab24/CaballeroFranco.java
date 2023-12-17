package Lab24;
public class CaballeroFranco extends Soldado implements SoldadoEspecial{
    private static int cantidad;
    private int cantidadLanzas;
    private int tamañoLanza;

    public CaballeroFranco (Ejercito suEjercito){
        super("Caballero_Franco", suEjercito);
        vidaActual = 15;
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad ++;
    }
    public void realizarHabilidadEspecial(){
        if (cantidadLanzas > 0)
            lanzarLanzas();
        else
            System.out.println("No quedan lanzas disponibles");
    }
    public void subirNivelEvolucion(){
        cantidadLanzas += 5;
        tamañoLanza ++;
    }
    public void lanzarLanzas(){
        cantidadLanzas --;
    }
}
