package Personnel;

import java.time.LocalDate;

public class Personnel {

    public String nom;
    public String prenom;
    public LocalDate dateNaissance;
    public String adresse;
    public String ville;
    public String cp;
    public String email;
    public String telephone;
    public String genre;
    public float taille;
    public float poids;
    public String dateEmbauche;
    public String finContrat;

    // Constructeur vide
    public Personnel() {}

    // Constructeur complet
    public Personnel(String nom, String prenom, LocalDate dateNaissance, String adresse, String ville,
                     String cp, String email, String telephone, String genre,
                     float taille, float poids, String dateEmbauche, String finContrat) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.email = email;
        this.telephone = telephone;
        this.genre = genre;
        this.taille = taille;
        this.poids = poids;
        this.dateEmbauche = dateEmbauche;
        this.finContrat = finContrat;
    }

    // toString pour affichage rapide
    @Override
    public String toString() {
        return "Nom : " + nom + "\n" +
                "Prénom : " + prenom + "\n" +
                "Date de naissance : " + dateNaissance + "\n" +
                "Adresse : " + adresse + "\n" +
                "Ville : " + ville + "\n" +
                "CP : " + cp + "\n" +
                "Email : " + email + "\n" +
                "Téléphone : " + telephone + "\n" +
                "Genre : " + genre + "\n" +
                "Taille : " + taille + " m\n" +
                "Poids : " + poids + " kg\n";
    }

    // Méthode displayInfo() pour affichage détaillé
    public void displayInfo() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Date de naissance : " + dateNaissance);
        System.out.println("Adresse : " + adresse);
        System.out.println("Ville : " + ville);
        System.out.println("CP : " + cp);
        System.out.println("Email : " + email);
        System.out.println("Téléphone : " + telephone);
        System.out.println("Genre : " + genre);
        System.out.println("Taille : " + taille + " m");
        System.out.println("Poids : " + poids + " kg");
        System.out.println("Date Embauche : " + dateEmbauche);
        System.out.println("Fin Contrat : " + finContrat);
    }
}
