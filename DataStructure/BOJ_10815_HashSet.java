// BOJ - 10815
// Problem Sheet - https://www.acmicpc.net/problem/10815

import java.util.*;
import java.io.*;

public class Main {
    // HashSet을 이용한 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> cards = new HashSet<>(); // 상근이가 가진 카드의 Set을 저장

        int n = Integer.parseInt(bf.readLine()); // 상근이가 가진 카드의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            cards.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(bf.readLine()); // 확인할 카드의 수
        int[] answers = new int[m]; // 각 카드의 존재여부 저장
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++)
            if(cards.contains(Integer.parseInt(st.nextToken())))
                answers[i] = 1;

        for(int answer : answers)
            System.out.print(answer + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }
}