public class BankAccount{
    //instance de comptes

    //Atributs
    private String number;
    private static float amount, lastDeposit;

    //Constructeur
    public BankAccount(String number){
        this.number=number;
        this.amount=0;
        this.lastDeposit=0;
    }

    //Getter
    public String getNumber() {
        return number;
    }
    public float getAmount() {return amount;}

    //Setter
    public static void setAmount(float deposit) {
        amount += deposit;
        lastDeposit = deposit;
    }
}
