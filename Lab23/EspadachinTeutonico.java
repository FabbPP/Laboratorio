package Lab23;
public class EspadachinTeutonico extends Soldado implements SoldadoEspecial{
    private static int cantidad;
    private int cantidadJabalinas;
    private int tamañoJabalinas;

    public EspadachinTeutonico (Ejercito suEjercito){
        super("Espadachin_Teutonico", suEjercito);
        vidaActual = 13;
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad ++;
    }
    public void realizarHabilidadEspecial(){
        if (cantidadJabalinas > 0)
            lanzarJabalina();
        else
            System.out.println("No quedan jabalinas disponibles");
    }
    public void subirNivelEvolucion(){
        cantidadJabalinas += 5;
        tamañoJabalinas --;
    }
    public void lanzarJabalina(){
        cantidadJabalinas --;
    }
}
