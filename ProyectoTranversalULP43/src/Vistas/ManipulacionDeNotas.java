package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.HashSet;
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
public class ManipulacionDeNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla;
    private DefaultComboBoxModel modeloBox;
    private Boolean condicion;  
    private Boolean teclaApretada;
    
    HashSet<Integer> filas = new HashSet();
    public ManipulacionDeNotas() {
        this.condicion = false;
        this.teclaApretada = false;
        this.modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int f, int c) {
                return c >= 2;}};
        this.modeloBox = new DefaultComboBoxModel();
        initComponents();
        armarBox();
        armarTabla();
        jButton1.setEnabled(false);
        ComboBox.setSelectedIndex(-1);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cargar Notas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxItemStateChanged(evt);
            }
        });
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxItemStateChanged
        // TODO add your handling code here:
        if (ComboBox.getSelectedIndex() != -1){
            modeloTabla.setRowCount(0);
            InscripcionData InsData = new InscripcionData();
            List<Inscripcion> inscripciones = new ArrayList();
            Alumno alu = new Alumno();
            alu = (Alumno) ComboBox.getSelectedItem();
            inscripciones = InsData.optenerInscripcionPorAlumno(alu.getIdAlumno());
            for (Inscripcion i : inscripciones){
                modeloTabla.addRow(new Object[]{i.getMateria().getIdMateria(),
                    i.getMateria().getNombre(),
                    i.getNota()+""});
            }
        }   
    }//GEN-LAST:event_ComboBoxItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (filas.isEmpty() && !condicion){
            JOptionPane.showMessageDialog(null, "Realize Cambios");
        } else {
            InscripcionData insData = new InscripcionData();
            Materia mate = new Materia();
            Alumno alu = new Alumno();
            alu = (Alumno) ComboBox.getSelectedItem();
            try {
                for (int f : filas){
                    mate.setIdMateria((int) modeloTabla.getValueAt(f, 0));
                    insData.actualizarNota(alu.getIdAlumno(), mate.getIdMateria(),
                            (Double) parseDouble((String) modeloTabla.getValueAt(f, 2)));
                }
                
                JOptionPane.showMessageDialog(null, "Nota/s Actualizada Correctamente");
                
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Hubo Un Error");
                insData.actualizarNota(alu.getIdAlumno(), mate.getIdMateria(), 0.0);
                modeloTabla.setRowCount(0);
                List<Inscripcion> inscripciones = new ArrayList();
                inscripciones = insData.optenerInscripcionPorAlumno(alu.getIdAlumno());
                for (Inscripcion i : inscripciones){
                modeloTabla.addRow(new Object[]{i.getMateria().getIdMateria(),
                i.getMateria().getNombre(),
                i.getNota()+""});
                }
            }   
            filas.clear();
            jButton1.setEnabled(false);
            ComboBox.setEnabled(true);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        int f = tabla.getSelectedRow();
        ComboBox.setEnabled(false);
        filas.add(f);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_tablaMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void armarBox() {
        List<Alumno> alumnos = new ArrayList();
        AlumnoData aluData = new AlumnoData();
        alumnos = aluData.listarAlumnosActivos();
        for (Alumno i : alumnos) {
            modeloBox.addElement(i);
        }
        ComboBox.setModel(modeloBox);
    }
    
    
    private void armarTabla() {
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Nota");
        tabla.setModel(modeloTabla);
    }
    
}
