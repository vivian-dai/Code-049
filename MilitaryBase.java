/**
 * [MilitaryBase.java]
 * A MilitaryBase building that can train store and move soldiers
 * @author Edward Yang
 * @version 0.1 Decemeber 26th 2020
 */

import java.awt.Image;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

class MilitaryBase extends Military{

    private ArrayList<Human> soldiers = new ArrayList<>();

    /**
     * Military base constructor
     * Creates a new MilitaryBase building
     * @param initialPrice initial price of building
     * @param maxHealth max health of the building
     * @param health current health of building
     * @param sprite image of building
     * @param x x coordinate of building
     * @param y y coordinate of building
     */
    MilitaryBase(int initialPrice, int maxHealth, int health, Image sprite, int x, int y){

        super(initialPrice, maxHealth, health, sprite, x, y);
    }

    
    //class methods

    /** 
     * @param number The number of troops to train 
     * @param type The type of troop to train 
     */
    public void trainTroops(int number, String type){
        //TODO: figure out trainTroops mechanic
    }


    
    /** 
     * @param repair the amount to repair 
     */
    //inherited methods
    public void repair(int repair){

        //TODO: figure out repair mechanic
    }

    
    /** 
     * @return String format of the object
     */
    public String toString(){
        String stringToReturn = "";

        return stringToReturn;

    }
    
    
    /** 
     * @param damage the damage that the building is going to take
     */
    public void takeDamage(int damage){

        this.setHealth(this.getHealth() - damage);
        //TODO: maybe different building have different damage taking mechanics
    }
    

    
    /** 
     * @param g the graphics variable to draw the building on
     */
    public void draw(Graphics g){

        g.drawImage(this.getImage(), this.getX(), this.getY(), Color.BLACK, null);
        //Military base has a black background 
    }


}
