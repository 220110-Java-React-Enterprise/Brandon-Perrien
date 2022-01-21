

public abstract class View {
    protected String viewName;
    protected ViewManager viewManager;

    public String getViewName(){
        return viewName;
    }

    //RenderView to be implemented by subclasses, renderView displays information to the console
    public abstract void renderView();

}
