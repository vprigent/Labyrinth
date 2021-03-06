// PersonnageClavier.java
package player;

import maze.Room;
import maze.grid.Case;
import maze.grid.SquareRoom;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;

public class KeyboardPlayer extends DefaultPlayer implements KeyListener {

    private Room salleChoisie = new SquareRoom(-1, -1); // au debut, salle choisie invalide
    private Collection<Room> sallesAccessibles;

    public Room faitSonChoix(Collection<Room> sallesAccessibles) {
        this.sallesAccessibles = sallesAccessibles;
        if (sallesAccessibles.contains(salleChoisie))
            return salleChoisie;
        // si la salle choisie n'est pas dans les salles accessibles, on ne bouge pas
        return getPosition();
    }

    // ecouteur sur le clavier
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // on recupere les coordonnees de la salle courante
        int x = ((Case) getPosition()).getColonne();
        int y = ((Case) getPosition()).getLigne();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                x--;
                break;
            case KeyEvent.VK_RIGHT:
                x++;
                break;
            case KeyEvent.VK_UP:
                y--;
                break;
            case KeyEvent.VK_DOWN:
                y++;
                break;
        }
        // mise a jour de salle choisie
        for (Room s : sallesAccessibles) {
            // on regarde si le choix fait partie des salles accessibles et on le valide si c'est le cas
            if (((Case) s).getLigne() == y && (((Case) s).getColonne() == x)) {
                salleChoisie = s;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
