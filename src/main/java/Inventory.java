import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Item> itemInventory ;

    public Inventory() {
        this.itemInventory  = new LinkedList<>();
    }

    public List<Item> getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(List<Item> itemInventory) {
        this.itemInventory = itemInventory;
    }

    public void addItem(Item item){
        itemInventory.add(item);
    }

    public void removeItem(Item item){
        itemInventory.remove(item);
    }

    public void display(){
        System.out.println("Current Inventory:");
        for(Rarity rarity: Rarity.values()){
            System.out.println(rarity.toString() + " ");
            for (Item item : itemInventory) {
                if(item.getRarity().equals(rarity)){
                    System.out.println("Item name : " + item.getName());
                    System.out.println("Item rarity : " + item.getRarity());
                    System.out.println("Item upgrade count : " + item.getUpgradeCount());
        }}}
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemInventory=" + itemInventory +
                '}';
    }
}
