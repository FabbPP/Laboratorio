package Lab22;
public class Soldado {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadTotal = 0; //Variable de Clase
    protected String tipoDeSoldado;
    private int fila;
    private int columna;
    private String columnaStr;
    private Ejercito ejercito; 
    private String nombre;
    private int vidaActual;
    protected String actitud; //Defensiva, fuga
    protected int nivelAtaque;
    protected int nivelDefensa; 

    public Soldado(String tipoDeSoldado,Ejercito suEjercito){  //Constructor define vidaActual del soldado
        this.tipoDeSoldado = tipoDeSoldado;
        ejercito = suEjercito;
        switch (tipoDeSoldado){ //Definimos vidaActual segun el tipo de Soldado 
            case "Caballero" :
                vidaActual = (int)((Math.random()*3)+10); // [10..12]
                break;
            case "Espadachin" :
                vidaActual = (int)((Math.random()*3)+8); //[8..10],
                break;
            case "Arquero" :
                vidaActual = (int)((Math.random()*3)+3); //[3..5] 
                break;
            case "Lancero" :
                vidaActual = (int)((Math.random()*4)+5); //[5..8] 
                break;
        } 
        nombre =(tipoDeSoldado+ejercito.getCantidadSoldados()+"x"+ejercito.getNombre());
        cantidadTotal ++;
    }
    public static int getCantidadSoldados(){
        return cantidadTotal;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipoDeSoldado(){
        return tipoDeSoldado;
    }
    public String getTipoAbreviado() {
        return tipoDeSoldado.substring(0, 1); // Obtener la primera letra del tipo de Soldado
    }   
    public Soldado setFila(int fil){ //Method-call chaining
        fila = fil;
        return this;
    }
    public int getFila(){
        return fila;
    }
    public void setColumna(int col){
        columna = col;
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
    public int getColumna(){
        return columna;
    }
    public String getColumnaStr(){
        return columnaStr;
    }
    public Ejercito getEjercito(){
        return ejercito;
    }    
    public void setVidaActual(int va){
        vidaActual = va;
    }
    public int getVidaActual(){
        return vidaActual;
    }
    public void mostrarDatos() {
        System.out.println("  Nombre: " + nombre);
        System.out.println("  Reino: "+this.getEjercito().getReino().getNombre());
        System.out.println("  Fila: " + fila);
        System.out.println("  Columna: " + columnaStr);
        System.out.println("  Vida Actual: " + vidaActual );
        System.out.println("  Nivel de Ataque: " + nivelAtaque);
        System.out.println("  Nivel de defensa: " + nivelDefensa +"\n_______________\n");
    }  
    public void bonificacionxVencida(){
        this.vidaActual ++;
    }
    public void bonificacionxTerritorio(){
        this.vidaActual ++;
    }
}