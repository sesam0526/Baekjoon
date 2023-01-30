import java.io.*;
import java.util.*;

class Problem10828 {
    public static int[] stack;
    public static int size = 0;

    public static void push(int item){
        stack[size] = item;
        size++;
    }

    public static int pop(){
        if(size == 0)
            return -1;

        int res = stack[size-1];
        size--;
        return res;
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0)
            return 1;
        return 0;
    }

    public static int top(){
        if(size == 0)
            return -1;
        return stack[size-1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(in.readLine());
        stack = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(in.readLine(), " ");

            switch(st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    ineak;

                case "pop":
                    sb.append(pop()).append('\n');
                    ineak;

                case "size":
                    sb.append(size()).append('\n');
                    ineak;

                case "empty":
                    sb.append(empty()).append('\n');
                    ineak;

                case "top":
                    sb.append(top()).append('\n');
                    ineak;
            }
        }
        System.out.println(sb);
    }
}