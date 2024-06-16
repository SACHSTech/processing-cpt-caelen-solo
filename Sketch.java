import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
* A typing game with 10 levels
* @author: C.Yeung
*/ 

public class Sketch extends PApplet {
    // Import the images for the program(there is a lot)
    PImage lvl1;
    PImage lvl1b;
    PImage lvl2;
    PImage lvl2b;
    PImage lvl3;
    PImage lvl3b;
    PImage lvl4;
    PImage lvl4b;
    PImage lvl5;
    PImage lvl5b;
    PImage lvl6;
    PImage lvl6b;
    PImage lvl7;
    PImage lvl7b;
    PImage lvl8;
    PImage lvl8b;
    PImage lvl9;
    PImage lvl9message;
    PImage lvl10;
    PImage lvl10b;
    PImage Note1;
    PImage Note2;
    PImage Note3;
    PImage Note4;
    PImage Menu;
    PImage popup;
    PImage popup2;
    PImage popup3;
    PImage play;
    PImage option;
    PImage end;
    PImage speech1;
    PImage story;

    // Images for the cursors
    PImage cursor;
    PImage cursor2;
    PImage cursor3;
    PImage cursor4;
    PImage cursor5;
    PImage cursor6;
    PImage cursor7;
    PImage cursor8;
    PImage chosenCursor = null;
    
    // Images for cursor display 
    PImage cursorD1;
    PImage cursorD2;
    PImage cursorD3;
    PImage cursorD4;
    PImage cursorD5;
    PImage cursorD6;
    PImage cursorD7;
    PImage cursorD8;
    PImage cursorD9;

     // Importing fonts
     PFont def;
     PFont atarian;
     PFont dragon;

    // Use a 2D array to store all of the words for each level of the game
    String[][] wordSets = {
        {"attack", "vacuum", "words", "goblin", "type", "quack"},
        {"intense quacking", "duck", "George Washington", "spooky skeletons"},
        {"watermark", "business", "shutterstock", "Why is he so angry?", "chill out"},
        {"The Walking Duck", "Dawn of the Duck", "Ash vs Evil Duck", "28 Ducks Later", "Duckpocalypse"},
        {"taxes", "deadline", "audit", "receipts", "fraud", "deducktible expenses", "capital gains", "offshore accounts", "criminal investigation"},
        {"Duck Duck Goose", "Waddle Away", "Wise Quacker", "Peking", "Duck You!", "It's Duckin Time", "I'm running out of duck puns"},
        {"Bill", "Nye", "The", "Science", "Guy", "Why is Aristotle even here?", "I am so tired", "hello", "cat", "keyboard", "388934287", "zzzzzzzzzz"}, 
        {"I am bored.", "quackity quack.", "^&!^5#@)", "barbie", "java!", "flappy", "Goose", "adfjhajskdf", "bonjour!", "words words words", "letters", "e",},
        {"accept"},
        {"VACUUM!!!","GiVe it BACk!", "DYSON...", "TuRBoFLOw 6000W", "avAilabLe at wAlmart", "I. Will. Punch. You. In. The. Hand.", "Feel the wrath of my duck power.", "I need to go clean my floors.", "I worked minimum wage to buy that.", "QUACKKKKKKKK!", "mauvaise main", "quackity quack", "qauk", "qack", "qaueck", "qoak"},
        {" "}
    };

    // Variables for array index
    int wordIndex = 0;
    String currentWord;
    int letterIndex = 0;

    // Variables for the win condition checking
    boolean isFinished = false;
    boolean isVictory = false;
    boolean winAnimation = false;

    // Variables for the timer
    int startTime;
    int totalTime = 0;
    int defaultTime = 20000;
    int remainingTime = 0;

    // Variables for the size of the word display box
    int boxSizeX = 450;
    int boxSizeY = 80;

