import java.sql.Connection;

public class Main {
    public static void main(String... args) {
        Connection con = ConnectionManager.getConnection();


        ViewManager viewManager = ViewManager.getViewManager();
        

        viewManager.registerView(new MainMenu());
        viewManager.registerView(new CreateAccount());
        viewManager.registerView(new LogIn());
        viewManager.registerView(new AccountMenu());

        viewManager.navigate("MainMenu");

        while(viewManager.isRunning()){
            viewManager.render();
        }


    }
}
