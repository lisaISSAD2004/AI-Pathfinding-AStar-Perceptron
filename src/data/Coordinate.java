package data;

import java.util.Objects;

public class Coordinate {
    private int line;
    private int column;

    public Coordinate(int line, int column) {
        if (line < 0 || column < 0) {
            throw new IllegalArgumentException("Les valeurs de line et column doivent être positives.");
        }
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Coordinate [line=" + line + ", column=" + column + "]";
    }

    public double calculateDistance(Coordinate cellCoordinate) {
        if (cellCoordinate == null) {
            throw new IllegalArgumentException("La coordonnée fournie ne peut pas être null.");
        }
        return Math.sqrt(Math.pow(cellCoordinate.getLine() - this.line, 2)
                + Math.pow(cellCoordinate.getColumn() - this.column, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate that = (Coordinate) obj;
        return line == that.line && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, column);
    }
}
