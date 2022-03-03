package com.kinandcarta.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.kinandcarta.domain.ItemImpl;
import com.kinandcarta.domain.PromotionsImpl;


/**
 * The default implementation of a {@link Checkout}.  This means that all the methods defined in
 * Checkout MUST be implemented here.  There are skeleton implementations for these methods below.
 *
 * (This class could also implement other interfaces as well, but do not confuse this with 'multiple
 * inheritance' that you may know from C++ or other languages; Java only allows single inheritance.)
 */
public class CheckoutImpl implements Checkout {

    // We want to define the kinds of things a user can purchase.  So add a field here that lets us look
    // up an Item based on the item id (a String).  You'll probably want to use one of the Java collection
    // classes (https://www.javatpoint.com/collections-in-java) to make a mapping (hint, hint) between
    // the item id String and an Item instance.  It should have the word 'private' in front of it, as we
    // don't want this field to be visible from other classes.
    //

    private HashMap<String, ItemImpl> checkoutItems = new HashMap<>();
    int total;

public CheckoutImpl () {
    checkoutItems.put("0001", new ItemImpl("0001", "Water Bottle", 2495));
    checkoutItems.put("0002", new ItemImpl("0002", "Hoodie", 6500));
    checkoutItems.put("0003", new ItemImpl("0003", "Sticker Set", 399));
    checkoutItems.put("0004", new ItemImpl("0004", "Water Bottle Discounted", 2299));
}

    private List<String> checkoutBasketList = new ArrayList<>();


    @Override
    public void scan(List<String> itemIds) {
        total = 0;

      checkoutBasketList = itemIds.stream()
                .filter(itemId -> checkoutItems.containsKey(itemId))
                .collect(Collectors.toList());
        }


    @Override
    public int getTotal() {
        if (total > 0) {
            return total;
        };

        List<String> wBs = new PromotionsImpl(checkoutBasketList).getCheckoutList();

        total = wBs.stream()
                .mapToInt(itemId -> checkoutItems.get(itemId).getPrice())
                .sum();

        int result = new PromotionsImpl(total).applyTotalDiscount();
        return result;

        };





}
