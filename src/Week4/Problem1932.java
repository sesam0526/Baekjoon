package Week4;

import java.io.*;
import java.util.*;

public class Problem1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            arr[i] = new int[i + 1];   // 비정방형 배열 선언
            for (int j = 0; j <= i; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i > 0; i--) {   // 제일 아래층부터 제일 위층까지 위로 올라가면서
            for (int j = 0; j < i; j++)
                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);   // 자기자신과 바로 옆의 수 중 큰 수를 위층 수에 더함
        }
        System.out.println(arr[0][0]);   // 제일 위층 수(최대값) 출력
    }
}
