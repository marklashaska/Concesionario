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
public class VentanaAlta extends JFrame implements ActionListener {

    JPanel contenedor;
    JButton alta, cancelar, limpiar;
    JTextField modelo, matricula, precio;
    JLabel nmodelo, nmatricula, nprecio;

    public VentanaAlta() {
        try {
            this.setIconImage(ImageIO.read(new File("res/icon_car.png")));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Automóviles DARPA - Alta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(350, 400);
    }

    private void initComponents() {
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new GridLayout(9, 9, 5, 10));
        contenedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        alta = new JButton("Aceptar");
        alta.setToolTipText("Dar de alta el vehículo introducido");
        alta.addActionListener(this);
        cancelar = new JButton("Volver");
        cancelar.setToolTipText("Volver a la ventana anterior");
        cancelar.addActionListener(this);
        limpiar = new JButton("Limpiar");
        limpiar.setToolTipText("Borrar los datos introducidos");
        limpiar.addActionListener(this);
        nmodelo = new JLabel("Modelo de Coche");
        nmodelo.setFont(new Font("Times New Roman", Font.BOLD, 14));
        nmodelo.setHorizontalAlignment(JLabel.CENTER);
        modelo = new JTextField();
        nmatricula = new JLabel("Matrícula");
        nmatricula.setFont(new Font("Times New Roman", Font.BOLD, 14));
        nmatricula.setHorizontalAlignment(JLabel.CENTER);
        matricula = new JTextField();
        nprecio = new JLabel("Precio");
        nprecio.setFont(new Font("Times New Roman", Font.BOLD, 14));
        nprecio.setHorizontalAlignment(JLabel.CENTER);
        precio = new JTextField();
        contenedor.add(nmodelo);
        contenedor.add(modelo);
        contenedor.add(nmatricula);
        contenedor.add(matricula);
        contenedor.add(nprecio);
        contenedor.add(precio);
        contenedor.add(cancelar);
        contenedor.add(limpiar);
        contenedor.add(alta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Aceptar":
                if (Coche.compruebaCoche(modelo.getText(), matricula.getText(), isNumeric(precio.getText()))) {
                    int x = JOptionPane.showConfirmDialog(this, "¿Confirma que quiere dar de alta este vehículo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (x == 0) {
                        Coches.coches.add(new Coche(modelo.getText(), matricula.getText(), isNumeric(precio.getText())));
                        JOptionPane.showMessageDialog(this, "Vehículo dado de alta correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    if (modelo.getText().length() == 0) {
                        ventanaError("Ha de introducir un nombre para el modelo.");
                    }
                    if ((matricula.getText().length() == 0) || (Coche.compruebaMatricula(matricula.getText().toLowerCase()) == false)) {
                        ventanaError("La matrícula introducida no es correcta");
                    }
                    if (isNumeric(precio.getText()) == 0 || isNumeric(precio.getText()) < 0) {
                        ventanaError("El precio introducido no es correcto.");
                    }
                }
                break;
            case "Limpiar":
                modelo.setText(null);
                matricula.setText(null);
                precio.setText(null);
                break;
            case "Volver":
                dispose();
                Ventana v = new Ventana();
                break;
        }
    }

    private void ventanaError(String cadena) {
        JOptionPane.showMessageDialog(this, cadena, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    private int isNumeric(String cadena) {
        int n = 0;
        boolean correcto = true;
        try {
            n = Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            correcto = false;
        }
        if (correcto == true) {
            return n;
        }
        return 0;
    }
}
