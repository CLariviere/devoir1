public class Branch{
    //instances des succursales, gestion des comptes

    //Atributs
    private String transit, number, reportBranch;
    private static BankAccount[] accounts = new BankAccount[10];
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
        for (int i=0; i < accounts.length; i++){
            //on verifie si il reste de la place dans le array
            //pour un nouveau compte
            if (accounts[i]==null){
                accounts[i] = new BankAccount(number);
            } else {
                BankAccount[] temp = accounts.clone();
                accounts = new BankAccount[accounts.length+10];
                for (i=0; i<temp.length;i++){
                    accounts[i]=temp[i];
                }
                accounts[temp.length]= new BankAccount(transit);
            }
        }
        compteurAccount++;
    }

    public void closeAccount(String number){
        for (int i = 0; i < compteurAccount; i++) {
            //condition qui s'assure que le compte existe
            if (number.equals(accounts[i].getNumber())) accounts[i].setStatus();
        }
    }
    public static void verifyAccountDep(String number, float deposit){
        for (int i = 0; i < compteurAccount; i++) {
            //condition qui s'assure que le compte existe
            if (number.equals(accounts[i].getNumber())){
                BankAccount.setDeposit(deposit);
            }
       }
    }
    public static void verifyAccountWith(String number, float withdraw){
        for (int i = 0; i < compteurAccount; i++) {
            //condition qui s'assure que le compte existe
            if (number.equals(accounts[i].getNumber())) BankAccount.setWithdraw(withdraw);
        }
    }
    public String reportBranch(){
        //loop sur le tableau account en appelant accounts[i].reportAccount()
        reportBranch="";
        for (int i=0; i<accounts.length; i++){
            int accountClose=0;
            float totalCloseAccount=0;
            if (accounts[i].getStatus()==false) {
                accountClose += 1;
                totalCloseAccount=accounts[i].getAmount();
            }

        }
        return reportBranch;
    }
}
