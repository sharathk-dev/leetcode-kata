package dev.sharathk.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeSumTest {

    private static Set<List<Integer>> asSet(List<List<Integer>> triplets) {
        return new HashSet<>(triplets);
    }

    @Test
    void example1() {
        List<List<Integer>> result = ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Set<List<Integer>> expected = Set.of(
                asList(-1, -1, 2),
                asList(-1, 0, 1)
        );

        assertEquals(expected.size(), result.size());
        assertEquals(expected, asSet(result));
    }

    @Test
    void allZerosProducesSingleTriplet() {
        List<List<Integer>> result = ThreeSum.threeSum(new int[]{0, 0, 0});
        Set<List<Integer>> expected = Set.of(asList(0, 0, 0));

        assertEquals(expected.size(), result.size());
        assertEquals(expected, asSet(result));
    }

    @Test
    void noValidTripletReturnsEmptyList() {
        List<List<Integer>> result = ThreeSum.threeSum(new int[]{0, 1, 1});

        assertTrue(result.isEmpty());
    }

    @Test
    void fewerThanThreeElementsReturnsEmptyList() {
        List<List<Integer>> result = ThreeSum.threeSum(new int[]{0, 0});

        assertTrue(result.isEmpty());
    }

    @Test
    void duplicateValuesDoNotProduceDuplicateTriplets() {
        List<List<Integer>> result = ThreeSum.threeSum(new int[]{-2, 0, 0, 2, 2, -2});
        Set<List<Integer>> expected = Set.of(
                asList(-2, 0, 2)
        );

        assertEquals(expected.size(), result.size());
        assertEquals(expected, asSet(result));
    }
}
