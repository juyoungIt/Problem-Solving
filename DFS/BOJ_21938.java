// BOJ - 21938
// Problem Sheet - https://www.acmicpc.net/problem/21938

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로의 길이
        int m = Integer.parseInt(st.nextToken()); // 가로의 길이
        int[][] rgbInfo = new int[n][m*3]; // 이미지를 구성하는 각 픽셀정보를 저장
        int[][] image = new int[n][m]; // 처리된 이미지 정보를 저장
        int answer = 0;

        // 이미지 구성 픽셀의 rgb 정보를 구성
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m*3 ; j++)
                rgbInfo[i][j] = Integer.parseInt(st.nextToken());
        }
        int threshold = Integer.parseInt(bf.readLine());

        // 이미지를 주어진 임계값을 기준으로 처리함
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m*3 ; j+=3) {
                int sum = 0; // rgb값의 합산값
                for(int k=0 ; k<3 ; k++)
                    sum += rgbInfo[i][j+k];
                image[i][j/3] = (threshold <= sum/3) ? 255 : 0;
            }
        }

        // 처리된 이미지 상에서 물체의 갯수를 카운트 함
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(image[i][j] == 255) {
                    dfs(image, j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void dfs(int[][] image, int startX, int startY) {
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        image[startY][startX] = 0;
        for(int i=0 ; i<4 ; i++) {
            int tx = startX + xi[i];
            int ty = startY + yi[i];
            if(validation(tx, ty, image[0].length, image.length) && image[ty][tx] == 255) {
                image[ty][tx] = 0;
                dfs(image, tx, ty);
            }
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}