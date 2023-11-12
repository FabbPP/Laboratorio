package Lab17;
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
        BONOS_POR_TERRITORIO.put("Castilla_Aragon", "montania");
        BONOS_POR_TERRITORIO.put("Moros", "desierto");
        BONOS_POR_TERRITORIO.put("Sacro_Imperio", "bosque");
        BONOS_POR_TERRITORIO.put("Sacro_Imperio", "playa");
        BONOS_POR_TERRITORIO.put("Sacro_Imperio", "campo abierto");
    }
    public Reino crearEjercitos(int random, int numJugador) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Bienvenido jugador "+numJugador+": \n**Escoja un nombre de Reino (Inglaterra, Francia, Sacro_Imperio, Castilla_Aragon y Moros)");
        System.out.print(" >Ingrese el nombre: ");
        String reinoE = sc.nextLine();
        
        boolean encontrado = false;
        while(!encontrado){
            for (String nombre: Reino.NOMBRES_DE_REINOS){
                if (nombre.equals(reinoE)){
                    encontrado = true;
                    break;
                }     
            }
            if (encontrado)
                    break;
            System.out.print("ERROR - Nombre ingresado no dentro de la lista, intentelo de nuevo\n: ");
            reinoE = sc.nextLine();
        }
        Reino nuevoReino = new Reino(reinoE);
        String territorioReino = BONOS_POR_TERRITORIO.get(nuevoReino.getNombre());
        if (territorioReino != null && tipoDeTerritorio.equals(territorioReino)){
            System.out.println("--Se agrego una bonificacion +1 a la vida de tus soldados por ser su campo de batalla");
            ArrayList<Ejercito> ejercitos = nuevoReino.getEjercitos();
            for (Ejercito ejercito : ejercitos) {
                for (Soldado soldado : ejercito.getSoldados()) 
                     soldado.bonificacionXterritorio();
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
            nuevoEjercito.setFila(fil+1).setColumna(col+1); //Recordar que para acceder al tablero es fil-1 col-1
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
        System.out.println("     A      B      C      D      E      F      G      H      I      J");
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
                            posicion.getReino().setColor("verde");
                            break;
                        case "Francia":
                            color = "\u001B[34m";  // Azul
                            posicion.getReino().setColor("azul");
                            break;
                        case "Castilla_Aragon":
                            color = "\u001B[33m";  // Amarillo
                            posicion.getReino().setColor("amarillo");
                            break;
                        case "Moros":
                            color = "\u001B[31m";  // Rojo
                            posicion.getReino().setColor("rojo");
                            break;
                        case "Sacro_Imperio":
                            color = "\u001B[36m";  // Cyan
                            posicion.getReino().setColor("cyan");
                            break;
                        default:
                            color = "\u001B[0m";   // Restaura el color original
                            break;
                    }
                    cs = posicion.getCantidadSoldados();
                    String csStr,nvStr;
                    if (cs<10)
                        csStr = (" "+cs);
                    else
                        csStr = (cs+"");
                    nv = posicion.getNivelVidaTotal();
                    if (nv<10)
                        nvStr = (" "+nv);
                    else
                        nvStr = (nv+"");
                    System.out.print(color + "|" + csStr + "-" + nvStr + "|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|_____|");
            }
            System.out.println();
        }
    } 
    
    public void generarMovimiento(Reino reino1, Reino reino2){ //Principal
        boolean continuar = sigueTurnos(reino1,reino2);
        while (continuar){
            boolean esVacio1 = reino1.esReinoVacio(); //Empezamos turno reino1
            if (esVacio1)
                break;
            else {
                mostrarTablero();
                movimientoTurnoReino(reino1,reino2);
            }
            boolean esVacio2 = reino2.esReinoVacio(); //Empezamos turno reino2
            if (esVacio2)
                break;
            else {
                mostrarTablero();
                movimientoTurnoReino(reino2,reino1);
            }
            continuar = sigueTurnos(reino1,reino2);
        }
    }
    public boolean sigueTurnos(Reino reino1, Reino reino2){ //Secundario generarMovimiento
       if (!(reino1.esReinoVacio() && reino2.esReinoVacio()))
           return true; //ambos reinos siguen manteniendo ejercitos continuan el par de turnos
       System.out.print("Partida terminada, ");
       if (reino1.esReinoVacio()){ //No es necesario invocar ambos booleanos segun la condicion...
           System.out.println("la totalidad del reino "+reino2.getNombre()+" azul fue eliminado");
           System.out.println("------> EL REINO ROJO GANO <------");
           System.out.println("------> Felicidades "+reino1.getNombre()+" ha ganado! <------");
       }
       else { //Si gano el equipo 0
           System.out.println("la totalidad del reino "+reino1.getNombre()+" rojo fue eliminado");
           System.out.println("------> EL REINO AZUL GANO <------");
           System.out.println("------> Felicidades "+reino2.getNombre()+" ha ganado! <------");
       }
       return false; //ALGUN Reino SE QUEDO SIN SOLDADOS, LA PARTIDA FINALIZA, TENEMOS UN GANADOR, no continuar turnos   
    }
    public void movimientoTurnoReino(Reino unReino,Reino otroReino){//Secundario generarMovimiento
        Scanner sc = new Scanner (System.in);
        System.out.println("\n\t\t    >>>Turno de " + unReino.getNombre()+"<<<");
        System.out.println("\t\t\t>>>Color: "+unReino.getColor()+"<<<");
        System.out.println("**Elija un ejercito...");
        ArrayList<Ejercito> listaEjercitos = unReino.getEjercitos();
        int i = 1;
        for (Ejercito ejercito : listaEjercitos){
            System.out.println("NRO. "+i+" "+ejercito.getNombre()+": ");
            System.out.println("  posicion: "+ejercito.getFila()+"x"+ejercito.getColumnaStr());
            i ++;
        }
        System.out.print(">Ingrese NRO. de ejercito: ");
        int numEnEjercitos = sc.nextInt();
        Ejercito ejercitoE = listaEjercitos.get(numEnEjercitos-1); //veremos la ubicacion en el tablero
        int fil = ejercitoE.getFila();
        int col = ejercitoE.getColumna();
        System.out.println("Ejercito ubicado "+fil+"x"+ejercitoE.getColumnaStr());
        ArrayList<String> posicionesStr = new ArrayList<>();//movimientos
        ArrayList<String> letrasPosicion = new ArrayList<>(); //letras accedoras a movimiento A W D S
        if (fil != 1 && esMovimientoValido(fil-1,col,ejercitoE)){//arriba
            posicionesStr.add("arriba");
            letrasPosicion.add("W");
        }
        if (fil != 10 && esMovimientoValido(fil+1,col,ejercitoE)){//abajo
            posicionesStr.add("abajo");
            letrasPosicion.add("S");
        }
        if (col != 10 && esMovimientoValido(fil,col+1,ejercitoE)){//der
            posicionesStr.add("derecha");
            letrasPosicion.add("D");
        }
        if (col != 1 && esMovimientoValido(fil,col-1,ejercitoE)){//izq
            posicionesStr.add("izquierda");
            letrasPosicion.add("A");
        }
        System.out.println("**Direcciones de movimiento disponibles...");
        for (int c=0; c<posicionesStr.size(); c++) 
            System.out.println(letrasPosicion.get(c)+".- "+posicionesStr.get(c));
        System.out.print(" >Ingrese LETRA en MAYUS de la direccion de movimiento seleccionada: ");
        String direccionElegida = posicionesStr.get(letrasPosicion.indexOf(sc.next()));
        int nuevoFil = fil; //incializamos la nueva posicion 
        int nuevoCol = col;
        switch (direccionElegida){ //guardamos datos de nueva posicion para cada caso
            case "arriba":
                nuevoFil--;
                break;
            case "abajo":
                nuevoFil++;
                break;
            case "derecha":
                nuevoCol++;
                break;
            case "izquierda":
                nuevoCol--;
                break;
        } 
        if (tablero.get(nuevoFil-1).get(nuevoCol-1) == null){ //se mueve, posicion libre
            ejercitoE.setFila(nuevoFil).setColumna(nuevoCol);
            tablero.get(nuevoFil-1).set(nuevoCol-1,ejercitoE); //Movemos el ejercito a la nueva posicion
            tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion
            System.out.println("Ejercito movido a "+nuevoFil+"x"+ejercitoE.getColumnaStr());
        }
        else { //Existe rival
            System.out.println("\t\t\t>>Se ha iniciado una batalla !!<<");
            Ejercito eRival = tablero.get(fil-1).get(col-1);
            int ganador = definirVencedorBatalla(ejercitoE,eRival);
            if (ganador == 1) {// El ejercito gana 
                ejercitoE.setFila(nuevoFil).setColumna(nuevoCol);
                tablero.get(nuevoFil-1).set(nuevoCol-1,ejercitoE); //Movemos el ejercito a la nueva posicion
                tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion
                otroReino.eliminarEjercito(eRival);//Se elimina el ejercito rival
                System.out.println("Su ejercito ha vencido la batalla, el ejercito rival ha sido eliminado y su lugar sera ocupado!");
                ejercitoE.bonificacionXvencida();
                System.out.println("Ademas, su ejercito gano +1 pto. de vida por bonificacion de la vencida");
                System.out.println("--> Ejercito movido a "+nuevoFil+"x"+ejercitoE.getColumnaStr());
            }
            else { // el ejercito pierde
                tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion del ejercito
                unReino.eliminarEjercito(ejercitoE);
                System.out.println("Su ejercito ha perdido la batalla y ha sido eliminado.");
            }
        }
    }
    public boolean esMovimientoValido(int fil,int col, Ejercito unEjercito) { //Secundario generarMovimiento-movimientoReino
        Ejercito hayEjercitoEnPosicion = tablero.get(fil- 1).get(col - 1);//Da paso si es que -no hay ejercito-hay ejercito rival
        return (hayEjercitoEnPosicion == null || hayEjercitoEnPosicion != unEjercito); 
    }
    public int definirVencedorBatalla(Ejercito unEjercito, Ejercito eRival){ //Secundario generarMovimiento-movimientoReino
        double total,proba1,proba2,aleat;
        int vida1 = unEjercito.getNivelVidaTotal();
        int vida2 = eRival.getNivelVidaTotal();
        total = vida1+vida2; //En double para que la division de probabilidad salga no entero
        proba1 = vida1/total;
        proba2 = vida2/total; //Aunque no es necesario calcularlo para definir el ganador, usado para poner el porcent
        System.out.println("*Probabilidades de vencer...\nSu ejercito = "+(proba1*100)+"%\t/\tSu ejercito rival = "+(proba2*100)+"%");
        System.out.println("---> De acuerdo a dichas probabilidades se decidira el ganador aleatoriamente.\n...");
        aleat = Math.random(); //devuelve un numero aleatorio entre 0-1 (double) mas probabilidas tienen los de mayor vida
        if (aleat <= proba1)
            return 1; //Gana soldado 1 
        else 
            return 2; //Gana soldado 2
    }
}
