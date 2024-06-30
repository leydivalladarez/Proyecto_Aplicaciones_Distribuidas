package view.nomina;

import dao.EmpleadoDAO;
import model.Empleado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NominaForm extends JFrame {
    private JTextField tfCedula, tfNombre, tfFechaIngreso, tfSueldo;
    private JButton btnGuardar, btnCancelar;

    public NominaForm() {
        setTitle("Formulario de Nómina");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel con un borde y layout
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Definir el estilo de la fuente
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        // Definir colores
        Color bgColor = new Color(230, 230, 250);  // Lavanda claro
        Color fgColor = new Color(54, 54, 54);     // Gris oscuro

        // Aplicar colores y fuente a las etiquetas y campos de texto
        tfCedula = createTextField(labelFont, fieldFont, bgColor, fgColor);
        tfNombre = createTextField(labelFont, fieldFont, bgColor, fgColor);
        tfFechaIngreso = createTextField(labelFont, fieldFont, bgColor, fgColor);
        tfSueldo = createTextField(labelFont, fieldFont, bgColor, fgColor);

        JLabel lblCedula = createLabel("Cédula:", labelFont, fgColor);
        JLabel lblNombre = createLabel("Nombre:", labelFont, fgColor);
        JLabel lblFechaIngreso = createLabel("Fecha Ingreso:", labelFont, fgColor);
        JLabel lblSueldo = createLabel("Sueldo:", labelFont, fgColor);

        // Agregar etiquetas y campos de texto al panel
        panel.add(lblCedula);
        panel.add(tfCedula);
        panel.add(lblNombre);
        panel.add(tfNombre);
        panel.add(lblFechaIngreso);
        panel.add(tfFechaIngreso);
        panel.add(lblSueldo);
        panel.add(tfSueldo);

        // Crear y configurar el botón de guardar
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(labelFont);
        btnGuardar.setBackground(new Color(100, 149, 237)); // Azul medio
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEmpleado();
            }
        });

        // Crear y configurar el botón de cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(labelFont);
        btnCancelar.setBackground(new Color(255, 99, 71)); // Rojo claro
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Agregar botón de guardar y botón de cancelar al panel
        panel.add(new JLabel()); // Espacio vacío para centrar los botones
        panel.add(btnGuardar);
        panel.add(new JLabel()); // Espacio vacío para centrar los botones
        panel.add(btnCancelar);

        // Agregar panel al formulario
        add(panel);
    }

    private JTextField createTextField(Font labelFont, Font fieldFont, Color bgColor, Color fgColor) {
        JTextField textField = new JTextField();
        textField.setFont(fieldFont);
        textField.setBackground(bgColor);
        textField.setForeground(fgColor);
        return textField;
    }

    private JLabel createLabel(String text, Font labelFont, Color fgColor) {
        JLabel label = new JLabel(text);
        label.setFont(labelFont);
        label.setForeground(fgColor);
        return label;
    }

    private void guardarEmpleado() {
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado empleado = new Empleado();

            empleado.setCedula(tfCedula.getText());
            empleado.setNombre(tfNombre.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaIngreso = sdf.parse(tfFechaIngreso.getText());
            empleado.setFechaIngreso(fechaIngreso);
            empleado.setSueldo(Double.parseDouble(tfSueldo.getText()));

            empleadoDAO.agregarEmpleado(empleado);

            JOptionPane.showMessageDialog(null, "Empleado guardado: " + empleado.getNombre());
            limpiarCampos();
        } catch (SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el empleado: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        tfCedula.setText("");
        tfNombre.setText("");
        tfFechaIngreso.setText("");
        tfSueldo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NominaForm().setVisible(true);
            }
        });
    }
}