    // Boolean variables to check for certain conditions
    boolean unlock = true;
    boolean unlockR = false;
    boolean begin = false;
    boolean popupVisible = false;
    boolean popup2Visible = false;
    boolean popup3Visible = false;
    boolean storyVisible = false;
    boolean enterLock = true;
    boolean startLock = false;

    // Other Variables
    int scene = 0;
    int cursorValue = 1;
    int level = 0;
    int fontSize = 40;

    /**
    * Set the size of the screen
    * @author: C.Yeung
    */ 
    public void settings() {
        // Size of screen
        size(1280, 720);
    }

    /**
    * Load and resize the images, and set up some variables
    * @author: C.Yeung
    */ 
    public void setup() {
        // Load the level images
        lvl1 = loadImage("lvl1.png");
        lvl1b = loadImage("lvl1b.png");
        lvl2 = loadImage("lvl2.png");
        lvl2b = loadImage("lvl2b.png");
        lvl3 = loadImage("lvl3.png");
        lvl3b = loadImage("lvl3b.png");
        lvl4 = loadImage("lvl4.png");
        lvl4b = loadImage("lvl4b.png");
        lvl5 = loadImage("lvl5.png");
        lvl5b = loadImage("lvl5b.png");
        lvl6 = loadImage("lvl6.png");
        lvl6b = loadImage("lvl6b.png");
        lvl7 = loadImage("lvl7.png");
        lvl7b = loadImage("lvl7b.png");
        lvl8 = loadImage("lvl8.png");
        lvl8b = loadImage("lvl8b.png");
        lvl9 = loadImage("lvl9.png");
        lvl9message = loadImage("lvl9message.png");
        lvl10 = loadImage("lvl10.png");
        lvl10b = loadImage("lvl10b.png");

        // Load other images
        Note1 = loadImage("Note1.png");
        Note2 = loadImage("Note2.png");
        Note3 = loadImage("Note3.png");
        Note4 = loadImage("Note4.png");
        Menu = loadImage("Menu.png");
        popup = loadImage("popup1.png");
        popup2 = loadImage("popup2.png");
        popup3 = loadImage("popup3.png");
        option = loadImage("Options.png");
        speech1 = loadImage("speech1.png");
        play = loadImage("Play.png");
        end = loadImage("end.png");
        story = loadImage("story.png");

        // Load images for the cursor and resize them
        cursor = loadImage("cursor.png");
        cursor.resize(cursor.width/14, cursor.height/14);
        cursor2 = loadImage("cursor2.png");
        cursor2.resize(cursor2.width/14, cursor2.height/14);
        cursor3 = loadImage("cursor3.png");
        cursor3.resize(cursor3.width/14, cursor3.height/14);
        cursor4 = loadImage("cursor4.png");
        cursor4.resize(cursor4.width/14, cursor4.height/14);
        cursor5 = loadImage("cursor5.png");
        cursor5.resize(cursor5.width/14, cursor5.height/14);
        cursor6 = loadImage("cursor6.png");
        cursor6.resize(cursor6.width/14, cursor6.height/14);
        cursor7 = loadImage("cursor7.png");
        cursor7.resize(cursor7.width/14, cursor7.height/14);
        cursor8 = loadImage("cursor8.png");
        cursor8.resize(cursor8.width/14, cursor8.height/14);

        // Load images for the displayed cursor 
        cursorD1 = loadImage("cursordisplay1.png");
        cursorD2 = loadImage("cursordisplay2.png");
        cursorD3 = loadImage("cursordisplay3.png");
        cursorD4 = loadImage("cursordisplay4.png");
        cursorD5 = loadImage("cursordisplay5.png");
        cursorD6 = loadImage("cursordisplay6.png");
        cursorD7 = loadImage("cursordisplay7.png");
        cursorD8 = loadImage("cursordisplay8.png");
        cursorD9 = loadImage("cursordisplay9.png");

        // Load the custom fonts 
        atarian = createFont("AtarianB.ttf", 38);
        def = createFont("MontsB.ttf", 20);
        dragon = createFont("dragon.otf", 20);

        // Set the array and timer 
        setCurrentArray();
        startTime = millis();
    }

