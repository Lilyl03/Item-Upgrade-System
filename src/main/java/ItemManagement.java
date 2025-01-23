import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManagement {
    private  Inventory inventory;

    public ItemManagement(Inventory inventory) {
        this.inventory = inventory;
    }


    public void upgradeItem(Item item) {
        Rarity currentRarity= item.getRarity();
        List<Item> sameItems = inventory.getItemsByRarityAndName(item.getRarity(),item.getName());
        if(!(item.getRarity().equals(Rarity.EPIC1) || item.getRarity().equals(Rarity.EPIC2) ||
                item.getRarity().equals(Rarity.EPIC)) ) {
            if( sameItems.size()<3) throw new NotEnoughItemsException("Not enough items for upgrade");
            for (int i = 0; i < 3; i++) {
                inventory.removeItem(sameItems.get(i));
            }
            switch (currentRarity) {
                case COMMON:
                    item.setRarity(Rarity.GREAT);
                    inventory.addItem(item);
                    break;
                case GREAT:
                    item.setRarity(Rarity.RARE);
                    inventory.addItem(item);
                    break;
                case RARE:
                    item.setRarity(Rarity.EPIC);
                    inventory.addItem(item);
                default:
                    throw new InvalidUpgradeException("Cannot upgrade item of rarity " + currentRarity + ".");
        }}
        if ((item.getRarity().equals(Rarity.EPIC1) || item.getRarity().equals(Rarity.EPIC2) ||
                item.getRarity().equals(Rarity.EPIC)) ){
            if( sameItems.size()<2) throw new NotEnoughItemsException("Not enough items for upgrade");
            for(int i=0; i<2;i++)
                inventory.removeItem(sameItems.get(i));
            switch (currentRarity) {
                case EPIC:
                    item.setRarity(Rarity.EPIC1);
                    inventory.addItem(item);
                    break;
                case EPIC1:
                    item.setRarity(Rarity.EPIC2);
                    break;
                case EPIC2:
                    item.setRarity(Rarity.LEGENDARY);
                default:
                    throw new InvalidUpgradeException("Cannot upgrade item of rarity " + currentRarity + ".");
            }
        }



    }
}
