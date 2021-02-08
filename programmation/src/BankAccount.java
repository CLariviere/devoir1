public class BankAccount{
    //instance de comptes

    //Atributs
    private String number;
    private static float amount, bonus;

    //Constructeur
    public BankAccount(String number){
        this.number=number;
        this.amount=0;
        this.bonus=0;

    }

    //Getter
    public String getNumber() {
        return number;
    }
    public float getAmount() {return amount;}

    //Setter
    public static void setBonus(float bonus) {
        if (bonus>=0){
            amount=bonus;
        }
    }

    public static void setDeposit(float deposit) {
        if (deposit>=0){
        amount+=deposit;
        float lastDeposit=deposit;
        }
    }
    public static void setWithdraw(float withdraw) {
        if (amount>=withdraw & withdraw>0){
            amount-=withdraw;
            }
        }
}
