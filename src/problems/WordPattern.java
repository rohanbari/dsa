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

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    /**
     * Bijection checker.
     * 
     * @param pattern The pattern
     * @param s       The text sequence
     * @return Is bijection?
     */
    private boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternMapKey = new HashMap<>();
        Map<String, Character> patternMapVal = new HashMap<>();

        int idx = 0;
        for (char c : pattern.toCharArray()) {
            if (patternMapKey.containsKey(c)) {
                if (!patternMapKey.get(c).equals(words[idx])) {
                    return false;
                }
            }

            if (patternMapVal.containsKey(words[idx])) {
                if (!patternMapVal.get(words[idx]).equals(c)) {
                    return false;
                }
            }

            patternMapKey.put(c, words[idx]);
            patternMapVal.put(words[idx], c);

            idx++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
    }
}
