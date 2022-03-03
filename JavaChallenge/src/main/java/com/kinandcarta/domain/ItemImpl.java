package com.kinandcarta.domain;

import com.kinandcarta.exercise.Checkout;

/**
 * Defines an item that can be purchased from the store.
 */
public class ItemImpl implements Item {

    // Define a private field for the item id.
private String itemId;
    // Define a private field for the item description.
private String itemDescription;
    // Define a private field for the price.
private int price;
    // Define a constructor which will take values for all three fields as parameters and assign them to the fields.
    public ItemImpl(String itemId, String itemDescription, int price) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getItemDescription() {
        return this.itemDescription;
    }

    @Override
    public String getItemId() {
        return this.itemId;
    }
    // Add 'get' methods that will allow external access to the fields.


}
