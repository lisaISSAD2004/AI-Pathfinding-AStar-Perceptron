# Projet Intelligence Artificielle - Pathfinding Visualizer

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![License](https://img.shields.io/badge/License-Academic-green?style=for-the-badge)](LICENSE)

## 📋 Description

Application éducative interactive développée dans le cadre du projet de Génie Logiciel (L2 Informatique, CY Cergy-Paris Université) permettant de visualiser et comparer deux approches fondamentales de recherche de chemin :

- **Algorithme A\*** : Recherche de chemin optimal avec visualisation en temps réel
- **Perceptron** : Approche par apprentissage automatique basée sur un réseau neuronal simple

## 🎯 Objectifs du Projet

- Implémenter et comparer deux algorithmes de pathfinding
- Développer des interfaces graphiques intuitives
- Visualiser le comportement des algorithmes en temps réel
- Faciliter l'apprentissage des concepts d'intelligence artificielle

## ✨ Fonctionnalités Principales

### Explorateur A*
- ✅ Visualisation de l'algorithme A* en action
- ✅ Affichage des valeurs F (F = G + H) pour chaque cellule
- ✅ Animation du parcours de l'agent
- ✅ Contrôles Start/Pause
- ✅ Statistiques détaillées avec graphiques

### Explorateur Perceptron
- ✅ Entraînement du réseau neuronal (1000 itérations)
- ✅ Affichage des directions prédites (flèches directionnelles)
- ✅ Animation du chemin appris
- ✅ Interface d'entraînement interactive

### Fonctionnalités Communes
- 📊 Visualisation graphique sur grille
- 🎨 Code couleur intuitif
- 📈 Statistiques de performance
- 💾 Confirmation de sortie
- 🎉 Message de félicitations à l'arrivée

## 🏗️ Architecture

### Structure Modulaire

```
projet-ia/
├── Module A*
│   ├── AStarProcessor (logique algorithmique)
│   └── AGrid (représentation spatiale)
├── Module Perceptron
│   ├── Réseau Neuronal
│   └── Apprentissage
├── Module Visualisation
│   ├── AStarGUI
│   └── PerceptronGUI
└── Modèle de Données Commun
```

### Design Patterns Utilisés

- **Template Method** : `AbstractGrid` / `AbstractCell` pour la structure des algorithmes
- **Factory Pattern** : `GridGenerator` pour la création dynamique des grilles
- **Singleton Pattern** : `ChartManager` pour la gestion centralisée des statistiques

## 🔧 Technologies Utilisées

| Technologie | Utilisation |
|------------|-------------|
| **Java** | Langage principal |
| **Swing** | Interface graphique |
| **Log4j** | Journalisation et débogage |
| **Eclipse** | IDE de développement |
| **LaTeX** | Rédaction du rapport |
| **Git/GitHub** | Gestion de version |

## 📦 Installation et Exécution

### Prérequis

- Java JDK 8 ou supérieur
- IDE Java (Eclipse, IntelliJ IDEA, ou NetBeans)

### Installation

```bash
# Cloner le dépôt
git clone [URL_DU_REPO]

# Accéder au répertoire
cd projet-ia

# Compiler le projet
javac -d bin src/**/*.java
```

### Exécution

**Explorateur A\*** :
```bash
java -cp bin AStarGUI
```

**Explorateur Perceptron** :
```bash
java -cp bin PerceptronGUI
```

## 🎮 Guide d'Utilisation

### Explorateur A*

1. **Lancer l'application** : Exécuter `AStarGUI`
2. **Comprendre la grille** :
   - 🟦 Cyan : Point de départ
   - 🟥 Rouge : Objectif
   - 🟩 Vert : Chemins accessibles
   - 🟪 Magenta : Obstacles (murs)
3. **Démarrer** : Cliquer sur "Start"
4. **Observer** : Les nombres affichés représentent la valeur F de chaque cellule
5. **Statistiques** : Cliquer sur "Voir les statistiques" pour l'analyse détaillée

### Explorateur Perceptron

1. **Lancer l'application** : Exécuter `PerceptronGUI`
2. **Entraîner le réseau** : Cliquer sur "Train Network" (1000 itérations)
3. **Démarrer la simulation** : Cliquer sur "Start"
4. **Observer les flèches** : Elles indiquent les directions prédites par le réseau

## 📊 Formules Mathématiques

### Algorithme A*
```
f(n) = g(n) + h(n)
```
- `f(n)` : Coût total estimé
- `g(n)` : Coût réel depuis le départ
- `h(n)` : Estimation heuristique jusqu'à l'objectif

### Perceptron
```
z = w₁x₁ + w₂x₂ + ... + wₙxₙ + b

f(z) = { 1 si z ≥ seuil
       { 0 sinon
```
- `wᵢ` : Poids associé à l'entrée
- `xᵢ` : Valeur d'entrée
- `b` : Biais

## 📁 Configuration de la Grille

Le fichier `map.txt` définit l'environnement :
- `0` : Cellule accessible
- `1` : Mur (obstacle)

Exemple :
```
0 0 0 1 0
0 1 0 1 0
0 0 0 0 0
1 1 0 1 0
0 0 0 0 0
```

## 📈 Statistiques et Visualisation

L'application propose plusieurs types de graphiques :

- **Diagramme circulaire** : Répartition des types de cellules
- **Histogramme** : Statut des cellules (visitées, ouvertes, sur le chemin)
- **Courbe d'évolution** : Valeur F au fil des étapes

## 👥 Équipe de Développement

| Nom | Rôle |
|-----|------|
| **ACHAB Ouardia** | Développement A*, Interface graphique, Documentation |
| **ISSAD Lisa** | Développement Perceptron, Tests, Rapport |
| **DE ANGELIS Enzo** | Conception classes, IHM, Gestion GitHub |

**Encadrant** : Monsieur Tianxiao LIU

## 🎓 Contexte Académique

- **Institution** : CY Cergy-Paris Université
- **Formation** : L2 Informatique
- **Cours** : Génie Logiciel
- **Année** : 2024/2025
- **Date de livraison** : Avril 2025

## 📚 Références

- Russell, S., & Norvig, P. (2010). *Artificial Intelligence: A Modern Approach* (3rd ed.). Pearson.
- Géron, A. (2019). *Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow* (2nd ed.). O'Reilly Media.
- [Amit's A* Pathfinding Tutorial](https://www.redblobgames.com/pathfinding/a-star/)
- [Oracle Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)


## 📄 License

Projet académique - CY Cergy-Paris Université

## 🙏 Remerciements

Nous remercions sincèrement :
- Notre enseignant, M. Tianxiao LIU, pour son encadrement
- Le département d'informatique de CY Cergy-Paris Université
- Nos camarades de classe pour leurs retours
- Nos familles pour leur soutien

---

**Note** : Ce projet a été développé à des fins éducatives dans le cadre du cours de Génie Logiciel.

Pour toute question ou suggestion, n'hésitez pas à nous contacter ! 📧
