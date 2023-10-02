/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itver.crud_project;

import conn.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alemr214
 */
public final class CRUD_view extends javax.swing.JFrame {

    private final MySQLConnection conexion = new MySQLConnection();

    // ...
    public void inicializarConexion() {
        try {
            conexion.openConnection();
            conexion.connectSchema();
            conexion.useSchema();
        } catch (SQLException e) {
            System.out.println("El error es: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            conexion.closeConnection();
        } catch (SQLException e) {
            System.out.println("El error es: " + e.getMessage());
        }
    }

    /**
     * Creates new form CRUD_view
     */
    public CRUD_view() {
        initComponents();

        inicializarConexion();
        // Inicializa la instancia de MySQLConnection
    }

    private void insertarPersonal(String nombre, String apePat, String apeMat, String curp, String adscripcion, String tipoContrato, String puesto, String fechaNac, String sexo, String estado) {
        String sql = "INSERT INTO personal (nombre, apePat, apeMat, curp, adscripcion, tipoContrato, puesto, fechaNac, sexo, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apePat);
            statement.setString(3, apeMat);
            statement.setString(4, curp);
            statement.setString(5, adscripcion);
            statement.setString(6, tipoContrato);
            statement.setString(7, puesto);
            statement.setString(8, fechaNac);
            statement.setString(9, sexo);
            statement.setString(10, estado);
            //statement.setBytes(11, fotoPersonal);

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el registro: " + e.getMessage());
        }
    }

