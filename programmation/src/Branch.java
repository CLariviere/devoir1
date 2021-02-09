public class Branch{
    //instances des succursales, gestion des comptes

    //Atributs
    private String transit, reportBranch;
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

    public void openAccount(String number) {
        boolean cherche = true;
        int i = 0;
        while (i < accounts.length & cherche) {
            //on verifie si il reste de la place dans le array
            //pour une nouvelle branche
            if (accounts[i] == null) {
                accounts[i] = new BankAccount(number);
                cherche = false;
            } else {
                i++;
            }
        }
        if (cherche == true) {
            BankAccount[] temp = accounts.clone();
            accounts = new BankAccount[accounts.length + 10];
            for (i = 0; i < temp.length; i++) {
                accounts[i] = temp[i];
            }
            accounts[temp.length] = new BankAccount(number);
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
                if (accounts[i].getStatus() == true){
                BankAccount.setDeposit(deposit);}
            }
       }
    }
    public static void verifyAccountWith(String number, float withdraw){
        for (int i = 0; i < compteurAccount; i++) {
            //condition qui s'assure que le compte existe
            if (number.equals(accounts[i].getNumber())){
                if (accounts[i].getStatus() == true){
                    BankAccount.setWithdraw(withdraw);}
            }
        }
    }
    //TODO reportBranch
    public String reportBranch(String transit){
        reportBranch="";
        int accountClose=0;
        int accountOpen=0;
        float totalOpenAccount=0;
        float totalCloseAccount=0;
        String report="### Branch "+transit+" ###\n";
        //boucle compte ferme et montant compte ferme
        for (int i=0; i<accounts.length; i++){
            if (accounts[i].getStatus()==false) {
                accountClose += 1;
                totalCloseAccount+=accounts[i].getAmount();
            } else {
                //boucle total compte ouvert et total montant compte ouvert
                accountOpen +=1;
                totalOpenAccount+=accounts[i].getAmount();
                reportBranch=reportBranch+"*** Account "+transit+":"+accounts[i].getNumber()+"\n";
                reportBranch=reportBranch+"    Balance = "+accounts[i].getAmount()+"$\n";
                reportBranch=reportBranch+"Last operation "+accounts[i].getLastOperation()+" "+accounts[i].getLastOperationAmount()+"$\n";
            }
        }
        report = report+ "    " + accountOpen + " active accounts.\n";
        report=report+reportBranch + "    Total deposits = " + totalOpenAccount + "$\n";
        report=report+"    "+accountClose+ "closed accounts.\n"+"    Total closed accounts = "+totalCloseAccount+"$";
        return report;
    }
}
