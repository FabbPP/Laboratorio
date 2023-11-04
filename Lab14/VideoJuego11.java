package Lab14;
import java.util.*;
public class VideoJuego11 {
    public static void main(String[] args){
        ArrayList<ArrayList<Soldado>> misSoldados = new ArrayList<>(); //misSoldado es el Arreglo del tablero de soldados
        ArrayList<Soldado> orden=new ArrayList<>(); //Se copian los datos de objetos Soldado
        Reino reino1 = crearReino();
        reino1.setColor("rojo");
        Reino reino2 = crearReino();
        reino2.setColor("azul");
        boolean noSalir = true;
        while (noSalir) {
            switch (menu1()){
                case 1: { //Juego rapido
                    boolean nuevaPartida=true;
                    while(nuevaPartida){
                        inicializarTablero(misSoldados);
                        crearSoldados(misSoldados,orden,0); //Soldados ejercito 0 rojo creados
                        crearSoldados(misSoldados,orden,1); //Soldado ejercito 1 azul creados
                        mostrarTablero(misSoldados);  
                        datosMayorVida(misSoldados,orden,0); 
                        datosMayorVida(misSoldados,orden,1);
                        mostrarDatosOrden(misSoldados,orden); 
                        rankingPoderBurbuja(orden);
                        rankingPoderSeleccion(orden);
                        juego(misSoldados,orden);
                        nuevaPartida=esIniciarNuevaPartida(); //Si resulta verdadera por la insercion Y se iniciara una nueva
                    }
                    break;
                }
                case 2:{ //Juego personalizado, permite gestionar ejercitos
                    int cantidadEjercito, fil = 0, col = 0;
                    inicializarTablero(misSoldados);
                    crearSoldados(misSoldados,orden,0); //Soldados ejercito 0 rojo creados
                    crearSoldados(misSoldados,orden,1); //Soldado ejercito 1 azul creados
                    int ejercitoE = eleccionEjercito(misSoldados,orden);
                    if (ejercitoE == 0) //cantidad sera de acuerdo al ejercito elegido
                        cantidadEjercito = Soldado.getCantidadEjercito0();
                    else
                        cantidadEjercito = Soldado.getCantidadEjercito1();
                    boolean noVolver = true; //Para que entre al bucle al menos la primera vez
                    while (noVolver){
                        switch (subMenu2(ejercitoE)){
                            case 1: { //Agregar un soldado al ejercito
                                if (cantidadEjercito <= Soldado.MAX_CANTIDAD){
                                    fil = (int)(Math.random()*10);
                                    col = (int)(Math.random()*10);
                                    while (misSoldados.get(fil).get(col)!=null){
                                        fil = (int)(Math.random()*10);
                                        col = (int)(Math.random()*10);
                                    }                   
                                Soldado nuevoSoldado;  //Declaracion del objeto
                                nuevoSoldado = new Soldado("Soldado"+ejercitoE+"X"+(cantidadEjercito+1)); //nombre asignado 
                                nuevoSoldado.soldadoF(fil+1); //ejercito, fila y luego columna asignados 
                                nuevoSoldado.setColumna(col+1); //Por separado para tambien dar valor a columnaStr
                                nuevoSoldado.setVidaActual((int)(Math.random()*5+1));
                                nuevoSoldado.Soldado(1,1,1,"Ofensiva",true);  //Demas atributos nuevos asignados METODO SOBRECARGADO X3
                                misSoldados.get(fil).set(col, nuevoSoldado); //Soldado en el tablero datos fil-1 y col-1
                                orden.add(misSoldados.get(fil).get(col)); //Arreglo que guardara el ejercito ordenado por creacion
                                System.out.println(". . .\n Soldado creado exitosamente");
                                }
                                else //Default
                                    System.out.println("No es posible agregar un soldado al ejercito debido a que este alcanzo el maximo permitido");
                                break;
                            }
                            case 2: { //Eliminar el ultimo soldado al ejercito
                                if (cantidadEjercito > 1){
                                    int fila,colu;
                                    Soldado posicion = orden.get(cantidadEjercito);
                                    fila = posicion.getFila();
                                    colu = posicion.getColumna();
                                    misSoldados.get(fila-1).set(colu-1,null);
                                    orden.remove(cantidadEjercito);
                                   posicion.morir();
                                }
                                else //Default
                                    System.out.println("No es posible eliminar el ultimo soldado debido a que este se quedaria vacio");
                                break;
                            }
                            case 3:{
                                
                                break;
                            }
                            case 4: {
                                
                                break;
                            }
                            case 5: {
                                
                                break;
                            }
                            case 6: {
                                
                                break;
                            }
                            case 7: {
                                
                                break;
                            }
                            case 8: {
                                
                                break;
                            }
                            case 9: {
                                
                                break;
                            }
                            case 10: { //Jugar con los cambios realizados
                                juego(misSoldados,orden);
                                break;  
                            }
                            case 11: {
                                noVolver = false;
                                break;
                            }
                            
                        }
                    }
                    break; //???
                    
                    

                }
                case 3:
                   System.out.println("\t\t\tHasta luego!\n\t\t\t...saliendo del juego...");
                   noSalir = false;
                   break;
            }
        } 
   }
    //Metodos de menu
    public static int menu1(){ //Eleccion de modos de juego
        Scanner sc = new Scanner (System.in);
        System.out.println("\t\t\tBIENVENIDO AL VIDEOJUEGO");
        System.out.println("**Elija un modo de juego...\n1. Juego Rapido\t\t2. Juego Personalizado\t\t3. Salir");
        System.out.print(">Ingrese el NRO. de modo seleccionado: ");
        return sc.nextInt();
    } //Buen funcionamiento
    public static int subMenu2(int ejercitoE){
        Scanner sc = new Scanner (System.in);
        System.out.println("Nota: Trabajando con ejercito "+ejercitoE);
        System.out.println("**Elija una opcion\n1. Crear Soldado\t\t2. Eliminar Soldado\t\t3. Clonar Soldado");
        System.out.println("4. Modificar Soldado\t\t5. Comparar Soldados\t\t6. Intercambiar Soldados");
        System.out.println("7. Ver Soldado\t\t\t8. Ver ejercito\t\t\t\t9. Sumar niveles");
        System.out.println("10. Jugar\t\t\t11. Volver al menu principal");
        System.out.print(">Ingrese el NRO. de opcion deseada: ");
        return sc.nextInt();

    }
    //Gestionamiento de ejercito
    public static int eleccionEjercito(ArrayList<ArrayList<Soldado>> arrL,ArrayList<Soldado> orden){
        Scanner sc = new Scanner (System.in);
        System.out.println("Se muestran la lista de soldados por ejercito");
        mostrarDatosOrden(arrL,orden);
        System.out.println("**Tendra que escoger cual de los ejercitos gestionar\n 0. Ejercito0 \t 1. Ejercito1");
        System.out.println(">Ingrese NRO. de ejercito seleccionado: ");
        return sc.nextInt();
    }
    
