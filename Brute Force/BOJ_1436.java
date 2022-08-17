// BOJ - 1436
// Problem Sheet - https://www.acmicpc.net/problem/1436

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt(); // 원하는 번째 수
        Integer curNum = 666;

        while(n > 0) {
            if(curNum.toString().contains("666"))
                n--;
            curNum++;
        }

        System.out.println(curNum-1);

        key.close();
        System.exit(0);
    }
}