import java.awt.Container;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

public class UserInterface implements Runnable {

private JFrame frame;
private WormGame wormGame;

public UserInterface(WormGame wormGame) {
    this.wormGame = wormGame;
}

public void run() {
    frame = this.wormGame.getWorm().getFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.createCompoent(frame.getContentPane());
    frame.pack();
    frame.setVisible(true);
}

private void createCompoent(Container container) {
    DrawingBoard board = new DrawingBoard(this.wormGame);
    container.add(board);
    KeyboardListener kL = new KeyboardListener(this.wormGame);
    frame.addKeyListener(kL);
    container.setPreferredSize(new Dimension(this.wormGame.getfieldWidth(), this.wormGame.getfieldLength()));
   }
}
