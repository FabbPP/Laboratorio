package Lab16;
import java.util.*;
public class Mapa {
    private static final String[] TIPOS_DE_TERRITORIO = {"bosque","campo abierto","montania","desierto","playa"};
    private static final Map<String, String> BONOS_POR_TERRITORIO = new HashMap<>();
    private static String tipoDeTerritorio;
    private ArrayList <ArrayList<Ejercito>> tablero = new ArrayList<>();
    private ArrayList<Ejercito> ejercitos = new ArrayList<>();
    
    public Mapa (){ 
        int numFilas = 10; //Inicializamos el tablero
        int numColumnas = 10;
        for (int i=0; i<numFilas;i++) {
            ArrayList<Ejercito> fila = new ArrayList<>();
            for (int j=0;j<numColumnas;j++) 
                fila.add(null); //Inicializa todas las posiciones como null 
            tablero.add(fila);
        }
        int aleat = (int)(Math.random()*TIPOS_DE_TERRITORIO.length);
        tipoDeTerritorio = TIPOS_DE_TERRITORIO[aleat];
    }
    public String getTipoDeTerritorio(){
        return tipoDeTerritorio;
    }
    static{
        BONOS_POR_TERRITORIO.put("Inglaterra", "bosque");
        BONOS_POR_TERRITORIO.put("Francia", "campo abierto");
        BONOS_POR_TERRITORIO.put("Castilla Aragon", "montania");
        BONOS_POR_TERRITORIO.put("Moros", "desierto");
        BONOS_POR_TERRITORIO.put("Sacro Imperio", "bosque");
        BONOS_POR_TERRITORIO.put("Sacro Imperio", "playa");
        BONOS_POR_TERRITORIO.put("Sacro Imperio", "campo abierto");
    }
    public Reino crearEjercitos(int random, int numJugador) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Bienvenido jugador "+numJugador+": \n**Escoja un nombre de Reino (Inglaterra, Francia, Sacro Imperio, Castilla Aragon y Moros)");
        System.out.print(" >Ingrese el nombre: ");
        String reinoE = sc.nextLine();
        boolean encontrado = false;
        for (String nombre: Reino.NOMBRES_DE_REINOS){
            if (nombre.equals(reinoE)){
                encontrado = true;
                break;
            }
        }
        while(!encontrado){
            System.out.print("ERROR - Nombre ingresado no dentro de la lista, intentelo de nuevo\n: ");
            reinoE = sc.nextLine();
        }
        Reino nuevoReino = new Reino(reinoE);
        if (BONOS_POR_TERRITORIO.get(nuevoReino.getNombre()).equals(tipoDeTerritorio)){
            System.out.println("Se agrego una bonificacion +1 de vida a tus soldados por ser tu campo de batalla");
            ArrayList<Ejercito> ejercitos = nuevoReino.getEjercitos();
            for (Ejercito ejercito : ejercitos) {
                for (Soldado soldado : ejercito.getSoldados()) 
                     soldado.bonificacionxTerritorio();
            }
        }
        for (int i = 0; i < random; i++) {
            int fil = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            while (tablero.get(fil).get(col) != null) { //Mientras que la posicion este ocupada seguir buscando otra
                fil = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            }
            Ejercito nuevoEjercito = new Ejercito ();
            nuevoEjercito.setReino(nuevoReino);
            nuevoReino.agregarEjercito(nuevoEjercito);
            tablero.get(fil).set(col, nuevoEjercito);
            agregarEjercito(nuevoEjercito);
        }
        return nuevoReino;
    }
    public void agregarEjercito(Ejercito nuevoEjercito){
        ejercitos.add(nuevoEjercito);
    }
    public void mostrarTablero() {
        int cs,nv;
        System.out.println("     A     B     C     D     E     F     G     H     I     J");
        for (int i = 0; i < tablero.size(); i++) {
            if (i!=9)
                System.out.print((i+1)+" ");
            else 
                System.out.print((i+1)); 
            for (int j = 0; j < tablero.get(i).size(); j++) {
                Ejercito posicion = tablero.get(i).get(j);
                if (posicion != null) {
                    String color = "";
                    switch (posicion.getReino().getNombre()) {
                        case "Inglaterra":
                            color = "\u001B[32m";  // Verde
                            break;
                        case "Francia":
                            color = "\u001B[34m";  // Azul
                            break;
                        case "Castilla Aragon":
                            color = "\u001B[33m";  // Amarillo
                            break;
                        case "Moros":
                            color = "\u001B[31m";  // Rojo
                            break;
                        case "Sacro Imperio":
                            color = "\u001B[36m";  // Cyan
                            break;
                        default:
                            color = "\u001B[0m";   // Restaura el color original
                            break;
                    }
                    cs = posicion.getCantidadSoldados();
                    nv = posicion.getNivelVidaTotal();
                    System.out.print(color + "|" + cs + "-" + nv + "|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|____|");
            }
            System.out.println();
        }
    } 
}
