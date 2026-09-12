package dev.sharathk.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    @Test
    void example1() {
        assertEquals(5, BestTimeToBuyAndSellStock.getMaxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void example2() {
        assertEquals(0, BestTimeToBuyAndSellStock.getMaxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
