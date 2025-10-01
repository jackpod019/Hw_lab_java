package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MinesweeperFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private final JLabel minesLabel = new JLabel();
    private final JLabel statusLabel = new JLabel();
    private final JPanel boardPanel = new JPanel();

    private GameModel gameModel;
    private CellButton[][] buttons;

    public MinesweeperFrame() {
        super("Minesweeper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new Dimension(420, 480));

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        minesLabel.setFont(minesLabel.getFont().deriveFont(Font.BOLD, 14f));
        statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        statusLabel.setFont(statusLabel.getFont().deriveFont(13f));
        topBar.add(minesLabel, BorderLayout.WEST);
        topBar.add(statusLabel, BorderLayout.EAST);

        add(topBar, BorderLayout.NORTH);
        add(new JScrollPane(boardPanel), BorderLayout.CENTER);

        startNewGame();
        pack();
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> startNewGame());

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        quitItem.addActionListener(e -> dispose());

        gameMenu.add(newItem);
        gameMenu.addSeparator();
        gameMenu.add(quitItem);
        bar.add(gameMenu);
        return bar;
    }

    private void startNewGame() {
        // Fixed configuration: 9x9 board, 10 mines
        this.gameModel = new GameModel(9, 9, 10);
        minesLabel.setText("Mines: " + gameModel.getRemainingMinesText());
        statusLabel.setText("Left click: open, Right click: flag");

        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(gameModel.getHeight(), gameModel.getWidth(), 0, 0));
        buttons = new CellButton[gameModel.getHeight()][gameModel.getWidth()];

        for (int y = 0; y < gameModel.getHeight(); y++) {
            for (int x = 0; x < gameModel.getWidth(); x++) {
                CellButton btn = new CellButton(x, y);
                btn.setPreferredSize(new Dimension(28, 28));
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.setFont(btn.getFont().deriveFont(Font.BOLD, 14f));

                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (!btn.isEnabled()) return;
                        if (SwingUtilities.isRightMouseButton(e)) {
                            gameModel.toggleFlag(btn.getCellX(), btn.getCellY());
                            refreshCell(btn.getCellX(), btn.getCellY());
                            minesLabel.setText("Mines: " + gameModel.getRemainingMinesText());
                            checkEndIfNeeded();
                        } else if (SwingUtilities.isLeftMouseButton(e)) {
                            List<Point> revealed = gameModel.reveal(btn.getCellX(), btn.getCellY());
                            for (Point p : revealed) {
                                refreshCell(p.x, p.y);
                            }
                            checkEndIfNeeded();
                        }
                    }
                });

                buttons[y][x] = btn;
                boardPanel.add(btn);
                refreshCell(x, y);
            }
        }

        boardPanel.revalidate();
        boardPanel.repaint();
        pack();
    }

    private void refreshCell(int x, int y) {
        CellButton btn = buttons[y][x];
        GameModel.Cell cell = gameModel.getCell(x, y);

        btn.setEnabled(!cell.isRevealed());
        btn.setBackground(btn.isEnabled() ? new Color(235, 235, 235) : Color.WHITE);
        btn.setForeground(getNumberColor(cell.getNeighborMines()));

        if (cell.isRevealed()) {
            if (cell.isMine()) {
                btn.setText("💣");
            } else {
                btn.setText(cell.getNeighborMines() == 0 ? "" : Integer.toString(cell.getNeighborMines()));
            }
        } else {
            if (cell.isFlagged()) {
                btn.setText("🚩");
            } else {
                btn.setText("");
            }
        }
    }

    private Color getNumberColor(int n) {
        switch (n) {
            case 1: return new Color(0, 102, 204);
            case 2: return new Color(0, 153, 0);
            case 3: return new Color(204, 0, 0);
            case 4: return new Color(102, 0, 153);
            case 5: return new Color(153, 0, 0);
            case 6: return new Color(0, 153, 153);
            case 7: return Color.BLACK;
            case 8: return Color.DARK_GRAY;
            default: return Color.GRAY;
        }
    }

    private void checkEndIfNeeded() {
        if (gameModel.isExploded()) {
            revealAllMines();
            statusLabel.setText("Game Over — New to restart");
            disableAll();
        } else if (gameModel.isWin()) {
            statusLabel.setText("You Win! 🎉");
            disableAll();
        }
    }

    private void revealAllMines() {
        for (int y = 0; y < gameModel.getHeight(); y++) {
            for (int x = 0; x < gameModel.getWidth(); x++) {
                GameModel.Cell c = gameModel.getCell(x, y);
                if (c.isMine()) {
                    c.setRevealed(true);
                    refreshCell(x, y);
                }
            }
        }
    }

    private void disableAll() {
        for (int y = 0; y < gameModel.getHeight(); y++) {
            for (int x = 0; x < gameModel.getWidth(); x++) {
                buttons[y][x].setEnabled(false);
            }
        }
    }

    
}




