package view;

import controller.TrabajadorController;
import model.AFP;
import model.Isapre;
import model.Trabajador;
import model.TrabajadorTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrabajadorView extends JFrame {
    private final TrabajadorTableModel trabajadorTableModel;
    private final TrabajadorController trabajadorController;

    public TrabajadorView(TrabajadorController trabajadorController) {
        this.trabajadorController = trabajadorController;

        setTitle("Dashboard");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        trabajadorTableModel = new TrabajadorTableModel();
        JTable trabajadorTable = new JTable(trabajadorTableModel);
        JScrollPane trabajadorScrollPane = new JScrollPane(trabajadorTable);

        panel.add(trabajadorScrollPane, BorderLayout.CENTER);

        JButton addTrabajadorButton = new JButton("Agregar trabajador");
        addTrabajadorButton.addActionListener(e -> showAddTrabajadorDialog());
        panel.add(addTrabajadorButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void showAddTrabajadorDialog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nombreTrabajadorLabel = new JLabel("Nombre:");
        panel.add(nombreTrabajadorLabel);
        JTextField nombreTrabajadorField = new JTextField();
        panel.add(nombreTrabajadorField);

        JLabel apellidoTrabajadorLabel = new JLabel("Apellido:");
        panel.add(apellidoTrabajadorLabel);
        JTextField apellidoTrabajadorField = new JTextField();
        panel.add(apellidoTrabajadorField);

        JLabel rutTrabajadorLabel = new JLabel("Rut:");
        panel.add(rutTrabajadorLabel);
        JTextField rutTrabajadorField = new JTextField();
        panel.add(rutTrabajadorField);

        JLabel isapreTrabajadorLabel = new JLabel("Isapre:");
        panel.add(isapreTrabajadorLabel);
        JComboBox<Isapre> trabajadorIsapreComboBox = new JComboBox<>(Isapre.values());
        panel.add(trabajadorIsapreComboBox);

        JLabel afpTrabajadorLabel = new JLabel("Afp:");
        panel.add(afpTrabajadorLabel);
        JComboBox<AFP> afpTrabajadorComboBox = new JComboBox<>(AFP.values());
        panel.add(afpTrabajadorComboBox);

        int result = JOptionPane.showConfirmDialog(this, panel, "Agregar trabajador", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String nombre = nombreTrabajadorField.getText();
            String apellido = apellidoTrabajadorField.getText();
            String rut = rutTrabajadorField.getText();
            String isapre = ((Isapre) trabajadorIsapreComboBox.getSelectedItem()).name();
            String afp = ((AFP) afpTrabajadorComboBox.getSelectedItem()).name();

            try {
                trabajadorController.crearTrabajador(nombre, apellido, rut, isapre, afp);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            loadTrabajadorTable();
        }
    }

    private void loadTrabajadorTable() {
        ArrayList<Trabajador> trabajadores = trabajadorController.obtenerTrabajadores();
        trabajadorTableModel.setTrabajadores(trabajadores);
    }
}
