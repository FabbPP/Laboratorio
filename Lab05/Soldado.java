package Lab05;
public class Soldado {
    private String nombre;
    private int fila;
    private int columna;
    private double nivelDeVida;
    
    public void setNombre( String n){
        nombre = n;
    }
    public void setFila(int f){
        fila = f;
    }
    public void setColumna(int c){
        columna = c;
    }
    public void setNivelDeVida(double nv){
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

    public double getNivelDeVida(){
        return nivelDeVida;

    }
}

