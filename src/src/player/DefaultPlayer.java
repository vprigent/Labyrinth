// personnageDefaut.java
// implémentation minimaliste de Personnage
// il sera ensuite conseillé de dériver cette classe afin
// de masquer la methode "faitSonChoix"

package player;

import maze.Salle;

import java.util.Collection;

public abstract class DefaultPlayer implements Player {
    private Salle salleCourante;

    public abstract Salle faitSonChoix(Collection<Salle> sallesAccessibles);

    public Salle getPosition() {
        return salleCourante;
    }

    public void setPosition(Salle salleCourante) {
        this.salleCourante = salleCourante;
    }
}
