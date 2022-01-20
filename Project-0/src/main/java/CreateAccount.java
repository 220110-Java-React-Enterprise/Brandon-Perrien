public class CreateAccount extends View{
    public CreateAccount(){
        viewName = "CreateAccount";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        //prompt user
        System.out.println("===== Create Account =====");
        System.out.println("Enter your Email Address: ");

        //get input
        String in = viewManager.getScanner().nextLine();

        //if email is not in the database, create the account. If it is, either throw error or just quit
        AccountModel accountModel = new AccountModel();
        if(VerifyEmail.verify(in)){
            accountModel.setEmail(in);
        }else{
            System.out.println("Invalid email address");
            viewManager.quit();
            return;
        }


        //prompt user for the rest of their data, then add their info to the database,
        // and then redirect them to the account details menu

        //First Name prompt
        System.out.println("Enter your First Name: ");
        in = viewManager.getScanner().nextLine();
        if(VerifyName.verify(in)) {
            accountModel.setFirstName(in);
        }else{
            //this might need to be switched to exception instead of a println
            System.out.println("First Name can only contain letters");
            viewManager.quit();
            return;
        }

        //Last Name prompt
        System.out.println("Enter your Last Name: ");
        in = viewManager.getScanner().nextLine();
        if (VerifyName.verify(in)) {
            accountModel.setLastName(in);
        }else{
            //this might need to be an exception
            System.out.println("Last Name can only contain letters");
            viewManager.quit();
            return;
        }


        //Password Creation
        System.out.println("Create a Password (This must have between 7 and 50 characters): ");
        in = viewManager.getScanner().nextLine();
        if(in.length() < 7 | in.length() > 50){
            //this might need to be an exception instead
            System.out.println("Password has an invalid amount of characters");
            viewManager.quit();
            return;
        }else {
            accountModel.setPassword(in);
        }


//temp quit
        viewManager.quit();
    }
}
