public class Bank {


    public void processTransaction(String line) {

    //verfier si code .equals ds la line. assigner int aux bonne variables
        if line.substring(0).equals("build") {
           int transit = Integer.parseInt(line.substring(6,11));
            Branch branch = new Branch(transit);
        }

    }
}
