package ippo.assignment.model;

public class Item {
    private String ItemName;

    public Item(String itemName) {
        this.ItemName = itemName;
    }

    @Override
    public String toString() {
        return this.ItemName;
    }
}
