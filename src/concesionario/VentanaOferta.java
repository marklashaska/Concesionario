/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class VentanaOferta extends JFrame implements ActionListener {

    JPanel contenedor, co1, co2, co3;
    JLabel mejorOferta, masBarato, masNuevo;
    JButton aceptar;
    Coches coches = new Coches();
    String matricula;
    String[] cabecera = {"Modelo", "Matrícula", "Precio"};
    String[][] contenido1 = new String[1][3], contenido2 = new String[1][3];
    JTable tabla1, tabla2;
    JScrollPane pt1, pt2;
    int x = 0;
    int y = 1;

    public VentanaOferta() {
        try {
            this.setIconImage(ImageIO.read(new File("res/icon_car.png")));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Automóviles DARPA - Oferta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(350, 400);
    }

    private void initComponents() {
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(5, 5, 5, 10));
        contenedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        co1 = new JPanel();
        co1.setLayout(new GridLayout(1, 2));
        co1.setBorder(new EmptyBorder(10, 0, 28, 0));
        co2 = new JPanel();
        co2.setLayout(new GridLayout(1, 2));
        co2.setBorder(new EmptyBorder(10, 0, 28, 0));
        co3 = new JPanel();
        co3.setLayout(new GridLayout(1, 2));
        co3.setBorder(new EmptyBorder(10, 0, 40, 0));
        mejorOferta = new JLabel("<html><div style='text-align:center;'>Estas son las mejores ofertas con las que contamos en nuestro concesionario</html>");
        mejorOferta.setFont(new Font("Arial", Font.BOLD, 14));
        masBarato=new JLabel("<html><div style='text-align:center;'>Coche más barato</html>");
        masBarato.setFont(new Font("Arial", Font.BOLD, 14));
        for (int x = 0; x < Coches.coches.size() - 1; x++) {
            if (Coches.coches.get(x + 1).getPrecio() < Coches.coches.get(x).getPrecio()) {
                for (int y = 0; y < 3; y++) {
                    contenido1[0][y] = Coches.coches.get(x).toArray(x, y);
                }
            }
        }
        tabla1 = new JTable(contenido1, cabecera);
        tabla1.setEnabled(false);
        tabla1.setFillsViewportHeight(true);
        pt1 = new JScrollPane(tabla1, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        co1.add(pt1);
        String matriculaNueva = Coche.matriculaNueva(coches.coches.get(x).getMatricula(), coches.coches.get(y).getMatricula());
        y++;
        do {
            matriculaNueva = Coche.matriculaNueva(matriculaNueva, coches.coches.get(y).getMatricula());
            y++;
        } while (y < Coches.coches.size());
        for (int x = 0; x < Coches.coches.size(); x++) {
            if (matriculaNueva.equalsIgnoreCase(Coches.coches.get(x).getMatricula())) {
                for (int y = 0; y < 3; y++) {
                    contenido2[0][y] = Coches.coches.get(x).toArray(x, y);
                }
            }
        }
        tabla2 = new JTable(contenido2, cabecera);
        tabla2.setEnabled(false);
        tabla2.setFillsViewportHeight(true);
        pt2 = new JScrollPane(tabla2, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        co2.add(pt2);
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        co3.add(aceptar);
        contenedor.add(mejorOferta);
        contenedor.add(masBarato);
        contenedor.add(co1);
        contenedor.add(co2);
        contenedor.add(co3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        Ventana v = new Ventana();
    }
}
