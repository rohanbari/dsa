/*
 Copyright 2025 Rohan Bari <rohanbari@outlook.com>

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package problems;

import java.util.ArrayList;
import java.util.List;

public class CombSum {

    /**
     * Generates all possible UNIQUE combinations that sums to `target`.
     * 
     * @param candidates An array of candidates
     * @param target     Target sum
     * @return Possible sum combinations
     */
    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(), 0);

        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result,
            ArrayList<Integer> temp, int idx) {
        // Base case
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], result, temp, i); // DFS
            temp.remove(temp.size() - 1); // Backtrack
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
