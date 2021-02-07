public class BankAccount{
    //instance de comptes

    //Atributs
    private String number;
    private static float amount;

    //Constructeur
    public BankAccount(String number){
        this.number=number;
        this.amount=0;
    }

    //Getter
    public String getNumber() {
        return number;
    }
    public float getAmount() {return amount;}

    //Setter
    public static void setAmount(float bonus) {
        if (bonus>=0){
            amount=bonus;
        }
        if (bonus<0){
            //TODO enlever les print avant la remise
            System.out.println("bonus invalide");
        }
    }
    public static void setDeposit(float deposit) {
        if (deposit>=0){
        amount+=deposit;
        System.out.println(amount);
        float lastDeposit=deposit;
        }
        if (deposit<0){
            //TODO enlever les print avant la remise
            System.out.println("On ne peut pas deposer moins que zero dollars");
        }
    }
    public static void setWithdraw(float withdraw) {
        if (amount>=withdraw & withdraw>0){
            amount-=withdraw;
        }
        if (amount<withdraw){
            //TODO enlever les print avant la remise
            System.out.println("fonds insuffisant");
            }
        }

}
