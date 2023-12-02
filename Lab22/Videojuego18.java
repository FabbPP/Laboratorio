package Lab22;
import java.util.*;
public class Videojuego18 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            inicioTerritorio(territorio);
            Ejercito ejercito1 = territorio.crearEjercito((int)(Math.random()*10) +1,1,"rojo");
            Ejercito ejercito2 = territorio.crearEjercito((int)(Math.random()*10) +1,2,"azul");
            territorio.mostrarTablero();
            datosSoldadosEjercitos(territorio);
            territorio.generarMovimiento(ejercito1,ejercito2);
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
    public static void datosSoldadosEjercitos(Mapa unMapa){
        ArrayList <Ejercito> ejercitos = unMapa.getEjercitos(); 
        for (int i = 0; i < ejercitos.size(); i++){
            Ejercito ej = ejercitos.get(i);
            System.out.println("|------DATOS EJERCITO "+(i+1)+"------|");
            System.out.println("|____________________________|");
            ej.mostrarInformacion(i+1);
            ej.mostrarDatosSoldados(); //Se muestran datos de todos los soldados ejercito en orden creacion
            ej.mostrarDatosMayorVida();
            System.out.println("Promedio de nivel de vida del ejercito : "+ej.getPromedioNivelVida());
            ej.mostrarRankingDePoder();
            System.out.println(); //Solo para mayor orden y estetica
        }
    }

}