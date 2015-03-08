// Dessin.java
package view;

import maze.Labyrinth;
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
    private Labyrinth labyrinth;
    private Player bob;
    private ArrayList<Case> sallesVisitees;

    public LabyrinthView(Labyrinth labyrinth, Player bob) {
        this.sallesVisitees = new ArrayList();
        this.labyrinth = labyrinth;
        this.bob = bob;

        // we define the minimal size of the component, depending on the size of the maze
        setMinimumSize(new Dimension(((LabyrinthGrille) labyrinth).getLargeur() * unite, ((LabyrinthGrille) labyrinth).getHauteur() * unite));

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
            Color c = new Color(255,255,255);

            int distanceToPlayer = (Math.abs(i - ((Case) bob.getPosition()).getLigne()) + Math.abs(j - ((Case) bob.getPosition()).getColonne()));

            for(int temp = 1; temp < distanceToPlayer; temp++){
                c = c.darker();
            }

            g.setColor(c);
            g.fillRect(j * unite, i * unite, unite, unite);
        }
    }

    public void drawVisitedRooms(Graphics g) {
        int i, j;

        System.out.println(this.hashCode());

        // dessin des salles connues
        Case c = (Case) bob.getPosition();
        if (!sallesVisitees.contains(c)) // maj des salles visitees
            sallesVisitees.add(c);

        for (Case s : sallesVisitees) {
            j = s.getColonne();
            i = s.getLigne();

            Color color = new Color(100,100,0);

            int distanceToPlayer = (Math.abs(i - ((Case) bob.getPosition()).getLigne()) + Math.abs(j - ((Case) bob.getPosition()).getColonne()));

            for(int temp = 1; temp < distanceToPlayer; temp++){
                color = color.darker();
            }

            g.setColor(color);

            g.setPaintMode();

            g.fillRect(j * unite, i * unite, unite, unite);
        }
    }

    public void drawEntryExit(Graphics g) {
        g.setColor(new Color(255, 190, 139));
        g.fillRect(((Case)labyrinth.getEntree()).getColonne() * unite, ((Case)labyrinth.getEntree()).getLigne() * unite, unite, unite);
        g.setColor(new Color(127, 207, 225));
        g.fillRect(((Case)labyrinth.getSortie()).getColonne() * unite, ((Case)labyrinth.getSortie()).getLigne() * unite, unite, unite);
    }

    public void drawHero(Graphics g) {
        g.setColor(new Color(125, 40, 255));
        Case s = (Case) bob.getPosition();
        g.fillRect(s.getColonne() * unite, s.getLigne() * unite,
                unite, unite);
    }

    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawRoom(g);
        drawVisitedRooms(g);
        drawEntryExit(g);
        drawHero(g);
    }
}
