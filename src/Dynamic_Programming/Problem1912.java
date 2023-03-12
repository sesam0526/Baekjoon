package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Problem1912 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}
