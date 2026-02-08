package astar;
import java.util.ArrayList;

//cœur de l'algorithme A*
public class AStarProcessor {
	

	    private AQueue openList;//cellules non traitees
	    private ArrayList<ACell> closedList;//garde une trace des cellules deja  traiter dans A*
	    private AGrid grid;
	   


	    public AStarProcessor() {
	        openList = new AQueue();
	        closedList = new ArrayList<>();
	        grid = new GridGenerator().BuildGrid("src/astar/map.txt");

	        openList.getQueue().add(grid.getStartingCell());
	    }

	    public AStarProcessor(int n) {
	        openList = new AQueue();
	        closedList = new ArrayList<>();
	        grid = new GridGenerator().BuildGrid("src/astar/map.txt");


	        openList.getQueue().add(grid.getStartingCell());
	    }

	   
	    public void process() {
	        ACell cell = openList.handle();
	        updateOpenList(cell);
	        closedList.add(cell);
	    }

	    
	    public boolean isEnded() {
	        return closedList.contains(grid.getEndingCell());
	    }

	
	    public boolean queueIsEmpty() {
	        return openList.getQueue().isEmpty();
	    }

	   
	    public boolean workFinished() {
	        return isEnded() || queueIsEmpty();
	    }

	    //🔹Mise à jour de la liste ouverte (exploration des voisins)
	
	    public void updateOpenList(ACell cell) {
	        for (int i = 0; i < 4; i++) {
	            ACell cellDaughter;
	            try {
	                switch (i) {
	                    case 0:
	                        cellDaughter = grid.getUp(cell);
	                        break;
	                    case 1:
	                        cellDaughter = grid.getDown(cell);
	                        break;
	                    case 2:
	                        cellDaughter = grid.getRight(cell);
	                        break;
	                    default:
	                        cellDaughter = grid.getLeft(cell);
	                        break;
	                }
	                if (!closedList.contains(cellDaughter) && !openList.getQueue().contains(cellDaughter)) {
	                    cellDaughter.setParent(cell);
	                    updateCosts(cellDaughter);
	                    openList.getQueue().add(cellDaughter);
	                }
	            } catch (CellIsWallException | IndexOutOfBoundsException ignored) {
	            }
	        }
	    }

	   
	    public void updateCosts(ACell cell) {
	        cell.calculateCost();
	        grid.calculateHeuristicCost(cell);
	    }


	    public AQueue getOpenList() {
	        return openList;
	    }

	    public AGrid getGrid() {
	        return grid;
	    }

	    public ArrayList<ACell> getClosedList() {
	        return closedList;
	    }

	    public int getClosedListSize() {
	        return closedList.size();
	    }

	    public int getCurrentPathSize() {
	        return closedList.get(closedList.size() - 1).getGenealogy().size();
	    }
	}