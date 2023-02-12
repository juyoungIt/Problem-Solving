// BOJ - 25327
// Problem Sheet - https://www.acmicpc.net/problem/25327

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<String, Integer> combinationMapper = new HashMap<>(); // 발생가능한 조합 - 빈도수

        int informationSize = Integer.parseInt(st.nextToken()); // 정보의 수
        int questionSize = Integer.parseInt(st.nextToken()); // 질의의 수
        StringBuilder sb = new StringBuilder();

        // 정보를 입력받아 조회 가능한 Map을 구성함
        for(int i=0 ; i<informationSize ; i++) {
            String[] tokens = bf.readLine().split(" ");
            // 1. '-'가 없는 경우
            sb.setLength(0);
            insertTokensToStringBuilder(sb, tokens);
            insertInfoToMapper(combinationMapper, sb.toString());
            // 2. '-'가 1개인 경우
            for(int j=0 ; j<3 ; j++) {
                sb.setLength(0); // 재사용을 위해 초기화
                for(int k=0 ; k<3 ; k++) {
                    if(j != k) {
                        sb.append(tokens[k]);
                    }
                }
                insertInfoToMapper(combinationMapper, sb.toString());
            }
            // 3. '-'가 2개인 경우
            for(int j=0 ; j<3 ; j++) {
                sb.setLength(0); // 재사용을 위해 초기화
                sb.append(tokens[j]);
                insertInfoToMapper(combinationMapper, sb.toString());
            }
        }

        // 질의를 입력받아 각각에 대한 처리결과를 반환함
        for(int i=0 ; i<questionSize ; i++) {
            sb.setLength(0); // 재사용을 위한 초기화
            insertTokensToStringBuilder(sb, bf.readLine().split(" "));
            if(sb.toString().length() == 0) {
                System.out.println(informationSize);
            } else {
                if(combinationMapper.containsKey(sb.toString())) {
                    System.out.println(combinationMapper.get(sb.toString()));
                } else {
                    System.out.println(0);
                }
            }
        }

        bf.close();
        System.exit(0);
    }

    static void insertInfoToMapper(Map<String, Integer> mapper, String infoStr) {
        if(!mapper.containsKey(infoStr)) {
            mapper.put(infoStr, 1);
        } else {
            mapper.put(infoStr, mapper.get(infoStr) + 1);
        }
    }

    static void insertTokensToStringBuilder(StringBuilder sb, String[] tokens) {
        for(String token : tokens) {
            if(!token.equals("-")) {
                sb.append(token);
            }
        }
    }
}