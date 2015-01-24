// Personnage.java
package player;

import maze.Room;

import java.util.Collection;

public interface Player {
    // renvoie une salle parmi sallesAccesibles
    public Room faitSonChoix(Collection<Room> sallesAccessibles);

    // renvoie sa position courante
    public Room getPosition();

    // definit sa position courante
    public void setPosition(Room s);

}
