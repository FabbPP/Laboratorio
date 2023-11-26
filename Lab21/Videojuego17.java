package Lab21;
import java.util.*;
public class Videojuego17 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            inicioTerritorio(territorio);
            Ejercito ejercito1 = territorio.crearEjercito((int)(Math.random()*10) +1,1);
            ejercito1.setColor("rojo");
            Ejercito ejercito2 = territorio.crearEjercito((int)(Math.random()*10) +1,2);
            ejercito2.setColor("azul");
            territorio.mostrarTablero();
            datosSoldadosEjercitos(territorio);
            determinarGanador(ejercito1,ejercito2);
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
            System.out.println("|---DATOS EJERCITO "+(i+1)+"---|");
            System.out.println("|______________________|");
            ej.mostrarDatosSoldados(); //Se muestran datos de todos los soldados ejercito en orden creacion
            ej.mostrarDatosMayorVida();
            System.out.println("Promedio de nivel de vida del ejercito : "+ej.getPromedioNivelVida());
            ej.mostrarRankingDePoder();
            System.out.println(); //Solo para mayor orden y estetica
        }
    }
    public static void determinarGanador(Ejercito ej1, Ejercito ej2){//v es reino1, f es reino2
        System.out.println("Se calculara el ganador calificando las siguientes metricas");
        int gano1=0, gano2=0;
        boolean m1 = metrica1(ej1,ej2);
        interpretacionGanador(ej1,ej2,m1,gano1,gano2);
        boolean m2 = metrica2(ej1,ej2);
        interpretacionGanador(ej1,ej2,m2,gano1,gano2);
        if (gano1>gano2)
            System.out.println("Felicitaciones ganador ejercito1 "+ej1.getNombre());
        else
            System.out.println("Felicitaciones ganador ejercito2 "+ej2.getNombre());
    }
    public static boolean metrica1(Ejercito ej1,Ejercito ej2){ //Metrica nivel vida Reino
        System.out.println("-Metrica nivel total de vida del Ejercito");
        double nivelVidaR1 = ej1.getNivelVidaTotal();
        double nivelVidaR2 = ej2.getNivelVidaTotal();
        System.out.println(ej1.getNombre()+"  /  "+ej2.getNombre());
        System.out.println("    "+nivelVidaR1+"      /  "+nivelVidaR2);
        return(nivelVidaR1>nivelVidaR2);//V es gano ejercito1, F es gano ejercito2
    }
    public static boolean metrica2(Ejercito ej1,Ejercito ej2){  //Metrica cantidad soldados Reino
        System.out.println("-Metrica cantidad de soldados del Ejercito");
        int numSolR1 = ej1.getCantidadSoldados();
        int numSolR2 = ej2.getCantidadSoldados();
        System.out.println(ej1.getNombre()+"  /  "+ej2.getNombre());
        System.out.println("    "+numSolR1+"      /  "+numSolR2);
        return(numSolR1>numSolR2);//V es gano reino1, F es gano reino2
    }
    public static void interpretacionGanador(Ejercito ej1,Ejercito ej2, boolean booleano,int c1,int c2){
        if (booleano){
            System.out.println("Ganador: "+ej1.getNombre());
            c1++;
        }
        else{
            System.out.println("Ganador: "+ej2.getNombre());
            c2++;
        }
    }
}