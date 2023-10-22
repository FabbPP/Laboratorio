package Lab11;
import java.util.*;
public class VideoJuego08 {
    public static void main(String[] args){
        boolean continuar=true;
        ArrayList<ArrayList<Soldado>> misSoldados = new ArrayList<>();
        int numFilas=10; //Inicializamos el tablero
        int numColumnas=10;
        for (int i=0;i<numFilas;i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j=0;j<numColumnas;j++) 
                fila.add(null); //Inicializa todas las posiciones como null
            misSoldados.add(fila);
        }
        ArrayList<Soldado> orden=new ArrayList<>();
        crearSoldados(misSoldados,orden,0); //Soldados ejercito 0 rojo creados
        crearSoldados(misSoldados,orden,1); //Soldado ejercito 1 azul creados
        mostrarTablero(misSoldados);  
        System.out.println("DATOS DE EJERCITO ROJO, JUGADOR 1..."); 
        datosMayorVida(misSoldados,orden,0);  
        System.out.println("-Promedio de nivel de vida del ejercito: "+promedioNivelVida(misSoldados,orden,0)+"\n");
        System.out.println("DATOS DE EJERCITO AZUL, JUGADOR 2...");
        datosMayorVida(misSoldados,orden,1); 
        System.out.println("-Promedio de nivel de vida del ejercito: "+promedioNivelVida(misSoldados,orden,1)+"\n");
        mostrarDatosOrden(misSoldados,orden); 
        rankingPoderBurbuja(orden);
        rankingPoderSeleccion(orden);
        System.out.println("\t\t\tCOMENZAMOS LA BATALLA!!!"); //Inician los turnos por jugador
        while(continuar){
            nuevasPosiciones(0,orden,misSoldados);
            nuevasPosiciones(1,orden,misSoldados);
            continuar=continuar(orden);
        }
        System.out.println("Partida terminada, gano...");
        
   }
    public static int nCantidadSoldados(){
        return (int)(Math.random()*10)+1;
    }
    public static void crearSoldados(ArrayList<ArrayList<Soldado>> arrL,ArrayList orden,int ejercito){
        int colStr;
        for (int i=0;i<nCantidadSoldados();i++ ){
            int fil = (int)(Math.random()*10);
            int col = (int)(Math.random()*10);
            while (arrL.get(fil).get(col)!=null){
                fil = (int)(Math.random()*10);
                col = (int)(Math.random()*10);
            }
            Soldado nuevoSoldado;  //
            nuevoSoldado=new Soldado("Soldado"+ejercito+"X"+i); //nombre asignado 
            nuevoSoldado.Soldado(ejercito,fil+1); //ejercito, fila y luego columna asignados 
            nuevoSoldado.setColumna(col+1); //Por separado para tambien dar valor a columnaStr
            nuevoSoldado.setVidaActual((int)(Math.random()*5+1));
            nuevoSoldado.Soldado(1,1,1,"Ofensiva",true);  //Demas atributos nuevos asignados METODO SOBRECARGADO X3
            arrL.get(fil).set(col, nuevoSoldado); //Soldado en el tablero datos fil-1 y col-1
            orden.add(arrL.get(fil).get(col)); //Arreglo que guardara el ejercito ordenado por creacion
        }
    }
    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> arrL){
        System.out.println(" A  B  C  D  E  F  G  H  I  J");
        for (int i=0;i<arrL.size(); i++){
            for (int j=0;j<arrL.get(i).size(); j++){
                Soldado posicion=arrL.get(i).get(j);
                if (posicion!=null){
                    String color = (posicion.getEjercito() == 0) ? "\u001B[31m" : "\u001B[34m"; // Rojo o Azul
                    System.out.print(color + "|" + posicion.getVidaActual() + "|" + "\u001B[0m"); // Restaura el color original
                }
                else 
                    System.out.print("|_|");
            }
            System.out.println(); 
        }
    }
    public static void mostrarDatos(ArrayList<ArrayList<Soldado>> arrL,int i,int j){
        Soldado posicion=arrL.get(i).get(j);
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
     public static void datosMayorVida(ArrayList<ArrayList<Soldado>> arrL,ArrayList<Soldado> orden,int ejercito){
        System.out.println("-Datos de soldado con mayor vida: ");
        int maxI = 0,maxJ = 0,mayorNivelV = 0;
        for(int i=0;i<orden.size();i++){
            int fil=orden.get(i).getFila()-1;
            int col=orden.get(i).getColumna()-1;
            Soldado posicion=arrL.get(fil).get(col);
            if (posicion.getEjercito()==ejercito){
                if (mayorNivelV<posicion.getVidaActual()){
                    mayorNivelV=posicion.getVidaActual();
                    maxI=fil;
                    maxJ=col;
                }
            }
        }
        mostrarDatos(arrL,maxI,maxJ);
    }
     public static double promedioNivelVida(ArrayList<ArrayList<Soldado>> arrL,ArrayList<Soldado> orden,int ejercito){
        double sumVida = 0;
        for(int i=0;i<orden.size();i++){
            int fil = orden.get(i).getFila()-1;
            int col = orden.get(i).getColumna()-1;
            Soldado posicion=arrL.get(fil).get(col);
            if(posicion.getEjercito()==ejercito)
                sumVida+=posicion.getVidaActual();
        }
        return sumVida/orden.size();
    }
    public static void mostrarDatosOrden(ArrayList<ArrayList<Soldado>> arrL,ArrayList<Soldado> orden){
        System.out.println("DATOS DEL EJERCITO EN EL ORDEN DE CREACION...");
        for(int i=0;i<orden.size();i++){
            if(orden.get(i).getEjercito()==0)
                System.out.println("-Ejercito 0...");
            else 
                System.out.println("-Ejercito 1...");
            if(orden.get(i)!=null)
                mostrarDatos(arrL,(orden.get(i).getFila())-1,(orden.get(i).getColumna())-1);
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
        System.out.println("Aclaracion: ejercito 0= rojo / ejercito 1= azul");
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
        System.out.println("Aclaracion: ejercito 0= rojo / ejercito 1= azul");
        for(int i=0;i<orden.size();i++)
            System.out.println((i+1)+".- "+orden.get(i).getNombre()+"\t, salud: "+orden.get(i).getVidaActual());
    }
    public static boolean continuar(ArrayList<Soldado> orden){ //continuen las rondas hasta que un ejercito se quede sin s
       boolean equipo0Vivo=false,equipo1Vivo=false;
       for(int i = 0; i < orden.size(); i++){
           if (orden.get(i).getEjercito() == 0)
               equipo0Vivo=true;
           if(orden.get(i).getEjercito() == 1)
               equipo1Vivo=true;
       }
       return (equipo0Vivo || equipo1Vivo); //Si existe al menos un soldado vivo de uno de los dos ejercitos que continue 
    }   
    public static void nuevasPosiciones(int e,ArrayList<Soldado> orden,ArrayList<ArrayList<Soldado>> arrL){
        Scanner sc=new Scanner(System.in);
        String eColor;
        if (e == 0)
            eColor="(rojo)";
        else
            eColor="(azul)";
        System.out.println("\n\t\t\t>>>Turno de Jugador "+(e+1)+"<<<");
        System.out.println("**Elija un soldado de su Ejercito "+e+" "+eColor); //Se mostrara la lista de Soldados de su ejercito
        for(int i=0;i<orden.size();i++){
            if(orden.get(i).getEjercito()==e){
                Soldado posicion=orden.get(i);
                System.out.println("NRO "+i+". "+posicion.getNombre()+": ");
                System.out.println("  posicion: "+posicion.getFila()+"x"+posicion.getColumnaStr());
            }
        }
        System.out.print(" >Ingrese NRO. de soldado seleccionado: ");
        Soldado soldadoE=orden.get(sc.nextInt());
        int fil = soldadoE.getFila();
        int col = soldadoE.getColumna(); //En modo numero para poder ubicarla en el tablero usando arr orden
        System.out.println("Soldado ubicado "+fil+"x"+soldadoE.getColumnaStr());
        System.out.println("**Elija una de las direcciones de movimiento disponibles...");
        ArrayList<String> posicionesStr=new ArrayList<>();//Simplemente para la impresion de estos mov como arriba
        if (soldadoE.getFila() != 1 && esMovimientoValido(arrL,soldadoE.getFila()-1,soldadoE.getColumna(),e))//arriba
            posicionesStr.add("arriba");
        if (soldadoE.getFila() != 10 && esMovimientoValido(arrL,soldadoE.getFila()+1,soldadoE.getColumna(),e))//abajo
            posicionesStr.add("abajo");
        if (soldadoE.getColumna() != 10 && esMovimientoValido(arrL,soldadoE.getFila(),soldadoE.getColumna()+1,e))//der
            posicionesStr.add("derecha");
        if (soldadoE.getColumna() != 1 && esMovimientoValido(arrL,soldadoE.getFila(),soldadoE.getColumna()-1,e))//izq
            posicionesStr.add("izquierda");
        for (int i=0;i<posicionesStr.size();i++) 
            System.out.println("NRO "+(i)+".- "+posicionesStr.get(i));
        System.out.print(" >Ingrese NRO. de direccion de movimiento seleccionado: ");
        int dNroSeleccionada = sc.nextInt();
        if (dNroSeleccionada >= 0 && dNroSeleccionada <= posicionesStr.size()) {
            String direccionElegida = posicionesStr.get(dNroSeleccionada);
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
            Soldado temp = arrL.get(fil-1).get(col-1);//Guardamos el objeto para que no se pierda cuando lo borremos del tablero
            arrL.get(fil-1).set(col-1,null); //Borramos del tablero el objeto en su antigua posicion
            Soldado rival = arrL.get(nuevoFil - 1).get(nuevoCol - 1); //Por si se encuentra un rival en la nueva posicion
            boolean eliminado=false;
            if (rival != null && rival.getEjercito() != e) { //BATALLA, comprueba que exista un rival
                System.out.println("Se ha iniciado una batalla...");
                int ganador=definirGanador(soldadoE,rival);
                if (ganador==1) {// El soldado gana //metrica ya modificada intento1
                    arrL.get(nuevoFil - 1).set(nuevoCol - 1, soldadoE);
                    soldadoE.setFila(nuevoFil);
                    soldadoE.setColumna(nuevoCol);
                    System.out.println("Su soldado ha ganado la batalla, el rival ha sido eliminado!");
                }
                else{ // el soldado pierde
                    System.out.println("Su soldado ha perdido la batalla y ha sido eliminado.");
                    eliminado=true;
                }
            } 
            if (!eliminado){ //Con tal que no haya perdido la batalla
                arrL.get(nuevoFil-1).set(nuevoCol-1,temp); //Guardamos en la nueva posicion el soldado
                Soldado nvPosicionSoldado=arrL.get(nuevoFil-1).get(nuevoCol-1);// Actualizamos a la nueva posicion
                nvPosicionSoldado.setFila(nuevoFil);
                nvPosicionSoldado.setColumna(nuevoCol);
                System.out.println("Soldado movido a " + nuevoFil+"x"+soldadoE.getColumnaStr());
            }
        }
        else //Default ingreso no valido
            System.out.println("Numero de direccion de movimiento no valido.");
        mostrarTablero(arrL);
    }
    public static boolean esMovimientoValido(ArrayList<ArrayList<Soldado>> arrL,int fila,int columna, int ejercito) { //Seguro
        Soldado soldadoEnPosicion = arrL.get(fila - 1).get(columna - 1);
        return soldadoEnPosicion == null || soldadoEnPosicion.getEjercito() != ejercito;
    }
    public static int definirGanador(Soldado sold1,Soldado sold2){ //Devuelve el soldado ganador segun metrica
        int vidaSold1,vidaSold2;
        double total,proba1,proba2,aleat;
        vidaSold1=sold1.getVidaActual();
        vidaSold2=sold2.getVidaActual();
        total=vidaSold1+vidaSold2; //En double para que la division de probabilidad salga no entero
        proba1=vidaSold1/total;
        proba2=vidaSold2/total; //Aunque no es necesario calcularlo para definir el ganador, usado para poner el porcent
        System.out.println("Probabilidades de vencer...\nTu soldado = "+(proba1*100)+"%\tTu rival = "+(proba2*100)+"%");
        aleat=Math.random(); //devuelve un numero aleatorio entre 0-1 (double) mas probabilidas tienen los de mayor vida
        if (aleat<=proba1)
            return 1; //Gana soldado 1 
        else 
            return 2; //Gana soldado 2
    }
}

