/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class Ventana extends JFrame implements ActionListener {

    JPanel contenedor;
    JButton[] botones;
    Coches coches;

    public Ventana() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VentanaBaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.setIconImage(ImageIO.read(new File("res/icon_car.png")));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Automóviles DARPA");
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(300, 300);
    }

    private void initComponents() {
        String textoBotones[] = {"Compra de vehículo", "Venta de vehículo", "Listado", "Mejor Oferta", "Fin"};
        botones = new JButton[textoBotones.length];
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(textoBotones.length, 1, 5, 5));
        contenedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (int x = 0; x < textoBotones.length; x++) {
            botones[x] = new JButton();
            botones[x].setText(textoBotones[x]);
            botones[x].setActionCommand(Integer.toString(x));
            botones[x].addActionListener(this);
            contenedor.add(botones[x]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "0":
                VentanaAlta vA = new VentanaAlta();
                this.dispose();
                break;
            case "1":
                VentanaBaja vB = new VentanaBaja();
                this.dispose();
                break;
            case "2":
                VentanaListado vL = new VentanaListado();
                this.dispose();
                break;
            case "3":
                VentanaOferta vO=new VentanaOferta();
                this.dispose();
                break;
            case "4":
                this.dispose();
                break;
        }
    }
}
