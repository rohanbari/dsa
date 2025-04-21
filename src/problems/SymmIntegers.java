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

public class SymmIntegers {

    /**
     * You are given `low` and `high`.
     * 
     * An integer x consisting of 2 * n digits is symmetric if the sum of the
     * first n digits of x is equal to the sum of the last n digits of x.
     * Numbers with an odd number of digits are never symmetric.
     * 
     * Return the number of symmetric integers in the range [low, high].
     * 
     * @param low  Lower bound
     * @param high Upper bound
     * @return No. of symmetric integers
     */
    private int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            // An odd integer can never be symmetric in nature
            if (countDigits(num) % 2 == 1) {
                continue;
            }

            int lhs = 0;
            int rhs = 0;
            String str = String.valueOf(num);

            // Sum up from both sides
            for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                lhs += str.charAt(i) - '0';
                rhs += str.charAt(j) - '0';
            }

            // Increment iff sum of both sides are equal
            if (lhs == rhs) {
                count++;
            }
        }

        return count;
    }

    private int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }

        return count;
    }

    /**
     * The main method.
     * 
     * @param args System arguments
     */
    public static void main(String[] args) {
        SymmIntegers symmIntegers = new SymmIntegers();

        // Some testcases
        System.out.println(symmIntegers.countSymmetricIntegers(1, 100));
        System.out.println(symmIntegers.countSymmetricIntegers(1200, 1230));
    }
}
