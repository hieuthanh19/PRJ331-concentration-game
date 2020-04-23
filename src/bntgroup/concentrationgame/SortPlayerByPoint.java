/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

import java.util.Comparator;

/**
 *
 * @author Dell
 */
public class SortPlayerByPoint implements Comparator<Player>{
    @Override
    public int compare(Player player1, Player player2) {
        if (player1.getPoints() < player2.getPoints()) {
            return 1;
        }
        return -1;
    }

}
