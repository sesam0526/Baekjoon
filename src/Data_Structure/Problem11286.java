package Data_Structure;

import java.io.*;
import java.util.*;

public class Problem11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(in.readLine());
            if (input != 0)
                queue.add(input);
            else {
                if (!queue.isEmpty())
                    System.out.println(queue.poll());
                else System.out.println(0);
                continue;
            }
        }
    }
}
