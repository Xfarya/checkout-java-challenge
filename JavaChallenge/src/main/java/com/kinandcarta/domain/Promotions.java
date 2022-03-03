package com.kinandcarta.domain;

import java.util.List;

public interface Promotions {

    int getTotal();

    List<String> getCheckoutList();

    int applyTotalDiscount();

}
