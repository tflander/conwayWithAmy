package conway;

import org.junit.Before;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridTest {
    Grid grid;

    @Before
    public void setUp() throws Exception {
        this.grid = new Grid(20, 30);
    }

    @Test
    public void createGrid() {

        assertThat(grid.getHeight()).isEqualTo(30);
        assertThat(grid.getWidth()).isEqualTo(20);

    }

    @Test
    public void setLiveGridValue() {

        grid.setCell(5,7, true);

        assertTrue(grid.getCell(5,7));

    }

    @Test
    public void setDeadGridValue() {

        grid.setCell(5,7, false);

        assertFalse(grid.getCell(5,7));
    }

    @Test
    public void countNeighborsWhenAllNeighborsAreDead() {
        int neighbors = grid.countNeighbors(5,7);

        assertThat(neighbors).isEqualTo(0);
    }

    @Test
    public void countNeighborsWhenAllNeighborsAreAlive() {
        grid.setCell(5, 7, true);
        grid.setCell(4,6, true);
        grid.setCell(4,7, true);
        grid.setCell(4,8, true);
        grid.setCell(5,6, true);
        grid.setCell(5,8, true);
        grid.setCell(6,6, true);
        grid.setCell(6,7, true);
        grid.setCell(6,8, true);

        int neighbors = grid.countNeighbors(5,7);

        assertThat(neighbors).isEqualTo(8);
    }

    @Test
    public void countNeighborsWhenCellIsAtZeroZero() {
        grid.setCell(0, 0, true);
        grid.setCell(0,1, true);
        grid.setCell(1,0, true);
        grid.setCell(1,1, true);

        int neighbors = grid.countNeighbors(0,0);

        assertThat(neighbors).isEqualTo(3);
    }



}
