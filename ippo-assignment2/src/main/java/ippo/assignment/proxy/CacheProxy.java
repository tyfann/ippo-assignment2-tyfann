package ippo.assignment.proxy;

import ippo.assignment.services.LocalService;
import ippo.assignment.services.Service;
import javafx.scene.image.Image;

import java.util.HashMap;

public class CacheProxy implements Service {

    private Service baseService;
    private HashMap<String,Image> keyImageHashMap;

    public CacheProxy() {
        this.baseService = new LocalService();
        this.keyImageHashMap = new HashMap<>();
    }

    @Override
    public Image getImage(String type, String imageURL) {
        String binaryKey = type.concat(imageURL);
        if(!this.keyImageHashMap.containsKey(binaryKey)){
            this.keyImageHashMap.put(binaryKey,this.baseService.getImage(type,imageURL));
        }
        return this.keyImageHashMap.get(binaryKey);
    }
}
