package lab11;


import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

class GameModel {
    private final int width;
    private final int height;
    private final int totalMines;
    private final Cell[][] cells;

    private boolean minesPlaced;
    private boolean exploded;
    private int flagsPlaced;
    private int revealedSafeCells;

    GameModel(int width, int height, int totalMines) {
        this.width = width;
        this.height = height;
        this.totalMines = totalMines;
        this.cells = new Cell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell();
            }
        }
        this.minesPlaced = false;
        this.exploded = false;
        this.flagsPlaced = 0;
        this.revealedSafeCells = 0;
    }

    int getWidth() { return width; }
    int getHeight() { return height; }
    Cell getCell(int x, int y) { return cells[y][x]; }

    String getRemainingMinesText() {
        int remaining = Math.max(0, totalMines - flagsPlaced);
        return remaining + "/" + totalMines;
    }

    boolean isExploded() { return exploded; }

    boolean isWin() {
        return !exploded && (revealedSafeCells == (width * height - totalMines));
    }

    void toggleFlag(int x, int y) {
        Cell c = cells[y][x];
        if (c.revealed) return;
        if (c.flagged) {
            c.flagged = false;
            flagsPlaced = Math.max(0, flagsPlaced - 1);
        } else {
            c.flagged = true;
            flagsPlaced = Math.min(totalMines, flagsPlaced + 1);
        }
    }

    List<Point> reveal(int startX, int startY) {
        List<Point> changed = new ArrayList<>();
        if (exploded) return changed;
        Cell start = cells[startY][startX];
        if (start.revealed || start.flagged) return changed;

        if (!minesPlaced) {
            placeMinesAvoiding(startX, startY);
            computeNeighborNumbers();
            minesPlaced = true;
        }

        if (start.isMine) {
            // First click can still be a mine only if mines already placed and user clicked a mine
            start.revealed = true;
            exploded = true;
            changed.add(new Point(startX, startY));
            return changed;
        }

        // Flood fill: reveal contiguous zeros and fringe numbers
        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(startX, startY));
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            Cell c = cells[p.y][p.x];
            if (c.revealed || c.flagged) continue;
            c.revealed = true;
            changed.add(new Point(p.x, p.y));
            if (!c.isMine) revealedSafeCells++;

            if (c.neighborMines == 0) {
                for (int ny = Math.max(0, p.y - 1); ny <= Math.min(height - 1, p.y + 1); ny++) {
                    for (int nx = Math.max(0, p.x - 1); nx <= Math.min(width - 1, p.x + 1); nx++) {
                        if (nx == p.x && ny == p.y) continue;
                        Cell nc = cells[ny][nx];
                        if (!nc.revealed && !nc.flagged && !nc.isMine) {
                            stack.push(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        return changed;
    }

    private void placeMinesAvoiding(int avoidX, int avoidY) {
        Random rnd = new Random();
        int placed = 0;
        while (placed < totalMines) {
            int x = rnd.nextInt(width);
            int y = rnd.nextInt(height);
            if ((x == avoidX && y == avoidY) || cells[y][x].isMine) continue;
            cells[y][x].isMine = true;
            placed++;
        }
    }

    private void computeNeighborNumbers() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (cells[y][x].isMine) {
                    cells[y][x].neighborMines = -1;
                    continue;
                }
                int count = 0;
                for (int ny = Math.max(0, y - 1); ny <= Math.min(height - 1, y + 1); ny++) {
                    for (int nx = Math.max(0, x - 1); nx <= Math.min(width - 1, x + 1); nx++) {
                        if (nx == x && ny == y) continue;
                        if (cells[ny][nx].isMine) count++;
                    }
                }
                cells[y][x].neighborMines = count;
            }
        }
    }

    static class Cell {
        boolean isMine;
        boolean revealed;
        boolean flagged;
        int neighborMines;

        boolean isMine() { return isMine; }
        boolean isRevealed() { return revealed; }
        boolean isFlagged() { return flagged; }
        int getNeighborMines() { return neighborMines; }

        void setRevealed(boolean r) { this.revealed = r; }
    }
}



