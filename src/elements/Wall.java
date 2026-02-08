package elements;

import java.awt.Color;

import data.Coordinate;


public class Wall implements Element{
    private Coordinate coordinate;
    public Wall(Coordinate c) {
        this.coordinate = c;
    }
   
    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }
    @Override
    public String toString() {
        return "Wall";
    }
    
}