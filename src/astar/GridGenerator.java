package astar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.AbstractGrid;
import elements.EmptyCell;
import elements.Wall;
public class GridGenerator {

    private final ArrayList<ArrayList<ACell>> listOfAreas;
    private final ArrayList<ACell> walls;

    public GridGenerator() {
        listOfAreas = new ArrayList<>();
        walls = new ArrayList<>();
    }

    public AGrid BuildGrid(String filePath) {
        AGrid grid = new AGrid();
        loadGridFromFile(grid, filePath);
        setStartAndEnding(grid);
        return grid;
    }

    public AbstractGrid BuildGrid(int n, String filePath) {
        AGrid grid = new AGrid(n);
        loadGridFromFile(grid, filePath);
        setStartAndEnding(grid);
        return grid;
    }

    private void loadGridFromFile(AGrid grid, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < grid.getSize()) { 
                String[] values = line.replaceAll("[{}]", "").split(",");
                for (int j = 0; j < values.length && j < grid.getSize(); j++) { 
                    int cellValue = Integer.parseInt(values[j].trim());
                    ACell aCell;
                    if (cellValue == 0) { // Mur
                        aCell = new ACell(i, j, null, false);
                        aCell.setElement(new Wall(aCell.getCoordinate()));
                        walls.add(aCell);
                    } else { // Case vide
                        aCell = new ACell(i, j, null, true);
                        aCell.setElement(new EmptyCell(aCell.getCoordinate()));
                        if (listOfAreas.size() <= i) {
                            listOfAreas.add(new ArrayList<>());
                        }
                        listOfAreas.get(i).add(aCell);
                    }
                    grid.setCell(i, j, aCell); 
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    private void setStartAndEnding(AGrid grid) {
        grid.setStartingCell(grid.getCell(0, 0)); 
        if (grid.getStartingCell() != null) {
            grid.getStartingCell().setCanAccess(true);
            grid.getStartingCell().setCost(0);
            grid.getStartingCell().setHeuristicCost(0);
        }

        grid.setEndingCell(grid.getCell(grid.getSize() - 1, grid.getSize() - 1)); 
        if (grid.getEndingCell() != null) {
            grid.getEndingCell().setCanAccess(true);
        }
    }
}
