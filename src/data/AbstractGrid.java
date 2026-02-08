package data;
 

public abstract class AbstractGrid {
    
    private AbstractCell[][] grid;

 
    private int size;

   
    private AbstractCell startCell;

   
    private AbstractCell goalCell;
    

    
    public AbstractGrid(int size) {
        this.grid = new AbstractCell[size][size];
        this.size = size;
    }

 
    public AbstractCell[][] getGrid() {
        return grid;
    }

 
    public void setGrid(AbstractCell[][] grid) {
        this.grid = grid;
    }

    
    public int getSize() {
        return size;
    }

  
    public AbstractCell getStartCell() {
        return startCell;
    }

    public void setStartCell(AbstractCell startCell) {
        this.startCell = startCell;
    }

   
    public AbstractCell getGoalCell() {
        return goalCell;
    }

   
    public void setGoalCell(AbstractCell goalCell) {
        this.goalCell = goalCell;
    }

  
    public AbstractCell getCell(int line, int column) {
        return grid[line][column];
    }
}