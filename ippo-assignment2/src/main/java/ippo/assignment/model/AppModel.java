package ippo.assignment.model;

import java.util.HashSet;
import java.util.Set;

public class AppModel implements Model{
    private Player currentPlayer;

    public AppModel(RoomsMap roomsMap) {
        this.currentPlayer = new Player(roomsMap);
    }

    @Override
    public void executeCommand(String command){
        String[] name;
        name = command.split(" ");
        switch (name[0]){
            case "Left":
                turnLeft();
                break;
            case "Right":
                turnRight();
                break;
            case "Forward":
                goForward();
                break;
            case "Pick":
                PickUpItem(name[1]);
                break;
            case "Put":
                PutDownItem(name[1]);
                break;
        }
    }

    public String getCurrentImage(){
        return this.currentPlayer.getImage();
    }

    public boolean checkForwardValidity() {
        return this.currentPlayer.checkForwardValidity();
    }

    @Override
    public void PickUpItem(String itemName){
        this.currentPlayer.pickItem(itemName);
    }

    @Override
    public void PutDownItem(String itemName){
        this.currentPlayer.putItem(itemName);
    }

    @Override
    public void turnLeft(){
        this.currentPlayer.turnLeft();
    }

    @Override
    public void turnRight(){
        this.currentPlayer.turnRight();
    }

    @Override
    public void goForward(){
        this.currentPlayer.goForward();
    }


    public Set<String> getPlayerItem(){
        return this.currentPlayer.getPlayerItem();
    }

    public Set<String> getWallItem(){
        return this.currentPlayer.getWallItem();
    }

    public Set<String> getWallItemUrl(){
        HashSet<String> itemUrlSet = new HashSet<>();
        for(String item : this.currentPlayer.getWallItem()){
            itemUrlSet.add(item);
        }
        return itemUrlSet;
    }


}
