/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projeto2so2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafik
 */
public class TipoFrame extends javax.swing.JFrame {

    /**
     * Creates new form TipoFrame
     */
    
    private float quantum = 0;
    private String tipoAlgoritmo = "";
    int[][] matrix;
    public TipoFrame(int[][] matrix) {
        this.matrix = matrix;
        initComponents();
    }
    public TipoFrame() {
        initComponents();
    }
    
    public void setQuantum(float valor){
        this.quantum = valor;
            }
    public void setTipoAlgo(String algo){
        this.tipoAlgoritmo = algo;
    }
    public float getQuantum(){
        return this.quantum;
    }
    public String getAlgo(){
        return this.tipoAlgoritmo;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "Job mais Curto", "Menor tempo", "Round Robin", "Prioridades", "Loteria" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Quantum");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Algoritmo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Execução");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Pronto");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Executando");

        jLabel8.setText("jLabel7");

        jLabel9.setText("jLabel7");

        jLabel10.setText("jLabel7");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Métricas");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Tudo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Passo a Passo");

        jButton3.setText("Real Time");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(46, 46, 46)
                .addComponent(jButton3)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(67, 67, 67)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        setTipoAlgo((String) jComboBox1.getSelectedItem());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
     float value = Float.parseFloat(jTextField2.getText());
        setQuantum( value);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String cmp = getAlgo();
       
        switch (cmp) {
            case "FCFS":
                Fcfs fc = new Fcfs();
           {
               try {
                   fc.fcfs(this.matrix);
                   String resultados = "FCFS\n\n"+"Tempo Máximo Espera -> "+fc.MaxTempoEspera + "\n" +
                           "Tempo Médio Espera -> "+fc.mediaTempoEspera + "\n" +
                           "Tempo Médio Oscioso -> "+fc.mediaTempoOscioso + "\n"
                           +"Tempo Máximo -> "+ fc.tempoMax + "\n"
                           +"Tempo de Espera -> "+ fc.tempoEspera + "\n" 
                           +"Tempo Total Oscioso -> "+ fc.tempoTotalOscioso + "\n" 
                           +"Total de Processos ->"+ fc.totalProcessos;
                  jTextArea1.append(resultados);


               } catch (InterruptedException ex) {
                   Logger.getLogger(TipoFrame.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
                break;

            case "Job mais Curto":
                JobMaisCurto jmc = new JobMaisCurto();
                jmc.getOptimalExecutionOrder(this.matrix);
                String resultado1 = "Job Mais Curto\n\n"+"Tempo Máximo Espera -> "+jmc.maximoTempoEsperado + "\n" +
                           "Tempo Médio Espera -> "+ jmc.tempoMedioEspera +  "\n" +
                           "Tempo Médio Oscioso -> "+ jmc.tempoMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ jmc.tempoMaximo + "\n"
                           +"Tempo de Espera -> "+ jmc.tempo + "\n" 
                           +"Tempo Total Oscioso -> "+ jmc.tempoTotalOscioso + "\n" ;
                 jTextArea1.append(resultado1);
                    break;
            case "Menor tempo":
                MenorTempoRestante mtr = new MenorTempoRestante();
                mtr.getOptimalExecutionOrder(this.matrix);
                
                String resultado = "Menor Tempo \n\n"+"Tempo Máximo Espera -> " + mtr.tempoMaximoEsperado + "\n" +
                           "Tempo Médio Espera -> "+ mtr.tempoMedioEsperado +  "\n" +
                           "Tempo Médio Oscioso -> "+ mtr.tempoMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ mtr.tempoMaximo + "\n"
                           +"Tempo de Espera -> "+ mtr.tempo + "\n" 
                           +"Tempo Total Oscioso -> "+ mtr.tempoTotalOscioso + "\n";
                 jTextArea1.append(resultado);
                break;
            case "Round Robin":
                RoundRobin rr = new RoundRobin();
                    rr.getOptimalExecutionOrder(this.matrix,this.quantum);
                    String resultado2 = "Round Robin\n\n"+"Tempo Máximo Espera -> " + rr.tempoMaximoEsperando + "\n" +
                           "Tempo Médio Espera -> "+ rr.tempoMedioEsperado +  "\n" +
                           "Tempo Médio Oscioso -> "+ rr.tempMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ rr.tempoMaximoEsperando + "\n"
                           +"Troca de Context-> "+ rr.trocaDeContexto + "\n" 
                           +"Tempo Total Oscioso -> "+ rr.tempoTotalOscioso + "\n";
                     jTextArea1.append(resultado2);
                break;
            case "Prioridades":
                PorPrioridades pp = new PorPrioridades();
                if(this.quantum != 0)
                {                
                    pp.getOptimalExecutionOrder(this.matrix, this.quantum);
                    String resultado3 = "Prioridaes \n\n"+"Tempo Máximo Espera -> " + pp.tempoMaximoEsperado + "\n" +
                           "Tempo Médio Espera -> "+ pp.TempoMedioEsperando +  "\n" +
                           "Tempo Médio Oscioso -> "+ pp.tempoMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ pp.tempoTotalEsperado + "\n"
                           +"Troca de Contexto -> "+ pp.trocaDeContexto + "\n" 
                           +"Tempo Total Oscioso -> "+ pp.tempoOscioso + "\n";
                     jTextArea1.append(resultado3);
                }
                break;
            case "Loteria":
                Loteria lot = new Loteria();
                lot.getOptimalExecutionOrder(this.matrix);
                String resultado4 = "Loteria \n\n"+"Tempo Máximo Espera -> " + lot.tempoMaximoEspera + "\n" +
                           "Tempo Médio Espera -> "+ lot.tempoMedioEsperando +  "\n" +
                           "Tempo Médio Oscioso -> "+ lot.tempoMedioOscioco+ "\n"
                           +"Tempo Máximo -> "+ lot.tempoMaximo + "\n"
                           +"Troca de contexto -> "+ lot.trocaDeContexto + "\n" 
                           +"Tempo Total Oscioso -> "+ lot.tempoTotalOscioso + "\n";
                 jTextArea1.append(resultado4);
                break;
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String cmp = getAlgo();
       
        switch (cmp) {
            case "FCFS":
                Fcfs fc = new Fcfs();
           {
               try {
                   fc.fcfs(this.matrix);
                   String resultados = "FCFS\n\n"+"Tempo Máximo Espera -> "+fc.MaxTempoEspera + "\n" +
                           "Tempo Médio Espera -> "+fc.mediaTempoEspera + "\n" +
                           "Tempo Médio Oscioso -> "+fc.mediaTempoOscioso + "\n"
                           +"Tempo Máximo -> "+ fc.tempoMax + "\n"
                           +"Tempo de Espera -> "+ fc.tempoEspera + "\n" 
                           +"Tempo Total Oscioso -> "+ fc.tempoTotalOscioso + "\n" 
                           +"Total de Processos ->"+ fc.totalProcessos;
                  jTextArea1.append(resultados);


               } catch (InterruptedException ex) {
                   Logger.getLogger(TipoFrame.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
                break;

            case "Job mais Curto":
                JobMaisCurto jmc = new JobMaisCurto();
                jmc.getOptimalExecutionOrder(this.matrix);
                String resultado1 = "Job Mais Curto\n\n"+"Tempo Máximo Espera -> "+jmc.maximoTempoEsperado + "\n" +
                           "Tempo Médio Espera -> "+ jmc.tempoMedioEspera +  "\n" +
                           "Tempo Médio Oscioso -> "+ jmc.tempoMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ jmc.tempoMaximo + "\n"
                           +"Tempo de Espera -> "+ jmc.tempo + "\n" 
                           +"Tempo Total Oscioso -> "+ jmc.tempoTotalOscioso + "\n" ;
                jTextArea1.append(resultado1);
                    break;
            case "Menor tempo":
                MenorTempoRestante mtr = new MenorTempoRestante();
                mtr.getOptimalExecutionOrder(this.matrix);
                
                String resultado = "Menor Tempo \n\n"+"Tempo Máximo Espera -> " + mtr.tempoMaximoEsperado + "\n" +
                           "Tempo Médio Espera -> "+ mtr.tempoMedioEsperado +  "\n" +
                           "Tempo Médio Oscioso -> "+ mtr.tempoMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ mtr.tempoMaximo + "\n"
                           +"Tempo de Espera -> "+ mtr.tempo + "\n" 
                           +"Tempo Total Oscioso -> "+ mtr.tempoTotalOscioso + "\n";
                jTextArea1.append(resultado);
                break;
            case "Round Robin":
                RoundRobin rr = new RoundRobin();
                if(this.quantum != 0){
                    rr.getOptimalExecutionOrder(this.matrix,1);
                    String resultado2 ="Round Robin \n\n"+ "Tempo Máximo Espera -> " + rr.tempoMaximoEsperando + "\n" +
                           "Tempo Médio Espera -> "+ rr.tempoMedioEsperado +  "\n" +
                           "Tempo Médio Oscioso -> "+ rr.tempMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ rr.tempoMaximoEsperando + "\n"
                           +"Troca de Context-> "+ rr.trocaDeContexto + "\n" 
                           +"Tempo Total Oscioso -> "+ rr.tempoTotalOscioso + "\n";
                    jTextArea1.append(resultado2);
                }
                break;
            case "Prioridades":
                PorPrioridades pp = new PorPrioridades();
                if(this.quantum != 0)
                {                
                    pp.getOptimalExecutionOrder(this.matrix, 1);
                    String resultado3 = "Prioridades \n\n"+"Tempo Máximo Espera -> " + pp.tempoMaximoEsperado + "\n" +
                           "Tempo Médio Espera -> "+ pp.TempoMedioEsperando +  "\n" +
                           "Tempo Médio Oscioso -> "+ pp.tempoMedioOscioso + "\n"
                           +"Tempo Máximo -> "+ pp.tempoTotalEsperado + "\n"
                           +"Troca de Contexto -> "+ pp.trocaDeContexto + "\n" 
                           +"Tempo Total Oscioso -> "+ pp.tempoOscioso + "\n";
                    jTextArea1.append(resultado3);
                }
                break;
            case "Loteria":
                Loteria lot = new Loteria();
                lot.getOptimalExecutionOrder(this.matrix);
                String resultado4 = "Loteria\n\n"+"Tempo Máximo Espera -> " + lot.tempoMaximoEspera + "\n" +
                           "Tempo Médio Espera -> "+ lot.tempoMedioEsperando +  "\n" +
                           "Tempo Médio Oscioso -> "+ lot.tempoMedioOscioco+ "\n"
                           +"Tempo Máximo -> "+ lot.tempoMaximo + "\n"
                           +"Troca de contexto -> "+ lot.trocaDeContexto + "\n" 
                           +"Tempo Total Oscioso -> "+ lot.tempoTotalOscioso + "\n";
                jTextArea1.append(resultado4);
                break;
           
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TipoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