    /**
    * The main method to draw all the elements 
    * @author: C.Yeung
    */ 
    public void draw() {
        // Check to see which level the player is on
        if (level == 0){
            // Display the background and different buttons
            image(Menu, 0, 0);
            image(play, 0, 0);
            image(option, 0, 0);
            // Display the story page if the story button is pressed
            if(storyVisible){
                image(story, 0, 0);
            }
            // Display the more page if the story button is pressed
            if (popupVisible) {
                image(popup, 0, 0);
            }
            // Display the cursor page if the story button is pressed
            if (popup2Visible) {
                image(popup2, 0, 0);
                cursorDisplay();    
            }
            // Display the learn more page if the story button is pressed
            if (popup3Visible) {
                image(popup3, 0, 0);
            }
        // Create each game level from 1 to 10 
        }else if(level == 1){
            // Prevent the user from skipping levels with Enter key
            unlock = false;
            // Display level background
            image(lvl1, 0, 0);
            // Display level timer and other
            display();
        }else if(level == 2){
            unlock = false;
            image(lvl2, 0, 0);
            display();
        }else if(level == 3){
            unlock = false;
            image(lvl3, 0, 0);
            display();      
        }else if(level == 4){
            unlock = false;
            image(lvl4, 0, 0);
            display();
        }else if(level == 5){
            unlock = false;
            image(lvl5, 0, 0);
            display();       
        }else if(level == 6){
            unlock = false;
            image(lvl6, 0, 0);
            display();
        }else if(level == 7){
            unlock = false;
            image(lvl7, 0, 0);
            display();       
        }else if(level == 8){
            unlock = false;
            image(lvl8, 0, 0);
            display();        
        }else if(level == 9){
            unlock = false;
            image(lvl9, 0, 0);
            display();
            // Display a message
            image(lvl9message, 0, 0);       
        }else if(level == 10){
            unlock = false;
            image(lvl10, 0, 0);
            display();          
        }else if(level == 11){
            unlock = false;
            image(end, 0, 0);           
        }else{ 
            fill(255, 0, 0);
            rect(0, 0, 1000, 700);
        }      
    }
    
    /**
    * Let the user press enter to continue when they win, and press r to retry when they lose
    * @author: C.Yeung
    */  
    public void keyTyped() {
        // Check to see if the game is finished
        if (isFinished) return;
            // Check if the current letter typed matches the letter 
            if (key == currentWord.charAt(letterIndex)) {
                letterIndex++;
                // Start the timer once the first letter is typed
                if (!begin) {
                    begin = true; 
                    startTime = millis(); 
                }
            }
            // Check if the a full phrase has been typed
            if (letterIndex == currentWord.length()) {
                wordIndex++;
                if (wordIndex == wordSets[level - 1].length) {
                    isFinished = true;
                    isVictory = true;
                } else {
                    setCurrentArray();
                    letterIndex = 0;
                }
        }
    }

    /**
    * Let the user press enter to continue when they win, and press r to retry when they lose
    * @author: C.Yeung
    */
    public void keyPressed() {
        // Let the user press r to retry, as long as retry is unlocked
        if (unlockR){
            if (key == 'R' || key == 'r') { 
            retry();
            }
        }
        // Let the user press enter to move on, as long as enter is unlocked
        if (unlock){
            if (key == RETURN || key == ENTER) { 
                // Increase level count by 1
                if (level < 12) {
                level++;
                } else {
                level = 0; 
                }
                // Reset all elements per level
                resetTimer();
                wordIndex = 0;
                setCurrentArray();
                updateTotalTime();
                updateBoxSize();
                updateFontSize();
            }
        }
    }

