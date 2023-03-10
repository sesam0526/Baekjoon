package Week6;

import java.io.*;
import java.util.*;

public class Problem8980 {
    static class Delivery implements Comparable<Delivery> {
        int from, to, num;

        public Delivery(int from, int to, int num) {
            this.from = from;
            this.to = to;
            this.num = num;
        }

        public int compareTo(Delivery o) {
            if (this.to == o.to)   // 받는 마을이 동일한 경우, 보내는 마을 오름차순으로 정렬
                return this.from - o.from;
            else return this.to - o.to;   // 받는 마을 오름차순으로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(in.readLine());
        Delivery d[] = new Delivery[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            d[i] = new Delivery(from, to, num);
        }
        Arrays.sort(d);   // compareTo에 따라 정렬

        int weight[] = new int[N];
        for (int i = 0; i < N; i++)
            weight[i] = C;   // 각 마을 당 최대 용량

        int total = 0;
        for (int i = 0; i < M; i++) {
            int max = C;

            for (int j = d[i].from; j < d[i].to; j++)
                max = Math.min(max, weight[j]);   // 보내는 마을과 받는 마을 사이의 경로 마을에서의 최대 용량

            if (max >= d[i].num) {   // 최대 용량이 보내는 박스 개수보다 같거나 크면
                for (int j = d[i].from; j < d[i].to; j++)
                    weight[j] -= d[i].num;   // 보내는 마을과 받는 마을 사이의 경로 마을 용량에서 박스 개수 뺌
                total += d[i].num;   // 배송한 박스 수 더하기
            } else {   // 최대 용량이 보내는 박스 개수보다 작으면
                for (int j = d[i].from; j < d[i].to; j++)
                    weight[j] -= max;   // 보내는 마을과 받는 마을 사이의 경로 마을 용량에서 최대 용량만큼만 뺌
                total += max;   // 배송한 박스 수 더하기
            }
        }
        System.out.println(total);
    }
}
