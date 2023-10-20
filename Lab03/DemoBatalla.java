//Laboratorio FDP2-Lab03
//Autor: Fabiana Pacheco
package Lab03;
import java.util.*;
public class DemoBatalla {
    public static void main(String [] args){
        Nave [] misNaves = new Nave[1
                ];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i+1));
            System.out.print("\tNombre: ");
            nomb = sc.next();
            System.out.print("\tFila: ");
            fil = sc.nextInt();
            System.out.print("\tColumna: ");
            col = sc.next();
            System.out.print("\tEstado: ");
            est = sc.nextBoolean();
            System.out.print("\tPuntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("...\nNAVES CREADAS...");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: ");
        mostrarMayorPuntos(misNaves);
   }
//Método para mostrar todas las naves
    public static void mostrarNaves(Nave [] flota){
        for(int i=0;i<flota.length;i++){
            System.out.print("Nave "+(i+1)+"\n\tNombre: ");
            System.out.print(flota[i].getNombre()+"\n\tFila: ");
            System.out.print(flota[i].getFila()+"\n\tColumna: ");
            System.out.print(flota[i].getColumna()+"\n\tEstado: ");
            System.out.print(flota[i].getEstado()+"\n\tPuntos: ");
            System.out.println(flota[i].getPuntos());
        }

    }
    public static void mostrarNave(Nave [] flota,int i){
            System.out.print("Nave "+(i+1)+":\n\tNombre: ");
            System.out.print(flota[i].getNombre()+"\n\tFila: ");
            System.out.print(flota[i].getFila()+"\n\tColumna: ");
            System.out.print(flota[i].getColumna()+"\n\tEstado: ");
            System.out.print(flota[i].getEstado()+"\n\tPuntos: ");
            System.out.println(flota[i].getPuntos()+"\n");
    }
//Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave [] flota){
        int i;
        boolean noEncontrado=true;
        Scanner sc=new Scanner(System.in);
        System.out.println("BUSQUEDA POR NOMBRE...");
        System.out.print("Ingrese nombre de nave(s) a buscar: ");
        String nom=sc.next();
        for(i=0;i<flota.length;i++){
            if((flota[i].getNombre()).equals(nom)){
               mostrarNave(flota,i); 
               noEncontrado=false;
            }
        }
        if(noEncontrado)
            System.out.println("No encontrado");
    }
//Método para mostrar todas las naves con un número de puntos inferior o igual
//al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave [] flota){
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("BUSQUEDA POR PUNTOS...");
        System.out.print("Ingrese limite de puntos de nave(s) a buscar: ");
        int ptos=sc.nextInt();
        for(i=0;i<flota.length;i++){
            if((flota[i].getPuntos())<=(ptos))
               mostrarNave(flota,i); 
        } 
    }
//Método que devuelve la Nave con mayor número de Puntos
    public static void mostrarMayorPuntos(Nave [] flota){
        int i, maxPtos=0,indiceMax=0;
        System.out.println("NAVE CON MAYOR NUMERO DE PUNTOS...");
        for(i=0;i<flota.length;i++){
            if (maxPtos<flota[i].getPuntos()){
                maxPtos=flota[i].getPuntos();
                indiceMax=i;
            }
        } 
        mostrarNave(flota,indiceMax);
    }
//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
//pero aleatoriamente desordenados
    public static Nave[] nuevoArr(Nave[] flota){
        Nave[] nuevoArreglo = new Nave[flota.length];
        boolean[] seleccionados = new boolean[flota.length]; 
        Random rand = new Random();
        int navesCopiadas = 0;
        while (navesCopiadas < flota.length) {
            int indiceAleatorio = rand.nextInt(flota.length);
            if (!seleccionados[indiceAleatorio]) {
                nuevoArreglo[navesCopiadas] = flota[indiceAleatorio];
                seleccionados[indiceAleatorio] = true;
                navesCopiadas++;
            }
        }
        return nuevoArreglo;
    }

}
