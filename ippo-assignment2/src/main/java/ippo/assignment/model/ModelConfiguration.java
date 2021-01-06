package ippo.assignment.model;

import java.util.HashMap;
import java.util.HashSet;

public class ModelConfiguration {
    public RoomsMap roomsMap;

    public ModelConfiguration() {
        HashMap<String,Room> roomMap = new HashMap<>();

        // all items list
        Item imageitem1 = new Item("bear.png");
        Item imageitem2 = new Item("bird.png");
        Item imageitem3 = new Item("cock.png");
        Item imageitem4 = new Item("dog.png");
        Item imageitem5 = new Item("horse.png");
        Item imageitem6 = new Item("kangaroo.png");
        Item imageitem7 = new Item("panda.png");
        Item imageitem8 = new Item("rabbit.png");
        Item imageitem9 = new Item("koala.png");


        //room1
        HashMap<WallDirection, Wall> directionToWall1 = new HashMap<>();
        HashSet<Item> itemMap1n = new HashSet<>();
        HashSet<Item> itemMap1e = new HashSet<>();
        HashSet<Item> itemMap1s = new HashSet<>();
        HashSet<Item> itemMap1w = new HashSet<>();
        HashMap<WallDirection, String> exitMap1 = new HashMap<>();
        //room1 north
        itemMap1n.add(imageitem1);
        Wall wall1n = new Wall("IMG_1795.jpeg",itemMap1n);
        directionToWall1.put(WallDirection.North,wall1n);
        //room1 east
        itemMap1e.add(imageitem5);
        Wall wall1e = new Wall("IMG_1797.jpeg",itemMap1e);
        directionToWall1.put(WallDirection.East,wall1e);
        //room1 south
        itemMap1s.add(imageitem2);
        itemMap1s.add(imageitem3);
        Wall wall1s = new Wall("IMG_1798.jpeg",itemMap1s);
        directionToWall1.put(WallDirection.South,wall1s);
        //room1 west
        itemMap1w.add(imageitem4);
        Wall wall1w = new Wall("IMG_1796.jpeg",itemMap1w);
        directionToWall1.put(WallDirection.West,wall1w);
        //exit add
        exitMap1.put(WallDirection.South,"lobby");
        //room1 initialization
        Room room1 = new Room(directionToWall1,exitMap1);
        roomMap.put("bedroom",room1);

        //room2
        HashMap<WallDirection, Wall> directionToWall2 = new HashMap<>();
        HashSet<Item> itemMap2n = new HashSet<>();
        HashSet<Item> itemMap2e = new HashSet<>();
        HashSet<Item> itemMap2s = new HashSet<>();
        HashSet<Item> itemMap2w = new HashSet<>();
        HashMap<WallDirection, String> exitMap2 = new HashMap<>();
        //room2 north
        itemMap2n.add(imageitem6);
        Wall wall2n = new Wall("IMG_1801.jpeg",itemMap2n);
        directionToWall2.put(WallDirection.North,wall2n);
        //room2 east
        itemMap2e.add(imageitem7);
        Wall wall2e = new Wall("IMG_1800.jpeg",itemMap2e);
        directionToWall2.put(WallDirection.East,wall2e);
        //room2 south

        Wall wall2s = new Wall("IMG_1799.jpeg",itemMap2s);
        directionToWall2.put(WallDirection.South,wall2s);
        //room2 west

        Wall wall2w = new Wall("IMG_1802.jpeg",itemMap2w);
        directionToWall2.put(WallDirection.West,wall2w);
        //exit add
        exitMap2.put(WallDirection.North,"bedroom");
        exitMap2.put(WallDirection.West,"lobby_corner");
        exitMap2.put(WallDirection.East,"kitchen");
        //room2 initialization
        Room room2 = new Room(directionToWall2,exitMap2);

        roomMap.put("lobby",room2);

        //room3
        HashMap<WallDirection, Wall> directionToWall3 = new HashMap<>();
        HashSet<Item> itemMap3n = new HashSet<>();
        HashSet<Item> itemMap3e = new HashSet<>();
        HashSet<Item> itemMap3s = new HashSet<>();
        HashSet<Item> itemMap3w = new HashSet<>();
        HashMap<WallDirection, String> exitMap3 = new HashMap<>();
        //room1 north
        itemMap3n.add(imageitem8);
        itemMap3n.add(imageitem9);
        Wall wall3n = new Wall("IMG_1810.jpeg",itemMap3n);
        directionToWall3.put(WallDirection.North,wall3n);
        //room1 east

        Wall wall3e = new Wall("IMG_1809.jpeg",itemMap3e);
        directionToWall3.put(WallDirection.East,wall3e);
        //room1 south

        Wall wall3s = new Wall("IMG_1804.jpeg",itemMap3s);
        directionToWall3.put(WallDirection.South,wall3s);
        //room1 west

        Wall wall3w = new Wall("IMG_1803.jpeg",itemMap3w);
        directionToWall3.put(WallDirection.West,wall3w);
        //exit add
        exitMap3.put(WallDirection.East,"lobby");
        //room1 initialization
        Room room3 = new Room(directionToWall3,exitMap3);

        roomMap.put("lobby_corner",room3);

        //room4
        HashMap<WallDirection, Wall> directionToWall4 = new HashMap<>();
        HashSet<Item> itemMap4n = new HashSet<>();
        HashSet<Item> itemMap4e = new HashSet<>();
        HashSet<Item> itemMap4s = new HashSet<>();
        HashSet<Item> itemMap4w = new HashSet<>();
        HashMap<WallDirection, String> exitMap4 = new HashMap<>();
        //room4 north
        Wall wall4n = new Wall("IMG_1808.jpeg",itemMap4n);
        directionToWall4.put(WallDirection.North,wall4n);
        //room4 east
        Wall wall4e = new Wall("IMG_1805.jpeg",itemMap4e);
        directionToWall4.put(WallDirection.East,wall4e);
        //room4 south

        Wall wall4s = new Wall("IMG_1806.jpeg",itemMap4s);
        directionToWall4.put(WallDirection.South,wall4s);

        Wall wall4w = new Wall("IMG_1807.jpeg",itemMap4w);
        directionToWall4.put(WallDirection.West,wall4w);


        //exit add
        exitMap4.put(WallDirection.West,"lobby");
        //room4 initialization
        Room room4 = new Room(directionToWall4,exitMap4);
        roomMap.put("kitchen",room4);

        roomsMap = new RoomsMap(roomMap);
    }
}
