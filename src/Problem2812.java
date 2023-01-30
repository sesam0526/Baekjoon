import java.io.*;
import java.util.*;

public class Problem2812 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        String s = in.readLine();
        int count = 0;
        for(int i=0; i<N; i++){
            int n = s.charAt(i) - '0';

            while(!stack.isEmpty() && K > count && stack.peek() < n){
                stack.pop();
                count++;
            }
            stack.push(n);
        }
        for(int i=0; i<N-K; i++)
            sb.append(stack.get(i));
        System.out.print(sb);
    }
}