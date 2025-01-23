import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManagement {
    private  Inventory inventory;

    public ItemManagement(Inventory inventory) {
        this.inventory = inventory;
    }
    public List<Item> getItemsByRarityAndName(Rarity rarity, String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : inventory.getItemInventory()) {
            if (item.getRarity() == rarity && item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }

    public void upgradeItem(Item item) {
        Rarity currentRarity= item.getRarity();
        List<Item> sameItems = getItemsByRarityAndName(item.getRarity(),item.getName());


    }
}
