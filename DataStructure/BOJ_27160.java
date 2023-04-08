// BOJ - 27160
// Problem Sheet - https://www.acmicpc.net/problem/27160

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID = "YES";
    private static final String INVALID = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countMapper = new HashMap<>();
        StringTokenizer st;
        boolean isValid = false;

        int numberOfCards = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfCards ; i++) {
            st = new StringTokenizer(bf.readLine());
            String cardType = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if(!countMapper.containsKey(cardType)) {
                countMapper.put(cardType, count);
            } else {
                countMapper.put(cardType, countMapper.get(cardType) + count);
            }
        }

        for(int count : countMapper.values()) {
            if(count == 5) {
                isValid = true;
                break;
            }
        }

        System.out.println(isValid ? VALID : INVALID);

        bf.close();
        System.exit(0);
    }
}