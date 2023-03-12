package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Problem15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] arr = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            if (max < arr[i])
                max = arr[i];

            int day = i + T[i];
            if (day <= N + 1)
                arr[day] = Math.max(arr[day], max + P[i]);
        }
        System.out.println(max);
    }
}
