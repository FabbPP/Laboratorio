package Lab06;
public class Soldado {
    private String nombre;
    private int ejercito;
    private int fila;
    private int columna;
    private int nivelDeVida;
    
    public void setNombre( String n){
        nombre = n;
    }
    public void setEjercito(int e){
        ejercito=e;
    }
    public int getEjercito(){
        return ejercito;
    }
    public void setFila(int f){
        fila = f;
    }
    public void setColumna(int c){
        columna = c;
    }
    public void setNivelDeVida(int nv){
        nivelDeVida=nv;
    }
    public String getNombre(){
        return nombre;

    }
    public int getFila(){
        return fila;

    }
    public int getColumna(){
        return columna;
    }

    public int getNivelDeVida(){
        return nivelDeVida;

    }
}
