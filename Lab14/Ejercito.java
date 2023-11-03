package Lab14;
import java.util.*;
public class Ejercito {
    private static int cantidadEjercitos = 0;
    private String nombre;
    private Reino reino;
    private int id; // Identificador para poder diferenciar los ejércitos
    private ArrayList<Soldado> soldados;

    public Ejercito(String n) {
        nombre = n;
        this.soldados = new ArrayList<>();
        cantidadEjercitos++;
    }
    public int getCantidadEjercitos() {
        return cantidadEjercitos;
    }
    public void agregarSoldado(String nombre, int nivelAtaque, int nivelDefensa, int velocidad, String actitud, boolean vive) {
        if (soldados.size() < Soldado.MAX_CANTIDAD) {
            Soldado nuevoSoldado = new Soldado(nombre, this, nivelAtaque, nivelDefensa, velocidad, actitud, vive);
            soldados.add(nuevoSoldado);
        } else {
            System.out.println("No es posible agregar más soldados, el ejército ha alcanzado su límite.");
        }
    }
    public void eliminarSoldado(Soldado unSoldado) {
        if (soldados.contains(unSoldado)) {
            soldados.remove(unSoldado);
        } else {
            System.out.println("El soldado no pertenece a este ejército.");
        }
    }

    public int getCantidadSoldados() {
        return soldados.size();
    }

    public void setReino(Reino reino) {
        this.reino = reino;
    }

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

    public void mostrarDatos(int maxI) {
        Soldado posicion = soldados.get(maxI);
        System.out.println("  Nombre: " + posicion.getNombre());
        System.out.println("  Ejercito: " + posicion.getEjercito());
        System.out.println("  Fila: " + posicion.getFila());
        System.out.println("  Columna: " + posicion.getColumnaStr());
        System.out.println("  Nivel ataque: " + posicion.getNivelAtaque());
        System.out.println("  Nivel defensa: " + posicion.getNivelDefensa());
        System.out.println("  Vida Actual: " + posicion.getVidaActual());
        System.out.println("  Velocidad: " + posicion.getVelocidad());
        System.out.println("  Actitud: " + posicion.getActitud());
        System.out.println("  Vive: " + posicion.getVive() + "\n");
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
