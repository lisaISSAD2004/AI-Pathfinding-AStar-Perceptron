package astar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import data.AbstractGrid;
import data.AbstractCell;

public class AGrid extends AbstractGrid {
    private static final int DIM = 40;
    private static final float HEURISTIC_RATIO = 3;
    private final int size;
    private final ACell[][] grid;

    public AGrid(int size) {
        super(size);
        this.size = size;
        this.grid = new ACell[size][size];
        loadGridFromFile("src/astar/map.txt");  // Charge la grille à partir du fichier
    }

    public AGrid() {
        this(DIM);
    }

    // Nouvelle méthode pour charger la grille depuis un fichier
    public void loadGridFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < size) {
                String[] values = line.replaceAll("[{}]", "").split(",");
                for (int j = 0; j < values.length && j < size; j++) {
                    int cellValue = Integer.parseInt(values[j].trim());
                    grid[i][j] = new ACell(i, j, null, cellValue == 1);
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public ACell getCell(int i, int j) {
        return (ACell) super.getCell(i, j);
    }

    public void setCell(int i, int j, AbstractCell abstractCell) {
        super.getGrid()[i][j] = abstractCell;
    }

    public int getDIM() {
        return DIM;
    }

    public ACell getEndingCell() {
        return (ACell) super.getGoalCell();
    }

    public void setEndingCell(ACell endingCell) {
        super.setGoalCell(endingCell);
    }

    public ACell getStartingCell() {
        return (ACell) super.getStartCell();
    }

    public int getSize() {
        return super.getSize();
    }

    public void setStartingCell(ACell startingCell) {
        super.setStartCell(startingCell);
    }

    public ACell getUp(ACell cell) throws CellIsWallException {
        if (!((ACell) super.getGrid()[cell.getCoordinate().getLine()][cell.getCoordinate().getColumn() - 1]).isCanAccess()) {
            throw new CellIsWallException();
        }
        return (ACell) super.getGrid()[cell.getCoordinate().getLine()][cell.getCoordinate().getColumn() - 1];
    }

    public ACell getDown(ACell cell) throws CellIsWallException {
        if (!((ACell) super.getGrid()[cell.getCoordinate().getLine()][cell.getCoordinate().getColumn() + 1]).isCanAccess()) {
            throw new CellIsWallException();
        }
        return (ACell) super.getGrid()[cell.getCoordinate().getLine()][cell.getCoordinate().getColumn() + 1];
    }

    public ACell getRight(ACell cell) throws CellIsWallException {
        if (!((ACell) super.getGrid()[cell.getCoordinate().getLine() + 1][cell.getCoordinate().getColumn()]).isCanAccess()) {
            throw new CellIsWallException();
        }
        return (ACell) super.getGrid()[cell.getCoordinate().getLine() + 1][cell.getCoordinate().getColumn()];
    }

    public ACell getLeft(ACell cell) throws CellIsWallException {
        if (!((ACell) super.getGrid()[cell.getCoordinate().getLine() - 1][cell.getCoordinate().getColumn()]).isCanAccess()) {
            throw new CellIsWallException();
        }
        return (ACell) super.getGrid()[cell.getCoordinate().getLine() - 1][cell.getCoordinate().getColumn()];
    }

    public void calculateHeuristicCost(ACell cell) {
        cell.setHeuristicCost(
            cell.getCost() + cell.getCoordinate().calculateDistance(super.getGoalCell().getCoordinate()) * HEURISTIC_RATIO
        );
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < super.getSize(); i++) {
            for (int j = 0; j < super.getSize(); j++) {
                res.append("|").append(((ACell) super.getGrid()[i][j]).isCanAccess() ? 0 : 1).append("|");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
