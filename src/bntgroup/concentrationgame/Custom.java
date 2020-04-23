/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author ThanhKH
 */
public class Custom extends javax.swing.JFrame {

    String player;
    String themes;
    WindowListener wlsnr;

    /**
     * Creates new form Custom
     *
     * @param player
     * @param themes
     */
    public Custom(String player, String themes) {
        this.player = player;
        this.themes = themes;
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/group-logo.png"));
        this.setIconImage(icon);
        preventExit();
    }

    //prevent closing the program when press close button
    public final void preventExit() {

        this.wlsnr = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                MainMenu main = new MainMenu(player, themes);
                main.setVisible(true);
                main.pack();
                main.setLocationRelativeTo(null);
            }

        };
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(wlsnr);
    }

    /**
     * find number of rows and columns
     *
     * @param a
     * @param b
     * @param pairNum
     * @return
     */
    public Integer[] findRowsNCols(int a, int b, int pairNum) {
        Integer[] arr = new Integer[2];
        while (a * b / 2 < pairNum) {
            if (a <= b) {
                return (findRowsNCols(++a, b, pairNum));
            } else {
                return findRowsNCols(++b, a, pairNum);
            }
        }
        arr[0] = a;
        arr[1] = b;
        return arr;
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
        lblReturn = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblRow = new javax.swing.JLabel();
        spnRows = new javax.swing.JSpinner();
        lblColumn = new javax.swing.JLabel();
        spnColumn = new javax.swing.JSpinner();
        lblTimer = new javax.swing.JLabel();
        spnTimer = new javax.swing.JSpinner();
        lblStart = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concentration Game");

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));
        jPanel1.setLayout(null);

        lblReturn.setForeground(new java.awt.Color(255, 255, 255));
        lblReturn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return-icon.png"))); // NOI18N
        lblReturn.setToolTipText("<html> <b>Back</b><br> Click to go back to previous window. </html>");
        lblReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReturnMouseExited(evt);
            }
        });
        jPanel1.add(lblReturn);
        lblReturn.setBounds(10, 20, 32, 40);

        lblTitle.setFont(new java.awt.Font("League Spartan", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Custom Mode");
        jPanel1.add(lblTitle);
        lblTitle.setBounds(110, 20, 166, 40);

        jPanel2.setBackground(new java.awt.Color(13, 102, 72));

        lblRow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRow.setForeground(new java.awt.Color(255, 255, 255));
        lblRow.setText("<html> Number of Rows: </html>");

        spnRows.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnRows.setModel(new javax.swing.SpinnerNumberModel(4, 1, 9, 1));

        lblColumn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColumn.setForeground(new java.awt.Color(255, 255, 255));
        lblColumn.setText("<html> Number of Columns: </html>");

        spnColumn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnColumn.setModel(new javax.swing.SpinnerNumberModel(4, 1, 9, 1));

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setText("<html>\nTimer(s):<br>\n(set 0 to disable)\n</html>");

        spnTimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnTimer.setModel(new javax.swing.SpinnerNumberModel(0, 0, 300, 1));

        lblStart.setFont(new java.awt.Font("League Spartan", 1, 24)); // NOI18N
        lblStart.setForeground(new java.awt.Color(255, 255, 255));
        lblStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStart.setText("START");
        lblStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblStartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblStartMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblRow, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(spnRows, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStart, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(spnRows, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(spnTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblStart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseClicked
        MainMenu main = new MainMenu(player, themes);
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.removeWindowListener(wlsnr);
        this.dispose();
    }//GEN-LAST:event_lblReturnMouseClicked

    private void lblReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseEntered
        lblReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return-icon-hover.png")));
    }//GEN-LAST:event_lblReturnMouseEntered

    private void lblReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseExited
        lblReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return-icon.png")));
    }//GEN-LAST:event_lblReturnMouseExited

    private void lblStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartMouseClicked
        try {
            int check = 0;
            //check input
            try {
                spnColumn.commitEdit();  //get typed but not-yet-enter values
                spnRows.commitEdit();
                spnTimer.commitEdit();
                check = 1;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Please enter a positive integer number and greater than 0!", "Error!", JOptionPane.YES_OPTION);
            }
            //valid            
            if (check == 1) {
                int row = (Integer) spnRows.getValue();
                int column = (Integer) spnColumn.getValue();
                if (row % 2 != 0 && column % 2 != 0) {  //if both number of row and column are odd numbers => odd number of cards
                    JOptionPane.showMessageDialog(this, "Number of rows/columns you've entered is invalid because they create an odd number of cards", "Error!", JOptionPane.YES_OPTION);
                } else {
                    //create game
                    InGame game = new InGame(row, column, (Integer) spnTimer.getValue(), themes, "Custom", player);
                    game.setVisible(true);
                    game.pack();
                    game.setLocationRelativeTo(null);
                    this.removeWindowListener(wlsnr);
                    this.dispose();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_lblStartMouseClicked

    private void lblStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartMouseEntered
        lblStart.setBorder(new LineBorder(Color.WHITE, 4));
    }//GEN-LAST:event_lblStartMouseEntered

    private void lblStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartMouseExited
        lblStart.setBorder(null);
    }//GEN-LAST:event_lblStartMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblColumn;
    private javax.swing.JLabel lblReturn;
    private javax.swing.JLabel lblRow;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSpinner spnColumn;
    private javax.swing.JSpinner spnRows;
    private javax.swing.JSpinner spnTimer;
    // End of variables declaration//GEN-END:variables
}
