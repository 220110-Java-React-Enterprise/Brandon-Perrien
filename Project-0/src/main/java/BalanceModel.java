public class BalanceModel {
    private Integer id;
    private String accountName;
    private Double balance;

    public BalanceModel(){
    }

    public BalanceModel(String accountName, Double balance){
        this.accountName = accountName;
        this.balance = balance;
    }


    public void withdraw(Double d){
        if(d > 0){
            if(balance - d > 0){
                balance = balance - d;
                setBalance(balance);
            }else{
                System.out.println("You cannot withdraw more than your balance.");
            }
        }else{
            System.out.println("You can only withdraw amounts greater than 0.");
        }
    }

    public void deposit(Double d){
        if(d > 0){
            balance = balance + d;
            setBalance(balance);
        }else{
            System.out.println("You can only deposit amounts greater than 0.");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}