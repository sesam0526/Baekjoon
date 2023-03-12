package DFS_BFS;

import java.io.*;
import java.util.*;

public class Problem5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] arr = new int[F + 1];

        System.out.println(BFS(F, S, G, U, D, arr));
    }

    public static String BFS(int F, int S, int G, int U, int D, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        arr[S] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == G)
                return String.valueOf(arr[current] - 1);

            if (current + U <= F) {
                if (arr[current + U] == 0) {
                    arr[current + U] = arr[current] + 1;
                    q.add(current + U);
                }
            }

            if (current - D > 0) {
                if (arr[current - D] == 0) {
                    arr[current - D] = arr[current] + 1;
                    q.add(current - D);
                }
            }
        }
        return "use the stairs";
    }
}
