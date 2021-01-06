package ippo.assignment.model;

import java.util.HashMap;

public class Room {
    private HashMap<WallDirection,Wall> DirectionToWall;
    private HashMap<WallDirection,String> exitMap;

    /**
     * self-construction
     * @param directionToWall
     * @param exitMap
     */
    public Room(HashMap<WallDirection, Wall> directionToWall, HashMap<WallDirection, String> exitMap) {
        DirectionToWall = directionToWall;
        this.exitMap = exitMap;
    }

    public Wall WallInDirection(WallDirection direction){
        return this.DirectionToWall.get(direction);
    }

    /**
     * check if this direction has an exit
     * @param currentDirection
     * @return
     */
    public boolean checkExit(WallDirection currentDirection) {
        return this.exitMap.containsKey(currentDirection);
    }

    /**
     * if this direction has an exit, the function should return the next room's name
     * @param currentDirection
     * @return
     */
    public String getExitRoomName(WallDirection currentDirection) {
        return this.exitMap.get(currentDirection);
    }
}
