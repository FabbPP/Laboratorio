package Lab23;
public class EspadachinReal extends Soldado implements SoldadoEspecial{
    private static int cantidad;
    private int cantidadCuchillos;
    private int tamañoCuchillo;

    public EspadachinReal(Ejercito suEjercito){
        super("Espadachin_Real", suEjercito);
        vidaActual = 12;
        nivelAtaque = 10;
        nivelDefensa = 8;
        cantidad ++;
    }
    public void realizarHabilidadEspecial(){
        if (cantidadCuchillos > 0)
            lanzarCuchillos();
        else
            System.out.println("No quedan cuchillos disponibles");
    }
    public void subirNivelEvolucion(){
        cantidadCuchillos += 5;
        tamañoCuchillo ++;
    }
    public void lanzarCuchillos(){
        cantidadCuchillos --;
    }
}
