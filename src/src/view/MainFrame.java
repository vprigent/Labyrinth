package view;

import maze.Labyrinth;
import maze.grid.LabyrinthGrille;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class MainFrame extends JFrame implements Observer{
    private LabyrinthView labyrinthView;
    private Labyrinth labyrinth;
    private Player mainPlayer;

    public MainFrame(LabyrinthGrille labyrinth, Player mainPlayer){
        this.labyrinth = labyrinth;
        this.mainPlayer = mainPlayer;

        syncViewFromModel();

        this.setTitle("Labyrinthe");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(labyrinthView);
        this.pack();
        this.setVisible(true);
        // this decision is due to the lack of beautiful resize of the labyrinths
        this.setResizable(false);
    }

    private void syncViewFromModel() {
        labyrinthView = new LabyrinthView(this.labyrinth, this.mainPlayer);
        labyrinthView.setFocusable(true);
        labyrinthView.requestFocus();

        Dimension minimumSize = labyrinthView.getMinimumSize();
        minimumSize.setSize(minimumSize.getWidth() + 6, minimumSize.getHeight() + 25);

        this.setMinimumSize(minimumSize);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.labyrinth = (Labyrinth) arg;
        syncViewFromModel();
    }
}
