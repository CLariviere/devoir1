public class Bank {
    //attributs
    private Branch[] branches = new Branch[100];
    private int compteurBranche;

    //constructeur
    public Bank(){
        this.compteurBranche=0;
    }

    public void processTransaction(String line) {
    //verfier si code .equals ds la line.
        if (line.substring(0,5).equals("build")) {
            String transit = line.substring(6,11);
            branches[compteurBranche] = new Branch(transit);
            compteurBranche++;
        };
        if (line.substring(0,9).equals("dismantle")) {
            String transit = line.substring(10,15);
            int i=0;
            while (i < compteurBranche & !transit.equals(branches[i].getTransit())) {
                i++;
            }
            branches[i] = null;
        };
        if (line.substring(0,4).equals("open")) {
            String transit = line.substring(5,10);
            String number = line.substring(11,18);
            int i=0;
            while (i < compteurBranche & !transit.equals(branches[i].getTransit())) {
                i++;
            }
            branches[i].openAccount(number);
        };
        if (line.substring(0,5).equals("close")) {
            String transit = line.substring(6,11);
            String number = line.substring(12,19);
            int i=0;
            while (i < compteurBranche & !transit.equals(branches[i].getTransit())) {
                i++;
            }
            branches[i].closeAccount(number);
        };
        if (line.substring(0,7).equals("deposit")) {
            String transit = line.substring(8,13);
            String number = line.substring(14,21);
            float deposit = Float.parseFloat(line.substring(22, line.length()));
            BankAccount.setAmount(deposit);


        };
        if (line.substring(0,8).equals("withdraw")) {
            String transit = line.substring(9,14);
            String number = line.substring(15,22);
            //on met amount negatif pour un retrait
            float amount = -(Float.parseFloat(line.substring(22, line.length())));
        };
        if (line.substring(0,5).equals("bonus")) {

        };
        if (line.substring(0,6).equals("report")) {
            //imprime le rapport
        };
        if (line.substring(0,5).equals("short")) {
            //imprime le rapport court
            System.out.println("short-report");
        };

    }

}
