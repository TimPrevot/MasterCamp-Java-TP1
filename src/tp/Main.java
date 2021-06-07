package tp;

import static tp.ScannerUtils.scanner;

public class Main {
    public static void main(String[] args) {
        int input;
        boolean continuer = true;
        System.out.println("Combien y a-t-il de coureurs dans la course ?");
        input = scanner.nextInt();
        Course course = new Course(input);
        System.out.println("Veuillez rentrer les informations des coureurs participant à la course :");
        course.createTable();
        course.afficherCoureurs();
        while (continuer) {
            System.out.println("Choisissez une action :");
            System.out.println("0 : Quitter le programme");
            System.out.println("1 : Afficher les coureurs");
            System.out.println("2 : Afficher le classement provisoire");
            System.out.println("3 : Enregistrer une arrivée");
            System.out.println("4 : Enregistrer un abandon");
            System.out.println("5 : Enregistrer une disqualification");
            System.out.println("6 : Enregistrer le temps d'arrivée d'un coureur");
            System.out.println("7 : Obtenir le temps d'un coureur");
            System.out.println("8 : Obtenir le temps d'écart entre deux coureurs donnés");
            input = scanner.nextInt();
            switch(input) {
                case 0:
                    continuer = false;
                    break;
                case 1:
                    course.afficherCoureurs();
                    break;
                case 2:
                    course.afficherClassement();
                    break;
                case 3:
                    course.addArrivee();
                    break;
                case 4:
                    course.addAbandon();
                    break;
                case 5:
                    course.addDisqualification();
                    break;
                case 6:
                    course.addTempsArrivee();
                    break;
                case 7:
                    course.getTempsArrivee();
                    break;
                case 8:
                    course.getDifferenceTemps();
                    break;
                default:
                    break;
            }
            System.out.println("Au revoir.");
        }
    }
}
