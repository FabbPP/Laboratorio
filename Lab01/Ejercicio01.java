package Lab01;
//Laboratorio Nro 01
//Autor: Pacheco Palo, Fabiana Francinet
import java.util.*;
public class Ejercicio01 {
    public static void main(String[] args){
        String[] losSoldados=new String[5];
        Scanner sc=new Scanner(System.in);
        ingresarDatos(losSoldados);
        imprimirDatos(losSoldados);
    }
    public static void ingresarDatos(String[] arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingresar datos...");
        for(int i=0;i<arr.length;i++){
            System.out.print("Soldado #"+(i+1)+"\n"+"Ingrese nombre: ");
            arr[i]=sc.next();
        }
    }
    public static void imprimirDatos(String[] arr){
        System.out.println("Datos ingresados...");
        for(int i=0;i<arr.length;i++){
            System.out.println("Soldado #"+(i+1)+"\n"+"Nombre: "+arr[i]);     
        }
    }
}
