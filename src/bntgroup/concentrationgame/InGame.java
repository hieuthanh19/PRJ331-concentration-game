/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * display all needed information + create a game board
 *
 * @author ThanhKH
 */
public class InGame extends javax.swing.JFrame {

    //variables
    private CardManagement cm;
    private PlayerManagement pm;
    private final int column;
    private final int row;
    private int point;
    private int time;
    private final int storeTime;
    private int pairNum;
    private final String themes;
    private final String mode;
    private final String player;
    private Timer timer;
    private Timer noTimer;
    private WindowListener wlsnr;

    /**
     * Creates new form InGame
     *
     * @param row
     * @param col
     * @param time
     * @param themes
     * @param mode
     * @param player
     * @throws java.io.IOException
     */
    public InGame(int row, int col, int time, String themes, String mode, String player) throws Exception {
        this.row = row;
        this.column = col;
        this.storeTime = time;
        this.themes = themes;
        this.mode = mode;
        this.player = player;

        initComponents();
        //set icon
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/group-logo.png"));
        this.setIconImage(icon);
        setUp();
        preventExit();

    }

    public JPanel getPnlGameArea() {
        return pnlGameArea;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getThemes() {
        return themes;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPairNum() {
        return pairNum;
    }

    public void setPairNum(int pairNum) {
        this.pairNum = pairNum;
    }

    /**
     * prevent closing the program (by return to main menu) when press close
     * button
     */
    public final void preventExit() {
        //create new window adapter to catch close action
        this.wlsnr = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                disableTimer();  //disable all current timer
                //open main menu
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
     * set up initial information for game board
     *
     * @throws Exception
     */
    private void setUp() throws Exception {
        pm = new PlayerManagement("src/data/data.txt"); //get players info
        pm.loadFile();
        //set size of the board
        pnlMenu.setSize(1049, 100);
        pnlStatus.setSize(100, 550);
        pnlGameArea.setSize(942, 550);
        //set info
        pairNum = column * row / 2;
        point = 0;
        time = storeTime;
        //set Mode for Title
        lblTitle.setText(mode + " (" + row + "x" + column + ")");
        //set text for other icons
        lblPairsNum.setText(String.valueOf(pairNum));
        lblTimer.setText(intToTime(time));
        lblScoreTitle.setText("<html>\n"
                + "Score<br>\n"
                + "<p style=\"text-align:center;\">" + point + "</p>\n"
                + "</html>");
        //create grid layout to store cards
        pnlGameArea.setLayout(new GridLayout(row, column));

        //create new CardManagement and create game
        cm = new CardManagement(this);
        cm.createGame();

        noTimer = new Timer(500, customNoTimer);//create new timer for custom mode when player set timer = 0
        timer = new Timer(1000, havingTimer);  //create new timer which repeat every 1s
        //if player set time=0 in custom mode 
        if (time == 0) {
            noTimer.start();
        } else {
            timer.start();
        }
    }

    //actions in normal games
    ActionListener havingTimer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (time > 0 && pairNum > 0) {
                    //update information
                    lblPairsNum.setText(String.valueOf(pairNum));
                    lblTimer.setText(intToTime(time));
                    time--;
                    lblScoreTitle.setText("<html>\n"
                            + "Score<br>\n"
                            + "<p style=\"text-align:center;\">" + point + "</p>\n"
                            + "</html>");
                } else if (time > 0 && pairNum == 0) //wining
                {
                    //update information
                    lblPairsNum.setText(String.valueOf(pairNum));

                    timer.stop();
                    gameOver(1);
                } else {  //losing    
                    //update information
                    lblTimer.setText(intToTime(time));
                    timer.stop();
                    gameOver(0);

                }
            } catch (Exception e) {
                System.out.println("Having timer exception: " + e);
            }

        }
    };

    //action for custom game with no timer
    ActionListener customNoTimer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (pairNum > 0) {
                    //update information
                    lblTimer.setText(intToTime(time));
                    lblPairsNum.setText(String.valueOf(pairNum));
                    lblScoreTitle.setText("<html>\n"
                            + "Score<br>\n"
                            + "<p style=\"text-align:center;\">" + point + "</p>\n"
                            + "</html>");
                }

