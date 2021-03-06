/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author ThanhKH
 */
public class Themes extends javax.swing.JFrame {

    private String themes;
    private final String player;
    private final String[] themeName = {"default", "animals", "fruitsVege"};  //themes name management
    private final MouseInputAdapter mouse;
    private JLabel storeLbl;  //store lbl that chosen as theme
    private WindowListener wlsnr;
    
    /**
     * Creates new form Themes
     * @param themes
     * @param player
     */
    public Themes(String themes, String player) {
        this.themes = themes;
        this.player = player;

        mouse = new MouseInputAdapter() {
            @Override
            public void mouseExited(MouseEvent me) {
                JLabel lbl = (JLabel) me.getComponent();
                lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                if (!lbl.getName().equals(storeLbl.getName())) {
                    lbl.setBorder(null);

                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                JLabel lbl = (JLabel) me.getComponent();
                lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
                if (!lbl.getName().equals(storeLbl.getName())) {
                    lbl.setBorder(new LineBorder(Color.BLACK, 3));

                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                JLabel lbl = (JLabel) me.getComponent();
                if (!lbl.getName().equals(storeLbl.getName())) {
                    lbl.setBorder(new LineBorder(Color.WHITE, 3));
                    storeLbl.setBorder(null);
                    storeLbl = lbl;
                }
            }

        };

        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/group-logo.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        setUp();
        preventExit();
    }

     //prevent closing the program when press close button
    public final void preventExit(){
       
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
    //check what theme is currently chosen 
    public boolean isSelected(String name) {
        return name.equals(themes);
    }
    //set up inital information
    public void setUp() {
        //set inital info
        this.setSize(1200, 500);
        pnlTitle.setSize(this.getWidth(), 85);
        pnl.setSize(this.getWidth(), this.getHeight() - pnlTitle.getHeight() - 10);
        pnlThemeArea.setSize(pnl.getWidth() - 30, pnl.getHeight() - 100);
        pnlThemeArea.setLayout(new GridLayout(1, 3, 10, 10));
        //create and add label to theme panel
        for (int i = 0; i < themeName.length; i++) {
            JLabel lbl = new JLabel();           
            ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/themes/cover/" + themeName[i] + ".png")).getImage().
                    getScaledInstance((pnlThemeArea.getWidth() - 50) / 3, pnlThemeArea.getHeight() - 20, Image.SCALE_SMOOTH));

            lbl.setIcon(img);
            lbl.setName(themeName[i]);
            if (isSelected(themeName[i])) {
                lbl.setBorder(new LineBorder(Color.WHITE, 3));
                storeLbl = lbl;
            }
            lbl.addMouseListener(mouse);
            pnlThemeArea.add(lbl);

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

        pnlTitle = new javax.swing.JPanel();
        lblReturn = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        pnl = new javax.swing.JPanel();
        pnlThemeArea = new javax.swing.JPanel();
        lblConfirm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concentration Game");
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 500));

        pnlTitle.setBackground(new java.awt.Color(32, 33, 36));

        lblReturn.setForeground(new java.awt.Color(255, 255, 255));
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

        lblTitle.setFont(new java.awt.Font("League Spartan", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Themes");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(449, 449, 449))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTitleLayout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTitleLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnl.setBackground(new java.awt.Color(13, 102, 72));

        pnlThemeArea.setBackground(new java.awt.Color(13, 102, 72));

        javax.swing.GroupLayout pnlThemeAreaLayout = new javax.swing.GroupLayout(pnlThemeArea);
        pnlThemeArea.setLayout(pnlThemeAreaLayout);
        pnlThemeAreaLayout.setHorizontalGroup(
            pnlThemeAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlThemeAreaLayout.setVerticalGroup(
            pnlThemeAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        lblConfirm.setFont(new java.awt.Font("League Spartan", 1, 24)); // NOI18N
        lblConfirm.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirm.setText("CONFIRM");
        lblConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConfirmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConfirmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConfirmMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(481, 481, 481))
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThemeArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThemeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(lblConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnl.getAccessibleContext().setAccessibleName("");

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

    private void lblConfirmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmMouseEntered
        lblConfirm.setBorder(new LineBorder(Color.WHITE, 4));
    }//GEN-LAST:event_lblConfirmMouseEntered

    private void lblConfirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmMouseExited
        lblConfirm.setBorder(null);
    }//GEN-LAST:event_lblConfirmMouseExited

    private void lblConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmMouseClicked
        MainMenu main = new MainMenu(player, storeLbl.getName());
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.removeWindowListener(wlsnr);
        this.dispose();
    }//GEN-LAST:event_lblConfirmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblReturn;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnlThemeArea;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
