package com.kinandcarta.exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A simple unit test class to test {@link CheckoutImpl}.
 */
public class CheckoutImplTest {

    /**
     * Test that we can use the checkout class to compute a total.  No discounts are
     * applied in this first step.
     */
    @Test
    public void testWithoutDiscounts() {

        // Items 0001 and 0003 together should come to £28.94.  As this is returned as an int,
        // it will be 2894.  Notice that we are creating a new instance of the implementation
        // class (CheckoutImpl), but the variable's type is the interface that that class
        // implements (Checkout).
        Checkout checkout = new CheckoutImpl();
        checkout.scan(Arrays.asList("0001", "0003"));

        // Use the junit method to check that we got the correct total.  The last parameter in this
        // call is the string that will only be displayed when the first two parameters aren't equal.
        assertEquals(2894, checkout.getTotal(), "Total incorrect");
    }

//    /**
//     * Test the examples that are contained in the exercise description.
//     */
    @Test
    public void testExamplesFromExerciseDescription() {

        Checkout checkout1 = new CheckoutImpl();
        checkout1.scan(Arrays.asList("0001", "0001", "0002", "0003"));
        assertEquals(10347, checkout1.getTotal(), "Total incorrect");

        Checkout checkout2 = new CheckoutImpl();
        checkout2.scan(Arrays.asList("0001", "0001", "0001"));
        assertEquals(6897, checkout2.getTotal(), "Total incorrect");

        Checkout checkout3 = new CheckoutImpl();
        checkout3.scan(Arrays.asList("0001", "0001", "0002", "0003"));
        assertEquals(10347, checkout3.getTotal(), "Total incorrect");
    }
}
