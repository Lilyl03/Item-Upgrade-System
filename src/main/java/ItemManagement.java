import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ItemManagement {
    private Inventory inventory;

    public ItemManagement(Inventory inventory) {
        this.inventory = inventory;
    }

    private void combineItems(Item item, int requiredItems) throws NotEnoughItemsException {
        List<Item> sameItems = inventory.getItemsByRarityAndName(item.getRarity(), item.getName());
        if (sameItems.size() < requiredItems) {
            throw new NotEnoughItemsException("Not enough items for upgrade");
        }
        for (int i = 0; i < requiredItems; i++) {
            inventory.removeItem(sameItems.get(i));
        }
    }

    private void upgradeNonEpicItem(Item item) throws InvalidUpgradeException {
        Rarity currentRarity = item.getRarity();
        switch (currentRarity) {
            case COMMON:
                item.setRarity(Rarity.GREAT);
                break;
            case GREAT:
                item.setRarity(Rarity.RARE);
                break;
            case RARE:
                item.setRarity(Rarity.EPIC);
                break;
            default:
                throw new InvalidUpgradeException("Cannot upgrade item of rarity " + currentRarity + ".");
        }
        inventory.addItem(item);
    }

    private void upgradeEpicItem(Item item) throws NotEnoughItemsException, InvalidUpgradeException {
        Map<Integer, List<Item>> itemsByUpgradeCount = inventory.groupItemsByUpgradeCount();

        if (item.getUpgradeCount() < 2) {
            if (itemsByUpgradeCount.getOrDefault(item.getUpgradeCount(), new ArrayList<>()).size() < 2) {
                throw new NotEnoughItemsException("Not enough items for upgrade");
            }
            List<Item> itemsToRemove = itemsByUpgradeCount.get(item.getUpgradeCount());
            for (int i = 0; i < 2; i++) {
                inventory.removeItem(itemsToRemove.get(i));
            }
            item.setUpgradeCount(item.getUpgradeCount() + 1);
        } else if (item.getUpgradeCount() == 2) {
            if (itemsByUpgradeCount.getOrDefault(2, new ArrayList<>()).size() < 3) {
                throw new NotEnoughItemsException("Not enough items for upgrade to Legendary");
            }
            List<Item> itemsToRemove = itemsByUpgradeCount.get(2);
            for (int i = 0; i < 3; i++) {
                inventory.removeItem(itemsToRemove.get(i));
            }
            item.setRarity(Rarity.LEGENDARY);
            item.setUpgradeCount(0);
        } else {
            throw new InvalidUpgradeException("Cannot upgrade item of rarity " + item.getRarity() + ".");
        }

        inventory.addItem(item);
    }

    public void upgradeItem(Item item) throws NotEnoughItemsException, InvalidUpgradeException {
        if (item.getRarity() == Rarity.EPIC) {
            upgradeEpicItem(item);
        } else {
            combineItems(item, 3);
            upgradeNonEpicItem(item);
        }
    }
}
