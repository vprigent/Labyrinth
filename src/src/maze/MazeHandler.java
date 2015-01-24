package maze;

import maze.grid.LabyrinthGrille;
import maze.grid.LabyrinthGrilleDefaut;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Vincent on 22/01/2015.
 */
public class MazeHandler {
    private Labyrinth currentLabyrinth;
    private int lastLevel = 0;

    public MazeHandler() {
        currentLabyrinth = new LabyrinthGrilleDefaut();

        lastLevel = loadLabyrinth(lastLevel);
    }

    /* Having a regex here is with the intention of loading any file on the folder labys
     * where the name pattern is some sort of :
     * sthOrNthgWithChar plus the number of the level needed plus sthWithChar
     */
    private int loadLabyrinth(int lastLevel) {
        boolean matches = false;
        int j;

        Pattern pattern;
        Matcher m;

        String[] files = new File("labys").list();

        while (!matches) {
            j = 0;
            pattern = Pattern.compile("\\D*?" + lastLevel + "\\D+?");
            while (!matches && j < files.length) {
                m = pattern.matcher(files[j]);
                if (m.matches()) {
                    currentLabyrinth.creerLabyrinthe("labys/"+files[j]);
                    matches = true;
                }
                j++;
            }
            lastLevel++;
        }

        // Error is probably not the good class to use here ( cf IntelliJ Suggestion )
        if(!matches) throw new Error("No labyrinth found on loading.");

        return lastLevel;
    }

    public final LabyrinthGrille getCurrentLabyrinth() {
        return (LabyrinthGrille) currentLabyrinth;
    }
}
