import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Activo;
import model.TipoActivo;

public class ActivoForm extends javax.swing.JFrame {

    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> tipoActivoComboBox;
    private javax.swing.JLabel tipoActivoLabel;
    private javax.swing.JTextField totalPeriodosField;
    private javax.swing.JLabel totalPeriodosLabel;
    private javax.swing.JTextField valorCompraField;
    private javax.swing.JLabel valorCompraLabel;

    public ActivoForm() {
        initComponents();
    }

    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        totalPeriodosLabel = new javax.swing.JLabel();
        totalPeriodosField = new javax.swing.JTextField();
        valorCompraLabel = new javax.swing.JLabel();
        valorCompraField = new javax.swing.JTextField();
        tipoActivoLabel = new javax.swing.JLabel();
        tipoActivoComboBox = new javax.swing.JComboBox<>();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activo");

        idLabel.setText("ID:");

        nombreLabel.setText("Nombre:");

        totalPeriodosLabel.setText("Total de Periodos de Depreciación:");

        valorCompraLabel.setText("Valor de Compra:");

        tipoActivoLabel.setText("Tipo de Activo:");

        tipoActivoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mueble", "Vehiculo" }));

        saveButton.setText("Guardar");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(nombreLabel)
                            .addComponent(totalPeriodosLabel)
                            .addComponent(valorCompraLabel)
                            .addComponent(tipoActivoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idField)
                            .addComponent(nombreField)
                            .addComponent(totalPeriodosField)
                            .addComponent(valorCompraField)
                            .addComponent(tipoActivoComboBox, 0, 200, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPeriodosLabel)
                    .addComponent(totalPeriodosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorCompraLabel)
                    .addComponent(valorCompraField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoActivoLabel)
                    .addComponent(tipoActivoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        // Tu código para guardar el activo
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        int totalPeriodos = Integer.parseInt(totalPeriodosField.getText());
        double valorCompra = Double.parseDouble(valorCompraField.getText());
        TipoActivo tipoActivo = TipoActivo.valueOf(tipoActivoComboBox.getSelectedItem().toString().toUpperCase());
        Activo activo = new Activo(id, nombre, totalPeriodos, valorCompra, tipoActivo);
        JOptionPane.showMessageDialog(this, "Activo guardado");
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        // Tu código para cancelar
        dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivoForm().setVisible(true);
            }
        });
    }
}
