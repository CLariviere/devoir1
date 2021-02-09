//Catherine Lariviere 0955948
//2021-02-15

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

    public void openAccount(String number, float bonus) {
        boolean cherche = true;
        int i = 0;
        while (i < accounts.length & cherche) {
            //on verifie si il reste de la place dans le array
            //pour une nouvelle branche
            if (accounts[i] == null) {
                accounts[i] = new BankAccount(number, bonus);
                cherche = false;
            } else {
                i++;}
        }
        if (cherche == true) {
            //on cree un nouvel array plus grand
            BankAccount[] temp = accounts.clone();
            accounts = new BankAccount[accounts.length + 10];
            for (i = 0; i < temp.length; i++) {
                accounts[i] = temp[i];
            }
            accounts[temp.length] = new BankAccount(number, bonus);
        }
        compteurAccount++;
    }
    public void closeAccount(String number){
        boolean cherche = true;
        int i = 0;
        while (i < accounts.length & cherche) {
            //condition qui s'assure que le compte existe
            if (accounts[i]!=null){
                if (number.equals(accounts[i].getNumber())) {
                    accounts[i].setStatus();
                    cherche=false;}
                else {i++;}
            }
            else {i++;}
        }
    }

    public static void verifyAccountDep(String number, float deposit){
        boolean cherche=true;
        int i=0;
        while (i < accounts.length & cherche){
            //condition qui s'assure que le compte existe
            if (accounts[i]!=null) {
                if (number.equals(accounts[i].getNumber())) {
                    //verifie que le account est ouvert
                    if (accounts[i].getStatus() == true) {
                        BankAccount.setDeposit(deposit);
                        cherche = false;
                    }
                }
                else{i++;}
            }
            else{i++;}
       }
    }
    public static void verifyAccountWith(String number, float withdraw){
        boolean cherche=true;
        int i=0;
        while (i < accounts.length & cherche){
            //condition qui s'assure que le compte existe
            if (accounts[i]!=null) {
                if (number.equals(accounts[i].getNumber())) {
                    //verifie que le account est ouvert
                    if (accounts[i].getStatus() == true) {
                        BankAccount.setWithdraw(withdraw);
                        cherche = false;
                    }
                }
                else{i++;}
            }
            else{i++;}
        }
    }
    //TODO reportBranch, bug qui loop 3 fois?
    public String reportBranch(String transit){
        reportBranch="";
        int accountClose=0;
        int accountOpen=0;
        float totalOpenAccount=0;
        float totalCloseAccount=0;
        String report="### Branch "+transit+" ###\n";
        //boucle compte ferme et montant compte ferme
        for (int i=0; i<accounts.length; i++){
            if (accounts[i].getStatus()==false & accounts[i]!=null) {
                accountClose += 1;
                totalCloseAccount+=accounts[i].getAmount();
            } if (accounts[i].getStatus()==true & accounts[i]!=null) {
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
        report=report+"    "+accountClose+ "closed accounts.\n"+"    Total closed accounts = "+totalCloseAccount+"$\n";
        report=report+"####################\n";
        return report;
    }
}
