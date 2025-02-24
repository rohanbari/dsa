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

public class NextGreaterElement {

    /**
     * Finds the next larger element of the array.
     * 
     * @param arr The array we are working on
     * @return Resultant array
     */
    private static ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Taking the nearest greater value (if present),
            // otherwise, elem will remain -1.
            int elem = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    elem = arr[j];
                    break;
                }
            }

            result.add(elem);
        }

        return result;
    }

    /**
     * The main method.
     * 
     * @param args System arguments
     */
    public static void main(String[] args) {
        // Some testcases
        int[][] testcases = {
                { 1, 3, 2, 4 },
                { 6, 8, 0, 1, 3 },
                { 10, 20, 30, 50, 70 },
        };

        System.out.println(String.valueOf(nextLargerElement(testcases[0])));
        System.out.println(String.valueOf(nextLargerElement(testcases[1])));
        System.out.println(String.valueOf(nextLargerElement(testcases[2])));
    }
}
