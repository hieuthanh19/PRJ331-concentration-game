/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bntgroup.concentrationgame;

/**
 *
 * @author nhan
 */
public class Player {

    private String name;
    private String GameMode;
    private int Points;
    private int Time;

    public Player() {
    }

    public Player(String name, String GameMode, int Points, int Time) {
        this.name = name;
        this.GameMode = GameMode;
        this.Points = Points;
        this.Time = Time;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        while(name.isEmpty()==true){
            throw new Exception("name can't be empty!");
        }
        this.name = name;
    }

    public String getGameMode() {
        return GameMode;
    }

    public int getPoints() {           
        return Points;
    }

    public int getTime() {        
        return Time;
    } 
    
    public String Output(){
        return "|"+this.getName()+"|"+this.getPoints()+"|"+this.getGameMode()+"|"+this.getTime();   
    }

}
