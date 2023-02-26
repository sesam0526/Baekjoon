package Week5;

import java.io.*;
import java.util.*;

public class Problem4963 {
    static int[][] map;
    static boolean[][] visited;
    static int w, h;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(in.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(in.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        island++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(island);
        }
    }

    public static void dfs(int X, int Y) {
        int dirX[] = {0, 0, +1, -1, -1, +1, -1, +1};   // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
        int dirY[] = {+1, -1, 0, 0, -1, +1, +1, -1};

        visited[X][Y] = true;

        for (int i = 0; i < 8; i++) {
            int nowX = X + dirX[i];
            int nowY = Y + dirY[i];

            if (nowX < h && nowX >= 0 && nowY < w && nowY >= 0) {
                if (!visited[nowX][nowY] && map[nowX][nowY] == 1)
                    dfs(nowX, nowY);
            }
        }
    }
}
