// BOJ - 1080
// Problem Sheet - https://www.acmicpc.net/problem/1080

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String tmp;
        boolean isEqual = true;

        int n = Integer.parseInt(st.nextToken()); // 행렬의 세로 길이
        int m = Integer.parseInt(st.nextToken()); // 행렬의 가로 길이
        int[][] matrix = new int[n][m]; // 행렬의 정보를 저장할 2차원 배열
        int answer = 0;

        // 행렬 A를 입력받는 부분
        for(int i=0 ; i<n ; i++) {
            tmp = bf.readLine();
            for(int j=0 ; j<m ; j++)
                matrix[i][j] = Integer.parseInt(tmp.charAt(j)+"");
        }

        // 행렬 B와 A를 비교하여 비교행렬을 생성하는 부분
        for(int i=0 ; i<n ; i++) {
            tmp = bf.readLine();
            for(int j=0 ; j<m ; j++) {
                if(matrix[i][j] == Integer.parseInt(tmp.charAt(j)+""))
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = 1;
            }
        }

        // 3x3 을 적용할 수 없는 경우
        if(n<3 || m<3) {
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<m ; j++) {
                    if(matrix[i][j] == 1) {
                        isEqual = false;
                        break;
                    }
                }
            }
            if(isEqual) {
                System.out.println(0);
                System.exit(0);   
            }
            else {
                System.out.println(-1);
                System.exit(0);
            }
        }

        // 3x3 연산을 적용할 수 있는 경우
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                // A와 B가 일치하지 않는 부분인 경우
                if(matrix[i][j] == 1) {
                    // 3x3 연산 수행이 가능한 경우
                    if((i+2 < n) && (j+2 < m)) {
                        for(int k=i ; k<i+3 ; k++) {
                            for(int l=j ; l<j+3 ; l++) {
                                if(matrix[k][l] == 0)
                                    matrix[k][l] = 1;
                                else
                                    matrix[k][l] = 0;
                            }
                        }
                        answer++;
                    }
                    // 3x3 연산 수행이 불가한 경우
                    else {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(answer);
        
        bf.close();
        System.exit(0);
    }
}