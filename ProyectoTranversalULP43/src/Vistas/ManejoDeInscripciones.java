package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectotranversalulp.Entidades.Alumno;
import proyectotranversalulp.Entidades.Inscripcion;
import proyectotranversalulp.Entidades.Materia;

/**
 *
 * @author manuv
 */
public class ManejoDeInscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla = null;
    private DefaultComboBoxModel modeloBox = null;
    private AlumnoData aluData = new AlumnoData();
    
    public ManejoDeInscripciones() {
        this.modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int f, int c) {
                return false; }};
        this.modeloBox = new DefaultComboBoxModel();
        initComponents();
        armarTabla();
        armarBox();
        deshabilitoBotones();
        comboBox.setSelectedIndex(-1);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        materiasCursadas = new javax.swing.JRadioButton();
        materiasNoCursadas = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Inscribir = new javax.swing.JButton();
        anularInscripcion = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripciones");

        jLabel2.setText("seleccione un alumno:");

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        materiasCursadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiasCursadasActionPerformed(evt);
            }
        });

        materiasNoCursadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiasNoCursadasActionPerformed(evt);
            }
        });

        jLabel3.setText("materias cursadas");

        jLabel4.setText("materias NO cursadas");

        Inscribir.setText("Inscribir");
        Inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscribirActionPerformed(evt);
            }
        });

        anularInscripcion.setText("Anular Inscripcion");
        anularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anularInscripcionActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(materiasCursadas)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(materiasNoCursadas))
                            .addComponent(jLabel2)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Inscribir)
                        .addGap(42, 42, 42)
                        .addComponent(anularInscripcion)
                        .addGap(47, 47, 47)
                        .addComponent(Salir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(materiasCursadas)
                    .addComponent(materiasNoCursadas)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inscribir)
                    .addComponent(anularInscripcion)
                    .addComponent(Salir))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void materiasCursadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiasCursadasActionPerformed
        if (comboBox.getSelectedIndex() != -1){
            modeloTabla.setRowCount(0);
            Inscribir.setEnabled(false);
            materiasNoCursadas.setSelected(false);
            List<Materia> materias = new ArrayList();
            InscripcionData InsData = new InscripcionData();
            Alumno alu = new Alumno();
            alu = (Alumno) comboBox.getSelectedItem();
            materias = InsData.OptenerMateriasCursadas(alu.getIdAlumno());
            for (Materia m : materias){
                modeloTabla.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
            }
            anularInscripcion.setEnabled(true);
        } else {
            deshabilitoBotones();
        }
    }//GEN-LAST:event_materiasCursadasActionPerformed

    private void materiasNoCursadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiasNoCursadasActionPerformed
        if (comboBox.getSelectedIndex() != -1){
            modeloTabla.setRowCount(0);
            anularInscripcion.setEnabled(false);
            materiasCursadas.setSelected(false);
            List<Materia> materias = new ArrayList();
            InscripcionData InsData = new InscripcionData();
            Alumno alu = new Alumno();
            alu = (Alumno) comboBox.getSelectedItem();
            materias = InsData.OptenerMateriasNoCursadas(alu.getIdAlumno());
            for (Materia m : materias){
                modeloTabla.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
            }
            Inscribir.setEnabled(true);
        } else {
            deshabilitoBotones();
        }
    }//GEN-LAST:event_materiasNoCursadasActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
        deshabilitoBotones();
        modeloTabla.setRowCount(0);
        anularInscripcion.setSelected(false);
        Inscribir.setSelected(false);
    }//GEN-LAST:event_comboBoxActionPerformed

    private void anularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anularInscripcionActionPerformed
        // TODO add your handling code here:
        int i = tabla.getSelectedRow();
        if (i != -1){
            InscripcionData id = new InscripcionData();
            Alumno alu = new Alumno();
            alu = (Alumno) comboBox.getSelectedItem();
            Materia mat = new Materia();
            id.borrarInscripcionMateriaAlumno(alu.getIdAlumno(), (int) modeloTabla.getValueAt(i, 0));
            materiasCursadasActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null,"Seleccione una materia antes de utilizar el boton");
        }
    }//GEN-LAST:event_anularInscripcionActionPerformed

    private void InscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscribirActionPerformed
        // TODO add your handling code here:
        int i = tabla.getSelectedRow();
        if (i != -1){
            Inscripcion insc = new Inscripcion();
            insc.setAlumno((Alumno) comboBox.getSelectedItem());
            Materia mat = new Materia();
            mat.setIdMateria((int) modeloTabla.getValueAt(i, 0));
            mat.setNombre((String) modeloTabla.getValueAt(i, 1));
            mat.setAnio((int) modeloTabla.getValueAt(i, 2));
            insc.setMateria(mat);
            insc.setNota(0.0);
            InscripcionData id = new InscripcionData();
            id.guardarInscripcion(insc);
            materiasNoCursadasActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null,"Seleccione una materia antes de utilizar el boton");
        }
        
    }//GEN-LAST:event_InscribirActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inscribir;
    private javax.swing.JButton Salir;
    private javax.swing.JButton anularInscripcion;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton materiasCursadas;
    private javax.swing.JRadioButton materiasNoCursadas;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void armarTabla() {
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("año");
        tabla.setModel(modeloTabla);
    }

    private void armarBox() {
        List<Alumno> alumnos = new ArrayList();
        alumnos = aluData.listarAlumnosActivos();
        for (Alumno i : alumnos) {
            modeloBox.addElement(i);
        }
        comboBox.setModel(modeloBox);
    }
    
    
    public void deshabilitoBotones(){
        materiasCursadas.setSelected(false);
        materiasNoCursadas.setSelected(false);
        Inscribir.setEnabled(false);
        anularInscripcion.setEnabled(false);
    }
    
}
