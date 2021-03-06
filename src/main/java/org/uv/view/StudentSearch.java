/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.view;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uv.model.FactoryDao;
import org.uv.model.IDaoGeneral;
import org.uv.model.Student;

/**
 *
 * @author asunawesker
 */
public class StudentSearch extends javax.swing.JInternalFrame {

    /**
     * Creates new form StudentSearch
     */
    
    Student student;
    IDaoGeneral<Student> dao;
    List<Student> ls;
    
    public StudentSearch() throws SQLException {
        this.student = new Student();
        this.dao = FactoryDao.create(FactoryDao.TypeDAO.STUDENT);
        this.ls = dao.readAll();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnVerUno = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar estudiante");
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Matricula");

        btnVerUno.setText("Ver uno");
        btnVerUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerUnoActionPerformed(evt);
            }
        });

        btnVerTodos.setText("Ver todos");
        btnVerTodos.setDefaultCapable(false);
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(700, 500));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matr??cula", "Nombre", "Apellido", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFillsViewportHeight(true);
        table.setPreferredSize(new java.awt.Dimension(700, 500));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnVerUno, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerTodos)
                    .addComponent(btnVerUno))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerUnoActionPerformed
        ls.clear();
        String id = txtId.getText();  
        
        Student student = new Student();
        
        student.setIdcard(id);
        ls.add(dao.readOne(student));
//            System.out.println(
//                    "\nMatr??cula: " + e.getEnrollment()+
//                            "\nNombre: "  + e.getName()+
//                            "\nApellido: "  + e.getLastName()+
//                            "\nCarrera: "   + e.getCareer()+
//                            "\n"
//            );
        showTable(ls);
    }//GEN-LAST:event_btnVerUnoActionPerformed

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        // TODO add your handling code here:
        ls.clear();
        
        ls = dao.readAll();            
//            ls.forEach((student) -> {
//                System.out.println(
//                    "\nMatr??cula: " + student.getEnrollment()+
//                    "\nNombre: "  + student.getName()+
//                    "\nApellido: "  + student.getLastName()+
//                    "\nCarrera: "   + student.getCareer()+
//                    "\n"
//                );
//                
//            }); 
        showTable(ls);       
    }//GEN-LAST:event_btnVerTodosActionPerformed

    private void showTable(List<Student> ls){
        Object matrix [][] = new Object[ls.size()][4];
        
        for (int i = 0; i < ls.size(); i++) {
            matrix [i][0] = ls.get(i).getIdcard();
            matrix [i][1] = ls.get(i).getName();
            matrix [i][2] = ls.get(i).getLastname();
            matrix [i][3] = ls.get(i).getCareer();
        }
        
         table.setModel(new javax.swing.table.DefaultTableModel(
            matrix,
            new String [] {
                "ID", "Nombre", "Apellido", "Carrera"
            }
        ));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JButton btnVerUno;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