                if (pairNum == 0) //wining
                {
                    //update paiNum
                    lblPairsNum.setText(String.valueOf(pairNum));
                    
                    noTimer.stop();
                    gameOver(1);

                }

            } catch (Exception e) {
                System.out.println("Custom Timer: " + e);
            }
        }
    };

    //disable all running timer
    public void disableTimer() {
        if (timer.isRunning()) {
            timer.stop();

        } else if (noTimer.isRunning()) {
            noTimer.stop();
        }
    }

    //format time
    public String intToTime(int time) {
        return String.format("%d:%02d", time / 60, time % 60);
    }

    //display score bonuses
    public String scoreBonus(int pointWithBonuses, int difficulty) {
        return "\nBase score:   " + point + "\nTime bonus: " + time * 10 + "\nDifficulty bonus:    " + difficulty + "\nTotal score: " + pointWithBonuses;
    }

    //actions when game is over
    public void gameOver(int result) throws Exception {
        int difficultyBonus = 0;
        //difficulty bonus 
        if (mode.equals("Hard")) {
            difficultyBonus += 1000;
        } else if (mode.equals("Normal")) {
            difficultyBonus += 500;
        }

        int pointWithBonus = point + time * 10 + difficultyBonus;
        //update score
        lblScoreTitle.setText("<html>\n"
                + "Score<br>\n"
                + "<p style=\"text-align:center;\">" + pointWithBonus + "</p>\n"
                + "</html>");

        if (result == 1) {//wining

            if (pm.getScore(player) < pointWithBonus) {  //if player has high score 
                if (!this.mode.equals("Custom")) {  //don't save score in custom mode
                    JOptionPane.showMessageDialog(this, "Congratulation! You've beat the game!\n" + scoreBonus(pointWithBonus, difficultyBonus) + " (HIGH SCORE)", "NEW HIGH SCORE!",
                            JOptionPane.INFORMATION_MESSAGE);
                    pm.changeData(player, mode, pointWithBonus, storeTime - time); //update new data
                    pm.saveFile();

                }

            } else {
                JOptionPane.showMessageDialog(this, "Congratulation! You've beat the game!" + scoreBonus(pointWithBonus, difficultyBonus), "Congratulation",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            //retry
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to play another game with the same parameters?", "Continue?", JOptionPane.YES_NO_OPTION);

            //create new game
            if (choice == JOptionPane.YES_OPTION) {
                //inital set up               
                pnlGameArea.removeAll();
                setUp();
                pnlGameArea.revalidate();
                pnlGameArea.repaint();

            } else {  //exit to main menu              
                MainMenu main = new MainMenu(player, themes);
                main.setVisible(true);
                main.setLocationRelativeTo(null);
                main.pack();
                //disableTimer();
                this.removeWindowListener(wlsnr);
                this.dispose();
            }

        } else {  //losing
            JOptionPane.showMessageDialog(this, "You lose! Try harder next time!" + scoreBonus(pointWithBonus, difficultyBonus), "You lose!", JOptionPane.YES_OPTION);
            //retry?
            int choice = JOptionPane.showConfirmDialog(this, "\nDo you want to retry?", "Retry?", JOptionPane.YES_NO_OPTION);
            //create new game
            if (choice == JOptionPane.YES_OPTION) {
                //inital set up                 
                pnlGameArea.removeAll();
                setUp();
                pnlGameArea.revalidate();
                pnlGameArea.repaint();

            } else {  //exit to main menu
                pnlGameArea.setEnabled(true);
                MainMenu main = new MainMenu(player, themes);
                main.setVisible(true);
                main.setLocationRelativeTo(null);
                main.pack();
                this.removeWindowListener(wlsnr);
                this.dispose();
            }
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

        pnlMenu = new javax.swing.JPanel();
        lblReturn = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblRestart = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        pnlStatus = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        lblPairsNum = new javax.swing.JLabel();
        lblScoreTitle = new javax.swing.JLabel();
        pnlGameArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concentration Game");
        setBackground(new java.awt.Color(13, 102, 72));
        setPreferredSize(new java.awt.Dimension(1055, 692));
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 692));

        pnlMenu.setBackground(new java.awt.Color(32, 33, 36));
        pnlMenu.setMinimumSize(new java.awt.Dimension(120, 80));
        pnlMenu.setPreferredSize(new java.awt.Dimension(1049, 100));

        lblReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return-icon.png"))); // NOI18N
        lblReturn.setToolTipText("<html>\n<b>Back</b><br>\nClick to go back to previous window.\n</html>");
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
        lblTitle.setText("Easy (4x4)");

        lblRestart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restart-icon.png"))); // NOI18N
        lblRestart.setToolTipText("<html>\n<b>Restart</b><br>\nRestart this game. All score will be lost\n</html>");
        lblRestart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRestartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRestartMouseExited(evt);
            }
        });

        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home-icon.png"))); // NOI18N
        lblHome.setToolTipText("<html>\n<b>Home</b><br>\nReturn to main menu. All your score will be lost\n</html>");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(238, 238, 238)
                .addComponent(lblRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblReturn))
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pnlStatus.setBackground(new java.awt.Color(13, 102, 72));
        pnlStatus.setPreferredSize(new java.awt.Dimension(100, 550));
        pnlStatus.setLayout(new java.awt.GridLayout(3, 0));

        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/timer-icon.png"))); // NOI18N
        lblTimer.setText("0:00");
        lblTimer.setToolTipText("Remaining time");
        pnlStatus.add(lblTimer);

        lblPairsNum.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblPairsNum.setForeground(new java.awt.Color(255, 255, 255));
        lblPairsNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPairsNum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pair-icon.png"))); // NOI18N
        lblPairsNum.setText("0");
        lblPairsNum.setToolTipText("Remaining Pairs");
        pnlStatus.add(lblPairsNum);

        lblScoreTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblScoreTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblScoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScoreTitle.setText("<html> Score<br> <p style=\"text-align:center;\">0</p> </html>");
        lblScoreTitle.setToolTipText("");
        pnlStatus.add(lblScoreTitle);

        pnlGameArea.setPreferredSize(new java.awt.Dimension(942, 550));

        javax.swing.GroupLayout pnlGameAreaLayout = new javax.swing.GroupLayout(pnlGameArea);
        pnlGameArea.setLayout(pnlGameAreaLayout);
        pnlGameAreaLayout.setHorizontalGroup(
            pnlGameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
        );
        pnlGameAreaLayout.setVerticalGroup(
            pnlGameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGameArea, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGameArea, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * when return button is clicked
     *
     * @param evt
     */
    private void lblReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseClicked
        int choice = JOptionPane.showConfirmDialog(this, "All your score will be lost. Do you want to continue?", "Return to previous menu?", JOptionPane.YES_NO_OPTION);
        //confirm?
        if (choice == JOptionPane.YES_OPTION) {
            //return to custom frame
            if (mode.equals("Custom")) {
                disableTimer();
                Custom custom = new Custom(player, themes);
                custom.setVisible(true);
                custom.setLocationRelativeTo(null);

                this.removeWindowListener(wlsnr);
                this.dispose();
            } else {  //return to choose difficulty  
                disableTimer();
                Difficulty diff = new Difficulty(player, themes);
                diff.setVisible(true);
                diff.setLocationRelativeTo(null);

                this.removeWindowListener(wlsnr);
                this.dispose();
            }
        }
    }//GEN-LAST:event_lblReturnMouseClicked

    private void lblReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseEntered
        lblReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return-icon-hover.png")));
    }//GEN-LAST:event_lblReturnMouseEntered

    private void lblReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnMouseExited
        lblReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return-icon.png")));
    }//GEN-LAST:event_lblReturnMouseExited
    /**
     * when home button is clicked
     *
     * @param evt
     */
    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        int choice = JOptionPane.showConfirmDialog(this, "All your score will be lost. Do you want to continue?", "Return to main menu?", JOptionPane.YES_NO_OPTION);
        //confirm?
        if (choice == JOptionPane.YES_OPTION) {
            disableTimer();
            MainMenu main = new MainMenu(player, themes);
            main.setVisible(true);
            main.setLocationRelativeTo(null);

            this.removeWindowListener(wlsnr);
            this.dispose();
        }

    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblRestartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestartMouseEntered
        lblRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restart-icon-hover.png")));
    }//GEN-LAST:event_lblRestartMouseEntered

    private void lblRestartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestartMouseExited
        lblRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restart-icon.png")));
    }//GEN-LAST:event_lblRestartMouseExited

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home-icon-hover.png")));
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home-icon.png")));
    }//GEN-LAST:event_lblHomeMouseExited
    /**
     * when restart button is clicked
     *
     * @param evt
     */
    private void lblRestartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestartMouseClicked
        try {
            int choice = JOptionPane.showConfirmDialog(this, "Your score will be lost. Do you want to continue?", "Restart?", JOptionPane.YES_NO_OPTION);
            //confirm?
            if (choice == JOptionPane.YES_OPTION) {
                //inital set up 
                disableTimer();
                // this.time = storeTime;
                pnlGameArea.removeAll();
                setUp();
                pnlGameArea.revalidate();
                pnlGameArea.repaint();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_lblRestartMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblPairsNum;
    private javax.swing.JLabel lblRestart;
    private javax.swing.JLabel lblReturn;
    private javax.swing.JLabel lblScoreTitle;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlGameArea;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlStatus;
    // End of variables declaration//GEN-END:variables
}
