public class Account {
    private String holderName;
    private int  accountNumber = 1001;
    private int balance = 0;
    private final int minLimit=0;
    private final int maxLimit= 1_00_000;
    private final int minDeposit= 500;
    private final int maxDeposit= 50_000;
    private final int minWithDrawl= 1_000;
    private final int maxWithDrawl= 25_000;
    private int noOfDepositsInDay=0;
    private int noOfWithDrawlInDay=0;


    public Account(String name,int noOfUser){
        this.holderName = name;
        this.accountNumber = accountNumber+noOfUser;
        System.out.println("Successfully created an account \nYour details :");
        System.out.println(holderName+" "+accountNumber);
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
    public String getHolderName(){
        return this.holderName;
    }

    public int getBalance(){
        return this.balance;
    }

    public int deposit(int depositAmmount) {
        if (this.balance + depositAmmount > maxLimit || depositAmmount < minDeposit || depositAmmount > maxDeposit || this.noOfDepositsInDay>=3) {
            return -1;
        } else {
            this.balance = this.balance + depositAmmount;
            this.noOfDepositsInDay++;
        }
        return getBalance();
    }

    public int withDraw(int withDrawAmmount){
        if (this.balance < withDrawAmmount || withDrawAmmount < minWithDrawl || withDrawAmmount > maxWithDrawl || this.noOfWithDrawlInDay>=3) {
            return -1;
        } else {
            this.balance = this.balance - withDrawAmmount;
            this.noOfWithDrawlInDay++;
        }
        return getBalance();
    }

    public boolean transfer(Account targetAccount , int transferAmmount){
        if(this.balance < transferAmmount || (targetAccount.balance+ transferAmmount)>maxLimit){
            return false;
        }
        else {
            this.balance = this.balance - transferAmmount;
            System.out.println(this.balance);
            targetAccount.balance =  targetAccount.balance + transferAmmount;
            System.out.println(targetAccount.balance);
        }
        return true;
    }

}
