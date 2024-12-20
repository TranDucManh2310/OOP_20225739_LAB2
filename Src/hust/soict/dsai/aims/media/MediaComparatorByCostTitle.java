package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByPriceTitle implements Comparator<MediaItem> {
    @Override
    public int compare(MediaItem item1, MediaItem item2) {
        if(item1.getItemCost() != item2.getItemCost()) {
            int costDifference = (int) (item1.getItemCost() - item2.getItemCost());
            return costDifference;
        } else {
            return item1.getItemTitle().compareTo(item2.getItemTitle());
        }
    }
}
