package Lab24;
public class Reino {
    public static final String[] NOMBRES_REINOS = {"Inglaterra", "Francia", "Sacro_Imperio", "Castilla_Aragon", "Moros"};
    private String nombre;
     
    public Reino(String n){
        nombre = n;      
    }
    public String getNombre(){
        return nombre;
    }
}
