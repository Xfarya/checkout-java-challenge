package com.kinandcarta.domain;


/**
 * Defines an item that can be purchased from the store.
 */
public interface Item {

//String itemId = "";
//
//String itemDescription = "";
//
//int price = 0;

    int getPrice();
    String getItemDescription();
    String getItemId();

}
