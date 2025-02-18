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

package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO: Add comments to this [file] and [CombSum.java] as well
 */
public class BFS {

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static void bfs(List<List<Integer>> adj, int target) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[target] = true;
        queue.add(target);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(String.format("Visiting %d", curr));

            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        final int V = 5;

        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacents.add(new ArrayList<>());
        }

        // Some testcases
        addEdge(adjacents, 0, 1);
        addEdge(adjacents, 0, 2);
        addEdge(adjacents, 1, 3);
        addEdge(adjacents, 1, 4);
        addEdge(adjacents, 2, 4);

        System.out.println("BFS (from 0th index) in progress...");
        bfs(adjacents, 0);
    }
}
