import java.io.*;
import java.util.*;

class Problem1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String str = in.readLine();   // abcd

        for(int i=0; i<str.length(); i++)
            leftStack.push(str.charAt(i));

        int n = Integer.parseInt(in.readLine());   // 3

        for(int i=0; i<n; i++){
            String cmd = in.readLine();

            switch(cmd.charAt(0)){
                case 'L':
                    if(leftStack.empty())
                        break;
                    rightStack.push(leftStack.pop());
                    break;

                case 'D':
                    if(rightStack.empty())
                        break;
                    leftStack.push(rightStack.pop());
                    break;

                case 'B':
                    if(leftStack.empty())
                        break;
                    leftStack.pop();
                    break;

                case 'P':
                    leftStack.push(cmd.charAt(2));
                    break;
            }
        }

        while(!leftStack.empty())
            rightStack.push(leftStack.pop());

        while(!rightStack.empty())
            sb.append(rightStack.pop());

        System.out.println(sb);
    }
}