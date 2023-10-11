package SSOS_Coding_Test;

import java.io.*;
import java.util.*;

public class Problem10813 {
    static int[] basket;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());   // 바구니 개수
        int m = Integer.parseInt(st.nextToken());   // 교환 횟수
        int temp;

        basket = new int[n];
        for(int i=0; i<n; i++){
            basket[i] = i+1;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            temp = basket[a-1];
            basket[a-1] = basket[b-1];
            basket[b-1] = temp;
        }

        for(int i=0; i<n; i++){
            System.out.print(basket[i] + " ");
        }
    }
}
