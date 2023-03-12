package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem15686 {
    static int N, M;
    static ArrayList<Node> home, chicken;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] city = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1)
                    home.add(new Node(i, j));

                if (city[i][j] == 2)
                    chicken.add(new Node(i, j));
            }
        }
        visited = new boolean[chicken.size()];
        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int start, int count) {
        if (count == M) {
            int total = 0;
            for (int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        min = Math.min(min, distance);
                    }
                }
                total += min;
            }
            result = Math.min(result, total);
            return;
        }

        // backtracking
        for (int k = start; k < chicken.size(); k++) {
            if (visited[k] == false)
                visited[k] = true;
            DFS(k + 1, count + 1);
            visited[k] = false;
        }
    }
}
