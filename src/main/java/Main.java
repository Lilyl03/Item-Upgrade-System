public class Main {



    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ItemManagement management = new ItemManagement(inventory);

        inventory.addItem(new Item("Iron Sword", Rarity.EPIC));
        inventory.addItem(new Item("Iron Sword", Rarity.EPIC));


        ItemManagement itemManagement = new ItemManagement(inventory);
        itemManagement.upgradeItem(inventory.getItemsByRarityAndName(Rarity.EPIC,"Iron Sword").get(0));



        inventory.display();
    }
}
