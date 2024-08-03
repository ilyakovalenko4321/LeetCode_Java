package LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class WeightOfLastStoneIII {

    public static int lastStoneWeightII(int[] stones) {
        int numberOfOptions = (int) Math.pow(2, stones.length);
        int[] operations = new int[stones.length];
        boolean flag;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < numberOfOptions; i++) {
            flag = true;
            for (int pointer = 0; pointer < stones.length && flag; pointer++) {
                if (operations[pointer] == 0) {
                    operations[pointer] = 1;
                    flag = false;
                } else {
                    operations[pointer] = 0;
                }
            }

            int lastStoneWeight = 0;
            for (int t = 0; t < operations.length; t++) {
                if (operations[t] == 0) {
                    lastStoneWeight -= stones[t];
                } else {
                    lastStoneWeight += stones[t];
                }
            }

            if (lastStoneWeight > 0) {
                result = Math.min(result, lastStoneWeight);
            } else if (lastStoneWeight == 0) {
                return 0;
            }
        }

        return result;
    }


    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int y = lastStoneWeightII(new int[]{35,33,30,25,19,11,53,40,36,10,31,23,26,13,14,18,33,22,16,22,16,28,16,72,25,23,19});
        System.out.println(y);
    }
}
