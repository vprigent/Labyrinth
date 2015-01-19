// Labyrinthe.java
package maze;

import player.Personnage;

import java.util.Collection;

public interface Labyrinthe {
    // cree le labyrinthe
    public void creerLabyrinthe(String file);

    // place bob à l'entree du labyrinthe
    public void entrer(Personnage bob);

    // dit si bob est sorti
    public boolean sortir(Personnage bob);

    // renvoie les salles accessibles par bob
    public Collection<Salle> sallesAccessibles(Personnage bob);

    // accesseur sur les salles du labyrinthes
    public Collection<Salle> getSalles();

    // accesseurs sur l'entree et la sortie
    public Salle getEntree();

    public Salle getSortie();
}
