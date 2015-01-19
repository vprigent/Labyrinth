package maze.grid;

import maze.Salle;

public interface Case extends Salle {
    public int getLigne();

    public int getColonne();
}