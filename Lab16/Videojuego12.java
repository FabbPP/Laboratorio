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
            mostrarColores(reino1,reino2);
            determinarGanador(reino1,reino2);
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
    public static void mostrarColores(Reino reino1,Reino reino2){
        System.out.println("REINOS: "+reino1.getNombre()+"\t"+reino2.getNombre());
        System.out.println("COLOR:  "+reino1.getColor()+"\t\t"+reino2.getColor());
        System.out.println("NUM:    "+reino1.getCantidadEjercitos()+"\t\t"+reino2.getCantidadEjercitos());
    }
    public static void determinarGanador(Reino reino1, Reino reino2){//v es reino1, f es reino2
        System.out.println("Se calculara el ganador calificando las siguientes metricas");
        int gano1=0, gano2=0;
        boolean m1 = metrica1(reino1,reino2);
        interpretacionGanador(reino1,reino2,m1,gano1,gano2);
        boolean m2 = metrica2(reino1,reino2);
        interpretacionGanador(reino1,reino2,m2,gano1,gano2);
        boolean m3 = metrica3(reino1,reino2);
        interpretacionGanador(reino1,reino2,m3,gano1,gano2);
        if (gano1>gano2)
            System.out.println("Felicitaciones ganador reino1");
        else
            System.out.println("Felicitaciones ganador reino2");
    }
    public static boolean metrica1(Reino reino1,Reino reino2){ //Metrica nivel vida Reino
        System.out.println("-Metrica nivel total de vida del Reino");
        int nivelVidaR1 = reino1.getTotalVidaReino();
        int nivelVidaR2 = reino2.getTotalVidaReino();
        return(nivelVidaR1>nivelVidaR2);//V es gano reino1, F es gano reino2
    }
    public static boolean metrica2(Reino reino1,Reino reino2){  //Metrica cantidad soldados Reino
        System.out.println("-Metrica cantidad de soldados del Reino");
        int numSolR1 = reino1.getCantidadSoldados();
        int numSolR2 = reino2.getCantidadSoldados();
        return(numSolR1>numSolR2);//V es gano reino1, F es gano reino2
    }
    public static boolean metrica3(Reino reino1,Reino reino2){ //Metrica cantidad ejercitos Reino
        System.out.println("-Metrica cantidad de ejercitos del Reino");
        int numEjeR1 = reino1.getCantidadEjercitos();
        int numEjeR2 = reino2.getCantidadEjercitos();
        return(numEjeR1>numEjeR2);//V es gano reino1, F es gano reino2
    }
    public static void interpretacionGanador(Reino reino1, Reino reino2, boolean booleano,int c1,int c2){
        if (booleano == true){
            System.out.println("Ganador: "+reino1.getNombre());
            c1++;
        }
        else{
            System.out.println("Ganador: "+reino2.getNombre());
            c2++;
        }
    }
}