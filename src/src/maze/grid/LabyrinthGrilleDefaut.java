package maze.grid;

import maze.Room;
import player.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LabyrinthGrilleDefaut implements LabyrinthGrille {

    private int hauteur;
    private int largeur;
    private SquareRoom[][] rooms;
    private SquareRoom entree;
    private SquareRoom sortie;

    // cree le labyrinthe
    public boolean creerLabyrinthe(String file) {

        Scanner sc = null;

        try {
            sc = new Scanner(new File(file));
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

        hauteur = sc.nextInt();
        largeur = sc.nextInt();
        rooms = new SquareRoom[hauteur][largeur];

        int ligneEntree = sc.nextInt();
        int colonneEntree = sc.nextInt();
        entree = new SquareRoom(ligneEntree, colonneEntree);


        int ligneSortie = sc.nextInt();
        int colonneSortie = sc.nextInt();
        sortie = new SquareRoom(ligneSortie, colonneSortie);

        for (int i = 0; i < hauteur; i++)
            for (int j = 0; j < largeur; j++)
                rooms[i][j] = null;

        rooms[ligneEntree][colonneEntree] = entree;
        rooms[ligneSortie][colonneSortie] = sortie;

        while (sc.hasNext()) {
            int ligne = sc.nextInt();
            int colonne = sc.nextInt();
            rooms[ligne][colonne] = new SquareRoom(ligne, colonne);
        }

        return true;
    }


    // renvoie les rooms accessibles par bob
    public Collection<Room> sallesAccessibles(Player bob) {
        Collection<Room> sa = new ArrayList();
        SquareRoom tmp = (SquareRoom) bob.getPosition();
        SquareRoom ad;
        try {
            if (tmp.getLigne() - 1 >= 0) {
                ad = rooms[tmp.getLigne() - 1][tmp.getColonne()];
                if (ad != null)
                    sa.add(ad); // haut
            }
            if (tmp.getColonne() + 1 < largeur) {
                ad = rooms[tmp.getLigne()][tmp.getColonne() + 1];
                if (ad != null)
                    sa.add(ad); // droite
            }
            if (tmp.getLigne() + 1 < hauteur) {
                ad = rooms[tmp.getLigne() + 1][tmp.getColonne()];
                if (ad != null)
                    sa.add(ad); // bas
            }
            if (tmp.getColonne() - 1 >= 0) {
                ad = rooms[tmp.getLigne()][tmp.getColonne() - 1];
                if (ad != null)
                    sa.add(ad); // gauche
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return sa;
    }


    public Collection<Room> getRooms() {
        ArrayList<Room> al = new ArrayList();
        for (int i = 0; i < getHauteur(); i++)
            for (int j = 0; j < getLargeur(); j++)
                if (rooms[i][j] != null)
                    al.add(rooms[i][j]);
        return al;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }


    public void entrer(Player bob) {
        entree.recevoir(bob);
    }

    public boolean sortir(Player bob) {
        return (bob.getPosition() == sortie);
    }

    public Room getEntree() {
        return entree;
    }

    public Room getSortie() {
        return sortie;
    }

}
