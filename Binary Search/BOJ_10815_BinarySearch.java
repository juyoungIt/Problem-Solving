// BOJ - 10815
// Problem Sheet - https://www.acmicpc.net/problem/10815

import java.util.*;
import java.io.*;

public class Main {
    // Binary Search를 이용한 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 상근이가 가진 카드의 수
        int[] cards = new int[n]; // 상근이가 가진 카드를 저장
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards); // 카드의 값을 기준으로 정렬함

        int m = Integer.parseInt(bf.readLine()); // 확인할 카드의 수
        int[] answers = new int[m]; // 각 카드의 존재여부 저장
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++) {
            int target = Integer.parseInt(st.nextToken()); // 찾고자 하는 수
            int left = 0;
            int right = n-1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(cards[mid] == target) {
                    answers[i] = 1;
                    break;
                }
                else if(cards[mid] > target) right = mid-1;
                else left = mid+1;
            }
        }

        for(int answer : answers)
            System.out.print(answer + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }
}