package Lab18;
import java.util.*;
public class Videojuego14 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            bienvenida(territorio);
            Reino reino1 = territorio.crearEjercitos((int)(Math.random()*10) +1,1);
            Reino reino2 = territorio.crearEjercitos((int)(Math.random()*10) +1,2);
            territorio.generarMovimiento(reino1,reino2);
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