package maze.grid;

import maze.Salle;
import player.Personnage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LabyrinthGrilleDefaut implements LabyrinthGrille {

    private int hauteur;
    private int largeur;
    private SalleCarree[][] salles;
    private SalleCarree entree;
    private SalleCarree sortie;

    // cree le labyrinthe
    public void creerLabyrinthe(String file) {
        // À parir d'un fichier !
        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));
        } catch (Exception e) {
            System.err.println(e);
        }

        hauteur = sc.nextInt();
        largeur = sc.nextInt();
        salles = new SalleCarree[hauteur][largeur];

        int ligneEntree = sc.nextInt();
        int colonneEntree = sc.nextInt();
        entree = new SalleCarree(ligneEntree, colonneEntree);


        int ligneSortie = sc.nextInt();
        int colonneSortie = sc.nextInt();
        sortie = new SalleCarree(ligneSortie, colonneSortie);

        for (int i = 0; i < hauteur; i++)
            for (int j = 0; j < largeur; j++)
                salles[i][j] = null;

        salles[ligneEntree][colonneEntree] = entree;
        salles[ligneSortie][colonneSortie] = sortie;

        while (sc.hasNext()) {
            int ligne = sc.nextInt();
            int colonne = sc.nextInt();
            salles[ligne][colonne] = new SalleCarree(ligne, colonne);
        }
    }


    // renvoie les salles accessibles par bob
    public Collection<Salle> sallesAccessibles(Personnage bob) {
        Collection<Salle> sa = new ArrayList();
        SalleCarree tmp = (SalleCarree) bob.getPosition();
        SalleCarree ad;
        try {
            if (tmp.getLigne() - 1 >= 0) {
                ad = salles[tmp.getLigne() - 1][tmp.getColonne()];
                if (ad != null)
                    sa.add(ad); // haut
            }
            if (tmp.getColonne() + 1 < largeur) {
                ad = salles[tmp.getLigne()][tmp.getColonne() + 1];
                if (ad != null)
                    sa.add(ad); // droite
            }
            if (tmp.getLigne() + 1 < hauteur) {
                ad = salles[tmp.getLigne() + 1][tmp.getColonne()];
                if (ad != null)
                    sa.add(ad); // bas
            }
            if (tmp.getColonne() - 1 >= 0) {
                ad = salles[tmp.getLigne()][tmp.getColonne() - 1];
                if (ad != null)
                    sa.add(ad); // gauche
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return sa;
    }


    public Collection<Salle> getSalles() {
        ArrayList<Salle> al = new ArrayList();
        for (int i = 0; i < getHauteur(); i++)
            for (int j = 0; j < getLargeur(); j++)
                if (salles[i][j] != null)
                    al.add(salles[i][j]);
        return al;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }


    public void entrer(Personnage bob) {
        entree.recevoir(bob);
    }

    public boolean sortir(Personnage bob) {
        return (bob.getPosition() == sortie);
    }

    public Salle getEntree() {
        return entree;
    }

    public Salle getSortie() {
        return sortie;
    }

}
