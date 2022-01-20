public class LogIn extends View{
    public LogIn(){
        viewName = "LogIn";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        //prompt user to enter their login email
        System.out.println("===== Log In =====");
        System.out.println("Enter your account's email address: ");

//verify that there is an account with that email

        //prompt user for their password, make sure this is correct and then redirect them to the account details menu


        //temp quit
        viewManager.quit();
    }
}
