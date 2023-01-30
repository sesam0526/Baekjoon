import java.io.*;
import java.util.*;

public class Problem2493 {
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(st.nextToken());

            while(true){
                if(!stack.empty()){
                    int top = stack.peek();
                    if(top > num){
                        System.out.print(index.peek() + " ");
                        stack.push(num);
                        index.push(i);
                        break;
                    }
                    else{
                        stack.pop();
                        index.pop();
                    }
                }
                else{
                    System.out.print("0 ");
                    stack.push(num);
                    index.push(i);
                    break;
                }
            }
        }
    }
}
