package Lab22;
import java.util.*;
public class Mapa {
    private static final String[] TIPOS_DE_TERRITORIO = {"bosque","campo abierto","montania","desierto","playa"};
    private static final Map<String, String> BONOS_POR_TERRITORIO = new HashMap<>();
    private ArrayList <ArrayList<Soldado>> tablero = new ArrayList<>();
    private ArrayList<Ejercito> ejercitos = new ArrayList<>();
    private String tipoDeTerritorio;
    public Mapa (){ 
        int numFilas = 10; //Inicializamos el tablero
        int numColumnas = 10;
        for (int i=0; i<numFilas;i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j=0;j<numColumnas;j++) 
                fila.add(null); //Inicializa todas las posiciones como null 
            tablero.add(fila);
        }
        int aleat = (int)(Math.random()*TIPOS_DE_TERRITORIO.length);
        tipoDeTerritorio = TIPOS_DE_TERRITORIO[aleat];
    }
    
    public Ejercito crearEjercito(int random, int numJugador) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Bienvenido jugador " + numJugador +": \n**Escoja su Reino (Inglaterra, Francia, Sacro_Imperio, Castilla_Aragon y Moros)");
        System.out.print("> Ingrese el reino: ");
        String reino = sc.nextLine();
        boolean encontrado = false;
        while(!encontrado){
            for (String nombre: Reino.NOMBRES_REINOS){
                if (nombre.equals(reino)){
                    encontrado = true;
                    break;
                }     
            }
            if (encontrado)
                    break;
            System.out.print("ERROR - Nombre ingresado no dentro de la lista, intentelo de nuevo\n: ");
            reino = sc.nextLine();
        }
        Ejercito nuevoEjercito = new Ejercito(numJugador,new Reino(reino));
        agregarEjercito(nuevoEjercito);
        String territorioReino = BONOS_POR_TERRITORIO.get(reino);
        if (territorioReino != null && tipoDeTerritorio.equals(territorioReino)){
            System.out.println("--Se agrego una bonificacion +1 a la vida de tus soldados por ser su campo de batalla");
            ArrayList<Soldado> soldados = nuevoEjercito.getSoldados();
            for (Soldado soldado : soldados) {
                     soldado.bonificacionxTerritorio();
            }
        }
        for (int i = 0; i < nuevoEjercito.getCantidadSoldadosCrear(); i++) {
            Soldado nuevoSoldado;
            int tipoSoldado = (int) (Math.random() * 4); // 0Caballero, 1Espadachin, 2Arquero, 3Lancero
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
                case 3:
                    nuevoSoldado = new Lancero(nuevoEjercito);
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
    static{
        BONOS_POR_TERRITORIO.put("Inglaterra", "bosque");
        BONOS_POR_TERRITORIO.put("Francia", "campo abierto");
        BONOS_POR_TERRITORIO.put("Castilla_Aragon", "montania");
        BONOS_POR_TERRITORIO.put("Moros", "desierto");
        BONOS_POR_TERRITORIO.put("Sacro_Imperio", "bosque");
        BONOS_POR_TERRITORIO.put("Sacro_Imperio", "playa");
        BONOS_POR_TERRITORIO.put("Sacro_Imperio", "campo abierto");
    }
    public void agregarEjercito(Ejercito nuevoEjercito){
        ejercitos.add(nuevoEjercito);
    }
    public String getTipoDeTerritorio(){
        return tipoDeTerritorio;
    }
    public ArrayList<Ejercito> getEjercitos(){
        return ejercitos;
    }
    public void mostrarTablero() { //Secundario de GenerarMovimiento
        System.out.println("Tablero:  ");
        System.out.println("     A    B    C    D    E    F    G    H    I    J");
        for (int i = 0; i < tablero.size(); i++){
            if (i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for (int j = 0; j < tablero.get(i).size(); j++){
                Soldado p = tablero.get(i).get(j);
                if (p != null){
                    String vida = Integer.toString(p.getVidaActual());
                    if (vida.length()==1)
                        vida = vida+" ";
                    Ejercito ejercito = p.getEjercito();
                    String color = (ejercito==ejercitos.get(0))? "\u001B[31m" : (ejercito==ejercitos.get(1))? "\u001B[34m" : "\u001B[0m";
                    System.out.print(color+"|"+p.getTipoAbreviado()+vida+"|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|___|");
            }
            System.out.println(); 
        }
        System.out.println("Recordatorio: Ejercito 1: "+ ejercitos.get(0).getColor()+"/ Ejercito 2: "+ejercitos.get(1).getColor()+"\n");
    }    
}