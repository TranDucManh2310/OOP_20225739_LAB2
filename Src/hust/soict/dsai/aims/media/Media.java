package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class MediaItem {
    private int itemId;
    private String itemTitle;
    private String itemCategory;
    private float itemCost;
    public static final Comparator<MediaItem> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<MediaItem> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public MediaItem(int itemId, String itemTitle, String itemCategory, float itemCost) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemCategory = itemCategory;
        this.itemCost = itemCost;   
    }

    public int getItemId() {
        return itemId;
    }
    public String getItemTitle() {
        return itemTitle;
    }
    public String getItemCategory(){
        return itemCategory;
    }
    public float getItemCost(){
        return itemCost;
    }
    boolean equals(MediaItem otherItem){
        return itemTitle.equals(otherItem.getItemTitle());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " [id= " + itemId +
                ", title='" + itemTitle + '\'' +
                ", category='" + itemCategory + '\'' +
                ", cost= " + itemCost + " $]";
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemCost(float itemCost) {
        this.itemCost = itemCost;
    }
}
