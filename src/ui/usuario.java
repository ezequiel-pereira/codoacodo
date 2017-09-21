/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.ProvinciaDao;
import dao.UsuarioDao;
import entities.Provincia;
import entities.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import utils.SQLError;

/**
 *
 * @author alumno
 */
public class usuario extends javax.swing.JFrame {

    /**
     * Creates new form usuario
     */
    public usuario() {
        initComponents();       
        mostrarUsuarios(null);
        initProvinciaCombo();
    }
    
    public void initProvinciaCombo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ProvinciaDao provDao = new ProvinciaDao();        
        LinkedList<Provincia> lista = provDao.getAll();
        
        for (Provincia provincia : lista) {
            modelo.addElement(provincia);    
        }
       
        provinciaCombo.setModel(modelo);
    }
    
    public void mostrarUsuarios(String busqueda){
        DefaultTableModel modelo = new DefaultTableModel();        
        modelo.addColumn("id");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        
        UsuarioDao udao = new UsuarioDao();
        LinkedList<Usuario> lista;
                    
        if(busqueda != null){            
            lista = udao.getByAllFields(busqueda);
        }else{            
            lista = udao.getAll();
        }           
        
        Object[] data = new Object[4];
        for (Usuario usuario : lista) {
            data[0] = usuario.getId();
            data[1] = usuario.getDni();
            data[2] = usuario.getNombre();
            data[3] = usuario.getApellido();
            modelo.addRow(data);
        }        
        
        usuarioTbl.setModel(modelo);                
        TableColumn col = usuarioTbl.getColumnModel().getColumn(0);        
        col.setResizable(false);
        col.setMinWidth(0);
        col.setMaxWidth(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dniTxt = new javax.swing.JTextField();
        nombreTxt = new javax.swing.JTextField();
        apellidoTxt = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();
        dniErrorLbl = new javax.swing.JLabel();
        errorLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuarioTbl = new javax.swing.JTable();
        buscarTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        nuevoBtn = new javax.swing.JButton();
        provinciaCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        dniTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dniTxtFocusGained(evt);
            }
        });

        apellidoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoTxtActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        dniErrorLbl.setForeground(new java.awt.Color(255, 0, 0));
        dniErrorLbl.setText(" ");

        errorLbl.setForeground(new java.awt.Color(255, 0, 0));
        errorLbl.setText(" ");

        usuarioTbl.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(usuarioTbl);

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        provinciaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        provinciaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinciaComboActionPerformed(evt);
            }
        });

        jLabel4.setText("Provincia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(errorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dniTxt)
                            .addComponent(nombreTxt)
                            .addComponent(apellidoTxt)
                            .addComponent(dniErrorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(provinciaCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nuevoBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardarBtn)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(dniErrorLbl)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provinciaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17)
                .addComponent(errorLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(nuevoBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apellidoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoTxtActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        if(id_modificar == -1){
            this.guardarUsuario();
        } else {
            this.modificarUsuario();
        }
        
        dniTxt.setText("");
        nombreTxt.setText("");
        apellidoTxt.setText("");
        mostrarUsuarios(null);        
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void modificarUsuario(){
        int dni = 0;
        errorLbl.setText(" ");
        
        try {
            dni = Integer.parseInt(dniTxt.getText());
        } catch (Exception e) {
            dniErrorLbl.setText("El DNI debe ser un numero.");
            return;
        }
        
        Usuario usuario = new Usuario();
        usuario.setId(this.id_modificar);
        usuario.setDni(dni);
        usuario.setNombre(nombreTxt.getText());
        usuario.setApellido(apellidoTxt.getText());
        
        UsuarioDao udao = new UsuarioDao();
        udao.update(usuario);
        this.id_modificar = -1;
        
        this.guardarBtn.setText("Guardar");
    }
    
    private void guardarUsuario(){
        int dni = 0;
        
        errorLbl.setText(" ");
        
        try {
            dni = Integer.parseInt(dniTxt.getText());
        } catch (Exception e) {
            dniErrorLbl.setText("El DNI debe ser un numero.");
            return;
        }
        
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setNombre(nombreTxt.getText());
        usuario.setApellido(apellidoTxt.getText());
        
        UsuarioDao udao = new UsuarioDao();
        udao.insert(usuario);
    }
    
    private void dniTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dniTxtFocusGained
        dniErrorLbl.setText(" ");
    }//GEN-LAST:event_dniTxtFocusGained

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        mostrarUsuarios(buscarTxt.getText());
    }//GEN-LAST:event_buscarBtnActionPerformed

    
    private int id_modificar = -1;
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int fila    = usuarioTbl.getSelectedRow();        
        if(fila < 0 ){
            return;
        }
        
        int id     = Integer.parseInt(usuarioTbl.getValueAt(fila, 0).toString());
        
        UsuarioDao udao = new UsuarioDao();
        Usuario usuario = udao.getById(id);
        
        this.id_modificar = usuario.getId();
        dniTxt.setText(String.valueOf(usuario.getDni()));
        nombreTxt.setText(usuario.getNombre());
        apellidoTxt.setText(usuario.getApellido());
        
        guardarBtn.setText("Actualizar");
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(JOptionPane.showConfirmDialog(this, "¿Desea Eliminar?") != 0){
            return;
        }        
                
        int fila    = usuarioTbl.getSelectedRow();
        
        int id     = Integer.parseInt(usuarioTbl.getValueAt(fila, 0).toString());
        
        Usuario usuario = new Usuario();
        usuario.setId(id);
        
        UsuarioDao udao = new UsuarioDao();
        udao.delete(usuario);
        
        mostrarUsuarios(null);
        
        /*try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/clase30", "root", "");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM usuario WHERE dni = ?");
            ps.setInt(1, dni);
            ps.executeUpdate();
            mostrarUsuarios(null);
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_eliminarActionPerformed

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        guardarBtn.setText("Guardar");
        this.id_modificar = -1;
        dniTxt.setText("");
        nombreTxt.setText("");
        apellidoTxt.setText("");
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void provinciaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinciaComboActionPerformed
        Provincia prov = (Provincia)provinciaCombo.getSelectedItem();        
        System.out.println(prov.getId());
    }//GEN-LAST:event_provinciaComboActionPerformed
    
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
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel dniErrorLbl;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JComboBox<String> provinciaCombo;
    private javax.swing.JTable usuarioTbl;
    // End of variables declaration//GEN-END:variables
}
