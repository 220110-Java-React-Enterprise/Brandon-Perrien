package src.main.java;
import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewManager;
    private boolean running;
    private final Scanner scanner;

    MyArrayList<View> viewList;
    View nextView;

    private ViewManager(){
        //private constructor so there is only one instance of this object
        //set up starting values and references
        running = true;
        scanner = new Scanner(System.in);
        viewList = new MyArrayList<>();
    }

    public static ViewManager getViewManager(){
        //creates new ViewManager if there isn't one, then returns viewManager
        if(viewManager == null){
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String destination) {
        //navigates to view at destination
        for (int i = 0; i < viewList.size(); i++) {
            View temp = viewList.get(i);
            if (temp.viewName.equals(destination)) {
                nextView = temp;
            }
        }
    }
        public void registerView(View view){
            viewList.add(view);
        }

        public void render(){
            nextView.renderView();
        }

        public Scanner getScanner(){
            return scanner;
        }

        public void quit(){
            running = false;
        }

        public boolean isRunning(){
            return running;
        }
    }
