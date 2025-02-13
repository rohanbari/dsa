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

package sort_search;

public class FiboSeq {

    private void printFibonacci(int n) {
        System.out.println(memoize(n, new int[n + 1]));
    }

    /**
     * The helper function that uses bottom-up memoization technique.
     * We basically store the calculated values and avoiding repetition in
     * calculations to store time and memory.
     * 
     * This takes just O(n) time!
     * 
     * @param i    The working index
     * @param memo Memo array
     * @return 'i'th term in sequence
     */
    private int memoize(int i, int[] memo) {
        if (i == 0 || i == 1) {
            return i;
        }

        if (memo[i] == 0) {
            memo[i] = memoize(i - 1, memo) + memoize(i - 2, memo);
        }

        return memo[i];
    }

    /**
     * The driver code.
     * 
     * @param args System arguments
     */
    public static void main(String[] args) {
        FiboSeq fiboSeq = new FiboSeq();

        // Some testcases
        fiboSeq.printFibonacci(4);
        fiboSeq.printFibonacci(10);
        fiboSeq.printFibonacci(35);
    }
}
