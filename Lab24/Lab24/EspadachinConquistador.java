package Lab24;
public class EspadachinConquistador extends Soldado implements SoldadoEspecial{
    private static int cantidad;
    private int cantidadHachasLanzables;
    private int tamañoHachasLanzables;

    public EspadachinConquistador (Ejercito suEjercito){
        super("Espadachin_Conquistador", suEjercito);
        vidaActual = 14;
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad ++;
    }
    public void realizarHabilidadEspecial(){
        lanzarHachasLanzables();
    }
    public void subirNivelEvolucion(){
        cantidadHachasLanzables += 5;
        tamañoHachasLanzables --;
    }
    public void lanzarHachasLanzables(){
        cantidadHachasLanzables --;
    }
}
