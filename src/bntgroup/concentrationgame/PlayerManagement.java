/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nhan
 */
public class PlayerManagement {

    private int numOfPlayer;
    private List<Player> listPlayer;
    private String P_FILE;

    public PlayerManagement(String P_FILE) throws IOException {
        if (P_FILE.equals("")) {
            throw new IOException("File URL can't be empty");
        }
        this.P_FILE = P_FILE;
        this.numOfPlayer = 0;
        this.listPlayer = new ArrayList<>();
    }

    public List<Player> getListPlayer() {
        return listPlayer;
    }

    
    public void saveFile() throws IOException {
        //overwrite data file
        FileWriter fw = new FileWriter(new File(P_FILE), false);
        try {
            fw.append(String.valueOf(numOfPlayer) + "\n");
            for (Player s : this.listPlayer) {
                String name = s.getName();
                String gameMode = s.getGameMode();
                int score = s.getPoints();
                int time = s.getTime();

                //Write data into file
                fw.append(name + "\n");
                fw.append(gameMode + "\n");
                fw.append(String.valueOf(score) + "\n");
                fw.append(String.valueOf(time) + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error!!! File writing fault!!!" + ex);
        }
    }

    public void loadFile() throws IOException {
        try {
            File fFile = new File(P_FILE);
            //Checks is file created
            if (!fFile.exists()) {
                fFile.createNewFile(); //If not, creates new file
                this.numOfPlayer = 0; //New data file with the number of player is 0
            } else {
                FileReader fr = new FileReader(this.P_FILE);
                BufferedReader br = new BufferedReader(fr); //ho tro doc tren tung dong
                try {
                    String line, name, gameMode, score, time;
                    line = br.readLine();
                    this.numOfPlayer = Integer.parseInt(line);
                    for (int i = 0; i < this.numOfPlayer; i++) {
                        //read player infomations
                        name = br.readLine();
                        gameMode = br.readLine();
                        score = br.readLine();
                        time = br.readLine();
                        //create new player
                        this.listPlayer.add(new Player(name, gameMode, Integer.parseInt(score), Integer.valueOf(time)));
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found!!!");
                }
            }

        } catch (IOException ex) {
            System.out.println("File not found!!!");
        }
    }

    /**
     * Create new player with empty info
     *
     * @param name
     */
    public void addPlayer(String name) {
        this.listPlayer.add(new Player(name, "none", 0, 0));
        this.numOfPlayer++;
    }

    /**
     * search for player in list
     *
     * @param name
     * @return
     */
    private int searchPlayer(String name) {
        for (int i = 0; i < listPlayer.size(); i++) {
            if (listPlayer.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * get score of player
     *
     * @param name
     * @return
     */
    public int getScore(String name) {
        int position = searchPlayer(name);
        if (position != -1) {
            return listPlayer.get(position).getPoints();
        }
        return -1;
    }

    //change data of current player
    public void changeData(String name, String gameMode, int score, int time) {
        int position = searchPlayer(name);
        if (position == -1) {
            System.out.println("Error! Player not found!");
        } else {
            listPlayer.set(position, new Player(name, gameMode, score, time));
        }
    }

    public void outputList() {
        for (Player s : listPlayer) {
            System.out.println(s.Output());
        }
    }

    public void sort() {
        Collections.sort(listPlayer, new SortPlayerByPoint());       
    }

    /**
     * Check if player name is duplicate
     *
     * @param name
     * @return
     */
    public boolean isExist(String name) {
        for (Player p : listPlayer) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
