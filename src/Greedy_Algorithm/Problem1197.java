package Greedy_Algorithm;

import java.io.*;
import java.util.*;

public class Problem1197 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {   // cost 기준으로 정렬
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수

        PriorityQueue<Edge> q = new PriorityQueue<Edge>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            q.add(new Edge(from, to, cost));
        }

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;   // 각 노드의 부모 노드를 자기 자신으로 초기화
        }

        int result = 0;
        for (int i = 0; i < E; i++) {
            Edge temp = q.poll();   // cost가 가장 작은 간선 뽑음

            int x = find(temp.from);   // 시작 노드의 최상위 노드 찾음
            int y = find(temp.to);   // 끝 논드의 최상위 노드 찾음

            if (x == y) continue;   // 최상위 노드가 서로 같으면 사이클 생기므로 패스
            union(x, y);   // 최상위 노드가 서로 다르면 union으로 연결
            result += temp.cost;   // cost를 결과에 더함
        }
        System.out.println(result);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parent[y] = x;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}