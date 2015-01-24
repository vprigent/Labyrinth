package view;

import maze.grid.LabyrinthGrille;
import player.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vincent on 22/01/2015.
 */
public class MainFrame extends JFrame {
    private LabyrinthView labyrinthView;
    private LabyrinthGrille labyrinth;
    private Player mainPlayer;

    public MainFrame(LabyrinthGrille labyrinth, Player mainPlayer){
        this.setTitle("Labyrinthe");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        labyrinthView = new LabyrinthView(labyrinth, mainPlayer);

        labyrinthView.setFocusable(true);
        labyrinthView.requestFocus();

        Dimension minimumSize = labyrinthView.getMinimumSize();
        minimumSize.setSize(minimumSize.getWidth()+6, minimumSize.getHeight()+25);

        this.setContentPane(labyrinthView);
        this.pack();
        this.setVisible(true);
        this.setMinimumSize(minimumSize);
        // this decision is due to the lack of beautiful resize of the labyrinths
        this.setResizable(false);
    }
}
