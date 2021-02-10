//Catherine Lariviere 0955948
//Maha Faraj 20092708
//2021-02-10

public class Branch{
    //instances des succursales, gestion des comptes

    //Atributs
    private  BankAccount[] accounts=new BankAccount[10];
    private  float totalDeposit, totalDepositAccount;
    private String transit, reportBranch;

    //Constructeur
    public Branch(String transit) {
        this.transit=transit;
        this.reportBranch="";
        this.totalDeposit=0;
    }

    //getter
    public String getTransit() {return transit;}
    public Float getTotalDepositAccount(){return totalDepositAccount;}

    public void openAccount(String transit, String number, float bonus) {
        boolean cherche = true;
        int i = 0;
        while (i < accounts.length && cherche) {
            //on verifie si il reste de la place dans le array
            //pour une nouvelle branche
            if (accounts[i]!=null && number.equals(accounts[i].getNumber())){
                cherche=false;
                break;}
            if (accounts[i] == null) {
                //on ouvre un account ds une place vide array
                accounts[i] = new BankAccount(transit, number, bonus);
                cherche = false;
            } else {
                i++;}
        }
        if (cherche) {
            //on cree un nouvel array plus grand, en copiant l'existant
            BankAccount[] temp = accounts.clone();
            accounts = new BankAccount[accounts.length + 10];
            for (i = 0; i < temp.length; i++) {
                accounts[i] = temp[i];
            }
            accounts[temp.length] = new BankAccount(transit, number, bonus);
        }
    }
    public void closeAccount(String number){
        boolean cherche = true;
        int i = 0;
        while (i < accounts.length && cherche) {
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

    public  void verifyAccountDep(String number, float deposit){
        boolean cherche=true;
        int i=0;
        while (i < accounts.length && cherche){
            //condition qui s'assure que le compte existe
            if (accounts[i]!=null) {
                if (number.equals(accounts[i].getNumber())) {
                    //verifie que le account est ouvert
                    if (accounts[i].getStatus()) {
                        accounts[i].setDeposit(deposit);
                        totalDeposit+= deposit;
                        cherche = false;
                    }
                }
                else{i++;}
            }
            else{i++;}
        }
    }
    public  void verifyAccountWith(String number, float withdraw){
        boolean cherche=true;
        int i=0;
        while (i < accounts.length && cherche){
            //condition qui s'assure que le compte existe
            if (accounts[i]!=null) {
                if (number.equals(accounts[i].getNumber())) {
                    //verifie que le account est ouvert
                    if (accounts[i].getStatus()) {
                        accounts[i].setWithdraw(withdraw);
                        cherche = false;
                    }
                }
                else{i++;}
            }
            else{i++;}
        }
    }
    public String reportBranch(String transit){
        reportBranch="";
        int accountClose=0;
        int accountOpen=0;
        float totalCloseAccount=0;
        String report="### Branch "+transit+" ###\n";
        //boucle compte ferme et montant compte ferme
        for (int i=0; i<accounts.length; i++){
            if (accounts[i]!=null && accounts[i].getStatus()==false) {
                accountClose += 1;
                totalCloseAccount+=accounts[i].getAmount();
            } if (accounts[i]!=null && accounts[i].getStatus()==true) {
                //boucle total compte ouvert et total montant compte ouvert
                accountOpen +=1;
                reportBranch += "*** Account " + transit + ":" + accounts[i].getNumber() + "\n";
                reportBranch += "    Balance = " + accounts[i].getAmount() + "$\n";
                reportBranch += "    Last operation " + accounts[i].getLastOperation() + " " +
                        accounts[i].getLastOperationAmount() + "$\n";
                totalDepositAccount+=accounts[i].getAmount();
            }
        }
        //construction du report
        report += "    " + accountOpen + " active accounts.\n";
        report += reportBranch + "    Total deposits = " + totalDepositAccount + "$\n";
        report += "    " + accountClose + " closed accounts.\n" + "    Total closed accounts = "
                + totalCloseAccount + "$\n####################\n";
        return report;
    }
}
