package astar;

public class Test {
    
    public static void main(String[] args) {
       
        GridGenerator gridGenerator = new GridGenerator();
        
        // Définir le chemin vers le fichier map.txt
        String filePath = "src/astar/map.txt"; // Assurez-vous que le chemin est correct

        // Créer la grille en utilisant le fichier map.txt
        AGrid grid = gridGenerator.BuildGrid(filePath);

        // Vérifier que la grille a bien été générée
        if (grid != null) {
            System.out.println("Grille générée avec succès !");
            
            // Afficher les coordonnées de la cellule de départ
            if (grid.getStartingCell() != null) {
                System.out.println("Cellule de départ : " + grid.getStartingCell().getCoordinate());
            } else {
                System.out.println("La cellule de départ est nulle !");
            }
            
            // Afficher les coordonnées de la cellule de fin
            if (grid.getEndingCell() != null) {
                System.out.println("Cellule de fin : " + grid.getEndingCell().getCoordinate());
            } else {
                System.out.println("La cellule de fin est nulle !");
            }

            // Optionnel : Afficher toute la grille (si cela est nécessaire)
            for (int i = 0; i < grid.getSize(); i++) {
                for (int j = 0; j < grid.getSize(); j++) {
                    ACell cell = grid.getCell(i, j);
                    System.out.print(cell.getElement().toString() + " ");
                }
                System.out.println(); // Nouvelle ligne après chaque ligne de la grille
            }
        } else {
            System.out.println("Échec de la génération de la grille.");
        }
    }
}
