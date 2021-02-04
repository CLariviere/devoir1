public class Bank {

    //gestion des transactions
         private String code;
         private int transit, number, amount;

        // Constructeur

    public Bank( String code, int transit,int number,int amount ) {
        this.code = code;
        this.transit = transit;
        this.number = number;
        this.amount = amount;
    }

    // getters
        public String getCode() {
            return code;
        };
        public Integer getTransit() {
        return transit;
    };
        public Integer getNumber() {
        return number;
    };
        public Integer getAmount() {
        return amount;
    }
    }

    public void processTransaction(String line) {

    //verfier si code .equals ds la line. assigner int aux bonne variables

    }
}
public class Universitaire {
    // Attributs
    private String prenom, nom, adresseCourriel;

    // Constructeur
    public Universitaire( String prenom, String nom ) {
        this.prenom = prenom;
        this.nom = nom;
    }

    // getters
    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresseCourriel() {
        return adresseCourriel;
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    // autres méthodes
}
