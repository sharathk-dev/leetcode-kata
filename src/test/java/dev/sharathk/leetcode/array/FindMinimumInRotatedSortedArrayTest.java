package dev.sharathk.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimumInRotatedSortedArrayTest {

    @Test
    void example1() {
        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void example2() {
        assertEquals(0, FindMinimumInRotatedSortedArray.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    void example3() {
        assertEquals(11, FindMinimumInRotatedSortedArray.findMin(new int[]{11, 13, 15, 17}));
    }

    @Test
    void singleElement() {
        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[]{1}));
    }

    @Test
    void twoElementsRotated() {
        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[]{2, 1}));
    }

    @Test
    void rotatedByOne() {
        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[]{2, 3, 4, 5, 1}));
    }

    @Test
    void minimumAtFrontMeansNoRotation() {
        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void threeElementsRotated() {
        assertEquals(1, FindMinimumInRotatedSortedArray.findMin(new int[]{3, 1, 2}));
    }
}
