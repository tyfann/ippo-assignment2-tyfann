package ippo.assignment.model;

import java.util.HashMap;

public class RoomsMap {
    HashMap<String,Room> roomMap;

    /**
     * self-construction
     * @param roomMap
     */
    public RoomsMap(HashMap<String, Room> roomMap) {
        this.roomMap = roomMap;
    }

    public Room getInitialRoom(){
        return this.roomMap.get("bedroom");
    }

    public Room getCurrentRoom(String roomName){
        return this.roomMap.get(roomName);
    }
}
