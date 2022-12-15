// BOJ - 9575
// Problem Sheet - https://www.acmicpc.net/problem/9575

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수

        for(int i=0 ; i<tcSize ; i++) {
            Set<Integer> goodNumbers = new HashSet<>(); // 발생 가능한 행운의 숫자 저장

            // 사용자 입력을 통해 수열을 구성함
            List<Integer> seqA = new ArrayList<>(); // 수열A
            List<Integer> seqB = new ArrayList<>(); // 수열B
            List<Integer> seqC = new ArrayList<>(); // 수열C

            int seqASize = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<seqASize ; j++)
                seqA.add(Integer.parseInt(st.nextToken()));

            int seqBSize = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<seqBSize ; j++)
                seqB.add(Integer.parseInt(st.nextToken()));

            int seqCSize = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<seqCSize ; j++)
                seqC.add(Integer.parseInt(st.nextToken()));

            // 발생가능한 행운의 수들을 저장
            for(int j=0 ; j<seqASize ; j++) {
                for(int k=0 ; k<seqBSize ; k++) {
                    for(int l=0 ; l<seqCSize ; l++) {
                        int sum = seqA.get(j) + seqB.get(k) + seqC.get(l);
                        if(isGoodNumber(sum))
                            goodNumbers.add(sum);
                    }
                }
            }
            System.out.println(goodNumbers.size());
        }

        bf.close();
        System.exit(0);
    }

    // 입력으로 들어온 수가 행운의 수 인가?
    public static boolean isGoodNumber(int number) {
        char[] numberStr = Integer.toString(number).toCharArray();
        for(char numLetter : numberStr) {
            if(numLetter != '5' && numLetter != '8') {
                return false;
            }
        }
        return true;
    }
}