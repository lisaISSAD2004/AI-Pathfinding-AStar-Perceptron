package astar;

import java.util.ArrayList;
import java.util.Comparator;

public class AQueue {
    private final ArrayList<ACell> queue;

    
    public AQueue() {
        queue = new ArrayList<>();
    }

    public ACell handle() {
        queue.sort(Comparator.comparingDouble(ACell::getHeuristicCost)); // Trie les cellules par coût heuristique
        ACell cell = queue.get(0); // Prend la cellule avec le coût le plus faible
        queue.remove(0); // La supprime de la file
        return cell; // Retourne cette cellule
    }
    


  
    public ArrayList<ACell> getQueue() {
        return queue;
    }
}
