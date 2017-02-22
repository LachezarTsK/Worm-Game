import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class DrawingBoard extends JPanel implements ActionListener {

private WormGame wormGame;
/*"Timer" sets the speed with which the worm moves.
Since in our case the worm accelerates with every eaten apple through 
"Thread.sleep()" applied in method "action()", class "WormGame", the "Timer" here 
sets the maximum speed. 
In other words:
the initial speed (i.e. delay in the movement of the worm) is the sum of 
the value of the integer in "Timer", which is 400, plus the value of the integer in 
"Thread.sleep", which is 1500, totalling to 1900.   
So, theoretically the value in "Thread.sleep" could be reduced to nearly zero, thus 
the maximum speed of 400 milliseconds delay remains the upper speed limit. 
Of course these values could be changed as per the desire of the player.*/
Timer tm = new Timer(400, this);

public DrawingBoard(WormGame wormGame) {
    this.wormGame = wormGame;
    super.setBackground(Color.WHITE);
}
/*this method paints the initial positions of the apple and the worm*/
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    for (Piece w : this.wormGame.getWorm().getPieces()) {
        g.fill3DRect(w.getX(), w.getY(), w.getWidth(), w.getLength(), true);
    }
    g.setColor(Color.RED);
    g.fillOval(this.wormGame.getApple().getX(), this.wormGame.getApple().getY(),
            this.wormGame.getApple().getWidth(), this.wormGame.getApple().getLength());
    tm.start();
}
/*this method paints the positions of the apple and the worm as they move across the board*/
public void actionPerformed(ActionEvent event) {
    this.wormGame.action();
    repaint();
   }
}
