// BOJ - 23057
// Problem Sheet - https://www.acmicpc.net/problem/23057

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 카드의 수
        int m = 0; // 모든 카드에 적힌 수의 합
        Set<Integer> sumSet = new HashSet<>(); // 발생 가능한 모든 수의 Set

        // 카드 정보를 입력받아 발생가능한 수를 구성함
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            int card = Integer.parseInt(st.nextToken());
            m += card;
            List<Integer> tmpStorage = new ArrayList<>(); // 새롭게 발생된 수를 일시저장
            for(int number : sumSet) {
                tmpStorage.add(number + card);
            }
            sumSet.addAll(tmpStorage); // 발생한 모든 수를 추가함
            sumSet.add(card); // 입력받은 수를 Set에 추가함
        }

        // 발생 시킬 수 없는 수의 정보를 카운트 함
        System.out.println(m - sumSet.size());

        bf.close();
        System.exit(0);
    }
}