    /**
    * Display the ui elements during the game
    * @author: C.Yeung
    */
    public void display(){
        // Chek to make sure the game is still ongoing
        if (!isFinished) {
            // Make a box with rounded corners 
            rectMode(CORNER);
            fill(255, 236, 166);
            rect(70, 550, boxSizeX, boxSizeY, 20);
            textFont(def);
            textSize(fontSize);
            // Letter spacing
            float spacing = 80; 
            // Fill the letters that get typed in green
            for (int i = 0; i < currentWord.length(); i++) {             
                if (i < letterIndex) {
                    fill(0, 255, 0);
                } else {
                    // Default to black
                    fill(0);
                }
                text(currentWord.charAt(i), spacing, 590);
                spacing += textWidth(currentWord.charAt(i));
            }
            // Make the timer
            timer();  
        } else {
            // Check to see if it is a win
            checkwin();
        }
    }

    /**
    * Creates the timer for each of the levels 
    * @author: C.Yeung
    */
    public void timer(){
        // Timer total time
        fill(255);
        rectMode(CORNER);
        rect(50, 50, width - 300, 20, 40);
        // Timer remaining time
        float countdownWidth = map(remainingTime, 0, totalTime, 0, width - 300);
        fill(255, 0, 0);
        rectMode(CORNER);
        rect(50, 50, countdownWidth, 20, 40);
        // Timer display box
        fill(184, 238, 255);
        rect(50, 70, 220, 50);
        // Timer text
        if(!begin){
            fill(255, 0, 0);
            textAlign(LEFT, CENTER);
            textFont(atarian);
            text("Time left: " + (totalTime / 1000) , 55, 95);
        }else{
            fill(255, 0, 0);
            textAlign(LEFT, CENTER);
            textFont(atarian);
            text("Time left: " + remainingTime / 1000 + "s", 55, 95);
        }
        // Display two notes for only before the first round
        if(!begin && level == 1){
            image(Note1, 0, 0);
            image(Note2, 0, 0);
           }
        // Display a note for only before the 5th round
        if(!begin && level == 5){
            image(Note3, 0, 0);
        }
        // Display a note before the 7th level
        if(!begin && level == 7){
            image(Note4, 0, 0); 
        }
        // Display a speech bubble before the 10th level
        if(!begin && level == 10){
            image(speech1, 0, 0);  
        }
        // Check if the game has begun
        if (!begin) return;
            int elapsedTime = millis() - startTime;
            remainingTime = totalTime - elapsedTime;

        if (remainingTime <= 0) {
            isFinished = true;
            isVictory = false;
            remainingTime = 0; 
        }
    }

    /**
    * Check if it is a win or a lost when the game ends
    * @author: C.Yeung
    */
    public void checkwin(){
        background(0);
        fill(255);
        textSize(64);
        textAlign(CENTER, CENTER);
        // Check if it is a win or lost
        if (isVictory) {
            winScreen();
        } else {
            loseScreen();
        }
    }

    /**
    * Display a screen when the player wins
    * @author: C.Yeung
    */ 
    public void winScreen(){
        // Display the different win screens corresponding to the specific level
        if(level == 1){
            // Display the specific image for the win screen
            image(lvl1b, 0, 0);

        }else if(level == 2){
            image(lvl2b, 0, 0);
            
        }else if(level == 3){
            image(lvl3b, 0, 0);

        }else if(level == 4){
            image(lvl4b, 0, 0);
        
        }else if(level == 5){
            image(lvl5b, 0, 0);
        
        }else if(level == 6){
            image(lvl6b, 0, 0);
        
        }else if(level == 7){
            image(lvl7b, 0, 0);
            
        }else if(level == 8){
            image(lvl8b, 0, 0);
            
        }else if(level == 9){
            image(lvl9, 0, 0);
            
        }else if(level == 10){
            image(lvl10b, 0, 0);

        }else{
            image(lvl1, 0, 0);
        }
            // Set font settings
            fill(0, 100); 
            rect(0, 0, width, height);
            textFont(dragon);
            fill(255); 
            textSize(130);
            textAlign(CENTER, CENTER);
            text("Victory!", width / 2, 200);
            textSize(32);
            text("Press ENTER to continue", width / 2, 600);
            // Unlock to let user press enter to continue
            unlock = true;
    }

