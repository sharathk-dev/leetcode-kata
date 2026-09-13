package dev.sharathk.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductSubarrayTest {

    @Test
    void example1() {
        assertEquals(6, MaximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    void example2() {
        assertEquals(0, MaximumProductSubarray.maxProduct(new int[]{-2, 0, -1}));
    }

    @Test
    void singleElement() {
        assertEquals(-5, MaximumProductSubarray.maxProduct(new int[]{-5}));
    }

    @Test
    void allPositive() {
        assertEquals(24, MaximumProductSubarray.maxProduct(new int[]{1, 2, 3, 4}));
    }

    @Test
    void twoNegativesMultiplyToLargerProduct() {
        assertEquals(24, MaximumProductSubarray.maxProduct(new int[]{-2, 3, -4}));
    }

    @Test
    void zeroSplitsArrayIntoSegments() {
        assertEquals(3, MaximumProductSubarray.maxProduct(new int[]{0, 2, -3, 0, 3, -1}));
    }

    @Test
    void allNegativeWithEvenCount() {
        assertEquals(24, MaximumProductSubarray.maxProduct(new int[]{-1, -2, -3, -4}));
    }

    @Test
    void allNegativeWithOddCountReturnsBestPrefixOrSuffix() {
        assertEquals(120, MaximumProductSubarray.maxProduct(new int[]{-1, -2, -3, -4, -5}));
    }
}
