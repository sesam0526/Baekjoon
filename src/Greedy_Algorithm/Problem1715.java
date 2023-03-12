package Greedy_Algorithm;

import java.io.*;
import java.util.*;

public class Problem1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(in.readLine()));
        }

        int result = 0;
        while (q.size() > 1) {
            int temp = q.poll() + q.poll();
            result += temp;
            q.add(temp);
        }
        System.out.println(result);
    }
}
