package Lab18;
import java.util.*;
public class Videojuego14 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            bienvenida(territorio);
            Ejercito ejercito1 = territorio.crearEjercito((int)(Math.random()*10) +1,1);
            Ejercito ejercito2 = territorio.crearEjercito((int)(Math.random()*10) +1,2);
            territorio.mostrarTablero();
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
        System.out.println("NUM:    "+ej1.getCantidadSoldados()+"\t\t"+ej2.getCantidadSoldados());
    }
    public static boolean esContinuar(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Desea generar otra partida y empezar de nuevo? (Y/N)\n: ");
        return (sc.next().equals("Y"));
    }    
    public static void determinarGanador(Ejercito ej1, Ejercito ej2){//v es reino1, f es reino2
        System.out.println("Se calculara el ganador calificando las siguientes metricas");
        int gano1=0, gano2=0;
        boolean m1 = metrica1(ej1,ej2);
        interpretacionGanador(ej1,ej2,m1,gano1,gano2);
        boolean m2 = metrica2(ej1,ej2);
        interpretacionGanador(ej1,ej2,m2,gano1,gano2);
        if (gano1>gano2)
            System.out.println("Felicitaciones ganador ejercito1");
        else
            System.out.println("Felicitaciones ganador ejercito2");
    }
    public static boolean metrica1(Ejercito ej1,Ejercito ej2){ //Metrica nivel vida Reino
        System.out.println("-Metrica nivel total de vida del Ejercito");
        int nivelVidaR1 = ej1.getNivelVidaTotal();
        int nivelVidaR2 = ej2.getNivelVidaTotal();
        return(nivelVidaR1>nivelVidaR2);//V es gano reino1, F es gano reino2
    }
    public static boolean metrica2(Ejercito ej1,Ejercito ej2){  //Metrica cantidad soldados Reino
        System.out.println("-Metrica cantidad de soldados del Ejercito");
        int numSolR1 = ej1.getCantidadSoldados();
        int numSolR2 = ej2.getCantidadSoldados();
        return(numSolR1>numSolR2);//V es gano reino1, F es gano reino2
    }
    public static void interpretacionGanador(Ejercito ej1,Ejercito ej2, boolean booleano,int c1,int c2){
        if (booleano == true){
            System.out.println("Ganador: "+ej1.getNombre());
            c1++;
        }
        else{
            System.out.println("Ganador: "+ej2  .getNombre());
            c2++;
        }
    }
}