package dev.sharathk.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductExceptSelfTest {

    @Test
    void example1() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, ProductExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    void example2() {
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, ProductExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }
}
