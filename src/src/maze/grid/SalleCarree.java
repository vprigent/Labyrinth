package maze.grid;


import player.Player;

public class SalleCarree implements Case {
    private int x;
    private int y;

    public SalleCarree(int colonne, int ligne) {
        this.x = colonne;
        this.y = ligne;
    }

    public void recevoir(Player bob) {
        bob.setPosition(this);
    }

    public int getLigne() {
        return x;
    }

    public int getColonne() {
        return y;
    }

    public String toString() {
        return "Salle: " + x + "," + y;
    }
}
