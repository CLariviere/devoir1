public class Bank {
    //attributs
    private Branch[] branches = new Branch[10];
    private String report, shortReport;

    public void processTransaction(String line) {
        String[] lineSplit = line.split(" ");
    //verfier si code .equals ds la line.
        if (lineSplit[0].equals("build")) {
            String transit = lineSplit[1];
            int i=0;
            boolean cherche=true;
            while(i<branches.length & cherche) {
                //on verifie si il reste de la place dans le array
                //pour une nouvelle branche
                if (branches[i] == null) {
                    branches[i] = new Branch(transit);
                    cherche = false;
                } else {i++;}
            }
            if (cherche==true) {
                Branch[] temp = branches.clone();
                branches = new Branch[branches.length+10];
                for (i=0; i<temp.length;i++){
                    branches[i]=temp[i];
                }
                branches[temp.length]=new Branch(transit);
                }
        };
        if (lineSplit[0].equals("dismantle")) {
            String transit = lineSplit[1];
            int i=0;
            boolean cherche=true;
            while (i < branches.length & branches[i]!=null & cherche) {
                //condition qui s'assure que la branche existe
                if (!transit.equals(branches[i].getTransit())){
                i++;} else {cherche=false;}
            }
            branches[i] = null;
        };
        if (lineSplit[0].equals("open") || lineSplit[0].equals("close") ) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            int i=0;
            while (i < branches.length & branches[i]!=null) {
                //condition qui s'assure que la branche existe
                if (lineSplit[0].equals("open") & transit.equals(branches[i].getTransit())){
                    branches[i].openAccount(number);
                    break;
                }
                if (lineSplit[0].equals("close") & transit.equals(branches[i].getTransit())){
                    branches[i].closeAccount(number);
                    break;
                }
                i++;
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
            for (int i = 0; i < branches.length; i++) {
            System.out.println(branches[i].reportBranch(branches[i].getTransit()));}
        };
        if (lineSplit[0].equals("short")) {
            //TODO creer fichier report
            System.out.println(shortReport);
        }
    }
}

