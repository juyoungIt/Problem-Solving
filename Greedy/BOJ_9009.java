// BOJ - 9009
// Problem Sheet - https://www.acmicpc.net/problem/9009

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        ArrayList<Integer> fiboNums = new ArrayList<>(); // 입력된 수보다 작은 수로 구성된 피보나치 수열을 저장
        PriorityQueue<Integer> answers = new PriorityQueue<>(); // 찾은 솔루션들을 저장

        // 각 테스트 케이스에 대하여 다음을 반복함
        for(int i=0 ; i<tcSize ; i++) {
            int tc = Integer.parseInt(bf.readLine()); // 테스트 케이스
            // 입력된 수보다 작은 수로 구성된 피보나치 수열을 구함
            fiboNums.add(0); // 기본값 주입(1)
            fiboNums.add(1); // 기본값 주입(2)
            for(int j=2 ; ; j++) {
                int tmp = fiboNums.get(j-1) + fiboNums.get(j-2);
                if(tc < tmp) break;
                fiboNums.add(tmp);
            }
            fiboNums.sort(Collections.reverseOrder()); // 크기 순으로 내림차순 정렬
            // 합을 구성할 수 있는 피보나치 수를 찾음
            for(int j=0 ; j<fiboNums.size() ; j++) {
                if(fiboNums.get(j) <= tc) {
                    answers.add(fiboNums.get(j));
                    tc -= fiboNums.get(j);
                }
            }
            // 구성된 솔루션을 출력함
            fiboNums.clear(); // 재사용을 위해 비움
            answers.poll(); // 바로 앞에 들어있을 0을 뺌
            while(!answers.isEmpty())
                System.out.print(answers.poll() + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }
}