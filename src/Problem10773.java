import java.io.*;

class Problem10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int top = -1;
        int n = Integer.parseInt(in.readLine());
        int[] stack = new int[n];

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(in.readLine());

            if(num == 0)
                top--;

            else
                stack[++top] = num;
        }

        int sum = 0;

        for(int i=0; i < top+1; i++)
            sum += stack[i];
        System.out.println(sum);
    }
}