Here is the complete program code for Worm Game, Exercise 49, Helsinki University's MOOC on Object Oriented Programming. 
The explanations throughout the code might seem too detailed but they are addressed to the learner, not the professional developer.
The structure of the program is not exactly like that proposed in the exercise of the course but the result is the same and there are some additonal features not required by the exercise. 
The program has the following logic:

 - The worm moves automatically across the board and its speed accelerates with every eaten apple.
 - The player can move the worm up, down, left and right with the arrow keys.
 - When the worm is shorter than three pieces it grows automatically with every move until the length of three pieces is reached.
 - If the worm eats an apple it grows by one piece with its next move.
 - If the worm runs into the frame of the field or into itself, the game is over. /If a few more lines of code are added that implement 
   a counter, we could determine after how many events of this type the game would be terminated./
 - The title of the field, i.e. the title of JFrame, is used as a dashboard display that shows the current number of eaten apples. 
   And if the worm runs into the frame of the field or into itself, it also shows the information about the respective event.
