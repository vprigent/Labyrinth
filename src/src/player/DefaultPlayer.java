// personnageDefaut.java
// implémentation minimaliste de Personnage
// il sera ensuite conseillé de dériver cette classe afin
// de masquer la methode "faitSonChoix"

package player;

import maze.Room;

import java.util.Collection;

public abstract class DefaultPlayer implements Player {
    private Room currentRoom;

    public abstract Room faitSonChoix(Collection<Room> sallesAccessibles);

    public Room getPosition() {
        return currentRoom;
    }

    public void setPosition(Room salleCourante) {
        this.currentRoom = salleCourante;
    }
}