    //Juego, contiene todo el proceso de metodos durante la batalla 
    public static ArrayList<ArrayList<Soldado>> inicializarTablero(ArrayList<ArrayList<Soldado>> arrL){ //bien
        int numFilas = 10; //Inicializamos el tablero
        int numColumnas = 10;
        for (int i=0;i<numFilas;i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j=0;j<numColumnas;j++) 
                fila.add(null); //Inicializa todas las posiciones como null 
            arrL.add(fila);
        } //ya inicializamos el tablero con posiciones null
        return arrL;
    }
    public static void juego(ArrayList<ArrayList<Soldado>> misSoldados, ArrayList<Soldado> orden,Reino reino1, Reino reino2){
        System.out.println("\t\t\tCOMENZAMOS LA BATALLA!!!"); //Inician los turnos por jugador
        System.out.println("Cantidad total de soldados creados: "+Soldado.getCantidadTotal());
        mostrarTablero(misSoldados,reino1,reino2);
        soldadosPorEjercito();
        boolean continuar = true;
        while(continuar){
            nuevasPosiciones(0,orden,misSoldados);
            soldadosPorEjercito();
            nuevasPosiciones(1,orden,misSoldados);
            soldadosPorEjercito();
            continuar = continuar(orden,reino1,reino2);
        }    
    }
    public static void soldadosPorEjercito(Ejercito ejercito1,Ejercito ejercito2){//Metodo de impresion de cantidad de soldados vivientes
        System.out.println("\t\t      SOLDADOS");
        System.out.println("\tROJOS \t\t |\t\t AZULES");
        System.out.print(ejercito1.getCantidadSoldados()+" soldado(s) ejercito0 \t |\t");
        System.out.println(ejercito2.getCantidadSoldados()+" soldado(s) ejercito1");
    }
 
    public static int nCantidad(){
        return (int)(Math.random()*Soldado.MAX_CANTIDAD)+1;
    }
    public static Reino crearReino(){
        Scanner sc = new Scanner (System.in);
        System.out.println("**Escoja el nombre de su reino (Inglaterra, Francia, Sacro Imperio, Castilla–Aragón y Moros).");
        System.out.print(">Ingrese el nombre: ");
        Reino unReino = new Reino(sc.next());
        return unReino;
    }
    public static void crearEjercitosSoldados(ArrayList<ArrayList<Soldado>> arrL,ArrayList orden,Reino reino1,Reino reino2){ //Principal
        int cantidadReino1 = nCantidad();
        for (int i=0; i<cantidadReino1; i++){
            Ejercito nuevoEjercito = new Ejercito("Ejercito"+reino1.getNombre().substring(0,2));
            crearSoldados(arrL,orden,nuevoEjercito);
            reino1.agregarEjercito(nuevoEjercito);
        }
        int cantidadReino2 = nCantidad();
        for (int i=0; i<cantidadReino2; i++){
            Ejercito nuevoEjercito = new Ejercito("Ejercito"+reino2.getNombre().substring(0,2));
            crearSoldados(arrL,orden,nuevoEjercito);
            reino2.agregarEjercito(nuevoEjercito);
        }
    }
    public static void crearSoldados(ArrayList<ArrayList<Soldado>> arrL, ArrayList orden, Ejercito ejercito) {
        for (int i = 0; i < nCantidad(); i++) {
            int fil = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            while (arrL.get(fil).get(col) != null) {
                fil = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            }
            ejercito.agregarSoldado(arrL,orden,("Soldado "+i),1,1,1,"Ofensiva",true,fil,col);
        }
    }
    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> arrL,Reino reino1,Reino reino2){ //Se usara tanto en el tablero de ejercitos y soldados
        System.out.println("Tablero:  ");
        System.out.println(" A  B  C  D  E  F  G  H  I  J");
        for (int i = 0; i < arrL.size(); i++){
            for (int j = 0; j < arrL.get(i).size(); j++){
                Soldado posicion = arrL.get(i).get(j);
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
    public static void mostrarDatos(ArrayList<ArrayList<Soldado>> arrL,int i,int j){
        Soldado posicion = arrL.get(i).get(j);
        System.out.println("  Nombre: "+ posicion.getNombre());
        System.out.println("  Ejercito: "+posicion.getEjercito());
        System.out.println("  Fila: "+ posicion.getFila());
        System.out.println("  Columna: "+ posicion.getColumnaStr());
        System.out.println("  Nivel ataque: "+ posicion.getNivelAtaque());
        System.out.println("  Nivel defensa: "+ posicion.getNivelDefensa());
        System.out.println("  Vida Actual: "+ posicion.getVidaActual());
        System.out.println("  Velocidad: "+ posicion.getVelocidad());
        System.out.println("  Actitud: "+ posicion.getActitud());
        System.out.println("  Vive: "+ posicion.getVive()+"\n");
    }
    public static void datosMayorVida(ArrayList<ArrayList<Soldado>> arrL,ArrayList<Soldado> orden,int ejercito){ //bien
        System.out.println("EJERCITO "+ejercito);
        System.out.println("-Datos de soldado con mayor vida: ");
        int maxI = 0,maxJ = 0,mayorNivelV = 0;
        for(int i = 0; i < orden.size(); i++){
            int fil = orden.get(i).getFila()-1;
            int col = orden.get(i).getColumna()-1;
            Soldado posicion=arrL.get(fil).get(col);
            if (posicion.getEjercito()==ejercito){
                if (mayorNivelV<posicion.getVidaActual()){
                    mayorNivelV=posicion.getVidaActual();
                    maxI = fil;
                    maxJ = col;
                }
            }
        }
        mostrarDatos(arrL,maxI,maxJ);
        System.out.println("-Promedio de nivel de vida del ejercito: "+promedioNivelVida(arrL,orden,ejercito)+"\n");
    }
    public static double promedioNivelVida(ArrayList<ArrayList<Soldado>> arrL,ArrayList<Soldado> orden,int ejercito){
        double sumVida = 0;
        for(int i = 0; i < orden.size(); i ++){
            int fil = orden.get(i).getFila()-1;
            int col = orden.get(i).getColumna()-1;
            Soldado posicion=arrL.get(fil).get(col);
            if(posicion.getEjercito()==ejercito)
                sumVida+=posicion.getVidaActual();
        }
        return sumVida/orden.size();
    }
    public static void mostrarDatosOrden(ArrayList<Soldado> orden,Reino reino1,Reino reino2){ //Bien
        System.out.println("LISTA DE SOLDADOS REINO "+reino1.getNombre());
        for (int i = 0; i < orden.size(); i ++){
            if (orden.get(i).getReino()==reino1)
                orden.get(i).mostrarDatos();
        }
        System.out.println("LISTA DE SOLDADOS REINO "+reino2.getNombre());
        for (int i = 0; i < orden.size(); i ++){
            if (orden.get(i).getReino()==reino2)
               orden.get(i).mostrarDatos();  
        }
    }
    public static void rankingPoderBurbuja(ArrayList<Soldado> orden) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < orden.size(); i++) {
            indices.add(i);
        }

        int temp;
        for (int i = 0; i < orden.size() - 1; i++) {
            for (int j = 0; j < orden.size() - i - 1; j++) {
                if (orden.get(j) != null) {
                    int ant = orden.get(indices.get(j)).getVidaActual();
                    int pos = orden.get(indices.get(j + 1)).getVidaActual();
                    if (ant < pos) {
                        temp = indices.get(j);
                        indices.set(j, indices.get(j + 1));
                        indices.set(j + 1, temp);
                    }
                }
            }
        }
        System.out.println("RANKING DE PODER POR ORDENAMIENTO BURBUJA...");
        System.out.println("Aclaracion: ejercito 0 (rojo) / ejercito 1 (azul)");
        for (int i = 0; i < orden.size(); i++) {
            int index = indices.get(i);
            Soldado soldado = orden.get(index);
            System.out.println((i + 1) + ".- " + soldado.getNombre() + "\t salud: " + soldado.getVidaActual());
            }
    }
    public static void rankingPoderSeleccion(ArrayList<Soldado> orden){
        int n=orden.size();
        for (int i = 0; i < n - 1; i++) {
            int mayor=i;
            for (int j=i+1;j<n;j++) {
                if (orden.get(j).getVidaActual() > orden.get(mayor).getVidaActual()) 
                    mayor = j;     
        }
        Soldado temp = orden.get(i);
        orden.set(i, orden.get(mayor));
        orden.set(mayor, temp);
    }
        System.out.println("RANKING DE PODER POR ORDENAMIENTO SELECCION...");
        System.out.println("Aclaracion: ejercito 0 (rojo) / ejercito 1 (azul)");
        for(int i=0;i<orden.size();i++)
            System.out.println((i+1)+".- "+orden.get(i).getNombre()+"\t, salud: "+orden.get(i).getVidaActual());
    }
    public static boolean continuar(ArrayList<Soldado> orden,Reino reino1,Reino reino2){ //BIEN ENCUENTRA GANADOR PARTIDA
       if (!(reino1.esReinoVacio() && reino2.esReinoVacio())) //ambos equipos (losdos) siguen manteniendo soldados continua el juego
           return true;
       System.out.print("Partida terminada, ");
       if (reino1.esReinoVacio()){ //No es necesario invocar ambos booleanos segun la condicion...
           System.out.println("la totalidad del reino "+reino2.getNombre()+" azul fue eliminado");
           System.out.println("------> EL REINO ROJO GANO <------");
           System.out.println("------> Felicidades jugador 1, su reino "+reino1.getNombre()+" ha ganado! <------");
       }
       else { //Si gano el equipo 0
           System.out.println("la totalidad del reino "+reino1.getNombre()+" rojo fue eliminado");
           System.out.println("------> EL REINO AZUL GANO <------");
           System.out.println("------> Felicidades jugador 2, su reino "+reino2.getNombre()+" ha ganado! <------");
       }
       return false; //ALGUN EQUIPO SE QUEDO SIN SOLDADOS, LA PARTIDA FINALIZA, TENEMOS UN GANADOR, no continuar turnos   
    }   
    public static void nuevasPosiciones(ArrayList<Soldado> orden,ArrayList<ArrayList<Soldado>> arrL,Ejercito unEjercito){
        Scanner sc = new Scanner(System.in);
        String eColor;
        eColor = unEjercito.getReino().getColor();
        boolean noEsVacio = !unEjercito.esEjercitoVacio();
        if (noEsVacio){ //Con tal que existan aun soldado en el ejercito
            System.out.println("\n\t\t\t>>>Turno de Jugador "+unEjercito.getReino()+"<<<");
            System.out.println("**Elija un soldado de su Ejercito "+eColor); //Se mostrara la lista de Soldados de su ejercito
            for(int i=0; i<orden.size(); i++){
                if(orden.get(i).getEjercito()==e){
                    Soldado posicion=orden.get(i);
                    System.out.println("NRO "+i+". "+posicion.getNombre()+": ");
                    System.out.println("  posicion: "+posicion.getFila()+"x"+posicion.getColumnaStr());
                }
            }
            System.out.print(" >Ingrese NRO. de soldado seleccionado: ");
            int numCreacion=sc.nextInt();
            Soldado soldadoE=orden.get(numCreacion);
            int fil = soldadoE.getFila();
            int col = soldadoE.getColumna(); //En modo numero para poder ubicarla en el tablero usando arr orden
            System.out.println("Soldado ubicado "+fil+"x"+soldadoE.getColumnaStr());
            System.out.println("**Elija una de las direcciones de movimiento disponibles...");
            ArrayList<String> posicionesStr = new ArrayList<>();//movimientos
            ArrayList<String> letrasPosicion = new ArrayList<>(); //letras accedoras a movimiento a  s  d  w
            if (soldadoE.getFila() != 1 && esMovimientoValido(arrL,soldadoE.getFila()-1,soldadoE.getColumna(),e)){//arriba
                posicionesStr.add("arriba");
                letrasPosicion.add("W");
            }
            if (soldadoE.getFila() != 10 && esMovimientoValido(arrL,soldadoE.getFila()+1,soldadoE.getColumna(),e)){//abajo
                posicionesStr.add("abajo");
                letrasPosicion.add("S");
            }
            if (soldadoE.getColumna() != 10 && esMovimientoValido(arrL,soldadoE.getFila(),soldadoE.getColumna()+1,e)){//der
                posicionesStr.add("derecha");
                letrasPosicion.add("D");
            }
            if (soldadoE.getColumna() != 1 && esMovimientoValido(arrL,soldadoE.getFila(),soldadoE.getColumna()-1,e)){//izq
                posicionesStr.add("izquierda");
                letrasPosicion.add("A");
            }
            for (int i=0;i<posicionesStr.size();i++) 
                System.out.println(letrasPosicion.get(i)+".- "+posicionesStr.get(i));
            System.out.print(" >Ingrese LETRA en MAYUS de la direccion de movimiento seleccionada: ");
            String letra = sc.next();
            String direccionElegida = posicionesStr.get(letrasPosicion.indexOf(letra));
            int nuevoFil = fil; //Mas arriba inicializamos fil y col como posicion respectiva de soldadoE elegido
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
            Soldado temp = arrL.get(fil-1).get(col-1);//Guardamos el objeto del tablero para restaurarlo en la nueva posicion si gana
            arrL.get(fil-1).set(col-1,null); //Borramos del tablero el objeto en su antigua posicion si pierde lo dejamos asi
            Soldado rival = arrL.get(nuevoFil - 1).get(nuevoCol - 1); // Si se encuentra un rival en la nueva posicion
            boolean miSoldadoeliminado=false;
            if (rival != null && rival.getEjercito() != e) { //BATALLA, comprueba que exista un rival
                System.out.println("\t\t\t>>Se ha iniciado una batalla !!<<");
                int ganador = definirGanadorBatalla(soldadoE,rival);
                if (ganador == 1) {// El soldado gana 
                    soldadoE.setFila(nuevoFil); //Actualizando datos de la lista orden
                    soldadoE.setColumna(nuevoCol);
                    soldadoE.ganarBatalla();
                    arrL.get(nuevoFil - 1).set(nuevoCol - 1, soldadoE); 
                    rival.morir(); //Baja la cantidad en la variable clase que maneja la cantidad total y por ejercito
                    orden.remove(rival);
                    System.out.println("Su soldado ha ganado la batalla, el rival ha sido eliminado y su lugar sera ocupado!");
                    System.out.println("Ademas, su soldado gano +1 pto. de vida");
                }
                else{ // el soldado pierde
                    soldadoE.morir(); //Baja la cantidad en la variable clase que maneja la cantidad total y por ejercito
                    orden.remove(numCreacion); //Borra el soldado de la lista de soldados
                    System.out.println("Su soldado ha perdido la batalla y ha sido eliminado.");
                    miSoldadoeliminado=true; //Ya no se recuperara la info de este soldado 
                }
            } //SI solo si hay rival y gano o no hay rival y se posicionara
            if (!miSoldadoeliminado){ //Con tal que no haya perdido en caso haya rival,guardamos nueva posicion en el tablero arreglo
                arrL.get(nuevoFil-1).set(nuevoCol-1,temp); //Guardamos en la nueva posicion el soldado
                Soldado nvPosicionSoldado = arrL.get(nuevoFil-1).get(nuevoCol-1);// Actualizamos a la nueva posicion
                nvPosicionSoldado.setFila(nuevoFil);
                nvPosicionSoldado.setColumna(nuevoCol);
                System.out.println("Soldado movido a " + nuevoFil+"x"+soldadoE.getColumnaStr());
            }
            mostrarTablero(arrL);
        }
        else
            System.out.println("...");
    }
    public static boolean esMovimientoValido(ArrayList<ArrayList<Soldado>> arrL,int fila,int columna, int ejercito) { //Seguro
        Soldado soldadoEnPosicion = arrL.get(fila - 1).get(columna - 1);
        return soldadoEnPosicion == null || soldadoEnPosicion.getEjercito() != ejercito;
    }
    public static int definirGanadorBatalla(Soldado sold1,Soldado sold2){ //Devuelve el soldado ganador segun metrica
        int vidaSold1,vidaSold2;
        double total,proba1,proba2,aleat;
        vidaSold1 = sold1.getVidaActual();
        vidaSold2 = sold2.getVidaActual();
        total = vidaSold1+vidaSold2; //En double para que la division de probabilidad salga no entero
        proba1 = vidaSold1/total;
        proba2 = vidaSold2/total; //Aunque no es necesario calcularlo para definir el ganador, usado para poner el porcent
        System.out.println("*Probabilidades de vencer...\nSu soldado = "+(proba1*100)+"%\t/\tSu rival = "+(proba2*100)+"%");
        System.out.println("---> De acuerdo a dichas probabilidades se decidira el ganador aleatoriamente.\n...");
        aleat = Math.random(); //devuelve un numero aleatorio entre 0-1 (double) mas probabilidas tienen los de mayor vida
        if (aleat <= proba1)
            return 1; //Gana soldado 1 
        else 
            return 2; //Gana soldado 2
    } //bien
    public static boolean esIniciarNuevaPartida(){ //Ingreso de menu luego de partida terminada//bien
        Scanner sc = new Scanner (System.in);
        System.out.println("**Elija una accion...\n1. Volver a jugar\t\t2. Volver al menu principal ");
        System.out.print(">Ingrese NRO de accion seleccionada: ");
        return sc.nextInt() == 1;
    } 
}
