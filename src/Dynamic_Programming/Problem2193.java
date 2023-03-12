package Dynamic_Programming;

import java.io.*;

public class Problem2193 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        long method[] = new long[91];
        method[1] = 1;
        method[2] = 1;

        for (int i = 3; i <= N; i++) {
            method[i] = method[i - 1] + method[i - 2];
        }

        System.out.println(method[N]);
    }
}
