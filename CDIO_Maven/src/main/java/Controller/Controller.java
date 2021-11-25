package Controller;

public abstract class Controller {
    public final boolean isDropdown;
    public final String[] menuActions;

    public Controller(String[] menuActions) {
        this.menuActions = menuActions;
        this.isDropdown = false;
    }

    public Controller(String[] menuActions, boolean isDropdown) {
        this.menuActions = menuActions;
        this.isDropdown = isDropdown;
    }

    abstract void handleActions(String action);
}
