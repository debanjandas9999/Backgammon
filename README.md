Team Name - Static.
Team Members - Debanjan Das, Kabir Guglani, Shrey Rastogi.

Program - Backgammon 

Sprint 2 Objective -  To display the board with all the checkers on it along with a information panel and a text panel. The checkers should move aftert the dice is rolled. 

Work Approach - The entire project load has been equally divided among three of the team members. Shrey and myself, Debanjan have worked together to implement the board. We have painted the board using java swing and the paint component function where the class extends JComponent.

Important Note: The game starts only after the user enters how many points they want to play for.

We have divided the entire program into a few parts. Some of the main parts are:

1. Backgammon.java -  It is the class where the main is created. It consists of three frames - frame(board), frame1(announcementpane) and frame2 ( Input Screen). In this class, we create objects of other classes like infopanel, commandpanel, checkers, dice and other components of the board and we use that to add it to the frame. It also consists of the input screen where inputs are taken from both players. When the textfield is empty, it shows data is missing. If the names are same for both players, it shows that names cannot be same. Otherwise, when we click on submit, it gets redirected to the board frame. We also determine the possible moves that is possible for every player. If the player enters next, it moves on to the next player. If the player enters cheat, it goes to a default position and the game continues from there and if the user enters quit, the entire application closes. Before every turn, a player is asked if they want to double ther stakes or not. If they want to double, its upto the other player if they want to accept it or reject it.  

2. AnnouncementPane.java  - In this class, we design a screen having two options -  Start and Exit. If we click on start, it gets redirected to the input screen and if we click on exit, the frame closes immediately. We have also added a picture on the frame. We use a constructor AnnouncementPane() to take all the three frames as parameters from the main class and when we click on something, we close that particular frame and redirect it to the new frame.

3. CommandPanel.java - In this class, we create a text field where we can accept inputs from the user. According to the command entered, the checkers move on the board. For example, if the user enters 6 4, it moves the checker from pip 6 to pip 4.If the user enters next, the other player gets the turn. If you enter quit instead of a value, the application terminates. 

4. Infopanel.java - It creates an infopanel on the right side of the screen displaying all the instructions. It displays which player has which colour and which player makes the first move. After that, when a user enters a move on the command panel, it displays whose turn it is next. 

5.Turnmove.java -  In this class, we paint the dice and we create an object of this in the main class. After the user enters a move, the dice values changes. We also create 2 variables CHOICE and CHOICE2 which stores the values of both the dices and using that we compare which values is greater to determine which player makes the first move. The dice on the left is meant for player1 and the dice on the right is for player2 only for determining which player can play first. 

6. Checker.java - In this class, we paint checkers on all the pips and we also make sure how we are supposed to move the checkers after every move entered by the user. 

We combine all the components in the backgammon class and run the application. 


