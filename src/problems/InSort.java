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

import java.util.Arrays;

public class InSort {

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                // Shifting elements
                arr[j + 1] = arr[j];
                j--;
            }

            // Placing to the right index
            arr[j + 1] = key;
        }
    }

    /**
     * The main method.
     * 
     * @param args System arguments
     */
    public static void main(String[] args) {
        // Some testcases
        int[][] testcases = {
                { 4, 1, 3, 9, 7 },
                { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
                { 4, 1, 9 },
        };

        sort(testcases[0]);
        sort(testcases[1]);
        sort(testcases[2]);

        System.out.println();
        System.out.println(Arrays.deepToString(testcases));
    }
}
