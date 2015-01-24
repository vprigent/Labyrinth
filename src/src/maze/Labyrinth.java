// Labyrinthe.java
package maze;

import player.Player;

import java.util.Collection;

public interface Labyrinth {
    // cree le labyrinthe
    public boolean creerLabyrinthe(String file);

    // place bob à l'entree du labyrinthe
    public void entrer(Player bob);

    // dit si bob est sorti
    public boolean sortir(Player bob);

    // renvoie les salles accessibles par bob
    public Collection<Room> sallesAccessibles(Player bob);

    // accesseur sur les salles du labyrinthes
    public Collection<Room> getRooms();

    // accesseurs sur l'entree et la sortie
    public Room getEntree();

    public Room getSortie();
}
