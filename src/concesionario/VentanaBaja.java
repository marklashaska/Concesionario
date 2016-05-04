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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class VentanaBaja extends JFrame implements ActionListener {

    JPanel contenedor;
    JButton baja, cancelar, limpiar;
    JLabel nmatricula;
    JTextField matricula;

    public VentanaBaja() {
        try {
            this.setIconImage(ImageIO.read(new File("res/icon_car.png")));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Automóviles DARPA - Baja");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(300, 300);
    }

    private void initComponents() {
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(5, 5, 5, 10));
        contenedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        baja = new JButton("Aceptar");
        baja.addActionListener(this);
        cancelar = new JButton("Volver");
        cancelar.addActionListener(this);
        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(this);
        nmatricula = new JLabel("Matrícula:");
        nmatricula.setFont(new Font("Times New Roman", Font.BOLD, 14));
        nmatricula.setHorizontalAlignment(JLabel.CENTER);
        matricula = new JTextField();
        contenedor.add(nmatricula);
        contenedor.add(matricula);
        contenedor.add(cancelar);
        contenedor.add(limpiar);
        contenedor.add(baja);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if (Coche.compruebaMatricula(matricula.getText())) {
                    for (int x = 0; x < Coches.coches.size(); x++) {
                        if (matricula.getText().equalsIgnoreCase(Coches.coches.get(x).getMatricula())) {
                            int y = JOptionPane.showConfirmDialog(this, "¿Confirma que quiere dar de baja este vehículo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (y == 0) {
                                Coches.coches.remove(x);
                                JOptionPane.showMessageDialog(this, "Vehículo dado de baja correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                } else {
                    ventanaError("La matrícula introducida no es correcta.");
                }
                break;
            case "Limpiar":
                matricula.setText(null);
                break;
            case "Volver":
                dispose();
                Ventana v = new Ventana();
        }
    }

    private void ventanaError(String cadena) {
        JOptionPane.showMessageDialog(this, cadena, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
}
