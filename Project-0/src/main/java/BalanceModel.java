public class BalanceModel {
    private Integer id;
    private String email;
    private String accountName;
    private Double balance;

    public BalanceModel(){
    }

    public BalanceModel(String email, String accountName, Double balance){
        this.email = email;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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