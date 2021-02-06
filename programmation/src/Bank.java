public class Bank {
    //attributs
    private Branch[] branches = new Branch[100];
    private BankAccount[] accounts = new BankAccount[100];
    private int compteurBranche;

    //constructeur
    public Bank(){
        this.compteurBranche=0;
    }

    public void processTransaction(String line) {
    //verfier si code .equals ds la line. assigner int aux bonnes variables
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
        if (line.substring(0).equals("open")) {
            String transit = line.substring(6,11);
            String number = line.substring(12,20);
            BankAccount bankAccount = new BankAccount(transit, number);
        };
        if (line.substring(0).equals("close")) {
        };
        if (line.substring(0).equals("deposit")) {
            String transit = line.substring(6,11);
            String number = line.substring(12,20);
            int amount = (Integer.parseInt(line.substring(20)));
        };
        if (line.substring(0).equals("withdraw")) {
            String transit = line.substring(6,11);
            String number = line.substring(12,20);
            //on met amount negatif pour un retrait
            int amount = -(Integer.parseInt(line.substring(20)));
        };
        if (line.substring(0).equals("bonus")) {
        };
        if (line.substring(0).equals("report")) {
            //imprime le rapport
            System.out.println("report");
        };
        if (line.substring(0).equals("short-report")) {
            //imprime le rapport court
            System.out.println("short-report");
        };

    }
}
