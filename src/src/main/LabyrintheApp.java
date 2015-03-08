package main;

import maze.MazeHandler;
import maze.Room;
import player.KeyboardPlayer;
import player.Player;
import view.MainFrame;

import java.util.Collection;

public class LabyrintheApp {

    public static void main(String[] args) {

        // modele
        MazeHandler labyrinthHandler = new MazeHandler();
        Player bob = new KeyboardPlayer();

        labyrinthHandler.getCurrentLabyrinth().entrer(bob);

        // vue
        MainFrame frame = new MainFrame(labyrinthHandler.getCurrentLabyrinth(), bob);

        labyrinthHandler.addObserver(frame);

        while (!labyrinthHandler.getCurrentLabyrinth().sortir(bob)) {
            Collection<Room> sallesAccessibles = labyrinthHandler.getCurrentLabyrinth().sallesAccessibles(bob);
            Room destination = bob.faitSonChoix(sallesAccessibles); // on demande au heros de faire son choix de salle
            if (destination != bob.getPosition()) {
                destination.recevoir(bob); // deplacement
            }

            //rafraichissement de la vue
            frame.repaint();
            // on fait une pause
            try {
                Thread.currentThread();
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                System.err.println(ie);
            }
            if(labyrinthHandler.getCurrentLabyrinth().sortir(bob)) {
                labyrinthHandler.loadLabyrinth();
                labyrinthHandler.getCurrentLabyrinth().entrer(bob);
            }
        }
    }
}
