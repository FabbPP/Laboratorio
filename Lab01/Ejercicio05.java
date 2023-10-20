package Lab01;
//Laboratorio Nro 01
//Autor: Pacheco Palo, Fabiana Francinet
import java.util.*;
public class Ejercicio05 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int tam1,tam2;
        tam1=(int)((Math.random()*5)+1);
        tam2=(int)((Math.random()*5)+1);
        String[] ejercito1=new String[tam1];
        String[] ejercito2=new String[tam2];
        inicializarEjercito(ejercito1);
        inicializarEjercito(ejercito2);
        if(mostrarGanador(ejercito1,ejercito2)==1){
            System.out.println("Ejercito 1 ganador");
            mostrarEjercito(ejercito1);
        }
        else if(mostrarGanador(ejercito1,ejercito2)==2){
            System.out.println("Ejercito 2 ganador");
            mostrarEjercito(ejercito2);
        }
        else
            System.out.println("Empate");
        
    }  
    public static void inicializarEjercito(String[] arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese nombres de los soldados...");
        for (int i=0;i<arr.length;i++){
            System.out.println("Soldado #"+(i+1));
            System.out.println("Ingrese nombre: ");
            arr[i]=sc.next();
        }
    }
    public static void mostrarEjercito(String[] arr){
       for(int i=0;i<arr.length;i++){
           System.out.println("Soldado"+(i+1));
           System.out.println(" nombre: "+arr[i]);
       }
    }
    public static int mostrarGanador(String[] arr,String[] arr2){
        if(arr.length>=arr2.length)
            if (arr.length==arr2.length)
                return 0;
            else 
                return 1;
        else 
            return 2;
        }
 }


