package project3;

/**
 * This class represents 2D coordinates of a square in the maze.
 * @author Joanna Klukowska
 *
 */
public class Location {
    //row and column locations
    private int row;
    private int column;

    /**
     * Create a Location object given row and column.
     * @param row the zero based row number
     * @param column the zero based column number
     */
    public Location ( int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns row of a position.
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns column of a position.
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Checks obj and this Location object for equality. Two Location objects
     * are equal if their rows and columns are the same.
     * @return true if obj is equal to this object, false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

    /**
     * Generates the string representation of this Location object in the formal
     *    row: ROW, col: COL
     * where ROW and COL are replaced by their numerical values.
     * @return the string representation of this maze
     */
    public String toString() {
        return String.format("row: %2d, col: %2d", row, column );
    }

}
