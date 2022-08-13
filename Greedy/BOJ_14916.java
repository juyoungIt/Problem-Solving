// BOJ - 14916
// Problem Sheet - https://www.acmicpc.net/problem/14916

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt(); // 거스름돈 금액
        int answer = 0;

        while(n > 0) {
            if((n-5)%2 == 0 || (n-5)%5 == 0) n -= 5;
            else n -= 2;
            answer++;
        }

        System.out.println((n == 0) ? answer : -1);

        key.close();
        System.exit(0);
    }
}