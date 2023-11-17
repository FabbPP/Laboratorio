package Lab19;
import java.util.*;
public class Videojuego15 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            bienvenida(territorio);
            Ejercito ejercito1 = territorio.crearEjercito((int)(Math.random()*10) +1,1);
            Ejercito ejercito2 = territorio.crearEjercito((int)(Math.random()*10) +1,2);
            mostrarColores(ejercito1,ejercito2);
            continuar = esContinuar();
        }
    }   
    public static void bienvenida(Mapa unMapa){
        System.out.println("\t\t--->> Bienvenido al juego <---");
    }
    public static void mostrarColores(Ejercito ej1, Ejercito ej2){
        ej1.setColor("rojo");
        ej2.setColor("azul");
        System.out.println("EJERCITOS: "+"Ejercito 1\t Ejercito 2");
        System.out.println("COLOR:  "+ej1.getColor()+"\t\t"+ej2.getColor());
        System.out.println("NUM:    "+ej1.getCantidadSoldados()+"\t\t"+ej1.getCantidadSoldados());
    }
    public static boolean esContinuar(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Desea generar otra partida y empezar de nuevo? (Y/N)\n: ");
        return (sc.next().equals("Y"));
    }    
}