package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem11725 {
    static ArrayList<Integer>[] arraylist;
    static boolean[] visited;
    static int[] parent;

    public static void dfs(int V) {
        visited[V] = true;

        for (int e : arraylist[V]) {
            if (!visited[e]) {
                parent[e] = V;
                dfs(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        arraylist = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < arraylist.length; i++) {
            arraylist[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arraylist[from].add(to);
            arraylist[to].add(from);
        }

        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
}
