package Lab01;
//Laboratorio Nro 01
//Autor: Pacheco Palo, Fabiana Francinet
import java.util.*;
public class Ejercicio02 {
    public static void main(String[] args){
        String[] losSoldados,sNivelVida;
        sNivelVida=new String[5];
        losSoldados=new String [5];
        Scanner sc=new Scanner(System.in);
        ingresarDatos(losSoldados,sNivelVida);
        imprimirDatos(losSoldados, sNivelVida);
    }
    public static void ingresarDatos(String[] arr,String[] arr2){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingresar datos...");
        for(int i=0;i<arr.length;i++){
            System.out.print("Soldado #"+(i+1)+"\n"+"Ingrese nombre: ");
            arr[i]=sc.next();
            System.out.print("Ingrese nivel de vida: ");
            arr2[i]=sc.next();
        }
    }
    public static void imprimirDatos(String[] arr,String[] arr2){
        System.out.println("Datos ingresados...");
        for(int i=0;i<arr.length;i++){
            System.out.println("Soldado #"+(i+1)+"\n"+"Nombre: "+arr[i]);   
            System.out.println("Nivel de vida: "+arr2[i]);
        }
    }
}
