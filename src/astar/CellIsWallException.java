package astar;

public class CellIsWallException extends Exception {
	private static final long serialVersionUID = 1L;

	public CellIsWallException() {
        super("Cell is a wall and cannot be accessed.");
    }
}
