package data;
import elements.Element;
public class AbstractCell { 

	
	    private final Coordinate coordinate;

	    
	    private Element element;

	  
	    public  AbstractCell(Coordinate coordinate, Element element) {
	        this.coordinate = coordinate;
	        this.element = element;
	    }

	    
	    public Coordinate getCoordinate() {
	        return coordinate;
	    }

	  
	    public Element getElement() {
	        return element;
	    }

	  
	    public void setElement(Element element) {
	        this.element = element;
	    }

	    @Override
	    public String toString() {
	        return "[" + getCoordinate().getColumn() + "," + getCoordinate().getColumn() + "] with element : " + getElement().toString();
	    }

	}