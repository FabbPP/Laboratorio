package Lab16;
import java.util.*;
public class Videojuego12 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            inicioTerritorio(territorio);
            Reino reino1 = territorio.crearEjercitos((int)(Math.random()*10) +1,1);
            Reino reino2 = territorio.crearEjercitos((int)(Math.random()*10) +1,2);
            territorio.mostrarTablero();
            
            continuar = esContinuar();
        }
    }
    
    public static void inicioTerritorio(Mapa unMapa){
        System.out.println("\t\t--->> Bienvenido al juego <---");
        System.out.println("\t\t Iniciando campo de batalla\n\t\t\t   ...\n\t  Se elegira aleatoriamente un territorio...");
        System.out.println("\t\t\t"+unMapa.getTipoDeTerritorio()+"\n");
    }
    public static boolean esContinuar(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Desea generar otra partida y empezar de nuevo? (Y/N)\n: ");
        return (sc.next().equals("Y"));
    }
    public static void mostrarColores(){
        
    }
}
