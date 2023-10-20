//FDP2 Lab 01
//Autor: Fabiana Pacheco
//Colaboro: -
package Lab02;
import java.util.*;
public class EjercicioAhorcado{
	public static void main(String[] args){
    	String ahor1 =  " +---+ \n"+
                   	" |   | \n" +
                   	"     | \n" +
                   	"     | \n" +
                   	"     | \n" +
                   	"     | \n" +
                   	"========= ";
    	String ahor2 =  " +---+ \n"+
                   	" |   | \n"+
                   	" O   | \n"+
                   	"     | \n"+
                   	"     | \n"+
                   	"     | \n"+
                   	"=========";
    	String ahor3 =  " +---+ \n"+
                   	" |   | \n"+
                   	" O   | \n"+
                   	" |   | \n"+
                   	"     | \n"+
                   	"     | \n"+
                   	"=========";
    	String ahor4 = " +---+ \n"+
                   	" |   | \n"+
                   	" O   | \n"+
                   	"/|   | \n"+
                   	"     | \n"+
                   	"     | \n"+
                   	"=========";
    	String ahor5 = " +---+ \n"+
                   	" |   | \n"+
                   	" O   | \n"+
                   	"/|\\  | \n"+
                   	"     | \n"+
                   	"     | \n"+
                   	"=========";
    	String ahor6 = " +---+ \n"+
                   	" |   | \n"+
                   	" O   | \n"+
                   	"/|\\  | \n"+
                   	"/    | \n"+
                   	"     | \n"+
                   	"=========";
    	String ahor7 = " +---+ \n"+
                   	" |   | \n"+
                   	" O   | \n"+
                   	"/|\\  | \n"+
                   	"/ \\  | \n"+
                   	"     | \n"+
                   	"=========";
    	String [] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
    	int contador = 1,intentos = 1;
    	String letra;
    	String [] palabras = {"programacion", "java", "indentacion", "clases",
    	"objetos", "desarrollador", "pruebas"};
    	String palSecreta = getPalabraSecreta(palabras);
    	System.out.println(figuras[0]);
    	mostrarBlancos(palSecreta);
    	System.out.println("\n");
        ArrayList<String> letrasAdivinadas=new ArrayList<>();
    	while(contador <= 6){
        	letra = ingreseLetra();
        	if (letraEnPalabraSecreta(letra, palSecreta)){
                    letrasAdivinadas.add(letra);
                    System.out.println(mostrarBlancosActualizados(letra,palSecreta,letrasAdivinadas));
                    intentos+=1;
                    if(palabraAdivinada(letrasAdivinadas,palSecreta)){
                        System.out.print("Ud gano, felicidades");
                        break;
                    }
                }       
                else{
                    System.out.println(figuras[contador]);
                    contador = contador +1;
                    intentos+=1;
                }
    	}
        System.out.println("\n");
        if(contador>=6)
            System.out.print("Ud perdio. ");
    	System.out.println("La palabra secreta era..."+palSecreta);
        System.out.println("El jugador requirio de "+intentos+" intentos.");
	}
    
	public static String getPalabraSecreta(String [] lasPalabras){
            String palSecreta;
            int ind;
            int indiceMayor = lasPalabras.length -1;
            int indiceMenor =0;
            ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
            return lasPalabras[ind];
        }//bien
	public static void mostrarBlancos(String palabra) {
            for(int i=0; i< palabra.length(); i++)
                    System.out.print("_ " );
	}//bien
	public static String ingreseLetra(){
            String laLetra;
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese letra: ");
            laLetra = sc.next();
            while(!(laLetra.length() == 1 && laLetra.matches("[a-z]"))){
                System.out.println("Entrada no válida. Ingrese una letra en minúscula (a-z): ");
                System.out.println("Ingrese letra: ");
                laLetra = sc.next();        
            }
            return laLetra;
	}   //bien
	public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
            for(int i=1;i<=palSecreta.length();i++){
                    if(palSecreta.substring(i-1,i).equals(letra))
                        return true;
            }
            return false;
	}
	public static String mostrarBlancosActualizados(String letra,String palabra,ArrayList<String> aList){
            System.out.println("PROCESANDO.....");
            String blancos="";
            for(int i=1; i<=palabra.length(); i++){
                    if(palabra.substring(i-1,i).equals(letra)){
                        blancos+=(letra+" ");
                    }
                    else if(aList.contains(palabra.substring(i-1,i)))
                        blancos+=(palabra.substring(i-1,i)+" ");
                            
                    else
                        blancos+=("_ " );    
            }   
            return blancos;
	}
        public static boolean palabraAdivinada(ArrayList<String>aList,String palabra){
            for(int i=1;i<=palabra.length();i++){
                if(!aList.contains(palabra.substring(i-1,i)))
                   return false;     
            }
            return true;
        }
}
