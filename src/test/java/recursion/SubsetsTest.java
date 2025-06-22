package recursion;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    Subsets obj = new Subsets();

    // Helper method to convert List<List<Integer>> to Set<Set<Integer>> for unordered comparison
    private Set<Set<Integer>> toSetOfSets(List<List<Integer>> listOfLists) {
        Set<Set<Integer>> setOfSets = new HashSet<>();
        for (List<Integer> list : listOfLists) {
            setOfSets.add(new HashSet<>(list));
        }
        return setOfSets;
    }

    @Test
    void testSubsetsOf123() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(),
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(1, 2),
            Arrays.asList(3),
            Arrays.asList(1, 3),
            Arrays.asList(2, 3),
            Arrays.asList(1, 2, 3)
        );

        assertEquals(
            toSetOfSets(expected),
            toSetOfSets(obj.subsets(nums))
        );
    }

    @Test
    void testSubsetsOf0() {
        int[] nums = {0};

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(),
            Arrays.asList(0)
        );

        assertEquals(
            toSetOfSets(expected),
            toSetOfSets(obj.subsets(nums))
        );
    }

    @Test
    void testSubsetsOfEmptyArray() {
        int[] nums = {};

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList()
        );

        assertEquals(
            toSetOfSets(expected),
            toSetOfSets(obj.subsets(nums))
        );
    }

    @Test
    void testSubsetsOfNegativeNumbers() {
        int[] nums = {-1, -2};

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(),
            Arrays.asList(-1),
            Arrays.asList(-2),
            Arrays.asList(-1, -2)
        );

        assertEquals(
            toSetOfSets(expected),
            toSetOfSets(obj.subsets(nums))
        );
    }

    @Test
    void testSubsetsOfMaxSizeInput() {
        int[] nums = {1, 2, 3, 4};

        // There should be 2^n subsets
        List<List<Integer>> actual = obj.subsets(nums);
        assertEquals(16, actual.size());
    }
}
