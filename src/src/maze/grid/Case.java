package maze.grid;

import maze.Room;

public interface Case extends Room {
    public int getLigne();

    public int getColonne();
}