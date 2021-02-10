//Catherine Lariviere 0955948
//2021-02-15

public class BankAccount{
    //instance de comptes

    //Atributs
    private  String number, lastOperation;
    private  float amount, bonus, lastOperationAmount, totalDepositAccount;
    private  boolean status;

    //Constructeur
    public BankAccount(String transit, String number, float bonus){
        this.number=number;
        this.amount=0+bonus;
        this.status=true;
        this.lastOperation="open "+transit+":"+number+" balance =";
        this.lastOperationAmount=0+bonus;
        this.totalDepositAccount=0;
    }

    //Getter
    public String getNumber() {return number;}
    public String getLastOperation() {return lastOperation;}
    public Float getLastOperationAmount() {return lastOperationAmount;}
    public Float getTotalDepositAccount() {return totalDepositAccount;}
    public float getAmount() {return amount;}
    public  boolean getStatus() {return status;}

    //Setter
    public  void setStatus() {
        status=false;
    }
    public  void setDeposit(float deposit) {
        //empeche depot d'un montant negatif
        if (deposit>=0){
            amount+=deposit;
            lastOperationAmount=deposit;
            lastOperation="deposit";
            totalDepositAccount+=deposit;
        }
    }
    public  void setWithdraw(float withdraw) {
        //empeche retrait d'un trop gros montant ou un retrait d'un montant negatif
        if (amount>=withdraw && withdraw>0){
            amount-=withdraw;
            lastOperationAmount=withdraw;
            lastOperation="withdraw";
        }
    }
}
