package dev.sharathk.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    @Test
    void example1() {
        assertEquals(49, ContainerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void example2() {
        assertEquals(1, ContainerWithMostWater.maxArea(new int[]{1, 1}));
    }

    @Test
    void optimalPairIsNotTheWidestSpan() {
        assertEquals(4, ContainerWithMostWater.maxArea(new int[]{1, 2, 4, 3}));
    }

    @Test
    void increasingHeightsPicksBestMiddlePair() {
        assertEquals(6, ContainerWithMostWater.maxArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void allSameHeightUsesFullWidth() {
        assertEquals(15, ContainerWithMostWater.maxArea(new int[]{5, 5, 5, 5}));
    }
}
