package main;

import maze.Salle;
import maze.grid.LabyrinthGrille;
import maze.grid.LabyrinthGrilleDefaut;
import player.Personnage;
import player.PersonnageClavier;
import view.Dessin;

import javax.swing.*;
import java.util.Collection;

public class LabyrintheApp {

    public static void main(String[] args) {


        // modele
        LabyrinthGrille labyrinthe = new LabyrinthGrilleDefaut();
        if (args.length == 0)
            labyrinthe.creerLabyrinthe("labys/level10.txt");
        else labyrinthe.creerLabyrinthe(args[0]);
        Personnage bob = new PersonnageClavier();
        labyrinthe.entrer(bob);

        // vue
        JFrame frame = new JFrame("Labyrinthe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dessin dessin = new Dessin(labyrinthe, bob);
        dessin.setFocusable(true);
        dessin.requestFocus();
        frame.setContentPane(dessin);
        frame.pack();
        frame.setVisible(true);

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
