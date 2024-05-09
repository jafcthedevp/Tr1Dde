package IGU;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Screen {
    private JPanel panel1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton calcularButton;
    private JButton nuevoButton;
    private JTextField textField5;
    private JComboBox comboBox1;

    public Screen() {
        comboBox1.addItem("Cat.A");
        comboBox1.addItem("Cat.B");
        comboBox1.addItem("Cat.C");
        comboBox1.addItem("Cat.D");

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la categoría seleccionada
                String categoria = (String) comboBox1.getSelectedItem();
                // Obtener la pensión asociada a la categoría
                double pension = obtenerPension(categoria);
                // Mostrar la pensión en el textField2
                textField2.setText(String.valueOf(pension));
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el porcentaje de descuento ingresado
                double descuento = Double.parseDouble(textField5.getText());
                // Obtener la pensión actual y calcular la nueva pensión
                double pensionActual = Double.parseDouble(textField2.getText());
                double nuevaPension = pensionActual - (pensionActual * descuento / 100);
                // Mostrar la nueva pensión en el textField3
                textField3.setText(String.valueOf(nuevaPension));
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                comboBox1.setSelectedIndex(0);
            }
        });
    }

    private double obtenerPension(String categoria) {
        switch (categoria) {
            case "Cat.A":
                return 550;
            case "Cat.B":
                return 500;
            case "Cat.C":
                return 460;
            case "Cat.D":
                return 400;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Screen");
        frame.setContentPane(new Screen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

