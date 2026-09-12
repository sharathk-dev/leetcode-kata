package dev.sharathk.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {

    @Test
    void example1() {
        assertEquals(6, MaximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void example2() {
        assertEquals(1, MaximumSubarray.maxSubArray(new int[]{1}));
    }

    @Test
    void example3() {
        assertEquals(23, MaximumSubarray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    @Test
    void singleNegativeElement() {
        assertEquals(-1, MaximumSubarray.maxSubArray(new int[]{-1}));
    }

    @Test
    void allNegativeReturnsLeastNegative() {
        assertEquals(-1, MaximumSubarray.maxSubArray(new int[]{-2, -1}));
    }
}
