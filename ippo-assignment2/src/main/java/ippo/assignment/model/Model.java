package ippo.assignment.model;

public interface Model {

    void executeCommand(String command);

    void turnRight();

    void goForward();

    void turnLeft();

    void PickUpItem(String itemName);

    void PutDownItem(String itemName);
}
