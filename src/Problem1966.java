import java.io.*;
import java.util.*;

public class Problem1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(in.readLine());

            for(int i=0; i<N; i++)
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});

            int count = 0;
            while(!queue.isEmpty()) {
                int[] front = queue.remove();
                boolean flag = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (front[1] < queue.get(i)[1]) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    count++;
                    if(front[0] == M) break;
                }
                else queue.add(front);
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
