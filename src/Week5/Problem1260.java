package Week5;

import java.io.*;
import java.util.*;

public class Problem1260 {
    static ArrayList<Integer>[] arraylist;
    static Queue<Integer> q;
    static boolean[] visited;
    static int N, M, V;

    public static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");

        for (int e : arraylist[V]) {
            if (!visited[e])
                dfs(e);
        }
    }

    public static void bfs(int V) {
        q = new LinkedList<>();
        q.add(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            V = q.poll();
            System.out.print(V + " ");

            for (int e : arraylist[V]) {
                if (!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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

        for (int i = 0; i < arraylist.length; i++) {   // 인접리스트 오름차순 정렬
            Collections.sort(arraylist[i]);
        }

        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);
    }
}
