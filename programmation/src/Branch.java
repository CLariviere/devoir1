public class Branch{
    //instances des succursales, gestion des comptes

    //Atributs
    private String transit, number;
    private BankAccount[] accounts = new BankAccount[100];
    private static int compteurAccount;

    //Constructeur
    public Branch(String transit) {
        this.transit=transit;
        this.compteurAccount=0;
    }

    //getter
    public String getTransit() {
        return transit;
    }
    public static int getCompteurAccount(){return compteurAccount;}

    public void openAccount(String number){
        accounts[compteurAccount] = new BankAccount(number);
        compteurAccount++;
    }
    public void closeAccount(String number){
        for (int i = 0; i < compteurAccount; i++) {
            //condition qui s'assure que le compte existe
            if (number.equals(accounts[i].getNumber())){
                accounts[i] = null;
                compteurAccount--;
            }

        }
    }
}
