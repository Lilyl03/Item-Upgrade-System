import java.util.Objects;

public class Item {
    private String name;
    private Rarity rarity;
    private int upgradeCount;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return upgradeCount == item.upgradeCount && Objects.equals(name, item.name) && rarity == item.rarity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rarity, upgradeCount);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity +
                ", upgradeCount=" + upgradeCount +
                '}';
    }
}
