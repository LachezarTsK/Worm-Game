import javax.swing.SwingUtilities;

public class Run {

public static void main(String[] args) {
    WormGame game = new WormGame(510, 510);
    UserInterface ui = new UserInterface(game);
    SwingUtilities.invokeLater(ui);
   }
}
