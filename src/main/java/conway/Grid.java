package conway;

public class Grid {

    int height;
    int width;
    boolean[][] grid;

    public Grid(int width, int height) {
        this.height = height;
        this.width = width;
        this.grid = new boolean [width][height];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setCell(int x, int y, boolean isAlive) {
        grid[x][y] = isAlive;
    }

    public boolean getCell(int x, int y) {
        return isAlive(x, y);

    }

    public int countNeighbors(int x, int y) {
        int count = 0;

        for(int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (isAlive(x + i, y + j)){
                    if(isNotSelf(i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isNotSelf(int i, int j) {
        return i != 0 || j !=0;
    }

    private boolean isAlive(int i, int i2) {
        return grid[i][i2];
    }
}
