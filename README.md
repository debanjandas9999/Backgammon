Team Name - Static.
Team Members - Debanjan Das, Kabir Guglani, Shrey Rastogi.

Program - Backgammon 

Sprint 1 Objective -  To display the board with all the checkers on it along with a information panel and a text panel. The checkers should
move atleast once in the board for both opponents.

Work Approach - The entire project load has been equally divided among three of the team members. Shrey and myself, Debanjan have worked together to 
implement the board. We have painted the board using java swing and the paint component function where the class extends JComponent.
We have the drawrect function to paint the board after which we have used the drawpolygon and drawoval for the triangles and the checkers 
respectively. Kabir has worked on the checker class giving all the atrributes needed for it. He made sure that the checker can move 
on the board. We have a green checker placed on the board and if we click on that, it moves to the other side of the board. This has 
been achieved by using a mouse listener.

Then, we have all worked on the main application where we create a frame first using Jframe. We give a title to it and also define a 
size for it. We create an object board of the class boardcomponent and we add that board to the frame. Similarly, we create an object checker 
of the Class Checker and add it to the frame. We also add the mouselistener to one of the checkers to display that it's moving.



