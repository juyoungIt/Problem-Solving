// BOJ - 11507
// Problem Sheet - https://www.acmicpc.net/problem/11507

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = bf.readLine(); // 카드 정보에 대한 문자열
        boolean isGRESKA = false;

        Set<String> cards = new HashSet<>(); // 현재 가진 카드의 Set
        Map<Character, Integer> indexMapper = new HashMap<>(); // 각 모양별 index를 저장
        indexMapper.put('P', 0);
        indexMapper.put('K', 1);
        indexMapper.put('H', 2);
        indexMapper.put('T', 3);

        int[] cardCounts = new int[4]; // 각 문자별 카드 수 정보
        Arrays.fill(cardCounts, 13);

        // 입력 문자열을 분석하여 카드현황 정보를 갱신함
        for(int i=0 ; i<inputStr.length() ; i+=3) {
            String card = inputStr.substring(i, i+3);
            if(cards.contains(card)) {
                System.out.println("GRESKA");
                isGRESKA = true;
                break;
            }
            cards.add(card);
            cardCounts[indexMapper.get(card.charAt(0))]--;
        }

        // 종합된 카운트 정보를 출력
        if(!isGRESKA) {
            for(int count : cardCounts) {
                System.out.print(count + " ");
            }
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }
}