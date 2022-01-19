package src.main.java;

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
        System.out.println("Enter name: ");

        //get input
        String in = viewManager.getScanner().nextLine();

        //perform validation??

        //store this for use later
        DataStore.setName(in);

        System.out.println("Welcome, " + DataStore.getName());

        //navigate to next menu or quit for now
        viewManager.quit();
    }
}
