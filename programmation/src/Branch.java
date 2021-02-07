public class Branch{
    //instances des succursales, gestion des comptes

    //Atributs
    private String transit, number;
    private BankAccount[] accounts = new BankAccount[100];
    private int compteurAccount;

    //Constructeur
    public Branch(String transit) {
        this.transit=transit;
        this.compteurAccount=0;
    }

    //getter
    public String getTransit() {
        return transit;
    }

    public void openAccount(String number){
        accounts[compteurAccount] = new BankAccount(number);
        compteurAccount++;
    }
    public void closeAccount(String number){
        int i=0;
        while (i < compteurAccount & accounts[i]!=null){
            if (!number.equals(accounts[i].getNumber()) & accounts[i]!=null) {
            i++;
        }
        accounts[i] = null;
        }
    }

}
