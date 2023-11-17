package Lab19;
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
        for (int i = 0; i < nuevoEjercito.getCantidadSoldados(); i++) {
            Soldado nuevoSoldado;
            int tipoSoldado = (int) (Math.random() * 3); // 0Caballero, 1Espadachin, 2Arquero
            switch (tipoSoldado) {
                case 0:
                    nuevoSoldado = new Caballero();
                    break;
                case 1:
                    nuevoSoldado = new Espadachin();
                    break;
                case 2:
                    nuevoSoldado = new Arquero();
                    break;
                default:
                    nuevoSoldado = new Caballero(); // Por defecto, crea un Caballero
                    break;
            }
            int fil = (int) ((Math.random() * 10)+1);
            int col = (int) ((Math.random() * 10)+1);
            while (tablero.get(fil).get(col) != null) {
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
        System.out.println(" A  B  C  D  E  F  G  H  I  J");
        for (int i = 0; i < tablero.size(); i++){
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
    public void generarMovimiento(Reino reino1, Reino reino2){ //PRINCIPAL
        boolean continuar = sigueTurnos(reino1,reino2);
        while (continuar){
            boolean esVacio1 = reino1.esReinoVacio(); //Empezamos turno reino1
            if (esVacio1)
                break;
            else {
                mostrarTablero();
                reino1.mostrarColores(reino2);
                movimientoTurnoReino(reino1,reino2);
            }
            boolean esVacio2 = reino2.esReinoVacio(); //Empezamos turno reino2
            if (esVacio2)
                break;
            else {
                mostrarTablero();
                reino2.mostrarColores(reino1);
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
        String ingreso = sc.next();
        while (letrasPosicion.indexOf(ingreso)==-1){
            System.out.println("ERROR - letra ingresada no permitida, asegurese que este dentro de la lista y en MAYUS");
            System.out.println(" >Ingrese LETRA en MAYUS de la direccion de movimiento seleccionada: ");
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
            ejercitoE.setFila(nuevoFil).setColumna(nuevoCol);
            tablero.get(nuevoFil-1).set(nuevoCol-1,ejercitoE); //Movemos el ejercito a la nueva posicion
            tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion
            System.out.println("Ejercito movido a "+nuevoFil+"x"+ejercitoE.getColumnaStr());
        }
        else { //Existe ejercito rival
            System.out.println("\t\t\t>>Se ha iniciado una batalla !!<<");
            Ejercito eRival = tablero.get(nuevoFil-1).get(nuevoCol-1);
            int ganador = definirVencedorBatalla(ejercitoE,eRival);
            if (ganador == 1) {// El ejercito gana 
                ejercitoE.setFila(nuevoFil).setColumna(nuevoCol);
                tablero.get(nuevoFil-1).set(nuevoCol-1,ejercitoE); //Movemos el ejercito a la nueva posicion
                tablero.get(fil-1).set(col-1,null); //Borramos la anterior posicion
                otroReino.getEjercitos().remove(eRival);//Se elimina el ejercito rival
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