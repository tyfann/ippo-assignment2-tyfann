package ippo.assignment.model;

import java.util.HashSet;
import java.util.Set;

public class Wall {
    public String imageUrl;
    private HashSet<Item> itemSet;

    public Wall(String imageUrl, HashSet<Item> itemSet) {
        this.imageUrl = imageUrl;
        this.itemSet = itemSet;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public Item removeItem(String itemName) {
        Item item = null;
        for (Item itemClass : this.itemSet){
            if (itemClass.toString().equals(itemName)){
                item = itemClass;
                this.itemSet.remove(itemClass);
                break;
            }
        }
        return item;
    }

    // add item which can be picked up
    public boolean addItem(Item item) {
        if(!this.itemSet.contains(item)){
            this.itemSet.add(item);
            return true;
        }
        return false;
    }

    // return item's name which can be picked up.
    public Set<String> getItemName(){
        HashSet<String> itemList = new HashSet<>();
        for (Item itemName : this.itemSet){
            itemList.add(itemName.toString());
        }
        return itemList;
    }
}
