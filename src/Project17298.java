import java.io.*;
import java.util.*;

public class Project17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int[] data = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        for(int i=0; i<n; i++)
            data[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && (data[stack.peek()] < data[i]))
                data[stack.pop()] = data[i];
            stack.push(i);
        }

        while(!stack.isEmpty())
            data[stack.pop()] = -1;

        for(int i=0; i<n; i++)
            sb.append(data[i]).append(' ');

        System.out.println(sb);
    }
}
