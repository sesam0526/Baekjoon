import java.io.*;
import java.util.*;

public class Problem2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(in.readLine());

        for(int i=1; i<=n; i++)
            queue.offer(i);

        while(queue.size() > 1){
            queue.remove();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
