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

public class BinarySearches {

    /**
     * The most-standard binary search algorithm.
     * 
     * @param array  The array to search on
     * @param target The element to find
     * @return Index of the element
     */
    private int binarySearch(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            // We use this technique to avoid potential overflows when the size
            // of the array is too large to handle
            int mid = lo + (hi - lo) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                // The element must be on the right half
                lo = mid + 1;
            } else {
                // The element must be on the left half
                hi = mid - 1;
            }
        }

        // Not present
        return -1;
    }

    /**
     * The beloved binary search, but using recursive technique.
     * 
     * @param array  The array to search on
     * @param target Element to find
     * @param lo     Lower bound
     * @param hi     Upper bound
     * @return Index of the element
     */
    private int binaryRecursive(int[] array, int target, int lo, int hi) {
        if (lo >= hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            // Search on the first half
            return binaryRecursive(array, target, lo, mid - 1);
        } else {
            // Search on the second half
            return binaryRecursive(array, target, mid + 1, hi);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 5, 7, 8, 9 };

        // Testcases using both methods
        System.out.println(new BinarySearches().binarySearch(array, 2));
        System.out.println(new BinarySearches().binarySearch(array, 10));
        System.out.println(new BinarySearches().binarySearch(array, 6));

        // Produces the same output
        System.out.println(new BinarySearches().binaryRecursive(array, 2, 0, array.length - 1));
        System.out.println(new BinarySearches().binaryRecursive(array, 10, 0, array.length - 1));
        System.out.println(new BinarySearches().binaryRecursive(array, 6, 0, array.length - 1));
    }
}
