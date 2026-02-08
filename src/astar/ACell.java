package astar;

import java.util.ArrayList;

import data.AbstractCell;
import elements.Element;
import elements.EmptyCell;
import data.Coordinate;

public class ACell extends AbstractCell{
    private ACell parent;
    private boolean canAccess;
    private double heuristicCost;
    private int cost;
    
  
    public ACell(int line, int column, ACell parent, boolean canAccess) {
        super(new Coordinate(line, column), new EmptyCell(new Coordinate(line, column)));
        this.parent = parent;
        this.canAccess = canAccess;
    }
   
    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }
   
    public double getHeuristicCost() {
        return heuristicCost;
    }
    
    public void setHeuristicCost(double heuristicCost) {
        this.heuristicCost = heuristicCost;
    }
   
    public boolean isCanAccess() {
        return canAccess;
    }	
    
    public void setCanAccess(boolean canAccess) {
        this.canAccess = canAccess;
    }
   
    public ACell getParent() {
        return parent;
    }

    public void setParent(ACell parent) {
        this.parent = parent;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Element getElement() {
        return super.getElement();
    }

    public void setElement(Element element) {
        super.setElement(element);
    }

    public void calculateCost() {
        cost = parent.getCost() + 1;
    }
   //retourne la liste des cellule de la plus recente jusqu a la cellule la plus ancienne
    public ArrayList<ACell> getGenealogy() {
        ArrayList<ACell> genealogy = new ArrayList<>();
        ACell parent = this; // Commence par la cellule actuelle
        genealogy.add(this); // Ajoute la cellule actuelle à la liste
        while (parent.getParent() != null) { // Tant qu'il y a un parent
            parent = parent.getParent(); // Remonte d'un niveau
            genealogy.add(parent); // Ajoute le parent à la liste
        }
        return genealogy; // Retourne la liste des cellules du chemin
    }

    @Override
    public String toString() {
        return "[" + getCoordinate().getLine() + "," + getCoordinate().getColumn() + "]";
    }
}
