package Lab18;
import java.util.*;
public class Mapa {
    private ArrayList <ArrayList<Soldado>> tablero = new ArrayList<>();
    private ArrayList<Ejercito> ejercitos = new ArrayList<>();
    public Mapa (){ 
        int numFilas = 10; //Inicializamos el tablero
        int numColumnas = 10;
        for (int i=0; i<numFilas;i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j=0;j<numColumnas;j++) 
                fila.add(null); //Inicializa todas las posiciones como null 
            tablero.add(fila);
        }
    }
    public Ejercito crearEjercito(int random, int numJugador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido jugador " + numJugador);
        Ejercito nuevoEjercito = new Ejercito(numJugador);
        agregarEjercito(nuevoEjercito);
        for (int i = 0; i < nuevoEjercito.getCantidadSoldadosCrear(); i++) {
            Soldado nuevoSoldado;
            int tipoSoldado = (int) (Math.random() * 3); // 0Caballero, 1Espadachin, 2Arquero
            switch (tipoSoldado) {
                case 0:
                    nuevoSoldado = new Caballero(nuevoEjercito);
                    break;
                case 1:
                    nuevoSoldado = new Espadachin(nuevoEjercito);
                    break;
                case 2:
                    nuevoSoldado = new Arquero(nuevoEjercito);
                    break;
                default:
                    nuevoSoldado = new Caballero(nuevoEjercito); // Por defecto, crea un Caballero
                    break;
            }
            int fil = (int) ((Math.random() * 10)+1);
            int col = (int) ((Math.random() * 10)+1);
            while (tablero.get(fil-1).get(col-1) != null) {
                fil = (int) ((Math.random() * 10)+1);
                col = (int) ((Math.random() * 10)+1);
            }
            nuevoSoldado.setFila(fil).setColumna(col);
            tablero.get(fil-1).set(col-1, nuevoSoldado);
            nuevoEjercito.agregarSoldado(nuevoSoldado);
        }
        return nuevoEjercito;
    }
    public void agregarEjercito(Ejercito nuevoEjercito){
        ejercitos.add(nuevoEjercito);
    }
    public void mostrarTablero() { //Secundario de GenerarMovimiento
        System.out.println("Tablero:  ");
        System.out.println("     A   B   C   D   E   F   G   H   I   J");
        for (int i = 0; i < tablero.size(); i++){
            if (i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for (int j = 0; j < tablero.get(i).size(); j++){
                Soldado p = tablero.get(i).get(j);
                if (p != null){
                    Ejercito ejercito = p.getEjercito();
                    String color = (ejercito==ejercitos.get(0))? "\u001B[31m" : (ejercito==ejercitos.get(1))? "\u001B[34m" : "\u001B[0m";
                    System.out.print(color+"|"+p.getTipoDeSoldado().indexOf(0)+p.getVidaActual()+"|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|__|");
            }
            System.out.println(); 
        }
    }    
}