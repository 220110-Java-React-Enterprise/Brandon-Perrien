public class LogIn extends View{
    public static String email;

    public LogIn(){
        viewName = "LogIn";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        //prompt user to enter their login email
        System.out.println("===== Log In =====");
        System.out.println("Enter your account's email address: ");

        AccountRepo repo = new AccountRepo();

//verify that there is an account with that email
       email = viewManager.getScanner().nextLine();

       //checks to see if email is in database, if not then it redirects to create an account
        if(repo.read(email).getEmail() == null){
            System.out.println("Email doesn't have an account associated with it. Redirecting to CreateAccount Menu");
            viewManager.navigate("CreateAccount");
            return;
        }

        //prompt user for their password, make sure this is correct and then redirect them to the account details menu
        System.out.println("Now Enter your password: ");
        String pword = viewManager.getScanner().nextLine();
        if(!pword.equals(repo.read(email).getPassword())){
            System.out.println("Incorrect Password.");
            viewManager.quit();
            return;
        }

        //navigate to AccountMenu after verifying login
        viewManager.navigate("AccountMenu");
    }
}
