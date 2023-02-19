package Week2;

import java.io.*;
import java.util.*;

public class Problem5430 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            String p = in.readLine();
            int n = Integer.parseInt(in.readLine());

            StringTokenizer st = new StringTokenizer(in.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

            for (int i = 0; i < n; i++)
                deque.add(Integer.parseInt(st.nextToken()));

            AC(p, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String p, ArrayDeque<Integer> deque) {
        boolean reverse = false;

        for (char s : p.toCharArray()) {

            if (s == 'R') {
                reverse = !reverse;
                continue;
            }

            if (!reverse) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque, reverse);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean reverse) {
        sb.append('[');

        if (deque.size() > 0) {
            if (!reverse) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty())
                    sb.append(',').append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
}