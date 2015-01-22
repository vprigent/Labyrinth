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
    private Labyrinthe currentLabyrinth;

    public MazeHandler() {
        currentLabyrinth = new LabyrinthGrilleDefaut();

        loadLabyrinth();
    }

    // mettre une regexp dans le laby de manière à charger tout fichier contenant le chiffre voulu plus, d'autres chiffres, exceptés du coup les chiffres ( en gros [a-z]i[a-z] )
    private void loadLabyrinth() {
        int i = 1;
        boolean matches = false;

        Pattern pattern = Pattern.compile("(labys/\\D)"+i+"(\\D)");
        Matcher m;

        String[] files =  new File("labys").list();

        for(String s : files){
            m = pattern.matcher(s);
            if(m.matches()){
                currentLabyrinth.creerLabyrinthe("labys/"+"\\D"+i+"\\D");
                matches = true;
            }

        }

        if(!matches) {
            while (!matches){
                i++;
                pattern = Pattern.compile("labys/" + "\\D" + i + "\\D");
                for(String s : files){
                    m = pattern.matcher(s);
                    if(m.matches()){
                        currentLabyrinth.creerLabyrinthe("labys/"+"\\D"+i+"\\D");
                        matches = true;
                    }
                    System.out.println(m);
                }
            }
        }

    }

    public LabyrinthGrille getCurrentLabyrinth() {
        return (LabyrinthGrille)currentLabyrinth;
    }
}
