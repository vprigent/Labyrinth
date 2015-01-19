package LabyrinthTest;

import maze.grid.LabyrinthGrilleDefaut;
import maze.grid.SalleCarree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabyrinthGrilleDefautTest extends LabyrinthGrilleDefaut {

    public LabyrinthGrilleDefaut LabyrinthTest = new LabyrinthGrilleDefaut();

    @Test
    public void testCreerLabyrinthe() throws Exception {
        LabyrinthTest.creerLabyrinthe("labys/level10.txt");
        assertEquals(LabyrinthTest.getHauteur(), 37);
        assertEquals(LabyrinthTest.getLargeur(), 37);
        SalleCarree c = (SalleCarree) LabyrinthTest.getEntree();
        assertEquals(c.getColonne(), 1);
        assertEquals(c.getLigne(), 1);
    }

    @Test
    public void testSallesAccessibles() throws Exception {

    }

    @Test
    public void testGetSalles() throws Exception {

    }

    @Test
    public void testEntrer() throws Exception {

    }

    @Test
    public void testSortir() throws Exception {

    }

    @Test
    public void testGetEntree() throws Exception {

    }

    @Test
    public void testGetSortie() throws Exception {

    }
}