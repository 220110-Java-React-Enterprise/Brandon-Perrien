import java.sql.Connection;

public class Main {
    public static void main(String... args) {
        Connection con = ConnectionManager.getConnection();


        ViewManager viewManager = ViewManager.getViewManager();
        
//registering views
        viewManager.registerView(new MainMenu());
        viewManager.registerView(new CreateAccount());
        viewManager.registerView(new LogIn());
        viewManager.registerView(new AccountMenu());
        viewManager.registerView(new BankMenu());
//navigating to the first menu, "MainMenu"
        viewManager.navigate("MainMenu");
//Continues to loop until isRunning returns false
        while(viewManager.isRunning()){
            viewManager.render();
        }


    }
}
