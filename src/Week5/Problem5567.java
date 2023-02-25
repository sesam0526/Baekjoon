package Week5;

import java.io.*;
import java.util.*;

public class Problem5567 {
    static ArrayList<Integer>[] arraylist;
    static boolean[] visited;
    static int n, m;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());

        arraylist = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < arraylist.length; i++)
            arraylist[i] = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arraylist[a].add(b);
            arraylist[b].add(a);
        }

        dfs(1, 0);
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int V, int depth) {
        if (depth == 2) return;

        for (int e : arraylist[V]) {
            visited[e] = true;
            dfs(e, depth + 1);
        }
    }
}
