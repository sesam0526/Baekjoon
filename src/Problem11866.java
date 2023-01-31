import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Problem11866 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
            queue.add(i);

        sb.append('<');

        while(queue.size() > 1){
            for(int i=0; i<K-1; i++)
                queue.offer(queue.poll());
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}
