import java.io.*;
import java.util.*;

class Problem1935 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String prefix = in.readLine();   // 식

        double[] value = new double[n];    // 숫자
        for(int i=0; i<n; i++)
            value[i] = Double.parseDouble(in.readLine());

        Stack<Double> stack = new Stack<>();

        int len = prefix.length();
        double result = 0;

        for(int i=0; i<len; i++){
            char ch = prefix.charAt(i);

            if('A' <= ch && 'Z' >= ch)
                stack.push(value[ch - 'A']);

            else{
                if(!stack.isEmpty()){
                    double first = stack.pop();
                    double second = stack.pop();

                    switch(ch){
                        case '+':
                            result = second + first;
                            break;

                        case '-':
                            result = second - first;
                            break;

                        case '*':
                            result = second * first;
                            break;

                        case '/':
                            result = second / first;
                            break;
                    }
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}