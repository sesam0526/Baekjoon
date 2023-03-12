package Dynamic_Programming;

import java.io.*;

public class Problem11726 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int method[] = new int[1001];
        method[1] = 1;
        method[2] = 2;

        for (int i = 3; i <= n; i++) {
            method[i] = (method[i - 1] + method[i - 2]) % 10007;
        }

        System.out.println(method[n]);
    }
}
