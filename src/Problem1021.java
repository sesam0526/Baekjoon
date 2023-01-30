import java.io.*;
import java.util.*;

public class Problem1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
            deque.offer(i);
        int[] seq = new int[M];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i=0; i<M; i++){
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if(deque.size() % 2 == 0)
                half_idx = deque.size() / 2 - 1 ;
            else half_idx = deque.size() / 2;

            if(target_idx <= half_idx){
                for(int j=0; j<target_idx; j++){
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else{
                for(int j=0; j<deque.size()-target_idx; j++){
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}