// BOJ - 26596
// Problem Sheet - https://www.acmicpc.net/problem/26596

import java.util.*;
import java.io.*;

public class Main {

    private static final double RATIO = 1.618; // 황금비 비율

    enum Messages {
        SUCCESS("Delicious!"),
        FAILED("Not Delicious...");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() { return this.message; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean isGoldenRatio = false; // 만들어진 칵테일이 황금비인가?

        Map<String, Integer> amountMapper = new HashMap<>(); // 넣은 재료량에 대한 mapper
        int m = Integer.parseInt(bf.readLine()); // 넣은 재료의 수
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken(); // 재료의 이름
            int amount = Integer.parseInt(st.nextToken()); // 재료량
            if(!amountMapper.containsKey(name)) {
                amountMapper.put(name, amount);
            } else {
                amountMapper.put(name, amountMapper.get(name) + amount);
            }
        }

        int size =  amountMapper.size();
        List<Integer> amount = new ArrayList<>(size);
        for(Map.Entry<String, Integer> entry : amountMapper.entrySet()) {
            amount.add(entry.getValue()); // 재료량을 별도로 추출하여 모음
        }

        // 재료량 중 황금비가 존재하는 지 검사
        for(int i=0 ; i<size ; i++) {
            if(isGoldenRatio) {
                break;
            }
            int amountA = amount.get(i);
            for(int j=i+1 ; j<size ; j++) {
                int amountB = amount.get(j);
                if((int)Math.floor(amountA * RATIO) == amountB || (int)Math.floor(amountB * RATIO) == amountA) {
                    isGoldenRatio = true;
                    break;
                }
            }
        }

        System.out.println((isGoldenRatio) ? Messages.SUCCESS.getMessage() : Messages.FAILED.getMessage());

        bf.close();
        System.exit(0);
    }
}