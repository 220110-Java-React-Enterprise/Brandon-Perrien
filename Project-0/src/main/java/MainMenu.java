public class MainMenu extends View {
    public MainMenu(){
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        //prompt user for whether they want to create an account or login to an existing one, then navigates to the
        //corresponding view
        System.out.println("===== Main Menu =====");
        System.out.println("Enter 1 to Create an Account");
        System.out.println("Enter 2 to Login to an existing Account");

        String in = viewManager.getScanner().nextLine();

        //Navigate to next menus, or exit if wrong command inputted
        switch(in){
            case "1":
                viewManager.navigate("CreateAccount");
                break;
            case "2":
                viewManager.navigate("LogIn");
                break;
            default:
                System.out.println("Invalid Command, exiting program...");
                viewManager.quit();
        }
    }
}
