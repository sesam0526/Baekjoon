package Week6;

import java.io.*;
import java.util.*;

public class Problem2285 {
    static int N;
    static long cnt = 0;
    static Node node[];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        node = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            long X = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());

            node[i] = new Node(X, A);
            cnt += A;
        }

        Arrays.sort(node);

        long sum = 0;
        for (Node n : node) {
            sum += n.A;
            if (sum >= (cnt + 1) / 2) {
                System.out.println(n.X);
                break;
            }
        }
    }

    static class Node implements Comparable<Node> {
        long X;
        long A;

        public Node(long x, long a) {
            this.X = x;
            this.A = a;
        }

        public int compareTo(Node o) {
            if (this.X == o.X) {
                return (int) (this.A - o.A);
            }
            return (int) (this.X - o.X);
        }
    }
}