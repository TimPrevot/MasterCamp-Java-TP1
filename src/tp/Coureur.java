package tp;

import java.time.LocalDateTime;

public class Coureur {
    private int ID;
    private static int count;
    private String nom;
    private int position;
    private boolean aTermine;
    private boolean aAbandonne;
    private boolean disqualifie;
    private LocalDateTime tempsArrivee;

    public Coureur() {
        this.ID = count++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isaTermine() {
        return aTermine;
    }

    public void setaTermine(boolean aTermine) {
        this.aTermine = aTermine;
    }

    public boolean isDisqualifie() {
        return disqualifie;
    }

    public void setDisqualifie(boolean disqualifie) {
        this.disqualifie = disqualifie;
    }

    public boolean isaAbandonne() {
        return aAbandonne;
    }

    public void setaAbandonne(boolean aAbandonne) {
        this.aAbandonne = aAbandonne;
    }

    public LocalDateTime getTempsArrivee() {
        return tempsArrivee;
    }

    public void setTempsArrivee(LocalDateTime tempsArrivee) {
        this.tempsArrivee = tempsArrivee;
    }

    @Override
    public String toString() {
        return "Coureur{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", position=" + position +
                ", aTermine=" + aTermine +
                ", disqualifie=" + disqualifie +
                '}';
    }

    @Override
    public Coureur clone() {
        Coureur result = new Coureur();
        result.setID(this.ID);
        result.setNom(this.nom);
        result.setPosition(this.position);
        result.setaTermine(this.aTermine);
        result.setDisqualifie(this.disqualifie);
        return result;
    }
}
