package ippo.assignment.model;

import java.util.HashMap;
import java.util.Set;


public class Player {
    private Room currentRoom;
    private WallDirection currentDirection;
    private boolean validForward;
    //itemMap is the bag of the player, which means the item which are not in the room.
    private HashMap<String, Item> itemBag;
    private RoomsMap roomsMap;

    /**
     * initialize the room and direction of the player
     * @param roomsMap
     */
    public Player(RoomsMap roomsMap) {
        this.roomsMap = roomsMap;
        this.currentDirection = WallDirection.North;
        this.currentRoom = roomsMap.getInitialRoom();
        this.itemBag =new HashMap<>();
        this.checkExit();
    }

    public String getImage(){
        return this.currentRoom.WallInDirection(this.currentDirection).getImageUrl();
    }

    public boolean checkForwardValidity(){
        checkExit();
        return this.validForward;
    }

    public void pickItem(String itemName){
        if(!this.itemBag.containsKey(itemName)){
            Item item = this.currentRoom.WallInDirection(this.currentDirection).removeItem(itemName);
            this.itemBag.put(itemName,item);
        }
    }
    
    public void putItem(String itemName){
        if(this.itemBag.containsKey(itemName)) {
            if(this.currentRoom.WallInDirection(this.currentDirection).addItem(this.itemBag.get(itemName))) {
                this.itemBag.remove(itemName);
            }
        }
    }
    
    private void setRoom(Room room){
        this.currentRoom = room;
        this.checkExit();
    }

    private void checkExit() {
        this.validForward = this.currentRoom.checkExit(this.currentDirection);
        
    }

    /**
     * player choose to turn left
     */
    public void turnLeft() {
        this.currentDirection = this.currentDirection.Left();
    }

    /**
     * player choose to turn right
     */
    public void turnRight() {
        this.currentDirection = this.currentDirection.Right();
    }

    /**
     * player choose to go forward
     */
    public void goForward() {
        if(this.checkForwardValidity()){
            this.setRoom(this.roomsMap.getCurrentRoom(this.getExitRoomName()));
        }
    }

    /**
     * get the Exit Room when it's available to go exit
     */
    private String getExitRoomName() {
        if(this.validForward){
            return this.currentRoom.getExitRoomName(this.currentDirection);
        }else {
            return null;
        }
    }

    /**
     * return the item which can be put down.
     */
    public Set<String> getPlayerItem(){
        return this.itemBag.keySet();
    }

    /**
     * return the item which can be picked up.
     */
    public Set<String> getWallItem(){
        return this.currentRoom.WallInDirection(this.currentDirection).getItemName();
    }
}