    /**
    * Display a screen when the player loses the game
    * @author: C.Yeung 
    */ 
    public void loseScreen(){
        // Set font settings
        textFont(dragon);
        textSize(130);
        fill(255, 0, 0);
        text("YOU DIED.", width / 2, height / 2);
        textSize(32);
        text("Press R to retry ", width / 2, 600);
        // Unlock to let user press r to retry 
        unlockR = true;
    }

    /**
    * Creates buttons for the menu screen
    * @author: C.Yeung
    */ 
    public void mouseClicked(){
        // Button for story
        if (mouseX > 58 && mouseX < 430 && mouseY > 245 && mouseY < 414){
            storyVisible =! storyVisible;
            popupVisible = false;
            popup2Visible = false;
            popup3Visible = false;
        }       
        // Button for more
        if (mouseX > 58 && mouseX < 431 && mouseY > 479 && mouseY < 648) {
            popupVisible = !popupVisible;
        }
        // Button for cursor selection
        if (mouseX > 642 && mouseX < 1186 && mouseY > 153 && mouseY < 315) {
            popup2Visible = !popup2Visible;
        }       
        // Button for extra resources
        if (mouseX > 642 && mouseX < 1186 && mouseY > 392 && mouseY < 554){
            popup3Visible = !popup3Visible;  
        }
        
        // Check if extra resources page is open
        if (popup3Visible == true){
            // Button for link 1 - typing.com
            if (mouseX > 1132 && mouseX < 1208 && mouseY > 168 && mouseY < 244){
                link("https://www.typing.com");
            }
            // Button for link 2 - monkeytype.con
            if (mouseX > 1132 && mouseX < 1208 && mouseY > 301 && mouseY < 377){
                link("https://monkeytype.com");
            }
        }

        // Button to go back to the last page
        if (popup2Visible == true || popup3Visible == true || storyVisible == true || popupVisible == true){
            if (mouseX > 786 && mouseX < 1081 && mouseY > 576 && mouseY < 648){
                // Close the popups
                popup2Visible = false;
                popup3Visible = false;
                storyVisible = false;
            }
        }

        // Button to change cursors
        if (popup2Visible == true){
            // left button
            if (mouseX > 616 && mouseX < 736 && mouseY > 300 && mouseY < 420) {
                cursorValue = (cursorValue - 1 + 9) % 9;
            }       
            // right button
            if (mouseX > 1131 && mouseX < 1251 && mouseY > 300 && mouseY < 420) {
                cursorValue = (cursorValue + 1) % 9;
            }
        }
        
        // Change the cursor according to what the user selects
        if (cursorValue == 1){
            // Change the cursor 
            cursor(cursor, 0, 0);
        }else if(cursorValue == 2){
            cursor(cursor2, 0, 0);
        }else if(cursorValue == 3){
            cursor(cursor3, 0, 0);
        }else if(cursorValue == 4){
            cursor(cursor4, 0, 0);            
        }else if(cursorValue == 5){
            cursor(cursor5, 0, 0);           
        }else if(cursorValue == 6){
            cursor(cursor6, 0, 0);           
        }else if(cursorValue == 7){
            cursor(cursor7, 0, 0);       
        }else if(cursorValue == 8){
            cursor(cursor8, 0, 0);
        }else if(cursorValue == 0){
            // Change the cursor to the default arrow cursor
            cursor(ARROW);
        }
    }

