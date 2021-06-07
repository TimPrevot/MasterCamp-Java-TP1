package tp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Vector;

import static tp.ScannerUtils.scanner;

public class Course {
    int nb_coureurs;
    Vector<Coureur> listeCoureurs;

    public Course(int nb_coureurs) {
        this.nb_coureurs = nb_coureurs;
    }

    public void addCoureur(Coureur newCoureur) {
        this.listeCoureurs.add(newCoureur);
    }

    public Coureur createCoureur() {
        Coureur newCoureur = new Coureur();
        String nom;
        int position;
        System.out.println("Quel est le nom du coureur ?");
        nom = scanner.nextLine();
        newCoureur.setNom(nom);
        System.out.println("Quel est la position du coureur ?");
        position = scanner.nextInt();
        newCoureur.setPosition(position);
        newCoureur.setaTermine(false);
        newCoureur.setDisqualifie(false);
        newCoureur.setaAbandonne(false);
        return newCoureur;
    }

    public void createTable() {
        int i = 0;
        for (i = 0; i < nb_coureurs; i++) {
            this.listeCoureurs.add(createCoureur());
        }
    }

    public void afficherCoureurs() {
        String maChaine;
        for (Coureur coureur : listeCoureurs) {
            maChaine = coureur.toString();
            System.out.println(maChaine);
        }
    }

    public void afficherClassement() {
        int cpt = 1;
        String maChaine;
        Vector<Coureur> classement = new Vector<>();
        for (Coureur coureur : listeCoureurs) {
            if (coureur.getPosition() == cpt) {
                classement.add(coureur.clone());
            }
            cpt++;
        }
        for (Coureur coureur : classement) {
            maChaine = coureur.toString();
            System.out.println(maChaine);
        }
    }

    public void addArrivee() {
        int choix = 0;
        System.out.println("Choisissez l'ID coureur arrivé :");
        afficherCoureurs();
        choix = scanner.nextInt();
        listeCoureurs.get(choix).setaTermine(true);
        System.out.println("Opération effectuée");
    }

    public void addAbandon() {
        int choix = 0;
        System.out.println("Choisissez l'ID coureur qui a abandonné :");
        afficherCoureurs();
        choix = scanner.nextInt();
        listeCoureurs.get(choix).setaAbandonne(true);
        System.out.println("Opération effectuée");
    }

    public void addDisqualification() {
        int choix = 0;
        System.out.println("Choisissez l'ID coureur disqualifié :");
        afficherCoureurs();
        choix = scanner.nextInt();
        listeCoureurs.get(choix).setDisqualifie(true);
        System.out.println("Opération effectuée");
    }

    public void addTempsArrivee() {
        int choix = 0;
        System.out.println("Choisissez l'ID coureur disqualifié :");
        afficherCoureurs();
        choix = scanner.nextInt();
        System.out.println("Veuillez rentrer la date et l'heure d'arrivée, au format aaaa-MM-JJ HH:mm.ss");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
        listeCoureurs.get(choix).setTempsArrivee(dateTime);
    }

    public void getTempsArrivee() {
        int choix = 0;
        System.out.println("Choisissez l'Id du coureur voulu :");
        afficherCoureurs();
        choix = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String temps = listeCoureurs.get(choix).getTempsArrivee().format(formatter);
        System.out.println("Le coureur " + choix + " a terminé en " + temps);
    }

    public void getDifferenceTemps() {
        int choix = 0, choix2 = 0;
        System.out.println("Choisissez l'Id du coureur voulu :");
        afficherCoureurs();
        choix = scanner.nextInt();
        System.out.println("Choisissez l'Id du coureur voulu :");
        choix2 = scanner.nextInt();
        if (listeCoureurs.get(choix -1).getPosition() > listeCoureurs.get(choix2 - 1).getPosition() && listeCoureurs.get(choix - 1).isaTermine() && listeCoureurs.get(choix2 - 1).isaTermine()) {

            LocalDateTime premier = LocalDateTime.from(listeCoureurs.get(choix).getTempsArrivee());
            LocalDateTime deuxieme=  LocalDateTime.from(listeCoureurs.get(choix2).getTempsArrivee());
            long hours = premier.until(deuxieme, ChronoUnit.HOURS);
            premier.plusHours(hours);
            long minutes = premier.until(deuxieme, ChronoUnit.MINUTES);
            premier.plusMinutes(minutes);
            long secondes = premier.until(deuxieme, ChronoUnit.SECONDS);
            premier.plusSeconds(secondes);
            System.out.println("La différence entre les coureurs " + choix + " et " + choix2 + " est de " + hours + " heures " + minutes + " minutes et " + secondes + " secondes");
            System.out.println("Le coureur " + choix + " est arrivé en premier.");

        } else if (listeCoureurs.get(choix).getPosition() < listeCoureurs.get(choix2).getPosition() && listeCoureurs.get(choix - 1).isaTermine() && listeCoureurs.get(choix2 - 1).isaTermine()) {

            LocalDateTime premier = LocalDateTime.from(listeCoureurs.get(choix2).getTempsArrivee());
            LocalDateTime deuxieme=  LocalDateTime.from(listeCoureurs.get(choix).getTempsArrivee());
            long hours = premier.until(deuxieme, ChronoUnit.HOURS);
            premier.plusHours(hours);
            long minutes = premier.until(deuxieme, ChronoUnit.MINUTES);
            premier.plusMinutes(minutes);
            long secondes = premier.until(deuxieme, ChronoUnit.SECONDS);
            premier.plusSeconds(secondes);
            System.out.println("La différence entre les coureurs " + choix2 + " et " + choix + " est de " + hours + " heures " + minutes + " minutes et " + secondes + " secondes");
            System.out.println("Le coureur " + choix2 + " est arrivé en premier.");

        } else if (listeCoureurs.get(choix).getPosition() == listeCoureurs.get(choix2).getPosition() && listeCoureurs.get(choix - 1).isaTermine() && listeCoureurs.get(choix2 - 1).isaTermine()) {
            System.out.println("Les deux coureurs sont arrivés en même temps");
        } else {
            System.out.println("Les deux coureurs ne sont pas encore arrivés");
        }
    }

}
