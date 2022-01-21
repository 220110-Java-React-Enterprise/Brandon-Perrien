
public class MainMenu extends View {
    public MainMenu(){
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
    }
//Need to change renderView later
    @Override
    public void renderView(){
        //prompt user
        System.out.println("===== Main Menu =====");
        System.out.println("Enter 1 to Create an Account");
        System.out.println("Enter 2 to Login to an existing Account");

        //get input
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