    /**
    * Displays the cursor as the user changes it
    * @author: C.Yeung
    */ 
    public void cursorDisplay(){
        if (cursorValue == 1){
            // Display the name of the cursor 
            cursorText();
            text("BLUE", 937, 110);
            // Display the image of the cursor
            image(cursorD1, 0, 0);

        }else if(cursorValue == 2){
            cursorText();
            text("WALTER", 937, 110);
            cursor(cursor2, 0, 0);
            image(cursorD2, 0, 0);

        }else if(cursorValue == 3){
            cursorText();
            text("WADDLE", 937, 110);
            cursor(cursor3, 0, 0);
            image(cursorD3, 0, 0);          

        }else if(cursorValue == 4){
            cursorText();
            text("SHUBA DUCK", 937, 110);
            cursor(cursor4, 0, 0);
            image(cursorD4, 0, 0);
            
        }else if(cursorValue == 5){
            cursorText();
            text("PSYDUCK", 937, 110);
            cursor(cursor5, 0, 0);
            image(cursorD5, 0, 0);
            
        }else if(cursorValue == 6){
            cursorText();
            text("DONALD DUCK", 937, 110);
            cursor(cursor6, 0, 0);
            image(cursorD6, 0, 0);
            
        }else if(cursorValue == 7){
            cursorText();
            text("DUCK.IRL", 937, 110);
            cursor(cursor7, 0, 0);
            image(cursorD7, 0, 0);
            
        }else if(cursorValue == 8){
            cursorText();
            text("DUCK WITH KNIFE", 937, 110);
            cursor(cursor8, 0, 0);
            image(cursorD8, 0, 0);
            
        }else if(cursorValue == 0){
            cursorText();
            text("DEFAULT", 937, 110);
            cursor(ARROW);  
            image(cursorD9, 0, 0); 
        }
    }

    /**
    * Sets font settings for the text on the cursor page
    * @author: C.Yeung
    */  
    public void cursorText(){
        // Set font to default
        textFont(def);
        fill(0); 
        textSize(130);
        textSize(52);
        textAlign(CENTER);
    }

    /**
    * Resets the timer 
    * @author: C.Yeung
    */  
    public void resetTimer() {
        // Reset all the elements of the timer for a new level
        begin = false; 
        startTime = millis(); 
        remainingTime = totalTime; 
        isVictory = false;
        isFinished = false;
    }

    /**
    * Updates the box size for certain levels
    * @author: C.Yeung
    */
    public void setCurrentArray() {
        // Move onto the next set of words whenever a level is passed
        if (level > 0 && level <= wordSets.length) {
            currentWord = wordSets[level - 1][wordIndex];
            // Reset letter index when setting a new word
            letterIndex = 0; 
        } else {
            currentWord = "";
        }
    }

    /**
    * Resets the timer and last word when the user presses "r"
    * @author: C.Yeung
    */   
    public void retry(){
        // Resets the timer
        resetTimer();
        // Resets the last word
        letterIndex = 0;
        // Lock retry to prevent retrying during a level
        unlockR = false;
    }

    /**
    * Updates the total time for certain levels
    * @author: C.Yeung
    */
    public void updateTotalTime() {
        if (level == 6) {
            totalTime = 35000;
        }
        else if(level == 5){
            totalTime = 25000;

        }else if(level == 10){
            totalTime = 95000;

        }else if(level == 8){
            totalTime = 50000;

        }else if(level == 7){
            totalTime = 35000;

        }else {
            totalTime = defaultTime;     
        }
    }

    /**
    * Updates the box size for certain levels
    * @author: C.Yeung
    */
    public void updateBoxSize() {
        if (level == 6) {
            boxSizeX = 600;
            boxSizeY = 80;
        }else if(level == 5) {
            boxSizeX = 510;
            boxSizeY = 80;
        }else if(level == 7) {
            boxSizeX = 550;
            boxSizeY = 80;
        }else if(level == 10) {
            boxSizeX = 650;
            boxSizeY = 80;
        }
         else {
            boxSizeX = 500;
            boxSizeY = 80;
        }
    }

    /**
    * Updates the font size for certain levels
    * @author: C.Yeung
    */
    public void updateFontSize(){
        if (level == 10) {
            fontSize = 32;
        }else if (level == 7) {
            fontSize = 36;
        }else if (level == 7) {
            fontSize = 32;
        } else {
            fontSize = 40;
        }
    }
}
