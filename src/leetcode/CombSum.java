package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombSum {

    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(), 0);

        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result,
            ArrayList<Integer> temp, int idx) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, temp, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Some testcases
        int[][] candidates = {
                { 2, 3, 6, 7 },
                { 2, 3, 5 },
                { 2 },
        };

        System.out.println(new CombSum().combinationSum(candidates[0], 7));
        System.out.println(new CombSum().combinationSum(candidates[1], 8));
        System.out.println(new CombSum().combinationSum(candidates[2], 1));
    }
}
