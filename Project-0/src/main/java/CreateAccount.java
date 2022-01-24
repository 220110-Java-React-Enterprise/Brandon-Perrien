import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class CreateAccount extends View{
    public CreateAccount(){
        viewName = "CreateAccount";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        //prompt user for details in order to create an account
        System.out.println("===== Create Account =====");
        System.out.println("Enter your Email Address: ");

        String in = viewManager.getScanner().nextLine();

        AccountModel accountModel = new AccountModel();
        AccountRepo repo = new AccountRepo();

        //makes sure the entered email is valid
        if(VerifyEmail.verify(in)){
            accountModel.setEmail(in);
        }else{
            System.out.println("Invalid email address");
            viewManager.quit();
            return;
        }

        //prompt user for the rest of their data, then add their info to the database,
        // and then redirect them to the account details menu
        System.out.println("Enter your First Name: ");
        in = viewManager.getScanner().nextLine();
        if(VerifyName.verify(in)) {
            accountModel.setFirstName(in);
        }else{
            System.out.println("First Name can only contain letters");
            viewManager.quit();
            return;
        }

        System.out.println("Enter your Last Name: ");
        in = viewManager.getScanner().nextLine();
        if (VerifyName.verify(in)) {
            accountModel.setLastName(in);
        }else{
            System.out.println("Last Name can only contain letters");
            viewManager.quit();
            return;
        }

        System.out.println("Create a Password (This must have between 7 and 50 characters): ");
        in = viewManager.getScanner().nextLine();
        if(in.length() < 7 | in.length() > 50){
            System.out.println("Password has an invalid amount of characters");
            viewManager.quit();
            return;
        }else {
            accountModel.setPassword(in);
        }

        //Creates the account in the database, then quits, rerun the program to login
        try {
            repo.create(accountModel);
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("Account Created. Try Logging In.");
        viewManager.quit();
    }
}
