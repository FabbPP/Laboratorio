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
            territorio.mostrarTablero();
            territorio.generarMovimiento(ejercito1,ejercito2);
            continuar = esContinuar();
        }
    }   
    public static void bienvenida(Mapa unMapa){
        System.out.println("\t\t--->> Bienvenido al juego <---");
    }
    public static boolean esContinuar(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Desea generar otra partida y empezar de nuevo? (Y/N)\n: ");
        return (sc.next().equals("Y"));
    }    
}