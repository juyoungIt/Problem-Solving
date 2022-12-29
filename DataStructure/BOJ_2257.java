// BOJ - 2257
// Problem Sheet - https://www.acmicpc.net/problem/2257

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> weightStack = new Stack<>(); // 화학식을 저장하는 stack
        Map<String, String> weightMapper = new HashMap<>();
        weightMapper.put("H", "1");
        weightMapper.put("C", "12");
        weightMapper.put("O", "16");

        String expression = bf.readLine(); // 화학식을 입력으로 받아옴
        for(int i=0 ; i<expression.length() ; i++) {
            String token = expression.charAt(i)+"";
            if(token.equals("(")) { // 여는괄호인 경우
                weightStack.add(token);
            } else if(token.equals("H") || token.equals("C") || token.equals("O")) { // 원자식인 경우
                weightStack.add(weightMapper.get(token));
            } else if(Character.isDigit(token.charAt(0))) { // 숫자인 경우
                int weight = Integer.parseInt(weightStack.pop()) * Integer.parseInt(token);
                weightStack.add(Integer.toString(weight));
            } else { // 닫는 괄호인 경우
                int tmpWeight = 0;
                while(true) {
                    String tmpToken = weightStack.pop();
                    if(tmpToken.equals("(")) {
                        weightStack.add(Integer.toString(tmpWeight));
                        break;
                    }
                    tmpWeight += Integer.parseInt(tmpToken);
                }
            }
        }

        int totalWeight = 0;
        while(!weightStack.isEmpty()) {
            totalWeight += Integer.parseInt(weightStack.pop());
        }
        System.out.println(totalWeight);

        bf.close();
        System.exit(0);
    }
}