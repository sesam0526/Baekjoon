import java.io.*;
import java.util.*;

public class Problem1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(in.readLine());
            if (input != 0)
                minQueue.add(input);
            else {
                if (!minQueue.isEmpty())
                    System.out.println(minQueue.poll());
                else System.out.println(0);
                continue;
            }
        }
    }
}
