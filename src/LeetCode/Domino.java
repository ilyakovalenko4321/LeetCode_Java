package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Domino {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int numPairs = 0;

        for (int[] domino : dominoes) {
            int hash = hashCode(domino);
            int count = countMap.getOrDefault(hash, 0);
            numPairs += count;
            countMap.put(hash, count + 1);
        }

        return numPairs;
    }

    private int hashCode(int[] domino) {
        return Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
    }
}
