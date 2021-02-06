public class Branch{
    //instances des succursales, gestion des comptes

    //Atributs
    private String transit;
    private int compteurAccount;

    //Constructeur
    public Branch(String transit) {
        this.transit=transit;
        this.compteurAccount=0;
    }
    public String getTransit() {
        return transit;
    }

}

