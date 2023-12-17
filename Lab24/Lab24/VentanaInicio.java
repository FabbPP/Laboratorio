package Lab24;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VentanaInicio extends JFrame {
    private static final int ANCHO = 260;
    private static final int ALTO = 250;
    public static String nPlayer1;
    public static String nPlayer2;
    public static String ReinoPlayer1;
    public static String ReinoPlayer2;
    
    private Mapa territorio;
    
    public VentanaInicio(Mapa territorio){
        this.territorio = territorio;
        setSize(ANCHO,ALTO);
        setTitle("Civil War game");
        setLayout(new FlowLayout());
        createContents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void createContents() {
        JLabel nombre = new JLabel("Ingresen los nombres de los jugadores"); //Se guardara un archivo con el nombre de los jugadores
        JTextField nameBox1 = new JTextField(10);
        JTextField nameBox2 = new JTextField(10);
        JButton botonIniciar = new JButton("Iniciar!");
        add(new JLabel("Bienvenido al videojuego"));
        add(nombre);
        add(new JLabel("Jugador 1: "));
        add(nameBox1);
        add(new JLabel("Jugador 2: "));
        add(nameBox2);
        add(botonIniciar, BorderLayout.AFTER_LAST_LINE);
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    PrintWriter fileIn;
                    fileIn = new PrintWriter (new FileWriter("allPlayers.txt",true));
                    String namePlayer1 = nameBox1.getText();
                    String namePlayer2 = nameBox2.getText();
                    fileIn.println(namePlayer1);
                    fileIn.println(namePlayer2);
                    JOptionPane.showMessageDialog(null,"Nombres guardados en el archivo satisfactoriamente");
                }
                catch (IOException a){
                    System.out.println("IO: " + a.getMessage());
                }
                mostrarPanelTerritorio();
            }
        });
        this.nPlayer1 = nameBox1.getText();
        this.nPlayer2 = nameBox2.getText();
    }
    public void mostrarPanelTerritorio() {
        JPanel panelTerritorio = new JPanel();
        setSize(800,130);
        panelTerritorio.add(new JLabel("Iniciando campo de batalla...\nSe elegirá aleatoriamente un territorio..."));
        panelTerritorio.add(new JLabel("\n"+territorio.getTipoDeTerritorio()));
        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.addActionListener(new ActionListenerContinuar());//abajo
        panelTerritorio.add(botonContinuar);
        getContentPane().removeAll();
        getContentPane().add(panelTerritorio);
        // Actualizamos la interfaz gráfica
        revalidate();
        repaint();
    }
    private class ActionListenerContinuar implements ActionListener { //aqui

        private String ReinoPlayer1;
        private String ReinoPlayer2;

        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            JPanel ejercito1 = new JPanel();
            ejercito1.add(new JLabel("Bienvenido jugador "+nPlayer1+"\nEscoja el Reino que desee"));
            String[] posibleReinos = Reino.NOMBRES_REINOS;
            JComboBox <String> reinos1 = new JComboBox<>(posibleReinos);
            ejercito1.add(reinos1);
            ejercito1.add(new JButton("Listo!"));
            ejercito1.setVisible(true);
            String reino1 = String.valueOf(reinos1.getSelectedItem());
            this.ReinoPlayer1 = reino1;
            getContentPane().removeAll();
            JPanel ejercito2 = new JPanel();
            ejercito2.add(new JLabel("Bienvenido jugador "+nPlayer2+"\nEscoja el Reino que desee"));
            JComboBox <String> reinos2 = new JComboBox<>(posibleReinos);
            ejercito2.add(reinos2);
            ejercito2.add(new JButton("Listo!"));
            ejercito2.setVisible(true);
            String reino2 = String.valueOf(reinos2.getSelectedItem());
            this.ReinoPlayer2 = reino2;
            getContentPane().add(ejercito2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaInicio(new Mapa());
        });
    }
}
