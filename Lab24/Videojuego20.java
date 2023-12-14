package Lab24;
import Lab23.*;
import java.util.*;
import javax.swing.*;
public class Videojuego20 {
    public static void main (String[] args){
        boolean continuar = true;
        while(continuar){
            Mapa territorio = new Mapa();
            VentanaInicio inicio = new VentanaInicio(territorio);
            Ejercito ejercito1 = territorio.crearEjercito((int)(Math.random()*10) +1,1,"rojo");
            Ejercito ejercito2 = territorio.crearEjercito((int)(Math.random()*10) +1,2,"azul");
            territorio.mostrarTablero();
            datosSoldadosEjercitos(territorio);
            territorio.generarMovimiento(ejercito1,ejercito2);
            continuar = esContinuar();
        }
    }   
    
    public static boolean esContinuar(){
        Scanner sc = new Scanner (System.in);
        int se = JOptionPane.showConfirmDialog(null,"Desea generar otra partida y empezar de nuevo? (Y/N)\n: ","Iniciar nueva partida?",JOptionPane.YES_NO_OPTION);
        return (se == JOptionPane.YES_OPTION);
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