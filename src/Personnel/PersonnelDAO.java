package Personnel;

import java.sql.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonnelDAO {

    // ✅ Paramètres de connexion
    private static final String URL = "jdbc:postgresql://localhost:5432/wetestify";
    private static final String USER = "postgres";          // ton utilisateur PostgreSQL
    private static final String PASSWORD = "BeyaGrace0510$"; // ton mot de passe PostgreSQL

    /**
     * Insère une liste de membres du personnel dans la base PostgreSQL
     *
     * @param personnels Liste des objets Personnel
     */
    public static void insertPersonnels(List<Personnel> personnels) {

        // 🔹 Charger explicitement le driver PostgreSQL
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver PostgreSQL non trouvé !");
            e.printStackTrace();
            return;
        }

        String sql = "INSERT INTO personnel " +
                "(nom, prenom, date_naissance, adresse, ville, cp, email, telephone, sexe, taille, poids, dateEmbauche, finContrat, statut) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // 🔹 Connexion et préparation de la requête
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Personnel p : personnels) {
                ps.setString(1, p.nom);
                ps.setString(2, p.prenom);
                ps.setDate(3, java.sql.Date.valueOf(p.dateNaissance));
                ps.setString(4, p.adresse);
                ps.setString(5, p.ville);
                ps.setString(6, p.cp);
                ps.setString(7, p.email);
                ps.setString(8, p.telephone);
                ps.setString(9, String.valueOf(p.sexe));
                ps.setFloat(10, p.taille);
                ps.setFloat(11, p.poids);
                ps.setString(12, p.dateEmbauche);
                ps.setString(13, p.finContrat);
                ps.setString(14, p.statut);
                ps.setString(15, p.role);
                ps.setInt(16, p.experience);

                /*
                ps.setDate(12, p.dateEmbauche != null ? java.sql.Date.valueOf(p.dateEmbauche) : null);
                ps.setDate(13, p.finContrat != null ? java.sql.Date.valueOf(p.finContrat) : null);
                */
                ps.addBatch();
            }

            // 🔹 Exécuter le batch
            int[] rows = ps.executeBatch();
            System.out.println("Insertion réussie pour " + rows.length + " membres du personnel.");

        } catch (SQLException e) {
            System.err.println("Erreur SQL : vérifie l'utilisateur/mot de passe et la base wetestify");
            e.printStackTrace();
        }
    }
}
