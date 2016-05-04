/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import java.awt.BorderLayout;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class VentanaListado extends JFrame implements ActionListener {
    
    JPanel contenedor, boton;
    JButton salir;
    JLabel listado;
    Coches coches = new Coches();
    String[] cabecera = {"Modelo", "Matrícula", "Precio"};
    String[][] contenido;
    JScrollPane panel;
    JTable lista;
    
    public VentanaListado() {
        try {
            this.setIconImage(ImageIO.read(new File("res/icon_car.png")));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Automóviles DARPA - Listado");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(350, 400);
    }
    
    private void initComponents() {
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(3, 5, 5, 10));
        contenedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        salir = new JButton("Aceptar");
        salir.addActionListener(this);
        boton = new JPanel();
        boton.setLayout(new GridLayout(1,2));
        boton.setBorder(new EmptyBorder(40, 0, 40, 0));
        boton.add(salir);
        listado = new JLabel("Listado de coches disponibles");
        listado.setFont(new Font("Arial", Font.BOLD, 14));
        listado.setHorizontalAlignment(JLabel.CENTER);
        contenedor.add(listado, BorderLayout.NORTH);
        contenido = new String[Coches.coches.size()][3];
        for (int x = 0; x < Coches.coches.size(); x++) {
            for (int y = 0; y < 3; y++) {
                contenido[x][y] = Coches.coches.get(x).toArray(x, y);
            }
        }
        lista = new JTable(contenido, cabecera);
        lista.setEnabled(false);
        panel = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setFillsViewportHeight(true);
        contenedor.add(panel);
        contenedor.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        Ventana v = new Ventana();
    }
}
