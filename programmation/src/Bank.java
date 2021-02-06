public class Bank {
    //attributs
    private String Branch[];
    private String BankAccount[];


    public void processTransaction(String line) {

    //verfier si code .equals ds la line. assigner int aux bonnes variables
        if (line.substring(0).equals("build")) {
            String transit = line.substring(6,11);
            Branch branch = new Branch(transit);
        };
        if (line.substring(0).equals("dismantle")) {
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
