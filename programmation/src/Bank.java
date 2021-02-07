public class Bank {
    //attributs
    private Branch[] branches = new Branch[100];
    private int compteurBranche;

    //constructeur
    public Bank(){
        this.compteurBranche=0;
    }

    public void processTransaction(String line) {
        String[] lineSplit = line.split(" ");
    //verfier si code .equals ds la line.
        if (lineSplit[0].equals("build")) {
            String transit = lineSplit[1];
            branches[compteurBranche] = new Branch(transit);
            compteurBranche++;
        };
        if (lineSplit[0].equals("dismantle")) {
            String transit = lineSplit[1];
            int i=0;
            while (i < compteurBranche & branches[i]!=null) {
                if (!transit.equals(branches[i].getTransit()) & branches[i]!=null){
                i++;}
            }
            branches[i] = null;
        };
        if (lineSplit[0].equals("open")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            int i=0;
            while (i < compteurBranche & !transit.equals(branches[i].getTransit())) {
                i++;
            }
            //TODO ajouter condition si branche inexistante
            branches[i].openAccount(number);
        };
        if (lineSplit[0].equals("close")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            int i=0;
            while (i < compteurBranche & !transit.equals(branches[i].getTransit())) {
                i++;
            }
            //TODO ajouter condition si bankAccount inexistant
            branches[i].closeAccount(number);
        };
        if (lineSplit[0].equals("deposit")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            float deposit = Float.parseFloat(lineSplit[3]);
            BankAccount.setDeposit(deposit);
            //TODO ajouter condition si branch/bankAccount inexistant

        };
        if (lineSplit[0].equals("withdraw")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            float withdraw = Float.parseFloat(lineSplit[3]);
            BankAccount.setWithdraw(withdraw);
            //TODO ajouter condition si branch/bankAccount inexistant
        };
        if (lineSplit[0].equals("bonus")) {
            float bonus = Float.parseFloat(lineSplit[1]);
            //TODO modifie la commande bonus
            BankAccount.setAmount(bonus);

        };
        if (lineSplit[0].equals("report")) {
            //imprime le rapport
        };
        if (lineSplit[0].equals("short")) {
            //imprime le rapport court
            System.out.println("short-report");
        };

    }
}
