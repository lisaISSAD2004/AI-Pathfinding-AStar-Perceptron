package elements;
import java.awt.Color;

import data.Coordinate;



public class EmptyCell implements Element {
    private Coordinate coordinate;
    public EmptyCell(Coordinate c) {
        this.coordinate = c;
    }

    @Override
    public Color getColor() {
        return Color.PINK;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
    @Override
    public String toString() {
        return "EmptyCell";
    }
    
}









