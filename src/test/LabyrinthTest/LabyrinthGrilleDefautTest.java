package LabyrinthTest;

import maze.Room;
import maze.grid.LabyrinthGrilleDefaut;
import maze.grid.SquareRoom;
import org.junit.Test;
import player.Player;
import player.KeyboardPlayer;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LabyrinthGrilleDefautTest {

    public final LabyrinthGrilleDefaut labyrinthTest = new LabyrinthGrilleDefaut();

    @Test
    public void testCreerLabyrinthe() throws Exception {
        labyrinthTest.creerLabyrinthe("labys/level10.txt");
        assertEquals(labyrinthTest.getHauteur(), 37);
        assertEquals(labyrinthTest.getLargeur(), 37);
        SquareRoom c = (SquareRoom) labyrinthTest.getEntree();
        assertEquals(c.getColonne(), 1);
        assertEquals(c.getLigne(), 1);
    }

    @Test
    public void testSallesAccessibles() throws Exception {
        Player p = new KeyboardPlayer();
        ArrayList<Room> sallesLibres;
        labyrinthTest.creerLabyrinthe("labys/level10.txt");

        labyrinthTest.entrer(p);
        assertEquals(labyrinthTest.sallesAccessibles(p).size(), 1);
        sallesLibres = (ArrayList)labyrinthTest.sallesAccessibles(p);
        p.setPosition(sallesLibres.get(0));
        sallesLibres = (ArrayList)labyrinthTest.sallesAccessibles(p);
        assertEquals(sallesLibres.size(), 2);
    }
}