import java.sql.SQLException;

public class AccountMenu extends View{
    public AccountMenu(){
        viewName = "AccountMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user to enter a command relating to an action(view bank accounts, add bank accounts, update info, logout)
        System.out.println("===== Account Menu =====");
        System.out.println("Enter one of the following commands: ");
        System.out.println("1 - View bank accounts");
        System.out.println("2 - Add bank account");
        System.out.println("3 - Update Account Information");
        System.out.println("4 - Log Out");

        String in = viewManager.getScanner().nextLine();
        AccountRepo arepo = new AccountRepo();
        AccountModel amodel = new AccountModel();
        BalanceModel model = new BalanceModel();
        BalanceRepo repo = new BalanceRepo();

        switch(in){
            case "1":
                //navigates to the bank menu which allows user to view their bank accounts and make changes to their balances
               viewManager.navigate("BankMenu");
                break;
            case "2":
                //creates a bank account with a unique name(provided by user) and a balance of $0.00
                model.setBalance(0.00);
                System.out.println("Enter a name for this bank account: ");
                in = viewManager.getScanner().nextLine();
                if(in.equals(repo.read(in).getAccountName())){
                    System.out.println("An account already exists with that name");
                    viewManager.quit();
                    return;
                }
                model.setAccountName(in);
                model.setId(arepo.read(LogIn.email).getId());
                try {
                    repo.create(model);
                }catch(SQLException e){
                    e.printStackTrace();
                }
                System.out.println("Bank account added.");
                break;
            case "3":
                //Allows user to change firstname, lastname, and password associated with account id/email
                amodel.setId(arepo.read(LogIn.email).getId());

                System.out.println("Enter your First Name: ");
                in = viewManager.getScanner().nextLine();
                if(VerifyName.verify(in)) {
                    amodel.setFirstName(in);
                }else{
                    System.out.println("First Name can only contain letters");
                    viewManager.quit();
                    return;
                }

                System.out.println("Enter your Last Name: ");
                in = viewManager.getScanner().nextLine();
                if(VerifyName.verify(in)) {
                    amodel.setLastName(in);
                }else{
                    System.out.println("First Name can only contain letters");
                    viewManager.quit();
                    return;
                }

                System.out.println("Enter your new password: ");
                in = viewManager.getScanner().nextLine();
                if(in.length() < 7 | in.length() > 50){
                    System.out.println("Password has an invalid amount of characters");
                    viewManager.quit();
                    return;
                }else {
                    amodel.setPassword(in);
                }
                arepo.update(amodel);
                break;

            case "4":
                viewManager.quit();
                break;
            default:
                //Navigate back here as default case
                viewManager.navigate("AccountMenu");
        }
    }
}
