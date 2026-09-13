package dev.sharathk.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {

    @Test
    void example1() {
        assertEquals(4, SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void example2() {
        assertEquals(-1, SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void example3() {
        assertEquals(-1, SearchInRotatedSortedArray.search(new int[]{1}, 0));
    }

    @Test
    void singleElementFound() {
        assertEquals(0, SearchInRotatedSortedArray.search(new int[]{1}, 1));
    }

    @Test
    void noRotationTargetInMiddle() {
        assertEquals(2, SearchInRotatedSortedArray.search(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    void targetIsRotationPoint() {
        assertEquals(4, SearchInRotatedSortedArray.search(new int[]{6, 7, 8, 1, 2, 3, 4}, 2));
    }

    @Test
    void targetBeforeRotationPoint() {
        assertEquals(1, SearchInRotatedSortedArray.search(new int[]{6, 7, 8, 1, 2, 3, 4}, 7));
    }
}
