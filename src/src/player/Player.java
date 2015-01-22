// Personnage.java
package player;

import maze.Salle;

import java.util.Collection;

public interface Player {
    // renvoie une salle parmi sallesAccesibles
    public Salle faitSonChoix(Collection<Salle> sallesAccessibles);

    // renvoie sa position courante
    public Salle getPosition();

    // definit sa position courante
    public void setPosition(Salle s);

}
