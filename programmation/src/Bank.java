public class Bank {
    //attributs
    private Branch[] branches = new Branch[100000]; //TODO a modifie, si tableau trop petit, a copier dans un plus gros tableau
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
                //condition qui s'assure que la branche existe
                if (!transit.equals(branches[i].getTransit()) & branches[i]!=null){
                i++;}
            }
            branches[i] = null;
        };
        if (lineSplit[0].equals("open")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            for (int i = 0; i < compteurBranche; i++) {
                //condition qui s'assure que la branche existe
                    if (transit.equals(branches[i].getTransit())){
                        branches[i].openAccount(number);
                    }
            }
        };
        if (lineSplit[0].equals("close")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            for (int i = 0; i < compteurBranche; i++) {
                //condition qui s'assure que la branche existe
                if (transit.equals(branches[i].getTransit())){
                    branches[i].closeAccount(number);
                }
            }
        };
        if (lineSplit[0].equals("deposit")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            float deposit = Float.parseFloat(lineSplit[3]);
            for (int i = 0; i < compteurBranche; i++) {
                //condition qui s'assure que la branche existe
                if (transit.equals(branches[i].getTransit())) Branch.verifyAccountDep(number, deposit);
            }
        };
        if (lineSplit[0].equals("withdraw")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            float withdraw = Float.parseFloat(lineSplit[3]);
            for (int i = 0; i < compteurBranche; i++) {
                //condition qui s'assure que la branche existe
                    if (transit.equals(branches[i].getTransit())) Branch.verifyAccountWith(number, withdraw);
                }
        };
        if (lineSplit[0].equals("bonus")) {
            float bonus = Float.parseFloat(lineSplit[1]);
            //TODO modifie la commande bonus
            BankAccount.setBonus(bonus);

        };
        if (lineSplit[0].equals("report")) {
            //TODO imprime le rapport
            //selon prof, faire des boucles pour passer dans les branches et les comptes
            //pour aller chercher les montants. La banque appelle report sur ses branches, et les branches appellent report sur les comptes.
            //Donc les comptes crée un rapport, et succursales crée un rapport

        };
        if (lineSplit[0].equals("short")) {
            //TODO imprime le rapport court
            System.out.println("short-report");
        };
    }
}

