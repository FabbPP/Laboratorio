package Lab16;
import java.util.*;
public class Mapa {
    private ArrayList <ArrayList<Ejercito>> tablero = new ArrayList<>();
    private String tipoDeTerritorio;
    private ArrayList<Ejercito> ejercitos = new ArrayList<>();
    
    public Mapa (String tipoT){ 
        int numFilas = 10; //Inicializamos el tablero
        int numColumnas = 10;
        for (int i=0; i<numFilas;i++) {
            ArrayList<Ejercito> fila = new ArrayList<>();
            for (int j=0;j<numColumnas;j++) 
                fila.add(null); //Inicializa todas las posiciones como null 
            tablero.add(fila);
        }
        tipoDeTerritorio = tipoT;
    }
    public void crearEjercitos() {
        Scanner sc = new Scanner (System.in);
        for (int i = 0; i < Ejercito.MAX_CANTIDAD; i++) {
            int fil = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            while (tablero.get(fil).get(col) != null) { //Mientras que la posicion este ocupada seguir buscando otra
                fil = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            }
            Ejercito nuevoEjercito = new Ejercito ();
            System.out.println("Bienvenido jugador 1: \nEscoja un nombre de Reino ((Inglaterra, Francia, Sacro Imperio, Castilla Aragon y Moros)");
            System.out.print(" >Ingrese el nombre: ");
            nuevoEjercito.setReino(new Reino(sc.next()));
            tablero.get(fil).set(col, nuevoEjercito);
            agregarEjercito(nuevoEjercito);
        }
        for (int i = 0; i < Ejercito.MAX_CANTIDAD; i++) {
            int fil = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            while (tablero.get(fil).get(col) != null) { //Mientras que la posicion este ocupada seguir buscando otra
                fil = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            }
            Ejercito nuevoEjercito = new Ejercito ();
            System.out.println("Bienvenido jugador 2: \nEscoja un nombre de Reino ((Inglaterra, Francia, Sacro Imperio, Castilla Aragon y Moros)");
            System.out.print(" >Ingrese el nombre: ");
            nuevoEjercito.setReino(new Reino(sc.next()));
            tablero.get(fil).set(col, nuevoEjercito);
            agregarEjercito(nuevoEjercito);
        }
    }
    public void agregarEjercito(Ejercito nuevoEjercito){
        ejercitos.add(nuevoEjercito);
    }
    public void mostrarMapa(){
        System.out.println(" A  B  C  D  E  F  G  H  I  J");
        for (int i = 0; i < tablero.size(); i++){
            for (int j = 0; j < tablero.get(i).size(); j++){
                Ejercito posicion = tablero.get(i).get(j);
                if (posicion != null){
                    Ejercito ejercito = posicion.getEjercito();
                    String color = (reino1.contieneEjercito(ejercito)) ? "\u001B[31m" : (reino2.contieneEjercito(ejercito)) ? "\u001B[34m" : "\u001B[0m";
                    System.out.print(color + "|" + posicion.getVidaActual() + "|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|_|");
            }
            System.out.println();   
        }
    }

}
