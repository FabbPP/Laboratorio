package Lab04;
//Laboratorio FDP2-Lab03
//Autor: Fabiana Pacheco
import java.util.*;
public class DemoBatalla2 {
    public static void main(String [] args){
        Nave [] misNaves = new Nave[2];
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
        mostrarMayorPuntos(misNaves);
        busquedaLinealNombre(misNaves);
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreBurbuja(misNaves); //falta
        mostrarNaves(misNaves);
        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        System.out.print("Ingrese nombre a buscar: ");
        String a=sc.next();
        busquedaBinariaNombre(misNaves,a);
        if(busquedaBinariaNombre(misNaves,a)==-1)
            System.out.println("no encontrado");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);

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
//Método para buscar la primera nave con un nombre que se pidió por teclado
    public static void busquedaLinealNombre(Nave[] flota){
        Scanner sc=new Scanner(System.in);
        System.out.println("BUSQUEDA POR NOMBRE...");
        System.out.print("Ingrese nombre de nave(s) a buscar: ");
        int iBusqueda=busquedaLineal(flota,sc.next());
        mostrarNave(flota,iBusqueda);
        if(iBusqueda==-1)
            System.out.println("\tNo encontrado...");
    }
//Método que ordena por número de puntos de MAYOR A MENOR
    public static void ordenarPorPuntosBurbuja(Nave[] arr){
        int temp;
        System.out.println("ORDENADAS POR PUNTOS DE MAYOR A MENOR...");
        for(int i=(arr.length-1);i>1;i--){
            for(int j=0;j<i;j++){
               if(arr[j+1].getPuntos()<arr[j].getPuntos()){
                 temp=arr[j].getPuntos();
                 arr[j].setPuntos(arr[j+1].getPuntos());
                 arr[j+1].setPuntos(temp);
               }   
            }
        }
    }
//Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] arr){
        String temp;
        System.out.println("ORDENADOS ALFABETICAMENTE POR NOMBRE: ");
        for(int i=(arr.length-1);i>1;i--){
            for(int j=0;j<i;j++){
               if(arr[j+1].getNombre().compareTo(arr[j].getNombre())<0){
                 temp=arr[j].getNombre();
                 arr[j].setNombre(arr[j+1].getNombre());
                 arr[j+1].setNombre(temp);
               }   
    }
        }
    }
//Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] arr, String a){
        int media,alta=arr.length-1;
        int baja=0;
        while (baja<=alta){
            media=(alta+baja)/2;
            int comparacion=a.compareTo(arr[media].getNombre());
            if(comparacion==0)
                return media;
            else if(comparacion<0)
                alta=media-1;
            else if(comparacion>0)
                baja=media+1;      
        }
        return -1;
    }
//Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] arr){
        System.out.println("ORDENAMIENTOS PUNTOS POR METODO BURBUJA...");
        int min=arr[0].getPuntos(),indiceMin=0,temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[j].getPuntos()<min){
                    min=arr[j].getPuntos();
                    indiceMin=j;
                }
            }
            temp=arr[i].getPuntos();
            arr[i].setPuntos(arr[indiceMin].getPuntos());
            arr[indiceMin].setPuntos(temp);
        }
    }
//Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota){
        
    }
//Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] arr){
        System.out.println("ORDENAMIENTOS PUNTOS DE MENOR A MAYOR...");
         for (int i = 1; i < arr.length; i++) {
        Nave actual = arr[i];
        int j = i - 1;
        
        while (j >= 0 && actual.getNombre().compareTo(arr[j].getNombre()) < 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        
        arr[j + 1] = actual;
        }
    }
//Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] arr){    
        System.out.println("ORDENAMIENTOS NOMBRE ALFABETICAMENTE DE Z a A...");
        for (int i = 1; i < arr.length; i++) {
            Nave actual = arr[i];
            int j = i - 1;
            while (j >= 0 && actual.getNombre().compareTo(arr[j].getNombre()) >0) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = actual;
        }
    }
//Busquedas y ordenamientos 

    public static void intercambiar(int[] arr,int i,int j){
        int temp; 
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //Ordenamiento seleccion
    public static void ordenamientoSeleccion(int[]arr){
        int min=arr[0],inMenor=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    inMenor=j;
                }
            }
            intercambiar(arr,i,inMenor);
        }
    }
    //Busqueda lineal Nombre
    public static int busquedaLineal(Nave[] arr,String a) {
        for(int i=0;i<arr.length;i++){
                if (arr[i].getNombre().equals(a))
                return i;
        }
        return -1;
    }
}
