// Labyrinthe.java
package maze;

import player.Player;

import java.util.Collection;

public interface Labyrinthe {
    // cree le labyrinthe
    public void creerLabyrinthe(String file);

    // place bob à l'entree du labyrinthe
    public void entrer(Player bob);

    // dit si bob est sorti
    public boolean sortir(Player bob);

    // renvoie les salles accessibles par bob
    public Collection<Salle> sallesAccessibles(Player bob);

    // accesseur sur les salles du labyrinthes
    public Collection<Salle> getSalles();

    // accesseurs sur l'entree et la sortie
    public Salle getEntree();

    public Salle getSortie();
}
