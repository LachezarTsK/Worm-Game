import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyboardListener implements KeyListener {

private WormGame wormGame;

public KeyboardListener(WormGame wormGame) {
    this.wormGame = wormGame;
}

@Override
public void keyPressed(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        this.wormGame.getWorm().setDirection(Direction.LEFT);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        this.wormGame.getWorm().setDirection(Direction.RIGHT);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        this.wormGame.getWorm().setDirection(Direction.DOWN);
    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        this.wormGame.getWorm().setDirection(Direction.UP);
    }
}

@Override
public void keyReleased(KeyEvent e) {
}

@Override
public void keyTyped(KeyEvent e) {
   }
}
