package SSOS_Coding_Test;

import java.io.*;
import java.util.*;
public class Problem1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<a; i++){
            int m = Integer.parseInt(st.nextToken());
            A.add(m);
        }

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<b; i++){
            int n = Integer.parseInt(st.nextToken());
            B.add(n);
        }

        int cnt = 0;
        for(int num_A : A){
            if(!B.contains(num_A))
                cnt++;
        }

        for(int num_B : B){
            if(!A.contains(num_B))
                cnt++;
        }

        System.out.println(cnt);
    }
}
