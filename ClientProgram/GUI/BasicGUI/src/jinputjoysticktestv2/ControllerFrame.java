package jinputjoysticktestv2;

import javax.swing.SwingConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PLC
 */
public class ControllerFrame extends javax.swing.JFrame {

    /**
     * Creates new form ControllerFrame
     */
    public ControllerFrame() {
        initComponents();
        sendCommand.hide();
        //zAxisProgress.setOrientation(SwingConstants.VERTICAL);
        //stopMotor.hide();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        velocitySlider = new javax.swing.JSlider();
        velLable = new javax.swing.JLabel();
        velValue = new javax.swing.JTextField();
        angleSlider = new javax.swing.JSlider();
        angLable = new javax.swing.JLabel();
        angleValue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        zAxisSlider = new javax.swing.JSlider();
        zAxisLable = new javax.swing.JLabel();
        zAxisValue = new javax.swing.JTextField();
        enableButton = new javax.swing.JRadioButton();
        sendCommand = new javax.swing.JButton();
        actualZaxisValue = new javax.swing.JTextField();
        actualValueLable = new javax.swing.JLabel();
        rightLamp = new javax.swing.JRadioButton();
        leftLamp = new javax.swing.JRadioButton();
        stopMotor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        forwardButton = new javax.swing.JButton();
        reverseButton = new javax.swing.JButton();
        turnRightButton = new javax.swing.JButton();
        turnLeftButton = new javax.swing.JButton();
        reverse = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        velocitySlider.setMaximum(500);
        velocitySlider.setValue(0);
        velocitySlider.setEnabled(false);
        velocitySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                velocitySliderStateChanged(evt);
            }
        });

        velLable.setText("Velocity");

        velValue.setText("0");
        velValue.setEnabled(false);
        velValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velValueActionPerformed(evt);
            }
        });

        angleSlider.setMaximum(90);
        angleSlider.setMinimum(-90);
        angleSlider.setValue(0);
        angleSlider.setEnabled(false);
        angleSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                angleSliderStateChanged(evt);
            }
        });

        angLable.setText("Angle");

        angleValue.setText("0");
        angleValue.setEnabled(false);
        angleValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angleValueActionPerformed(evt);
            }
        });

        jLabel3.setText("0");

        jLabel4.setText("500");

        jLabel5.setText("-90");

        jLabel6.setText("0");

        jLabel7.setText("90");

        zAxisSlider.setMaximum(1500);
        zAxisSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        zAxisSlider.setValue(352);
        zAxisSlider.setEnabled(false);
        zAxisSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zAxisSliderStateChanged(evt);
            }
        });

        zAxisLable.setText("Z-Axis");

        zAxisValue.setText("352");
        zAxisValue.setEnabled(false);
        zAxisValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zAxisValueActionPerformed(evt);
            }
        });

        enableButton.setText("Enable GUI Controller");
        enableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableButtonActionPerformed(evt);
            }
        });

        sendCommand.setEnabled(false);
        sendCommand.setLabel("Send Command");

        actualZaxisValue.setEditable(false);
        actualZaxisValue.setText("0");

        actualValueLable.setText("Actual Value");

        rightLamp.setText("Right Lamp");
        rightLamp.setEnabled(false);

        leftLamp.setText("Left Lamp");
        leftLamp.setEnabled(false);

        stopMotor.setText("Stop");
        stopMotor.setEnabled(false);
        stopMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopMotorActionPerformed(evt);
            }
        });

        forwardButton.setText("Forward");
        forwardButton.setEnabled(false);
        forwardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forwardButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                forwardButtonMouseReleased(evt);
            }
        });

        reverseButton.setText("Reverse");
        reverseButton.setEnabled(false);
        reverseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reverseButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                reverseButtonMouseReleased(evt);
            }
        });

        turnRightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jinputjoysticktestv2/RightTurn.png"))); // NOI18N
        turnRightButton.setEnabled(false);
        turnRightButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                turnRightButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                turnRightButtonMouseReleased(evt);
            }
        });

        turnLeftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jinputjoysticktestv2/LeftTurn.png"))); // NOI18N
        turnLeftButton.setEnabled(false);
        turnLeftButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                turnLeftButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                turnLeftButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(turnLeftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reverseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(forwardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnRightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(forwardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reverseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(turnRightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(turnLeftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        reverse.setText("Reverse");
        reverse.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enableButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(leftLamp)
                                .addGap(18, 18, 18)
                                .addComponent(rightLamp)))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sendCommand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stopMotor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(velLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(angLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addComponent(angleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(angleValue))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addComponent(velocitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(velValue, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reverse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zAxisSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(zAxisLable)
                        .addComponent(zAxisValue, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addComponent(actualZaxisValue))
                    .addComponent(actualValueLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(zAxisSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addComponent(zAxisLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(velocitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(velLable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(velValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(angleValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(angleSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(angLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sendCommand)
                                            .addComponent(leftLamp)
                                            .addComponent(rightLamp)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(zAxisValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(reverse))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(actualValueLable)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(actualZaxisValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stopMotor)
                                    .addComponent(enableButton))))))
                .addGap(0, 71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void velValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velValueActionPerformed
        // TODO add your handling code here:
        this.velocitySlider.setValue(Integer.parseInt(this.velValue.getText()));
    }//GEN-LAST:event_velValueActionPerformed

    private void enableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableButtonActionPerformed
        // TODO add your handling code here:
        if(this.enableButton.isSelected())
        {
            this.angleSlider.setEnabled(true);
            this.velocitySlider.setEnabled(true);
            this.angleValue.setEnabled(true);
            this.zAxisSlider.setEnabled(true);
            this.zAxisValue.setEnabled(true);
            this.zAxisSlider.setValue(Integer.parseInt(JoystickTest.window.zAxisDpl.getText()));
            this.velValue.setEnabled(true);
            this.sendCommand.setEnabled(true);
            this.stopMotor.setEnabled(true);
            this.leftLamp.setEnabled(true);
            this.rightLamp.setEnabled(true);
            this.forwardButton.setEnabled(true);
            this.reverseButton.setEnabled(true);
            this.turnLeftButton.setEnabled(true);
            this.turnRightButton.setEnabled(true);
            this.reverse.setEnabled(true);
        
        }
        else
        {
            this.angleSlider.setEnabled(false);
            this.velocitySlider.setEnabled(false);
            this.angleValue.setEnabled(false);
            this.zAxisSlider.setEnabled(false);
            this.zAxisValue.setEnabled(false);
            this.velValue.setEnabled(false);
            this.sendCommand.setEnabled(false);
            this.stopMotor.setEnabled(false);
            this.leftLamp.setEnabled(false);
            this.rightLamp.setEnabled(false);
            this.forwardButton.setEnabled(false);
            this.reverseButton.setEnabled(false);
            this.turnLeftButton.setEnabled(false);
            this.turnRightButton.setEnabled(false);
            this.reverse.setEnabled(false);
        }
    }//GEN-LAST:event_enableButtonActionPerformed
    
    private void angleValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angleValueActionPerformed
        // TODO add your handling code here:
        this.angleSlider.setValue(Integer.parseInt(this.angleValue.getText()));
    }//GEN-LAST:event_angleValueActionPerformed

    private void zAxisValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zAxisValueActionPerformed
        // TODO add your handling code here:
        this.zAxisSlider.setValue(Integer.parseInt(this.zAxisValue.getText()));
        
    }//GEN-LAST:event_zAxisValueActionPerformed

    private void velocitySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_velocitySliderStateChanged
        // TODO add your handling code here:
        //if(!this.velocitySlider.getValueIsAdjusting())
        //{
            
            if(this.zAxisSlider.getValue()>352)
                this.velocitySlider.setValue((int)0);
            this.velValue.setText(""+this.velocitySlider.getValue());
        //}
    }//GEN-LAST:event_velocitySliderStateChanged

    private void angleSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_angleSliderStateChanged
        // TODO add your handling code here:
        this.angleValue.setText(""+this.angleSlider.getValue());
    }//GEN-LAST:event_angleSliderStateChanged

    private void zAxisSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zAxisSliderStateChanged
        // TODO add your handling code here:
        this.zAxisValue.setText(""+this.zAxisSlider.getValue());
        //this.velocitySlider.setValue((int)0);
    }//GEN-LAST:event_zAxisSliderStateChanged

    private void stopMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopMotorActionPerformed
        // TODO add your handling code here:
        this.velocitySlider.setValue((int)0);
        this.angleSlider.setValue((int)0);
    }//GEN-LAST:event_stopMotorActionPerformed

    private void turnRightButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnRightButtonMousePressed
        // TODO add your handling code here:
        
         this.velocitySlider.setValue(150);
         this.angleSlider.setValue(-35);
         if(this.zAxisSlider.getValue()>352)
             this.velocitySlider.setValue(0);
    }//GEN-LAST:event_turnRightButtonMousePressed

    private void turnRightButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnRightButtonMouseReleased
        // TODO add your handling code here:
          this.velocitySlider.setValue(0);
          this.angleSlider.setValue(0);
          
    }//GEN-LAST:event_turnRightButtonMouseReleased

    private void turnLeftButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnLeftButtonMousePressed
        // TODO add your handling code here:
        this.velocitySlider.setValue(150);
        this.angleSlider.setValue(35);
        if(this.zAxisSlider.getValue()>352)
             this.velocitySlider.setValue(0);
    }//GEN-LAST:event_turnLeftButtonMousePressed

    private void turnLeftButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnLeftButtonMouseReleased
        // TODO add your handling code here:
        this.velocitySlider.setValue(0);
        this.angleSlider.setValue(0);
    }//GEN-LAST:event_turnLeftButtonMouseReleased

    private void forwardButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMousePressed
        // TODO add your handling code here:
        this.velocitySlider.setValue(150);
        this.angleSlider.setValue(0);
        if(this.zAxisSlider.getValue()>352)
             this.velocitySlider.setValue(0);
    }//GEN-LAST:event_forwardButtonMousePressed

    private void forwardButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMouseReleased
        // TODO add your handling code here:
        this.velocitySlider.setValue(0);
        this.angleSlider.setValue(0);
    }//GEN-LAST:event_forwardButtonMouseReleased

    private void reverseButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reverseButtonMousePressed
        // TODO add your handling code here:
        this.reverse.setSelected(true);
        this.velocitySlider.setValue(150);
        //this.velocitySlider.setEnabled(false);
        //this.velValue.setText(""+Integer.valueOf(-150));
        this.angleSlider.setValue(0);
        if(this.zAxisSlider.getValue()>352)
             this.velocitySlider.setValue(0);
    }//GEN-LAST:event_reverseButtonMousePressed

    private void reverseButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reverseButtonMouseReleased
        // TODO add your handling code here:
        this.reverse.setSelected(false);
        //this.velocitySlider.setEnabled(true);
        //this.velValue.setText(""+Integer.valueOf(0));
        this.velocitySlider.setValue(0);
        this.angleSlider.setValue(0);
        
    }//GEN-LAST:event_reverseButtonMouseReleased
    public void disablingComponents()
    {
        this.angleSlider.setEnabled(false);
        this.velocitySlider.setEnabled(false);
        this.angleValue.setEnabled(false);
        this.zAxisSlider.setEnabled(false);
        this.zAxisValue.setEnabled(false);
        this.velValue.setEnabled(false);
        this.sendCommand.setEnabled(false);
        this.stopMotor.setEnabled(false);
        this.leftLamp.setEnabled(false);
        this.rightLamp.setEnabled(false);
        this.forwardButton.setEnabled(false);
        this.reverseButton.setEnabled(false);
        this.turnLeftButton.setEnabled(false);
        this.turnRightButton.setEnabled(false);
        this.reverse.setEnabled(false);
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControllerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControllerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControllerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControllerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ControllerFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualValueLable;
    public javax.swing.JTextField actualZaxisValue;
    private javax.swing.JLabel angLable;
    public javax.swing.JSlider angleSlider;
    public javax.swing.JTextField angleValue;
    public javax.swing.JRadioButton enableButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JRadioButton leftLamp;
    public javax.swing.JRadioButton reverse;
    private javax.swing.JButton reverseButton;
    public javax.swing.JRadioButton rightLamp;
    public javax.swing.JButton sendCommand;
    public javax.swing.JButton stopMotor;
    private javax.swing.JButton turnLeftButton;
    private javax.swing.JButton turnRightButton;
    private javax.swing.JLabel velLable;
    public javax.swing.JTextField velValue;
    public javax.swing.JSlider velocitySlider;
    private javax.swing.JLabel zAxisLable;
    public javax.swing.JSlider zAxisSlider;
    public javax.swing.JTextField zAxisValue;
    // End of variables declaration//GEN-END:variables
}
