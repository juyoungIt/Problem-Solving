// BOJ - 5585
// Problem Sheet - https://www.acmicpc.net/problem/5585

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int[] bills = {500, 100, 50, 10, 5, 1}; // 보유한 지폐 금액의 단위
        int change = 1000 - key.nextInt(); // 비용입력 후 거스름돈 계산
        int count = 0; // 잔돈의 수
        int tmp;

        while(change > 0) {
            for(int i=0 ; i<bills.length ; i++) {
                tmp = change / bills[i];
                count += tmp;
                change -= bills[i] * tmp;
            }
        }
        System.out.println(count);
    }
}
