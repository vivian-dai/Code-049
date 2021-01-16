//swing imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//util imports
import java.util.ArrayList;

/**
 * [Player.java]
 * Stores information about the player
 * @author Damon Ma, Edward Yang, and Vivian Dai
 * @version 1.0 on January 5, 2021
 */

abstract class Player {
    /** Username of the player */
    private String username;
    /** client that this player needs to communicate to */
    private Client playerClient;
    /**The opponent this player will be playing against. */
    private String opponent;
    /** A list of all frames */
    private ArrayList<JFrame> gameFrames;
    /**An arrayList of enemy humans. */
    private ArrayList<Human> humans;
    /**An arrayList of enemy buildings. */
    private ArrayList<Building> buildings;
    /** An ArrayList of all events.*/
    private ArrayList<Event> events;
    /**An arraylist of all SCPs in the game. */
    private ArrayList<SCP0492> scps;

    /**
     * Constructor for the {@code Player} class
     * @param username the username of the {@code Player}
     * @param playerClient The client program of the player that connected to the server.
     * @param opponent The username of the opponent that the player will play against.
     */
    public Player(String username, Client playerClient, String opponent){
        this.username = username;
        this.playerClient = playerClient;
        this.opponent = opponent;
        this.gameFrames = new ArrayList<JFrame>();
        this.humans = new ArrayList<Human>();
        this.buildings = new ArrayList<Building>();
        this.events = new ArrayList<Event>();
        this.scps = new ArrayList<SCP0492>();
    }

    /**
     * Gets the JFrames in the game
     * @return gameFrames, the frames in the game
     */
    public ArrayList<JFrame> getGameGraphics(){
        return this.gameFrames;
    }

    /**
     * Tells the player what side they will be playing on
     * @param side The side that the player will be playing as
     */
    public void displaySide(String side){
        String welcomeMessage = "Welcome player " + this.username + "! You will be playing as the " + side + "against " + this.opponent + "! Your objective is to";
        //TODO: PLaceholder instructions, may be subject to change at the end of the game
        if (side.equals("Town")){
            welcomeMessage += "survive the SCP invasion for 10 turns!";
        }else if (side.equals("SCP")){
            welcomeMessage += "destroy the town in 10 turns!";
        }else{ //TODO: This block of the if statement is temporary (for testing)
            System.out.println("An error has occured");
        }//end of if statement blockl

        welcomeMessage += "Good luck, and may the best player win...";


        new WelcomeWindow(welcomeMessage).run();
        
    }

    /**
     * Abstract method starts the game.
     */
    public abstract void start();

    /**
     * Abstract method starts the next turn of the game.
     */
    public abstract void startTurn();

    /**
     * Abstract method ends the current turn of the game.
     */
    public abstract void endTurn();

    //TODO: abstract method for client-game transactions.


    //start of getters

    /**
     * Gets the username of the player.
     * @return The username.
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Gets the opponent's username.
     * @return The username.
     */
    public String getOpponent(){
        return this.opponent;
    }


    /**
     * Gets all of the player's SCP0492's.
     * @return The player's SCP0492's.
     */
    public  ArrayList<SCP0492> getSCPs(){
        return this.scps;
    }




    /**
     * Gets the list of human NPC's.
     * @return The list of humans.
     */
    public ArrayList<Human> getHumans(){
        return this.humans;
    }

    /**
     * Gets the list of buildings.
     * @return The list of buildings.
     */
    public ArrayList<Building> getBuildings(){
        return this.buildings;
    }

    /**
     * Gets the list of events in the game.
     * @return The list of game events.
     */
    public ArrayList<Event> getEvents(){
        return this.events;
    }
    //end of getters


    //start of setters



    /**
     * Updates all game objects at the end of the turn.
     * @param humans The new list of humans.
     * @param buildings The new list of buildings.
     * @param events The new list of events.
     * @param scps The new list of SCP0492s.
     */
    public void updateGameObjects(ArrayList<Human> humans, ArrayList<Building> buildings, ArrayList<Event> events, ArrayList<SCP0492> scps){
        this.humans = (ArrayList<Human>)humans.clone();
        this.buildings = (ArrayList<Building>)buildings.clone();
        this.events = (ArrayList<Event>)events.clone();
        this.scps = (ArrayList<SCP0492>)scps.clone();
    }

    /**
     * Sets all of the human NPC's.
     * @param humans The list of humans.
     */
    public void setHumans(ArrayList<Human> humans){
        this.humans = humans;
    }

    /**
     * Sets the list of all SCP0492 NPC's.
     * @param scps The list of SCP0492's.
     */
    public void setSCPs(ArrayList<SCP0492> scps){
        this.scps = scps;
    }


    /**
     * Sets the list of all game events.
     * @param events The list of events.
     */
    public void setEvents(ArrayList<Event> events){
        this.events = events;
    }

    /**
     * Sets the list of all buildings.
     * @param buildings The list of buildings.
     */
    public void setBuildings(ArrayList<Building> buildings){
        this.buildings = buildings;
    }

    //end of setters


    /**
     * Inner class to display the welcome window to the player at the beginning of the game.
     */
    public class WelcomeWindow{
        /**The JFrame and window the the welcome window */
        private JFrame window;
        /**The Jpanel that will hold the JTextArea */
        private JPanel mainPanel;
        /**The welcome message to be displayed to the player. */
        private String welcomeMessage;
        /**The JTextArea used to display the welcome message to the player.*/
        private JTextArea welcomeBox;


        /**
         * Constructor for the WelcomeWindow.
         * @param welcomeMessage The welcome message for the player.
         */
        public WelcomeWindow(String welcomeMessage){
            this.welcomeMessage = welcomeMessage;
        }

        /**
         * Runs the WelcomeWindow.
         */
        public void run(){
            this.window = new JFrame("Now entering Code-049!");
            this.mainPanel = new JPanel();
            this.welcomeBox = new JTextArea(welcomeMessage);

            //set the window
            this.window.setSize(500, 500);
            this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //set the main JPanel
            this.mainPanel.setBounds(0,0,500,500);
            this.window.add(this.mainPanel);

            //set the text box
            this.welcomeBox.setBounds(0,0,500,500);
            this.welcomeBox.setEditable(false);
            this.mainPanel.add(this.welcomeBox);
            
            //allow player to see this window
            this.window.setVisible(true);


        }//end of method

    }//end of inner class

}//end of class