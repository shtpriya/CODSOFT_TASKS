import javax.swing.JOptionPane;

public class Currency_Converter extends javax.swing.JFrame {

    String[] currencyUnits = {
        "units",
        "Dollar",
        "NPR",
        "CAD",
        "Real",
        "Rupiah",
        "INR"
    };

    double US_Dollar = 1.27;
    double Nepalese_Rupee = 168.83;
    double canadian_dollar = 1.71;
    double brazilian_real = 6.25;
    double Indonesian_rupiah = 20048.75;
    double Indian_Rupee = 105.52;

    public Currency_Converter() {
        setTitle("Task 4");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        country1 = new javax.swing.JComboBox();
        text1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        unit1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        country2 = new javax.swing.JComboBox();
        text2 = new javax.swing.JTextField();
        unit2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(195, 65, 65), new java.awt.Color(128, 33, 217), java.awt.Color.red, null));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 29)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CURRENCY CONVERTER");

        country1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select  Country", "USA", "Nepal", "Canada", "Brazil", "Indonesia", "India" }));
        country1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                country1ItemStateChanged(evt);
            }
        });
        country1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country1ActionPerformed(evt);
            }
        });

        text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel2.setText("From Currency of :");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jButton1.setText("Convert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        unit1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        unit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        unit1.setName(""); // NOI18N

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel4.setText("To Currency of :");

        country2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select  Country", "USA", "Nepal", "Canada", "Brazil", "Indonesia", "India" }));
        country2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                country2ItemStateChanged(evt);
            }
        });
        country2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country2ActionPerformed(evt);
            }
        });

        text2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text2ActionPerformed(evt);
            }
        });

        unit2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton2.setBackground(new java.awt.Color(102, 255, 0));
        jButton2.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(212, 42, 32));
        jButton3.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButton1)
                        .addGap(96, 96, 96)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unit1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(country1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(country2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unit2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(country1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(country2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unit1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unit2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void country1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country1ActionPerformed

    private void country2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_country2ActionPerformed

    private void text2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text1ActionPerformed

    private void country1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_country1ItemStateChanged
        int position = country1.getSelectedIndex();
        unit1.setText(currencyUnits[position]);
    }//GEN-LAST:event_country1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (country1.getSelectedIndex() == 0 || country2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "SELECT THE COUNTRY FIRST!", "Error Message",
                    JOptionPane.INFORMATION_MESSAGE);

            return;
        } else if (text1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ENTER THE AMOUNT YOU WANT TO CONVERT!", "Error Message",
                    JOptionPane.INFORMATION_MESSAGE);

            return;

        }

        double amtchange = Double.parseDouble(text1.getText());
        double amtinpounds = 0.0;
        double amtchanged = 0.0;

        switch (country1.getSelectedItem().toString()) {
            case "USA":
                amtinpounds = amtchange / US_Dollar;
                break;
            case "Nepal":
                amtinpounds = amtchange / Nepalese_Rupee;
                break;
            case "Canada":
                amtinpounds = amtchange / canadian_dollar;
                break;
            case "Brazil":
                amtinpounds = amtchange / brazilian_real;
                break;
            case "Indonesia":
                amtinpounds = amtchange / Indonesian_rupiah;
                break;
            case "India":
                amtinpounds = amtchange / Indian_Rupee;
                break;
            default:
                amtinpounds = 0.0;

        }

        switch (country2.getSelectedItem().toString()) {
            case "USA":
                amtchanged = amtinpounds * US_Dollar;
                break;
            case "Nepal":
                amtchanged = amtinpounds * Nepalese_Rupee;
                break;
            case "Canada":
                amtchanged = amtinpounds * canadian_dollar;
                break;
            case "Brazil":
                amtchanged = amtinpounds * brazilian_real;
                break;
            case "Indonesia":
                amtchanged = amtinpounds * Indonesian_rupiah;
                break;
            case "India":
                amtchanged = amtinpounds * Indian_Rupee;
                break;
            default:
                amtchanged = amtinpounds * 0.0;

        }

        String value = String.format("%.2f", amtchanged);
        text2.setText(value);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void country2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_country2ItemStateChanged
        int position = country2.getSelectedIndex();
        unit2.setText(currencyUnits[position]);
    }//GEN-LAST:event_country2ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        country1.setSelectedIndex(0);
        country2.setSelectedIndex(0);
        text1.setText(null);
        text2.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Currency_Converter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox country1;
    private javax.swing.JComboBox country2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JLabel unit1;
    private javax.swing.JLabel unit2;
    // End of variables declaration//GEN-END:variables
}
