package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.module.ModuleDescriptor;
import java.util.*;

public class ShoppingCart {
    private ObservableList<Media> orderedItems  = FXCollections.observableArrayList();

    public void addMediaItem(Media mediaItem) {
        if(orderedItems.contains(mediaItem)){
            System.out.println(mediaItem.getTitle() + " is already in the shopping cart.");
        }else{
            orderedItems.add(mediaItem);
            System.out.println(mediaItem.getTitle() + " has been added to the cart.");
        }
    }

    public void removeMediaItem(Media mediaItem) {
        if(orderedItems.contains(mediaItem)){
            orderedItems.remove(mediaItem);
        } else{
            System.out.println(mediaItem.getClass().getSimpleName() +' ' + mediaItem.getTitle() + " is not in the cart.");
        }
    }

    // Method to calculate the total cost of the items
    public float calculateTotal() {
        float total = 0;
        for(Media mediaItem : orderedItems){
            total += mediaItem.getCost();
        }
        return total;
    }

    public void displayCart() {
        StringBuilder cartContents = new StringBuilder("*********************SHOPPING CART************************** \nOrdered items: \n");
        if(orderedItems.isEmpty()) {
            cartContents.append("No items in the cart\n");
        }else{
            int index = 1;
            for (Media mediaItem : orderedItems) {
                cartContents.append(index + ".[" + mediaItem.getTitle() + "] - [" + mediaItem.getCategory() + "] - "+ mediaItem.getCost() + " $\n");
                index++;
            }
        }
        cartContents.append("Total: ").append(calculateTotal()).append(" $\n");
        cartContents.append("***************************************************\n");
        System.out.println(cartContents);
    }

    public void searchById(int id) {
        if(id > orderedItems.size()) {
            System.out.println("No match found!");
        } else {
            System.out.println("Found: " +  "[" + orderedItems.get(id-1).getTitle() +
                    "] - [" + orderedItems.get(id-1).getCategory() + "] -"
                    + orderedItems.get(id-1).getCost() + " $\n");
        }
    }

    public void searchByTitle(String title) {
        for(Media mediaItem : orderedItems) {
            if(mediaItem.getTitle().equals(title)) {
                System.out.println("Found: " +  "[" + mediaItem.getTitle() +
                        "] - [" + mediaItem.getCategory() + "] -"
                        + mediaItem.getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found");
    }

    public Media findMediaByTitle(String title) {
        for (Media mediaItem : orderedItems) {
            if (mediaItem.getTitle().equals(title)) {
                return mediaItem;
            }
        }
        return null;
    }

    public ObservableList<Media> getOrderedItems() {
        return orderedItems;
    }

    public void clearCart() {
        orderedItems.clear();
    }

    public void sortByTitleAndCost() {
        Collections.sort(orderedItems, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostAndTitle() {
        Collections.sort(orderedItems, Media.COMPARE_BY_COST_TITLE);
    }
}
