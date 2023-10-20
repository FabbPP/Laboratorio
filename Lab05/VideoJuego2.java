package Lab05;
import java.util.*;
public class VideoJuego2 {
    public static void main(String[] args){
        Soldado[][] misSoldados=new Soldado[10][10];
        int numSoldados=nCantidadSoldados();
        Soldado[] orden=new Soldado [numSoldados];
        crearSoldados(misSoldados,orden);
        mostrarTablero(misSoldados);
        mostrarDatosMayorVida(misSoldados);
        mostrarNVEjercito(misSoldados,numSoldados);
        System.out.println("  Promedio de nivel de vida del Ejercito: "+promedioDeNivelVida(misSoldados,numSoldados)+"\n");
        mostrarDatosOrden(orden,misSoldados);
        rankingPoderBurbuja(orden);
        rankingPoderSeleccion(orden);
    }
    public static int nCantidadSoldados(){
        return (int)((Math.random()*10)+1);
    }
    public static void crearSoldados(Soldado[][] arr,Soldado[] orden){
        for (int i=0;i<nCantidadSoldados();i++ ){
            int fil=(int)(Math.random()*10);
            int col=(int)(Math.random()*10);
            while (arr[fil][col]!=null){
                fil=(int)(Math.random()*10);
                col=(int)(Math.random()*10);
            }
            arr[fil][col]=new Soldado();
            arr[fil][col].setNombre("Soldado"+i);
            arr[fil][col].setFila(fil+1);
            arr[fil][col].setColumna(col+1);
            arr[fil][col].setNivelDeVida((int)(Math.random()*5+1));
            orden[i]= arr[fil][col]; //Arreglo que guardara el ejercito ordenado por creacion
        }
    }
    public static void mostrarTablero(Soldado[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] != null) 
                    System.out.print("|S|");
                else 
                    System.out.print("|_|");
            }
            System.out.println(); 
        }
    }
    public static void mostrarDatosMayorVida(Soldado[][] arr){
        double mayorNivelV=0;
        int mI=0,mJ=0;
        for (int i=0;i<arr.length;i++)
            for (int j=0;j<arr[i].length;j++)
                if (arr[i][j]!=null){
                    if (mayorNivelV<arr[i][j].getNivelDeVida()){
                        mayorNivelV=arr[i][j].getNivelDeVida();
                        mI=i;
                        mJ=j;
                    }
                
                }
                
        System.out.println("Datos de soldado con mayor nivel de vida...");
        mostrarDatos(arr,mI,mJ);
    }
    public static void mostrarDatos(Soldado[][] arr,int i,int j){
        System.out.println("  Nombre: "+ arr[i][j].getNombre());
        System.out.println("  Fila: "+ arr[i][j].getFila());
        System.out.println("  Columna: "+ arr[i][j].getColumna());
        System.out.println("  Nivel de vida: "+ arr[i][j].getNivelDeVida()+"\n");
    }
    public static double promedioDeNivelVida (Soldado[][] arr,int c){
        double sumAcumulador=0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[i][j]!=null){
                    sumAcumulador+=arr[i][j].getNivelDeVida();
                }
            }
        }
        return sumAcumulador/c;
    }
    public static void mostrarNVEjercito(Soldado[][] arr,int c){
        int k=0;
        System.out.println("Nivel de vida del Ejercito...");
        for (int i=0;i<arr.length;i++)
            for (int j=0;j<arr[i].length;j++)
                if (arr[i][j]!=null){
                    System.out.println("  "+arr[i][j].getNombre()+": "+arr[i][j].getNivelDeVida());
                    k++;
                    if (k==c)
                        break;
                }
    }
    public static void mostrarDatosOrden(Soldado[] orden,Soldado[][] arr){
        System.out.println("Datos del ejercito en el orden que fueron creados...");
        for(int i=0;i<orden.length;i++){
            if(orden[i]!=null)
                mostrarDatos(arr,(orden[i].getFila())-1,(orden[i].getColumna())-1);
        }
    }
    public static void rankingPoderBurbuja(Soldado[] arr){
        Soldado temp=arr[0];
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[i]!=null){
                    double ant=arr[j].getNivelDeVida();
                    double pos=arr[j+1].getNivelDeVida();
                    if (ant<pos){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }   
                }
            }
        }
        System.out.println("Ranking de poder por burbuja...");
        for(int i=0;i<arr.length;i++)
            System.out.println((i+1)+".- "+arr[i].getNombre()+"\t"+arr[i].getNivelDeVida());
    }
    public static void rankingPoderSeleccion(Soldado[] arr){
        double mayor=0,temp;
        int iMayor=0;
        for(int i=0;i>arr.length;i++){
            double posicion=arr[i].getNivelDeVida();
            for(int j=i;j<arr.length;j++){
                double pAnali=arr[j].getNivelDeVida();
                if(mayor<pAnali){
                    mayor=pAnali;
                    iMayor=j;
                }
            }
            temp=posicion;
            arr[i].setNivelDeVida(mayor);
            arr[iMayor].setNivelDeVida(temp);
        } 
        System.out.println("Ranking de poder por seleccion...");
        for(int i=0;i<arr.length;i++)
            System.out.println((i+1)+".- "+arr[i].getNombre()+"\t"+arr[i].getNivelDeVida());
    }
}

