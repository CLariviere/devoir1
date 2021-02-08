public class Bank {
    //attributs
    private Branch[] branches = new Branch[10];

    public void processTransaction(String line) {
        String[] lineSplit = line.split(" ");
    //verfier si code .equals ds la line.
        if (lineSplit[0].equals("build")) {
            String transit = lineSplit[1];
            for (int i=0; i < branches.length; i++){
                //on verifie si il reste de la place dans le array
                //pour une nouvelle branche
                if (branches[i]==null){
                    branches[i] = new Branch(transit);
                } else {
                    Branch[] temp = branches.clone();
                    branches = new Branch[branches.length+10];
                    for (i=0; i<temp.length;i++){
                        branches[i]=temp[i];
                    }
                    branches[temp.length]=new Branch(transit);
                }
            }
        };

        if (lineSplit[0].equals("dismantle")) {
            String transit = lineSplit[1];
            int i=0;
            while (i < branches.length & branches[i]!=null) {
                //condition qui s'assure que la branche existe
                if (!transit.equals(branches[i].getTransit()) & branches[i]!=null){
                i++;}
            }
            branches[i] = null;
        };
        if (lineSplit[0].equals("open")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            for (int i = 0; i < branches.length; i++) {
                //condition qui s'assure que la branche existe
                    if (transit.equals(branches[i].getTransit())){
                        branches[i].openAccount(number);
                    }
            }
        };
        if (lineSplit[0].equals("close")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            for (int i = 0; i < branches.length; i++) {
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
            for (int i = 0; i < branches.length; i++) {
                //condition qui s'assure que la branche existe
                if (transit.equals(branches[i].getTransit())) Branch.verifyAccountDep(number, deposit);
            }
        };
        if (lineSplit[0].equals("withdraw")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            float withdraw = Float.parseFloat(lineSplit[3]);
            for (int i = 0; i < branches.length; i++) {
                //condition qui s'assure que la branche existe
                    if (transit.equals(branches[i].getTransit())) Branch.verifyAccountWith(number, withdraw);
                }
        };
        if (lineSplit[0].equals("bonus")) {
            float bonus = Float.parseFloat(lineSplit[1]);
            //TODO modifie la commande bonus
            //BankAccount.setBonus(bonus);

        };
        if (lineSplit[0].equals("report")) {
            //TODO imprime le rapport
            //selon prof, faire des boucles pour passer dans les branches et les comptes
            //pour aller chercher les montants. La banque appelle report sur ses branches, et les branches appellent report sur les comptes.
            //Donc les comptes cree un rapport, et succursales cree un rapport.

        };
        if (lineSplit[0].equals("short")) {
            //TODO imprime le rapport court
            System.out.println("short-report");
        };
    }
}

