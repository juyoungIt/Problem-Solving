// BOJ - 1972
// Problem Sheet - https://www.acmicpc.net/problem/1972

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            boolean isSurprise = true;
            String inputStr = bf.readLine();
            if(inputStr.equals("*")) {
                break;
            }
            // 각각의 문자열에 대하여 다음을 반복함
            for(int dist=0 ; dist<=inputStr.length()-2 ; dist++) {
                Set<String> strSet = new HashSet<>(); // 발생한 문자열의 Set
                for(int i=0 ; i<inputStr.length()-(dist+1) ; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(inputStr.charAt(i)).append(inputStr.charAt(i+dist+1));
                    if(strSet.contains(sb.toString())) {
                        isSurprise = false;
                        break;
                    }
                    strSet.add(sb.toString());
                }
            }
            if(isSurprise) {
                System.out.println(inputStr + " is surprising.");
            } else {
                System.out.println(inputStr + " is NOT surprising.");
            }
        }

        bf.close();
        System.exit(0);
    }
}