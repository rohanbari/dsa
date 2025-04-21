package problems;

import java.util.Arrays;

public class SelflessProduct {

    private int[] productExceptSelf(int[] nums) {
        final int N = nums.length;

        int[] prefixProducts = new int[N];
        int[] suffixProducts = new int[N];
        int[] result = new int[N];

        // Initial products
        prefixProducts[0] = 1;
        suffixProducts[N - 1] = 1;

        for (int i = 1; i < N; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < N; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] testcases = {
                { 1, 2, 3, 4 },
                { -1, 1, 0, -3, 3 },
        };

        System.out.println(Arrays.toString(new SelflessProduct().productExceptSelf(testcases[0])));
        System.out.println(Arrays.toString(new SelflessProduct().productExceptSelf(testcases[1])));
    }
}