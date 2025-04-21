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

public class SearchIn2D {

    private boolean searchMatrix(int[][] matrix, int target) {
        boolean isPresent = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                continue;
            }

            isPresent = binarySearch(matrix[i], target);
        }

        return isPresent;
    }

    private boolean binarySearch(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] testcases = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 },
        };

        System.out.println(new SearchIn2D().searchMatrix(testcases, 13));
        System.out.println(new SearchIn2D().searchMatrix(testcases, 3));
    }
}
