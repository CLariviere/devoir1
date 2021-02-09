//Catherine Lariviere 0955948
//2021-02-15

public class BankAccount{
    //instance de comptes

    //Atributs
    private static String number, lastOperation;
    private static float amount, bonus, lastOperationAmount;
    private static boolean status;

    //Constructeur
    public BankAccount(String number, float bonus){
        this.number=number;
        this.amount=0+bonus;
        this.status=true;
        this.lastOperation="";
        this.lastOperationAmount=0;
    }

    //Getter
    public String getNumber() {return number;}
    public String getLastOperation() {return lastOperation;}
    public Float getLastOperationAmount() {return lastOperationAmount;}
    public float getAmount() {return amount;}
    public static boolean getStatus() {return status;}

    //Setter
    public static void setStatus() {
        status=false;
    }
    public static void setDeposit(float deposit) {
        if (deposit>=0){
            amount+=deposit;
            lastOperationAmount=deposit;
            lastOperation="deposit";
        }
    }
    public static void setWithdraw(float withdraw) {
        if (amount>=withdraw & withdraw>0){
            amount-=withdraw;
            lastOperationAmount=withdraw;
            lastOperation="withdraw";
            }
        }
}
