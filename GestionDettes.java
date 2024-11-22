import java.util.ArrayList;
import java.util.List;

/*
 * je vais creer les classes Dette et Client 
 * les methodes necessaires sont  :

enregistrerDette(int idDette, double montant, int idClient) : 
filtrerDettesParTel(String tel) : 
ajouterClient(Client client) :
trouverClientParId(int id) :
 */

public class GestionDettes {
    
    static class Client {
        int id;
        String nom;
        String prenom;
        String tel;

        public Client(int id, String nom, String prenom, String tel) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.tel = tel;
        }

        public String toString() {
            return "Client{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', tel='" + tel + "'}";
        }
    }

    static class Dette {
        int id;
        double montant;
        Client client; // Lien avec le client

        public Dette(int id, double montant, Client client) {
            this.id = id;
            this.montant = montant;
            this.client = client;
        }

        public String toString() {
            return "Dette{id=" + id + ", montant=" + montant + ", client=" + client + "}";
        }
    }

    // Listes pour stocker les clients et les dettes
    static List<Client> clients = new ArrayList<>();
    static List<Dette> dettes = new ArrayList<>();

    //  Enregistrer une nouvelle dette pour un client
    public static void enregistrerDette(int idDette, double montant, int idClient) {
        Client client = trouverClientParId(idClient);
        if (client != null) {
            Dette dette = new Dette(idDette, montant, client);
            dettes.add(dette);  // Ajouter la dette à la liste des dettes
            System.out.println("Dette enregistrée: " + dette);
        } else {
            System.out.println("Client introuvable !");
        }
    }

    // Lister toutes les dettes
    public static void listerDettes() {
        if (dettes.isEmpty()) {
            System.out.println("Aucune dette enregistrée.");
        } else {
            for (Dette dette : dettes) {
                System.out.println(dette);
            }
        }
    }

    // Filtrer les dettes par téléphone du client
    public static void filtrerDettesParTel(String tel) {
        boolean trouve = false;
        for (Dette dette : dettes) {
            if (dette.client.tel.equals(tel)) {
                System.out.println(dette);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucune dette trouvée pour ce téléphone.");
        }
    }

    // Méthode pour ajouter un client à la liste
    public static void ajouterClient(Client client) {
        clients.add(client);
    }

    // Méthode pour trouver un client par son ID
    private static Client trouverClientParId(int id) {
        for (Client client : clients) {
            if (client.id == id) {
                return client;
            }
        }
        return null; 
    }

    
}
