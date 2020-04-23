/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

/**
 * Create and manage all card on game board
 *
 * @author ThanhKH
 */
public class CardManagement extends JLabel {

    private int colums;
    private int rows;
    private int pairNum;
    private String themes;
    private ImageIcon folded;
    private ImageIcon unfold;
    private ArrayList<CardManagement> queue;
    private HashMap<String, JLabel> storeLabel;
    private ArrayList<JLabel> label;
    private JPanel pnl;
    Timer timerDup;
    Timer timerUndup;
    private MouseInputAdapter mouse;
    private Color grey = new Color(240, 240, 240);

    /**
     * Create new Card Management with inputed attributes
     *
     * @param frame
     * @throws java.lang.Exception
     */
    public CardManagement(InGame frame) throws Exception {

        this.themes = frame.getThemes();
        this.colums = frame.getColumn();
        this.rows = frame.getRow();
        this.pnl = frame.getPnlGameArea();
        this.pairNum = colums * rows / 2;
        this.queue = new ArrayList<>();
        this.storeLabel = new HashMap<>();
        this.label = new ArrayList<>();
        this.mouse = new MouseInputAdapter() {
            //hover effect
            @Override
            public void mouseExited(MouseEvent me) {
                CardManagement card = (CardManagement) me.getComponent();
                if (card.isEnabled()) {
                    card.setBorder(new LineBorder(grey, 2));
                    card.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

            }

            //hover effect
            @Override
            public void mouseEntered(MouseEvent me) {
                CardManagement card = (CardManagement) me.getComponent();
                if (card.isEnabled()) {
                    card.setBorder(new LineBorder(Color.BLACK, 2));
                    card.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            //actions
            @Override
            public void mouseClicked(MouseEvent me) {
                //get clicked card
                CardManagement card = (CardManagement) me.getComponent();

                if (card.isEnabled()) { //prevent clicking on cleared card
                    if (queue.isEmpty()) {
                        queue.add(card);
                        changeState(card);
                    } else {
                        if (queue.size() < 2) {  //if number of cards in queue less than 2
                            if (card.getLocation().equals(queue.get(0).getLocation())) {  //if new clicked card is same as previous 
                                changeState(card);  //fold it
                                queue.remove(0); //and remove from queue    
                            } else {
                                try {
                                    queue.add(card); //add new card to queue
                                    changeState(card);  //unfold it         

                                    if (checkDuplicate(queue.get(0), queue.get(1))) {  //if two card duplicate
                                        timerDup = new Timer(300, cardDuplicate);  //create new timer
                                        timerDup.setRepeats(false);
                                        timerDup.start();
                                        //update information
                                        frame.setPairNum(frame.getPairNum() - 1);
                                        frame.setPoint(frame.getPoint() + 10);

                                    } else {
                                        timerUndup = new Timer(400, cardNotDuplicate);

                                        timerUndup.setRepeats(false);
                                        timerUndup.start();
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(CardManagement.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        }
                    }

                }
            }
        };

    }
    //actions when 2 card duplicate
    ActionListener cardDuplicate = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                //remove them from the board
                queue.get(0).setVisible(false);
                queue.get(0).setEnabled(false);
                queue.get(1).setVisible(false);
                queue.get(1).setEnabled(false);
                queue.remove(0);
                queue.remove(0);

            } catch (Exception ex) {
                Logger.getLogger(CardManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    //actions when 2 card not duplicate
    ActionListener cardNotDuplicate = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //fold them
            changeState(queue.get(0));
            changeState(queue.get(1));
            queue.remove(0);
            queue.remove(0);
        }
    };

    /**
     * Create new CardM to store pictures
     *
     * @param folded
     * @param unfold
     */
    public CardManagement(ImageIcon folded, ImageIcon unfold) {
        this.folded = folded;
        this.unfold = unfold;

    }

    public ImageIcon getUnfold() {
        return unfold;
    }

    /**
     * create random number list
     *
     * @param size
     * @return
     */
    private ArrayList<Integer> createRandomList(int size) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        while (array.size() < size) {
            int num = random.nextInt(40) + 1; //36: total number of picture
            if (!array.contains(num)) {
                array.add(num);
            }
        }
        return array;
    }

    /**
     * Create random number list from given list
     *
     * @param list
     * @return
     */
    private ArrayList<Integer> createRandomListFromList(ArrayList<Integer> list) {
        ArrayList<Integer> array = new ArrayList<>(list);
        Random random = new Random();

        for (int i = 0; i < list.size(); i++) {  //swaps
            int num = random.nextInt(list.size());  //create a random position number
            int tmp = array.get(i);
            array.set(i, array.get(num));
            array.set(num, tmp);
        }
        return array;
    }

    /**
     * Find suitable card's size
     *
     * @param pnl
     * @return
     */
    private Dimension findCardSize(JPanel pnl) {
        Dimension size = new Dimension();
        size.width = (pnl.getWidth() - (colums - 1)*5) / colums;
        size.height = (pnl.getHeight() - (rows - 1)*5) / rows;
        return size;
    }

    /**
     * Create cards and display
     *
     * @throws Exception
     */
    public void createGame() throws Exception {

        String name = "card";
        //get folded icon
        folded = new ImageIcon(new ImageIcon(getClass().getResource("/themes/folded-card.png")).getImage().
                getScaledInstance(findCardSize(pnl).width, findCardSize(pnl).height, Image.SCALE_SMOOTH));
        ArrayList<Integer> arr1 = createRandomList(pairNum);
        ArrayList<Integer> arr2 = createRandomListFromList(arr1);
        Random random = new Random();
        int count1 = 0; //count number of elements have been created in array1
        int count2 = 0; //count number of elements have been created in array2
        int i = 0;

        while (i < pairNum * 2) {
            int number = random.nextInt(2); //choose between array1 and array2 randomly 

            if (count1 == arr1.size()) {   //if arr1 full
                number = 1;
            } else if (count2 == arr2.size()) {  //if arr2 full
                number = 0;
            }
            if (number == 0)//array1
            {
                unfold = new ImageIcon(new ImageIcon(getClass().getResource("/themes/" + themes + "/" + arr1.get(count1) + ".jpg")).getImage().
                        getScaledInstance(findCardSize(pnl).width, findCardSize(pnl).height, Image.SCALE_SMOOTH));  //get an icon image, resize and add it to label
                // storeIcon.put(card, unfold);                      
                label.add(new CardManagement(folded, unfold));
                setBasicInfo(label.get(i), name + arr1.get(count1));  //set name base on picture's number
                storeLabel.put(name + i, label.get(i));
                pnl.add(label.get(i)); //add label to panel
                
                count1++;
                i++;

            } else //array2
            {
                unfold = new ImageIcon(new ImageIcon(getClass().getResource("/themes/" + themes + "/" + arr2.get(count2) + ".jpg")).getImage().
                        getScaledInstance(findCardSize(pnl).width, findCardSize(pnl).height, Image.SCALE_SMOOTH));  //get an icon image, resize and add it to label
                label.add(new CardManagement(folded, unfold));
                setBasicInfo(label.get(i), name + arr2.get(count2));  //set name base on picture's number
                storeLabel.put(name + i, label.get(i));
                pnl.add(label.get(i)); //add label to panel      
                
                count2++;
                i++;

            }
        }
    }

    /**
     * set basic info for labels
     *
     * @param cm
     * @param name
     */
    public void setBasicInfo(JLabel cm, String name) {
        cm.setName(name);
        cm.setIcon(folded);
        cm.setVisible(true);
        cm.setEnabled(true);
        cm.setBorder(new LineBorder(grey, 2));
        cm.addMouseListener(mouse);
    }

    /**
     * check if card is folded
     *
     * @param card
     * @return
     */
    public boolean isFolded(CardManagement card) {
        if (card.getIcon() == folded) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * change state of card
     *
     * @param card
     */
    public void changeState(CardManagement card) {
        if (card.getIcon() == folded) {
            card.setIcon(card.getUnfold());
        } else {
            card.setIcon(folded);
        }
    }
    /**
     * check if two card are duplicate
     * @param card1
     * @param card2
     * @return 
     */
    public boolean checkDuplicate(JLabel card1, JLabel card2) {
        return card1.getName().equals(card2.getName());
    }

}
