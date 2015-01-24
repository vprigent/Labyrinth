// Dessin.java
package view;

import maze.Room;
import maze.grid.Case;
import maze.grid.LabyrinthGrille;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class LabyrinthView extends JComponent {

    private final static int unite = 15;
    private LabyrinthGrille labyrinth;
    private Player bob;
    private Case entree;
    private Case sortie;
    private ArrayList<Case> sallesVisitees;

    public LabyrinthView(LabyrinthGrille labyrinthe, Player bob) {
        this.sallesVisitees = new ArrayList();
        this.labyrinth = labyrinthe;
        entree = (Case) labyrinthe.getEntree();
        sortie = (Case) labyrinthe.getSortie();
        this.bob = bob;

        // we define the minimal size of the component, depending on the size of the maze
        setMinimumSize(new Dimension(labyrinthe.getLargeur() * unite, labyrinthe.getHauteur() * unite));

        addKeyListener((KeyListener) bob);
    }

    public void drawBackground(Graphics g) {
        // black background
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void drawRoom(Graphics g) {
        int i, j;
        Collection<Room> rooms = labyrinth.getRooms();
        for (Room s : rooms) {
            i = ((Case) s).getLigne();
            j = ((Case) s).getColonne();
            g.setColor(Color.white);
            g.fillRect(j * unite, i * unite, unite, unite);
        }
    }

    public void dessinSallesVisitees(Graphics g) {
        int i, j;
        // dessin des salles connues
        Case c = (Case) bob.getPosition();
        if (!sallesVisitees.contains(c)) // maj des salles visitees
            sallesVisitees.add(c);
        for (Case s : sallesVisitees) {
            j = s.getColonne();
            i = s.getLigne();
            g.setColor(new Color(100, 100, 0));
            g.fillRect(j * unite, i * unite, unite, unite);
        }
    }

    public void dessinEntreeSortie(Graphics g) {
        g.setColor(new Color(110, 90, 50));
        g.fillRect(entree.getColonne() * unite, entree.getLigne() * unite, unite, unite);
        g.setColor(new Color(0, 200, 255));
        g.fillRect(sortie.getColonne() * unite, sortie.getLigne() * unite, unite, unite);
    }

    public void dessinHeros(Graphics g) {
        g.setColor(new Color(125, 40, 255));
        Case s = (Case) bob.getPosition();
        g.fillRect(s.getColonne() * unite, s.getLigne() * unite,
                unite, unite);
    }

    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawRoom(g);
        dessinSallesVisitees(g);
        dessinEntreeSortie(g);
        dessinHeros(g);
        revalidate();
    }
}
