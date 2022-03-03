package com.kinandcarta.domain;
import java.util.List;

public class PromotionsImpl implements Promotions {

    private int total;
    private List<String> checkoutItems;

    public PromotionsImpl(int total){
        this.total = total;
    }

    public PromotionsImpl(List<String> checkoutItems){
        this.checkoutItems = checkoutItems;
    }

    @Override
    public int getTotal() {
        return this.total;
    }

    @Override
    public List<String> getCheckoutList() {
        long occurrences = checkoutItems.stream()
                .filter(checkoutItem -> "0001".equals(checkoutItem))
                .count();
        if (occurrences > 1) {
            checkoutItems.replaceAll(item -> item == "0001" ? "0004" : item);
        }
            return checkoutItems;
    }

    @Override
    public int applyTotalDiscount() {
       if (total > 7500) {
           return total = (int) Math.round((float) total * 0.9);
       }
        return total;
    }
}

