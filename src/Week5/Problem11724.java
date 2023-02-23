package Week5;

import java.io.*;
import java.util.*;

public class Problem11724 {
    static ArrayList<Integer>[] arraylist;
    static boolean[] visited;
    static int N, M;

    public static void dfs(int V) {
        visited[V] = true;

        for (int e : arraylist[V]) {
            if (!visited[e]) {
                dfs(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arraylist = new ArrayList[N + 1];

        for (int i = 0; i < arraylist.length; i++) {   // 초기화하지 않으면 java.lang.NullPointerException 오류발생
            arraylist[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arraylist[from].add(to);
            arraylist[to].add(from);
        }

        for (int i = 0; i < arraylist.length; i++) {
            Collections.sort(arraylist[i]);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
