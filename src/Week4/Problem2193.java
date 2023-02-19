package Week4;

import java.io.*;
import java.util.*;

public class Problem2193 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        long method[] = new long[91];
        method[0] = 0;
        method[1] = 1;

        for (int i = 2; i <= N; i++) {
            method[i] = method[i - 1] + method[i - 2];
        }

        System.out.println(method[N]);
    }
}
