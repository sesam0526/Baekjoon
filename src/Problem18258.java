import java.io.*;
import java.util.*;

public class Problem18258 {
    static StringBuilder sb = new StringBuilder();
    static int[] command = new int[2000000];
    static int size = 0;
    static int front = 0;
    static int back = 0;

    static void push(int n){
        command[back] = n;
        back++;
        size++;
    }

    static void pop(){
        if(size == 0)
            sb.append(-1).append('\n');
        else{
            sb.append(command[front]).append('\n');
            size--;
            front++;
        }
    }

    static void size(){
        sb.append(size).append('\n');
    }

    static void empty(){
        if(size == 0)
            sb.append(1).append('\n');
        else sb.append(0).append('\n');
    }

    static void front(){
        if(size == 0)
            sb.append(-1).append('\n');
        else sb.append(command[front]).append('\n');
    }

    static void back(){
        if(size == 0)
            sb.append(-1).append('\n');
        else sb.append(command[back-1]).append('\n');
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            switch(st.nextToken()){
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": pop(); break;
                case "size": size(); break;
                case "empty": empty(); break;
                case "front": front(); break;
                case "back": back(); break;
            }
        }
        System.out.println(sb);
    }
}
