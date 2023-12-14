package Lab24;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VentanaInicio extends JFrame {
    private static final int ANCHO = 300;
    private static final int ALTO = 100;
    private Mapa territorio;
    
    public VentanaInicio(Mapa territorio){
        this.territorio = territorio;
        setSize(ANCHO,ALTO);
        setTitle("Bandos game");
        setLayout(new FlowLayout());
        createContents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void createContents(){
        JLabel bienvenido = new JLabel("Bienvenido al videojuego");
        JButton botonIniciar = new JButton("Iniciar!");
        add(bienvenido);
        add(botonIniciar);
        botonIniciar.addActionListener(new ActionListener(){
                                            public void actionPerformed(ActionEvent e){
                                                JOptionPane.showMessageDialog(null,"\t\t Iniciando campo de batalla\n\t\t\t   ...\n\t  Se elegira aleatoriamente un territorio...");
                                                JOptionPane.showMessageDialog(null,territorio.getTipoDeTerritorio());
                                            }
                                         }
                                       );
    }
       
}
