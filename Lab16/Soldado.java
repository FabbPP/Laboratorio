package Lab16;
public class Soldado {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadTotal = 0; //Variable de Clase
    private Ejercito ejercito; 
    private Reino reino;
    private String nombre;
    private double vidaActual;

    
    //Constructor sobrecargado
    public Soldado(){  //Simula un setNombre y es el principal
        vidaActual = (int)(Math.random() * 5 + 1);
        cantidadTotal ++;
    }
    //Metodos de clase
    public static int getCantidadTotal(){
        return cantidadTotal;
    }
    //Get y set de atributos 
     //Metodos de atributos solo accesores, ya definidos en clase Soldado
    public String getNombre(){
        return nombre;
    }
    public Ejercito getEjercito(){
        return ejercito;
    }    
    public Reino getReino(){
        return reino;
    }
    public double getVidaActual(){
        return vidaActual;
    }
    public void bonificacionxTerritorio(){
        vidaActual++;
    }
    public void mostrarDatos() {
        System.out.println("  Nombre: " + this.getNombre());
        System.out.println("  Ejercito: " + this.getEjercito());
        System.out.println("  Vida Actual: " + this.getVidaActual());
    }       
}
