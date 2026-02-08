package gui;

import javax.swing.*;
import astar.ACell;
import astar.AStarProcessor;
import java.awt.*;
import java.util.ArrayList;

public class AstarGUI extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private AStarProcessor aStarProcessor;
    private JLabel[][] grid;
    private boolean stop = true;

    public AstarGUI() {
        super();
        init();
    }

    private void init() {
        aStarProcessor = new AStarProcessor();
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(aStarProcessor.getGrid().getDIM(), aStarProcessor.getGrid().getDIM(), 0, 0)); // Pas d'espacement
        grid = new JLabel[aStarProcessor.getGrid().getDIM()][aStarProcessor.getGrid().getDIM()];

        for (int i = 0; i < aStarProcessor.getGrid().getDIM(); i++) {
            for (int j = 0; j < aStarProcessor.getGrid().getDIM(); j++) {
                grid[i][j] = new JLabel("■");
                ACell cell = aStarProcessor.getGrid().getCell(i, j);
                
                // Initial color setup based on the state of the cell
                setCellColor(i, j, cell);
                
                gridPanel.add(grid[i][j]);
            }
        }
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (stop) {
                stop = false;
                startButton.setText("Pause");
                Thread thread = new Thread(this);
                thread.start();
            } else {
                stop = true;
                startButton.setText("Start");
            }
        });
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(gridPanel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // Helper method to set the color of the cell based on its type
    private void setCellColor(int i, int j, ACell cell) {
        if (cell.equals(aStarProcessor.getGrid().getStartCell())) {
            grid[i][j].setForeground(Color.CYAN); 
        } else if (cell.equals(aStarProcessor.getGrid().getGoalCell())) {
            grid[i][j].setForeground(Color.RED); 
        } else if (cell.isCanAccess()) {
            grid[i][j].setForeground(Color.GREEN);
        } else {
            grid[i][j].setForeground(Color.MAGENTA);
        }
    }

    private void update() {
        ArrayList<ACell> parents = aStarProcessor.getClosedList()
                .get(aStarProcessor.getClosedList().size() - 1).getGenealogy();

        for (int i = 0; i < aStarProcessor.getGrid().getDIM(); i++) {
            for (int j = 0; j < aStarProcessor.getGrid().getDIM(); j++) {
                ACell cell = aStarProcessor.getGrid().getCell(i, j);
                
                if (cell.equals(aStarProcessor.getGrid().getStartCell())) {
                    grid[i][j].setForeground(Color.CYAN);
                } else if (cell.equals(aStarProcessor.getGrid().getGoalCell())) {
                    grid[i][j].setForeground(Color.RED);
                } else if (aStarProcessor.getClosedList().contains(cell)) {
                    grid[i][j].setForeground(parents.contains(cell) ? Color.BLUE : Color.BLACK);
                } else {
                    grid[i][j].setForeground(cell.isCanAccess() ? Color.GREEN : Color.MAGENTA);
                }
            }
        }
    }

    @Override
    public void run() {
        while (!stop && !aStarProcessor.getClosedList().contains(aStarProcessor.getGrid().getGoalCell())) {
            aStarProcessor.process();
            update();
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!stop) {
            System.out.println("Le but est atteint !");
        }
    }

    public static void main(String[] args) {
        new AstarGUI();
    }
}