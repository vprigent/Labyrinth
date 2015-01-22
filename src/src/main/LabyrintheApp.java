package main;

import maze.Salle;
import maze.grid.LabyrinthGrille;
import maze.grid.LabyrinthGrilleDefaut;
import player.KeyboardPlayer;
import player.Player;
import player.KeyboardPlayer;
import view.LabyrinthView;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class LabyrintheApp {

    public static void main(String[] args) {


        // modele
        LabyrinthGrille labyrinthe = new LabyrinthGrilleDefaut();
        if (args.length == 0) {
            labyrinthe.creerLabyrinthe("labys/level11.txt");
        }
        else labyrinthe.creerLabyrinthe(args[0]);

        Player bob = new KeyboardPlayer();

        labyrinthe.entrer(bob);

        // vue
        MainFrame frame =  new MainFrame(labyrinthe, bob);

        while (!labyrinthe.sortir(bob)) {
            Collection<Salle> sallesAccessibles = labyrinthe.sallesAccessibles(bob);
            Salle destination = bob.faitSonChoix(sallesAccessibles); // on demande au heros de faire son choix de salle
            if (destination != bob.getPosition()) destination.recevoir(bob); // deplacement
            //rafraichissement de la vue
            frame.repaint();
            // on fait une pause
            try {
                Thread.currentThread();
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                System.err.println(ie);
            }

        }
    }
}
