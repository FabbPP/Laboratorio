package Lab14;
public class Soldado {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadTotal = 0; //Variable de Clase
    private Ejercito ejercito; 
    private Reino reino;
    private String nombre;
    private int fila;
    private int columna; //Usada solo para reconocer posicion
    private String columnaStr; 
    private int nivelAtaque;
    private int nivelDefensa;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private String vive;
    
    //Constructor sobrecargado
    public Soldado(String n, Ejercito e,int nA,int nD,int v,String a,boolean vi,int fil){  //Simula un setNombre y es el principal
        nombre = n;
        ejercito = e;
        vidaActual = (int)(Math.random() * 5 + 1);
        cantidadTotal ++;
        nivelAtaque = nA;   //Inicializa por defecto los valores predeterminados
        nivelDefensa = nD;
        velocidad = v;
        actitud = a;
        if (vi)
            vive = "si";
        else 
            vive = "no";
        fila = fil;
    }
    //Metodos de clase
    public static int getCantidadTotal(){
        return cantidadTotal;
    }
    //Metodos de instancia
    public Soldado setFila(int f){ //mETHOD CALL CHAINING
        fila = f;
        return this;
    }
    //Get y set de atributos 
     //Metodos de atributos solo accesores, ya definidos en clase Soldado
    public String getNombre(){
        return nombre;
    }
    public Ejercito getEjercito(){
        return ejercito;
    }    
    public Reino getReino(){
        return reino;
    }
    public int getFila(){
        return fila;
    }
    public void setColumna(int c){  //Debido a que columna es una letra 
        columna = c;
        switch (columna){
            case 1: 
                columnaStr = "A";
                break;
            case 2: 
                columnaStr = "B";
                break;
            case 3:
                columnaStr = "C";
                break;
            case 4: 
                columnaStr = "D";
                break;
            case 5: 
                columnaStr = "E";
                break;
            case 6: 
                columnaStr = "F"; 
                break;
            case 7: 
                columnaStr = "G"; 
                break;
            case 8: 
                columnaStr = "H"; 
                break;
            case 9: 
                columnaStr = "I"; 
                break;
            case 10: 
                columnaStr = "J"; 
                break;
        }
    }
    public int getColumna(){ //Para usar la posicion
        return columna;
    }
    public String getColumnaStr(){
        return columnaStr;
    }
    public void setVidaActual(int v){
        vidaActual = v;
    }
    public int getVidaActual(){
        return vidaActual;
    }    
    public void setVive(boolean v){
        if (v == true)
            vive = "si";
        else 
            vive = "no";
    }
    public String getVive(){
        return vive;
    }
    
    //Solo metodos accesores para estos atributos
    public int getNivelDefensa(){
        return nivelDefensa;
    }
    public int getNivelAtaque(){
        return nivelAtaque;
    } 
    public int getVelocidad(){
        return velocidad;
    }
    public String getActitud(){
        return actitud;
    }
    //Acciones
    public void avanzar(){
        velocidad ++;
    }
    public void atacar(){
        actitud = "ofensiva";
        avanzar();
    }
    public void defender(){
        velocidad = 0;
    }
    public void actitud(String a){
        actitud = a;
    }
    public void retroceder(){
        if (velocidad > 0){
            velocidad = 0;
            actitud = "defensiva";
        }
        else
            velocidad-=1;
    }
    public void serAtacado(){
        vidaActual -= 1;
        if (vidaActual == 0)
            morir();
    }
    public void morir(){ //Contiene algunas variables de clase
        vive = "no";
        cantidadTotal --;
        ejercito.eliminarSoldado(this);

    }
    public void huir(){
        actitud="fuga";
        velocidad += 2;
    }
    public void ganarBatalla(){
        vidaActual += 1;
    }
    //Metodos toString cadenas
    public void tostring() {
        System.out.println("Datos del ejército...");
        System.out.println("-Soldado con mayor vida: ");
        int maxI = 0, maxJ = 0, mayorNivelV = 0;
        for (int i = 0; i < soldados.size(); i++) {
            Soldado posicion = soldados.get(i);
            if (mayorNivelV < posicion.getVidaActual()) {
                mayorNivelV = posicion.getVidaActual();
                maxI = i;
            }

        }
        mostrarDatos(maxI);
        System.out.println("-Promedio de nivel de vida del ejército: " + promedioNivelVida() + "\n");
    }

    public void mostrarDatos() {
        System.out.println("  Nombre: " + this.getNombre());
        System.out.println("  Ejercito: " + this.getEjercito());
        System.out.println("  Fila: " + this.getFila());
        System.out.println("  Columna: " + this.getColumnaStr());
        System.out.println("  Nivel ataque: " + this.getNivelAtaque());
        System.out.println("  Nivel defensa: " + this.getNivelDefensa());
        System.out.println("  Vida Actual: " + this.getVidaActual());
        System.out.println("  Velocidad: " + this.getVelocidad());
        System.out.println("  Actitud: " + this.getActitud());
        System.out.println("  Vive: " + this.getVive() + "\n");
    }

    public double promedioNivelVida() {
        double vidaTotal = 0;
        for (int i = 0; i < soldados.size(); i++) {
            int vida = soldados.get(i).getVidaActual();
            vidaTotal += vida;
        }
        return vidaTotal / soldados.size();
    }
}
