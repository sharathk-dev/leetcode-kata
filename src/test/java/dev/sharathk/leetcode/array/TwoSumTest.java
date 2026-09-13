package dev.sharathk.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {


    @Test
    void returnsIndicesForBasicCase() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void returnsIndicesWhenSolutionIsAtEnd() {
        assertArrayEquals(new int[]{2, 3}, TwoSum.twoSum(new int[]{3, 2, 4, 6}, 10));
    }

    @Test
    void handlesDuplicateValues() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    void handlesNegativeNumbers() {
        assertArrayEquals(new int[]{0, 2}, TwoSum.twoSum(new int[]{-3, 4, -1}, -4));
    }

    @Test
    void returnsEmptyArrayWhenNoSolutionExists() {
        assertArrayEquals(new int[]{}, TwoSum.twoSum(new int[]{1, 2, 3}, 100));
    }
}
