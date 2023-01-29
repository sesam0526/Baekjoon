import java.io.*;

class Problem9012 {
    public static String solve(String s){
        int count = 0;

        for(char c : s.toCharArray()){
            if(c == '(')
                count++;

            else if(count == 0)
                return "NO";

            else
                count--;
        }

        if(count == 0)
            return "YES";
        return "NO";
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        for(int i=0; i<n; i++){
            sb.append(solve(in.readLine())).append('\n');
        }
        System.out.println(sb);
    }
}