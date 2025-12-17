import Personnel.Personnel;
import Personnel.PersonnelDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Personnel> personnels = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Combien de membres du personnel voulez-vous saisir ? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("=== Saisie du personnel " + (i + 1) + " ===");
            Personnel p = new Personnel();

            System.out.print("Nom : ");
            p.nom = sc.nextLine();

            System.out.print("Prénom : ");
            p.prenom = sc.nextLine();

            while (true) {
                try {
                    System.out.print("Date de naissance (dd/MM/yyyy) : ");
                    p.dateNaissance = LocalDate.parse(sc.nextLine(), formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Format invalide ! Veuillez entrer la date au format dd/MM/yyyy.");
                }
            }

            System.out.print("Adresse : ");
            p.adresse = sc.nextLine();

            System.out.print("Ville : ");
            p.ville = sc.nextLine();

            System.out.print("Code Postal : ");
            p.cp = sc.nextLine();

            System.out.print("Email : ");
            p.email = sc.nextLine();

            System.out.print("Téléphone : ");
            p.telephone = sc.nextLine();

            System.out.print("Sexe (M/F) : ");
            String saisieSexe = sc.nextLine();
            p.sexe = !saisieSexe.isEmpty() ? saisieSexe.charAt(0) : ' ';

            System.out.print("Taille (en m) : ");
            p.taille = Float.parseFloat(sc.nextLine());

            System.out.print("Poids (en kg) : ");
            p.poids = Float.parseFloat(sc.nextLine());

            System.out.print("Date d'embauche (dd/MM/yyyy) : ");
            p.dateEmbauche = sc.nextLine(); // peut rester vide si non fournie

            System.out.print("Date de fin de contrat (dd/MM/yyyy) : ");
            p.finContrat = sc.nextLine();   // peut rester vide si non fournie

            System.out.println("Statut : ");
            p.statut = sc.nextLine();

            System.out.println("Rôle : ");
            p.role = sc.nextLine();

            System.out.print("Experience (en année) : ");
            p.experience = Integer.parseInt(sc.nextLine());


            /* Saisie des dates de contrat
            while (true) {
                try {
                    System.out.print("Date d'embauche (dd/MM/yyyy) : ");
                    String dateEmbauche = sc.nextLine();
                    p.dateEmbauche = dateEmbauche.isEmpty() ? null : LocalDate.parse(dateEmbauche, formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Format invalide !");
                }
            }

            while (true) {
                try {
                    System.out.print("Date de fin de contrat (dd/MM/yyyy) : ");
                    String finContrat = sc.nextLine();
                    p.finContrat = finContrat.isEmpty() ? null : LocalDate.parse(finContrat, formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Format invalide !");
                }
            }
            */


            personnels.add(p);
            System.out.println("Membre du personnel ajouté avec succès !");
        }

        sc.close();

        // Affichage
        System.out.println("\n=== Liste du personnel ===");
        for (Personnel p : personnels) {
            p.displayInfo();
            System.out.println();
        }

        // Insertion dans la base PostgreSQL
        PersonnelDAO.insertPersonnels(personnels);
    }
}
