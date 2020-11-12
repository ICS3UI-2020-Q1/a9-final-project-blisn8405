import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel gameScreen;
  JPanel titleScreen;
  JPanel attackScreen;

  JPanel mainPanel;

  JLabel pikachuHealth;
  JLabel radicateHealth;
  JLabel chooseaPokemon;
  JLabel attackInput;
  JLabel picture;
  JLabel picture2;
  
  ImageIcon charmanderImage;
  ImageIcon pikachuImage;
  ImageIcon pokemonImage;
  ImageIcon radicateImage;

  JButton pikachuButton;
  JButton turtwigButton;
  JButton charmanderButton;
  JButton radicateButton;
  JButton slashButton;
  JButton startButton;
  JButton attackButton;

  CardLayout screens;  

// create the array to store all the attacks
    String[] attacks = {"slam", "slash", "tackle"};
   // creating the random generator
   Random rand = new Random();

   // create a random number
    int randNum = rand.nextInt(2 - 1 +1) + 1;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Pokemon");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
   
    //create the game screen
    gameScreen = new JPanel();
    gameScreen.setLayout(null);

    
    //set up the button to change the image to what pokemon you choose
    pikachuButton = new JButton("pikachu");
    pikachuButton.addActionListener(this);
    pikachuButton.setActionCommand("pikachu");
    
    // set boundaries

    //set up the images
    pikachuImage = new ImageIcon("pikachu.jpg");
    pokemonImage = new ImageIcon("pokemon.png");

    //create a JLabel with an image
    picture = new JLabel(pikachuImage);
    picture.setBounds(0,0,800,500);
    picture.setLayout(null);
    picture2 = new JLabel(pokemonImage);
    picture2.setBounds(0,0,800,500);
    
     //create the middle labels
    attackInput = new JLabel("");

    //set the location and size
    attackInput.setBounds(300,250,100,40);

    
    //add pieces to the screen
    gameScreen.add(pikachuButton);
    gameScreen.add(picture);
    
    
    //set up the title screen
    titleScreen = new JPanel();
    titleScreen.setLayout(null);

   pikachuHealth = new JLabel("5");
   radicateHealth = new JLabel("5");
   pikachuHealth.setBounds(50,50,100,50);
   radicateHealth.setBounds(750,50,100,50);
    // create the button to start the game
    startButton = new JButton("BATTLE WITH PIKACHU");
    startButton.setBounds(400, 300, 200, 100);
   startButton.addActionListener(this);
   startButton.setActionCommand("start");

   //create the attackButton
   attackButton = new JButton("ATTACK");
   attackButton.setBounds(300, 500 ,100, 40);
   attackButton.addActionListener(this);
   attackButton.setActionCommand("attack");


   titleScreen.add(startButton);
   titleScreen.add(picture2);
   //create the screen JPanel manager
   screens = new CardLayout();
   
   mainPanel = new JPanel();
   mainPanel.setLayout(screens);

   // add screens to the card CardLayouts
   mainPanel.add(titleScreen, "titleScreen");
   mainPanel.add(gameScreen, "gameScreen");
   mainPanel.add(attackInput);
  gameScreen.add(attackButton);

  picture.add(pikachuHealth);
  picture.add(radicateHealth);
  
  

    frame.add(mainPanel);

    //sets the screen to show by asking the card CardLayout
    screens.show(mainPanel, "titleScreen");

   
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
     // get the text from each text boxes
   
    int pikachu = 5;
    int radicate = 5;

    if(command.equals("attack")){
      int choice2 = rand.nextInt();
      int choice1 = rand.nextInt();
      pikachu = pikachu - 1;
      radicate = radicate - 1;
       if(choice2 == 0){
        attackInput.setText("slam" + pikachu);
      }else 

       if(choice1 == 0){
         attackInput.setText("slam" + radicate);
       }else

       if(choice2 == 1){
         attackInput.setText("slash" + pikachu); 
       }else

       if(choice1 == 1){
         attackInput.setText("slash" + radicate);
       }else

       if(choice2 == 2){
         attackInput.setText("tackle" + pikachu);
       }else

       if(choice1 == 2){
         attackInput.setText("tackle" + radicate);
      } 
      
      
    }else if(command.equals("start")){
    //switch title screen to game screen
      screens.show(mainPanel, "gameScreen");
      }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
