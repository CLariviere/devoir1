public class BankAccount{
    //instance de comptes

    //Atributs
    private String transit, number;
    private int amount;

    //Constructeur
    public BankAccount(String transit, String number){
        this.transit=transit;
        this.number=number;
        this.amount=0;
    }
}
