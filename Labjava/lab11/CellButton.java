package lab11;

import javax.swing.JButton;

public class CellButton extends JButton {
    private static final long serialVersionUID = 1L;

    private final int cellX;
    private final int cellY;

    public CellButton(int x, int y) {
        super();
        this.cellX = x;
        this.cellY = y;
        setFocusPainted(false);
    }

    public int getCellX() { return cellX; }
    public int getCellY() { return cellY; }
}
