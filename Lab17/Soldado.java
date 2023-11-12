package Lab17;
public class Soldado {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadTotal = 0; //Variable de Clase
    private Ejercito ejercito; 
    private Reino reino;
    private String nombre;
    private double vidaActual;

    public Soldado(){  //Constructor
        vidaActual = (int)(Math.random() * 5 + 1);
        cantidadTotal ++;
    }
    public static int getCantidadSoldados(){
        return cantidadTotal;
    }
    public String getNombre(){
        return nombre;
    }
    public Ejercito getEjercito(){
        return ejercito;
    }    
    public Reino getReino(){
        return reino;
    }
    public void setVidaActual(double va){
        vidaActual = va;
    }
    public double getVidaActual(){
        return vidaActual;
    }
    public void bonificacionXterritorio(){
        vidaActual ++;
    }
    public void mostrarDatos() {
        System.out.println("  Nombre: " + this.getNombre());
        System.out.println("  Ejercito: " + this.getEjercito());
        System.out.println("  Vida Actual: " + this.getVidaActual());
    }       
}
