import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(in.readLine());
        int top = 0;

        while(n-- > 0){
            int value = Integer.parseInt(in.readLine());

            if(top < value){
                for(int i = top + 1; i <= value; i++){
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                top = value;
            }

            else if (stack.peek() != value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
