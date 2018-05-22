package org.academiadecodigo.beerjammersgame.grid.position;

import org.academiadecodigo.beerjammersgame.grid.Grid;
import org.academiadecodigo.beerjammersgame.grid.GridColor;
import org.academiadecodigo.beerjammersgame.grid.GridDirection;

/**
 * Base skeleton for a grid position
 *
 * @see GridPosition
 */
public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;
    private GridColor color;
    private Grid grid;

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col   the column of the grid position
     * @param row   the row of the grid position
     * @param grid  the grid in which the position will be displayed
     */
    public AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.color = GridColor.NOCOLOR;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#setPos(int, int)
     */
    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    /**
     * @see GridPosition#getCol()
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * @see GridPosition#getColor()
     */
    @Override
    public GridColor getColor() {
        return color;
    }

    /**
     * @see GridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        this.color = color;
        show();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    /**
     * @see GridPosition#equals(GridPosition)
     */
    @Override
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }

    private void moveUp(int dist) {

        int maxRowsUp = Math.min(dist,getRow());
        setPos(getCol(), getRow() - maxRowsUp);

    }

    private void moveDown(int dist) {

        int maxRowsDown = Math.min((getGrid().getRows()) - (getRow() + 1), dist);
        setPos(getCol(), getRow() + maxRowsDown);

    }

    private void moveLeft(int dist) {

        int maxRowsLeft = Math.min(dist,getCol());
        setPos(getCol() - maxRowsLeft, getRow());

    }

    private void moveRight(int dist) {

        int maxRowsRight = Math.min(getGrid().getCols() - (getCol() + 1), dist);
        setPos(getCol() + maxRowsRight, getRow());
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                ", getColor=" + color +
                '}';
    }

}
