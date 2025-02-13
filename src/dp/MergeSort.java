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

package dp;

import java.util.Arrays;

public class MergeSort {

    /**
     * The beloved mergesort algorithm.
     * 
     * @param array Array to sort
     */
    private void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        sort(array, helper, 0, array.length - 1);
    }

    /**
     * Overload `internal` function that actually sorts.
     * 
     * @param array  Array to sort
     * @param helper Helper array to work with
     * @param lo     Beginning point
     * @param hi     End point
     */
    private void sort(int[] array, int[] helper, int lo, int hi) {
        // Exit recursion on this condition
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        // Sort each half
        sort(array, helper, lo, mid);
        sort(array, helper, mid + 1, hi);

        // Merge the halves
        merge(array, helper, lo, mid, hi);
    }

    /**
     * Does the main heavylifting.
     * 
     * @param array  Array to sort
     * @param helper Helper array
     * @param lo     Beginning index
     * @param mid    Middle index
     * @param hi     End index
     */
    void merge(int[] array, int[] helper, int lo, int mid, int hi) {
        // Prepare the helper function
        helper = array.clone();

        // Setting bounds
        int hLeft = lo;
        int hRight = mid + 1;
        int curr = lo;

        // If the right index is greater than the left, or vice versa,
        // we swap the elements.
        while (hLeft <= mid && hRight <= hi) {
            if (helper[hLeft] <= helper[hRight]) {
                array[curr] = helper[hLeft++];
            } else {
                array[curr] = helper[hRight++];
            }

            curr++;
        }

        // Merging leftover elements
        while (hLeft <= mid)
            array[curr++] = helper[hLeft++];
        while (hRight <= hi)
            array[curr++] = helper[hRight++];
    }

    /**
     * The driver code.
     * 
     * @param args System arguments
     */
    public static void main(String[] args) {
        // Some testcases
        int[][] arrays = {
                { 1, 3, 2, 5, 7, 4 },
                { 4, 3, 2, 1, 2, 3, 4 },
                { 5, 1, 8, 2, 9, 4, 1, 9, 6, 10 }
        };

        new MergeSort().mergeSort(arrays[0]);
        new MergeSort().mergeSort(arrays[1]);
        new MergeSort().mergeSort(arrays[2]);

        System.out.println();
        System.out.println(Arrays.toString(arrays[0]));
        System.out.println(Arrays.toString(arrays[1]));
        System.out.println(Arrays.toString(arrays[2]));
    }
}
