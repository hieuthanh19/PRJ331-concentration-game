/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 *
 * @author ThanhKH
 */
public final class MainMenu extends javax.swing.JFrame {

    private String playerName = "BNT";
    private String themes = "default";

    /**
     * Creates new form MainMenu on start
     */
    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblPlayerName.setText("Welcome, " + playerName);
        this.pack();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/group-logo.png"));
        this.setIconImage(icon);
        setThemesIcon(themes);
    }

    /**
     * Create MainMenu with player's info on return
     *
     * @param name
     * @param themes
     */
    public MainMenu(String name, String themes) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.playerName = name;
        this.themes = themes;
        lblPlayerName.setText("Welcome, " + playerName);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/group-logo.png"));
        this.setIconImage(icon);
        setThemesIcon(themes);
    }

    //Set icon for lbl in menu
    public void setThemesIcon(String themes) {

        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/themes/menuIcon/" + themes + ".png")).getImage().
                getScaledInstance(lblIconThemes.getWidth(), lblIconThemes.getHeight(), Image.SCALE_SMOOTH));
        lblIconThemes.setIcon(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblText2 = new javax.swing.JLabel();
        lblText1 = new javax.swing.JLabel();
        lblCredit = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        lblCustom = new javax.swing.JLabel();
        lblLeaderboard = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblThemes = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();
        lblChangeAccount = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIconThemes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concentration Game");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(18, 103, 72));
        pnlBackground.setPreferredSize(new java.awt.Dimension(1200, 500));

        lblText2.setFont(new java.awt.Font("League Spartan", 1, 46)); // NOI18N
        lblText2.setForeground(new java.awt.Color(255, 255, 255));
        lblText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText2.setText("GAME");

        lblText1.setFont(new java.awt.Font("League Spartan", 1, 46)); // NOI18N
        lblText1.setForeground(new java.awt.Color(255, 255, 255));
        lblText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText1.setText("CONCENTRATION\n");

        lblCredit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCredit.setForeground(new java.awt.Color(255, 255, 255));
        lblCredit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredit.setText("Credits");
        lblCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCreditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCreditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCreditMouseExited(evt);
            }
        });

        lblStart.setBackground(new java.awt.Color(153, 0, 51));
        lblStart.setFont(new java.awt.Font("League Spartan", 0, 24)); // NOI18N
        lblStart.setForeground(new java.awt.Color(255, 255, 255));
        lblStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStart.setText("Start");
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

        lblCustom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCustom.setForeground(new java.awt.Color(255, 255, 255));
        lblCustom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustom.setText("Custom");
        lblCustom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCustomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCustomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCustomMouseExited(evt);
            }
        });

        lblLeaderboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLeaderboard.setForeground(new java.awt.Color(255, 255, 255));
        lblLeaderboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeaderboard.setText("Leaderboard");
        lblLeaderboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeaderboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLeaderboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLeaderboardMouseExited(evt);
            }
        });

        lblVersion.setForeground(new java.awt.Color(255, 255, 255));
        lblVersion.setText("v1.4.4");
        lblVersion.setToolTipText("");

        lblThemes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThemes.setForeground(new java.awt.Color(255, 255, 255));
        lblThemes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThemes.setText("Themes");
        lblThemes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThemesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThemesMouseExited(evt);
            }
        });

        lblPlayerName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerName.setText("Welcome, Thanh ");

        lblChangeAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChangeAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblChangeAccount.setText("Click here to change");
        lblChangeAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangeAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChangeAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChangeAccountMouseExited(evt);
            }
        });

        lblExit.setBackground(new java.awt.Color(102, 0, 51));
        lblExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("Exit");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pair-trans.png"))); // NOI18N

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblText1)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(lblText2)))
                        .addGap(225, 225, 225)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPlayerName)
                            .addComponent(lblChangeAccount)))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCustom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThemes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLeaderboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCredit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIconThemes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVersion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblChangeAccount)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblText1)
                        .addGap(18, 18, 18)
                        .addComponent(lblText2)))
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                            .addGap(164, 164, 164)
                            .addComponent(lblIconThemes, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblVersion))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblStart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(lblThemes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblLeaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLeaderboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaderboardMouseClicked
        try {
            Leaderboard lead = new Leaderboard(playerName, themes);
            lead.setVisible(true);
            lead.pack();
            lead.setLocationRelativeTo(null);
            lead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblLeaderboardMouseClicked

    private void lblStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartMouseClicked
        Difficulty choose = new Difficulty(playerName, themes);
        choose.setVisible(true);
        choose.setLocationRelativeTo(null);
        choose.pack();
        this.dispose();
    }//GEN-LAST:event_lblStartMouseClicked

    private void lblCustomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomMouseClicked
        //open custome mode frame
        Custom custom = new Custom(playerName, themes);
        custom.setVisible(true);
        custom.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblCustomMouseClicked

    private void lblThemesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemesMouseClicked
        //open themes frame
        Themes theme = new Themes(this.themes, playerName);
        theme.setVisible(true);
        theme.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblThemesMouseClicked

    private void lblCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreditMouseClicked
        //open credit frame
        Credits credit = new Credits(playerName, themes);
        credit.setVisible(true);
        credit.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblCreditMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblChangeAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeAccountMouseClicked
        try {

            Font font;
            font = lblChangeAccount.getFont();
            Map attribute = font.getAttributes();
            attribute.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); //set text to underline on click
            lblChangeAccount.setFont(font.deriveFont(attribute));
            //open changeName frame
            ChangeAccount change = new ChangeAccount(playerName, themes);
            change.setVisible(true);
            change.setLocationRelativeTo(null);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblChangeAccountMouseClicked

    private void lblStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartMouseEntered
        lblStart.setBorder(new LineBorder(Color.white, 3));
    }//GEN-LAST:event_lblStartMouseEntered

    private void lblCustomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomMouseEntered
        lblCustom.setBorder(new LineBorder(Color.white, 3));
    }//GEN-LAST:event_lblCustomMouseEntered

    private void lblThemesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemesMouseEntered
        lblThemes.setBorder(new LineBorder(Color.white, 3));
    }//GEN-LAST:event_lblThemesMouseEntered

    private void lblLeaderboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaderboardMouseEntered
        lblLeaderboard.setBorder(new LineBorder(Color.white, 3));
    }//GEN-LAST:event_lblLeaderboardMouseEntered

    private void lblCreditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreditMouseEntered
        lblCredit.setBorder(new LineBorder(Color.white, 3));
    }//GEN-LAST:event_lblCreditMouseEntered

    private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseEntered
        lblExit.setBorder(new LineBorder(Color.white, 3));
    }//GEN-LAST:event_lblExitMouseEntered

    private void lblStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStartMouseExited
        lblStart.setBorder(null);
    }//GEN-LAST:event_lblStartMouseExited

    private void lblCustomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomMouseExited
        lblCustom.setBorder(null);
    }//GEN-LAST:event_lblCustomMouseExited

    private void lblThemesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemesMouseExited
        lblThemes.setBorder(null);
    }//GEN-LAST:event_lblThemesMouseExited

    private void lblLeaderboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaderboardMouseExited
        lblLeaderboard.setBorder(null);
    }//GEN-LAST:event_lblLeaderboardMouseExited

    private void lblCreditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreditMouseExited
        lblCredit.setBorder(null);
    }//GEN-LAST:event_lblCreditMouseExited

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        lblExit.setBorder(null);
    }//GEN-LAST:event_lblExitMouseExited

    private void lblChangeAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeAccountMouseEntered
        Font font;
        font = lblChangeAccount.getFont();
        Map attribute = font.getAttributes();
        attribute.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);  //set text to underline on mouse hover
        lblChangeAccount.setFont(font.deriveFont(attribute));

    }//GEN-LAST:event_lblChangeAccountMouseEntered

    private void lblChangeAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeAccountMouseExited
        Font font;
        font = lblChangeAccount.getFont();
        Map attribute = font.getAttributes();
        attribute.put(TextAttribute.UNDERLINE, -1);  //set text to normal
        lblChangeAccount.setFont(font.deriveFont(attribute));
    }//GEN-LAST:event_lblChangeAccountMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblChangeAccount;
    private javax.swing.JLabel lblCredit;
    private javax.swing.JLabel lblCustom;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblIconThemes;
    private javax.swing.JLabel lblLeaderboard;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblText1;
    private javax.swing.JLabel lblText2;
    private javax.swing.JLabel lblThemes;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
