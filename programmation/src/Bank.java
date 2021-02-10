//Catherine Lariviere 0955948
//Maha Faraj 20092708
//2021-02-10

public class Bank {
    //attributs

    private Branch[] branches = new Branch[10];
    private float bonus;

    public void processTransaction(String line) {
        String[] lineSplit = line.split(" ");
        if (lineSplit[0].equals("build") || lineSplit[0].equals("dismantle")) {
            String transit = lineSplit[1];
            int i=0;
            boolean cherche=true;
            while(i<branches.length && cherche) {
                if(lineSplit[0].equals("build")) {
                    //condition qui trouve la branch
                    if (branches[i] != null && transit.equals(branches[i].getTransit())) {
                        cherche = false;
                        break;
                    }
                    //on ouvre branch ds array si place vide
                    if (branches[i] == null) {
                        branches[i] = new Branch(transit);
                        cherche = false;
                        break;
                    }
                }
                if (lineSplit[0].equals("dismantle") && branches[i]!=null) {
                    //on remet la branche a null
                    if (transit.equals(branches[i].getTransit())){
                        branches[i] = null;
                        cherche=false;}
                    else {i++;}
                }
                else {i++;}
            }
            if (cherche && lineSplit[0].equals("build")) {
                //le array est plein, on reinitialise array plus gros
                Branch[] temp = branches.clone();
                branches = new Branch[branches.length+10];
                for (i=0; i<temp.length;i++){
                    branches[i]=temp[i];
                }
                branches[temp.length]=new Branch(transit);
            }
        }
        if (lineSplit[0].equals("open") || lineSplit[0].equals("close") ) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            int i=0;
            while (i < branches.length && branches[i]!=null) {
                //condition qui s'assure que la branche existe, avec le bon transit
                if (lineSplit[0].equals("open") && transit.equals(branches[i].getTransit())){
                    branches[i].openAccount(transit, number, bonus);
                    break;
                }
                if (lineSplit[0].equals("close") && transit.equals(branches[i].getTransit())){
                    //condition qui s'assure que la branche existe, avec le bon transit
                    branches[i].closeAccount(number);
                    break;
                }
                else{i++;};
            }
        }

        if (lineSplit[0].equals("deposit") || lineSplit[0].equals("withdraw")) {
            String transit = lineSplit[1];
            String number = lineSplit[2];
            boolean cherche=true;
            int i=0;
            while (i < branches.length && cherche) {
                //condition qui s'assure que la branche existe
                if (branches[i]!=null){
                    if (transit.equals(branches[i].getTransit()) && lineSplit[0].equals("deposit")) {
                        float deposit = Float.parseFloat(lineSplit[3]);
                        //methode pour verifier status du account
                        branches[i].verifyAccountDep(number, deposit);
                        cherche=false;}
                    if (transit.equals(branches[i].getTransit()) && lineSplit[0].equals("withdraw")) {
                        float withdraw = Float.parseFloat(lineSplit[3]);
                        //methode pour verifier status du account
                        branches[i].verifyAccountWith(number, withdraw);
                        cherche=false;
                    }
                    else {i++;}
                }
                else {i++;}
            }
        }
        if (lineSplit[0].equals("bonus")) {
            bonus = Float.parseFloat(lineSplit[1]);
        }
        if (lineSplit[0].equals("report") || lineSplit[0].equals("short-report")) {
            String report = "+++ Bank Report +++\n";
            float totalDeposit = 0;
            for (int i = 0; i < branches.length; i++) {
                if (branches[i]!=null) {
                        report+=(branches[i].reportBranch(branches[i].getTransit()));
                        totalDeposit+=branches[i].getTotalDepositAccount();
                }
            }
            if (lineSplit[0].equals("report")){
                report+="Bank total deposits = "+totalDeposit+"$\n-------------------";
                System.out.println(report);}
            if (lineSplit[0].equals("short-report")){
                String shortReport = "+++ Bank Report +++\n";
                shortReport += "Bank total deposits = " + totalDeposit + "$\n-------------------";
                System.out.println(shortReport);}
        }
    }
}

