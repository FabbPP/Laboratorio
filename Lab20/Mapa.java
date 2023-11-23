package Lab20;
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
        System.out.println("Bienvenido jugador " + numJugador);
        Ejercito nuevoEjercito = new Ejercito(numJugador);
        agregarEjercito(nuevoEjercito);
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
                    System.out.print(color+"|"+p.getTipoAbreviado()+p.getVidaActual()+"|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|__|");
            }
            System.out.println(); 
        }
    }
    public void generarMovimiento(Ejercito ejercito1,Ejercito ejercito2){ //PRINCIPAL
            boolean continuar = sigueTurnos(ejercito1,ejercito2);
            while (continuar){
                boolean esVacio1 = ejercito1.esEjercitoVacio(); //Empezamos turno reino1
                if (!esVacio1){
                    mostrarTablero();
                    ejercito1.mostrarColores(ejercito2);
                    movimientoTurnoEjercito(ejercito1,ejercito2);
                }
                boolean esVacio2 = ejercito2.esEjercitoVacio(); //Empezamos turno reino2
                if (!esVacio2){
                    mostrarTablero();
                    ejercito1.mostrarColores(ejercito2);
                    movimientoTurnoEjercito(ejercito2,ejercito1);
                }
                continuar = sigueTurnos(ejercito1,ejercito2);
            }
    }
    public boolean sigueTurnos(Ejercito ejercito1, Ejercito ejercito2){ //Secundario generarMovimiento
       if (!(ejercito1.esEjercitoVacio() && ejercito2.esEjercitoVacio()))
           return true; //ambos reinos siguen manteniendo ejercitos continuan el par de turnos
       System.out.print("Partida terminada, ");
       if (ejercito1.esEjercitoVacio()){ //No es necesario invocar ambos booleanos segun la condicion...
           System.out.println("la totalidad del ejercito azul fue eliminado");
           System.out.println("------> EL EJERCITO ROJO GANO <------");
           System.out.println("------> Felicidades ejercito ROJO     ganaste la partida! <------");
       }
       else { //Si gano el equipo 0
           System.out.println("la totalidad del ejercito rojo fue eliminado");
           System.out.println("------> EL EJERCITO AZUL GANO <------");
           System.out.println("------> Felicidades ejercito AZUL ganaste la partida!<------");
       }
       return false; //ALGUN Reino SE QUEDO SIN SOLDADOS, LA PARTIDA FINALIZA, TENEMOS UN GANADOR, no continuar turnos   
    }
    public void movimientoTurnoEjercito(Ejercito ejercitoTurno, Ejercito ejercitoOtro){//Secundario generarMovimiento
        Scanner sc = new Scanner (System.in);
        System.out.println("\n\t\t    >>>Turno de Ejercito " + ejercitoTurno.getNombre()+"<<<");
        System.out.println("\t\t\t>>>Color: "+ejercitoTurno.getColor()+"<<<");
        System.out.println("**Elija un ejercito...");
        ArrayList<Soldado> listaSoldados = ejercitoTurno.getSoldados();
        int i = 1;
        for (Soldado soldado : listaSoldados){
            System.out.println("NRO. "+i+" "+soldado.getNombre()+": ");
            System.out.println("  posicion: "+soldado.getFila()+"x"+soldado.getColumnaStr());
            i ++;
        }
        System.out.print(">Ingrese NRO. de soldado: ");
        int numEnSoldados = sc.nextInt();
        Soldado soldadoE = listaSoldados.get(numEnSoldados-1); //veremos la ubicacion en el tablero
        int fil = soldadoE.getFila();
        int col = soldadoE.getColumna();
        System.out.println("Soldado ubicado "+fil+"x"+soldadoE.getColumnaStr());
        ArrayList<String> posicionesStr = new ArrayList<>();//movimientos
        ArrayList<String> letrasPosicion = new ArrayList<>(); //letras accedoras a movimiento A W D S
        if (fil != 1 && esMovimientoValido(fil-1,col,soldadoE)){//arriba
            posicionesStr.add("arriba");
            letrasPosicion.add("W");
        }
        if (fil != 10 && esMovimientoValido(fil+1,col,soldadoE)){//abajo
            posicionesStr.add("abajo");
            letrasPosicion.add("S");
        }
        if (col != 10 && esMovimientoValido(fil,col+1,soldadoE)){//der
            posicionesStr.add("derecha");
            letrasPosicion.add("D");
        }
        if (col != 1 && esMovimientoValido(fil,col-1,soldadoE)){//izq
            posicionesStr.add("izquierda");
            letrasPosicion.add("A");
        }
        System.out.println("**Direcciones de movimiento disponibles...");
        for (int c=0; c<posicionesStr.size(); c++) 
            System.out.println(letrasPosicion.get(c)+".- "+posicionesStr.get(c));
        System.out.print(" >Ingrese LETRA en MAYUS de la direccion de movimiento seleccionada: ");
        String ingreso = sc.next();
        while (letrasPosicion.indexOf(ingreso)==-1){
            System.out.println("ERROR - letra ingresada no permitida, asegurese que este dentro de la lista y en MAYUS");
            System.out.print(" >Ingrese LETRA en MAYUS de la direccion de movimiento seleccionada: ");
            ingreso = sc.next();
        }
        String direccionElegida = posicionesStr.get(letrasPosicion.indexOf(ingreso));
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
            soldadoE.setFila(nuevoFil).setColumna(nuevoCol);
            tablero.get(nuevoFil-1).set(nuevoCol-1,soldadoE); //Movemos el soldado a la nueva posicion
            tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion
            System.out.println("Ejercito movido a "+nuevoFil+"x"+soldadoE.getColumnaStr());
        }
        else { //Existe ejercito rival
            System.out.println("\t\t\t>>Se ha iniciado una batalla !!<<"); //Se encuentra un rival en la posicion deseada
            Soldado sRival = tablero.get(nuevoFil-1).get(nuevoCol-1);
            int ganador = definirVencedorBatalla(soldadoE,sRival);
            if (ganador == 1) {// El ejercito gana 
                soldadoE.setFila(nuevoFil).setColumna(nuevoCol);
                tablero.get(nuevoFil-1).set(nuevoCol-1,soldadoE); //Hacemos una copia del obj a la nueva posicion
                tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion
                ejercitoOtro.getSoldados().remove(sRival);//Se elimina el ejercito rival
                System.out.println("Su soldado ha vencido la batalla, el soldado rival ha sido eliminado y su lugar sera ocupado!");
                soldadoE.bonificacionxVencida();
                System.out.println("Ademas, su soldado gano +1 pto. de vida por bonificacion de la vencida");
                System.out.println("--> Soldado movido a "+nuevoFil+"x"+soldadoE.getColumnaStr());
            }
            else { // el ejercito pierde
                tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion del ejercito
                ejercitoTurno.eliminarSoldado(soldadoE);
                System.out.println("Su soldado ha perdido la batalla y ha sido eliminado :(");
            }
        }
    }
    public boolean esMovimientoValido(int fil,int col, Soldado elSoldado) { //Secundario generarMovimiento-movimientoReino
        Soldado haySoldadoEnPosicion = tablero.get(fil- 1).get(col - 1);//Da paso si es que -no hay ejercito-hay ejercito rival
        return (haySoldadoEnPosicion == null || haySoldadoEnPosicion != elSoldado); 
    }
    public int definirVencedorBatalla(Soldado unSoldado, Soldado soldadoRival){ //Secundario generarMovimiento-movimientoReino
        double total,proba1,proba2,aleat;
        int vida1 = unSoldado.getVidaActual();
        int vida2 = soldadoRival.getVidaActual();
        total = vida1+vida2; //En double para que la division de probabilidad salga no entero
        proba1 = vida1/total;
        proba2 = vida2/total; //Aunque no es necesario calcularlo para definir el ganador, usado para poner el porcent
        System.out.println("*Probabilidades de vencer...\nSu soldado = "+(proba1*100)+"%\t/\t Su soldado rival= "+(proba2*100)+"%");
        System.out.println("---> De acuerdo a dichas probabilidades se decidira el ganador aleatoriamente.\n...");
        aleat = Math.random(); //devuelve un numero aleatorio entre 0-1 (double) mas probabilidas tienen los de mayor vida
        if (aleat <= proba1)
            return 1; //Gana soldado 1 
        else 
            return 2; //Gana soldado 2
    }      
}