public class BankAccount{
    //instance de comptes

    //Atributs
    private String number, lastOperation;
    private static float amount, bonus;
    private static boolean status;

    //Constructeur
    public BankAccount(String number){
        this.number=number;
        this.amount=0;
        this.bonus=0;
        this.lastOperation="";
        this.status=true;
    }



    //Getter
    public String getNumber() {
        return number;
    }
    public float getAmount() {return amount;}
    public static boolean getStatus() {return status;}

    public static void setStatus() {
        status=false;
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
