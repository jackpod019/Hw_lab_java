package lab11;

import javax.swing.SwingUtilities;

public class Minesweeper {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MinesweeperFrame frame = new MinesweeperFrame();
            frame.setVisible(true);
        });
    }
}
