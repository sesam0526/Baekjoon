package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem10451 {
    static int[] cycle;
    static boolean[] visited;

    static void dfs(int V) {
        visited[V] = true;

        int next = cycle[V];
        if (!visited[next]) {
            dfs(cycle[V]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            cycle = new int[N + 1];
            int count = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cycle[j] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}