    private void eliminarPersonal(int idPersonal) {
        String sql = "DELETE FROM personal WHERE idPersonal = ?";
        try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql)) {
            statement.setInt(1, idPersonal);

            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro a eliminar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage());
        }
    }

    private void modificarPersonal(int idPersonal, String nombre, String apePat, String apeMat, String curp, String adscripcion, String tipoContrato, String puesto, String fechaNac, String sexo, String estado) {
        String sql = "UPDATE personal SET nombre=?, apePat=?, apeMat=?, curp=?, adscripcion=?, tipoContrato=?, puesto=?, fechaNac=?, sexo=?, estado=? WHERE idPersonal=?";
        try (PreparedStatement statement = conexion.getConnection().prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apePat);
            statement.setString(3, apeMat);
            statement.setString(4, curp);
            statement.setString(5, adscripcion);
            statement.setString(6, tipoContrato);
            statement.setString(7, puesto);
            statement.setString(8, fechaNac);
            statement.setString(9, sexo);
            statement.setString(10, estado);
            //statement.setBytes(11, fotoPersonal);
            statement.setInt(11, idPersonal);

            int filasModificadas = statement.executeUpdate();
            if (filasModificadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro a modificar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el registro: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastNameLabel2 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        lastNameTextField2 = new javax.swing.JTextField();
        curpLabel = new javax.swing.JLabel();
        adscripcionLabel = new javax.swing.JLabel();
        contratoLabel = new javax.swing.JLabel();
        puestoLabel = new javax.swing.JLabel();
        curpTextField = new javax.swing.JTextField();
        adscripcionTextField = new javax.swing.JTextField();
        contratoTextField = new javax.swing.JTextField();
        puestoTextField = new javax.swing.JTextField();
        birthLabel = new javax.swing.JLabel();
        sexLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        birthTextField = new javax.swing.JTextField();
        sexTextField = new javax.swing.JTextField();
        stateComboBox = new javax.swing.JComboBox<>();
        photoChooser = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        guardarButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        guardarFotoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idLabel.setText("ID");

        nameLabel.setText("Nombre(s)");

        lastNameLabel.setText("ApePat");

        lastNameLabel2.setText("ApeMat");

        curpLabel.setText("CURP");

        adscripcionLabel.setText("Adscripcion");

        contratoLabel.setText("Contrato");

        puestoLabel.setText("Puesto");

        birthLabel.setText("FecNac");

        sexLabel.setText("Sexo");

        stateLabel.setText("Estado");

        photoLabel.setText("Foto");

        photoChooser.setText("Cargar");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APEPAT", "APEMAT", "CURP", "ADSCRIPCION", "CONTRATO", "PUESTO", "FECNAC", "SEXO", "ESTADO", "FOTO"
            }
        ));
        jScrollPane.setViewportView(jTable);

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        guardarFotoButton.setText("Guardar foto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(nameLabel)
                            .addComponent(lastNameLabel2)
                            .addComponent(lastNameLabel))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(nameTextField)
                            .addComponent(lastNameTextField)
                            .addComponent(lastNameTextField2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contratoLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(curpLabel)
                                    .addComponent(adscripcionLabel)
                                    .addComponent(puestoLabel))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(curpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(adscripcionTextField)
                                    .addComponent(contratoTextField)
                                    .addComponent(puestoTextField))))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthLabel)
                            .addComponent(sexLabel)
                            .addComponent(photoLabel)
                            .addComponent(stateLabel))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(birthTextField)
                            .addComponent(sexTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(photoChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stateComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eliminarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardarFotoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel2)
                            .addComponent(lastNameTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(curpLabel)
                            .addComponent(curpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adscripcionLabel)
                            .addComponent(adscripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contratoLabel)
                            .addComponent(contratoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(puestoLabel)
                            .addComponent(puestoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthLabel)
                            .addComponent(birthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardarButton))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexLabel)
                            .addComponent(sexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarButton))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stateLabel)
                            .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarButton))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(photoLabel)
                            .addComponent(photoChooser)
                            .addComponent(guardarFotoButton))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        String nombre = this.nameTextField.getText();
        String apePat = lastNameTextField.getText();
        String apeMat = lastNameTextField2.getText();
        String curp = curpTextField.getText();
        String adscripcion = adscripcionTextField.getText();
        String tipoContrato = contratoTextField.getText();
        String puesto = puestoTextField.getText();
        String fechaNac = birthTextField.getText();
        String sexo = sexTextField.getText();
        String estado = (String) stateComboBox.getSelectedItem();

        // Aquí deberías obtener la foto (LONGBLOB) y guardarla en una variable byte[]
        // Ahora puedes ejecutar la inserción en la base de datos
        insertarPersonal(nombre, apePat, apeMat, curp, adscripcion, tipoContrato, puesto, fechaNac, sexo, estado);
        }//GEN-LAST:event_guardarButtonActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        int idPersonal = Integer.parseInt(idTextField.getText());
        String nombre = nameTextField.getText();
        String apePat = lastNameTextField.getText();
        String apeMat = lastNameTextField2.getText();
        String curp = curpTextField.getText();
        String adscripcion = adscripcionTextField.getText();
        String tipoContrato = contratoTextField.getText();
        String puesto = puestoTextField.getText();
        String fechaNac = birthTextField.getText();
        String sexo = sexTextField.getText();
        String estado = (String) stateComboBox.getSelectedItem();

        // Aquí deberías obtener la foto (LONGBLOB) y guardarla en una variable byte[]
        // Ahora puedes ejecutar la modificación en la base de datos
        modificarPersonal(idPersonal, nombre, apePat, apeMat, curp, adscripcion, tipoContrato, puesto, fechaNac, sexo, estado);

    }//GEN-LAST:event_modificarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        int idPersonal = Integer.parseInt(idTextField.getText());
        eliminarPersonal(idPersonal);
    }//GEN-LAST:event_eliminarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUD_view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD_view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD_view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD_view.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_view().setVisible(true);
            }

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adscripcionLabel;
    private javax.swing.JTextField adscripcionTextField;
    private javax.swing.JLabel birthLabel;
    private javax.swing.JTextField birthTextField;
    private javax.swing.JLabel contratoLabel;
    private javax.swing.JTextField contratoTextField;
    private javax.swing.JLabel curpLabel;
    private javax.swing.JTextField curpTextField;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton guardarFotoButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel lastNameLabel2;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField lastNameTextField2;
    private javax.swing.JButton modificarButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton photoChooser;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel puestoLabel;
    private javax.swing.JTextField puestoTextField;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JTextField sexTextField;
    private javax.swing.JComboBox<String> stateComboBox;
    private javax.swing.JLabel stateLabel;
    // End of variables declaration//GEN-END:variables
}
