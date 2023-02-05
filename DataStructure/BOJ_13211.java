// BOJ - 13211
// Problem Sheet - https://www.acmicpc.net/problem/13211

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> stolenPassports = new HashSet<>(); // 도난된 여권들
        int result = 0; // 주어진 리스트에서 도난된 여권의 수

        int stolenPassportCount = Integer.parseInt(bf.readLine()); // 도난된 여권의 수
        for(int i=0 ; i<stolenPassportCount ; i++) {
            stolenPassports.add(bf.readLine());
        }

        int checkCount = Integer.parseInt(bf.readLine()); // 확인하고자 하는 여권의 수
        for(int i=0 ; i<checkCount ; i++) {
            String passportCode = bf.readLine();
            if(stolenPassports.contains(passportCode)) {
                result++;
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}